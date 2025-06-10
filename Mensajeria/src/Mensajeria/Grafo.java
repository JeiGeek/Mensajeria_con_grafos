/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mensajeria;

import java.util.LinkedList;
import java.util.Random;

/**
 *
 * @autores Steven Rey - Sara Patiño - Jeison Guarguati 
 */
public class Grafo {
    //------------------------------- Atributos ------------------------------
    private int V; //numero de vertices
    private int A; //numero de aristas
    private int [][] matrizAdyacencia; // conexiones entre nodos
    private float [][] matrizDePeso; // para el caso de este proyecto horas que hay entre conexiones de nodos
    private float [][] matrizDeKilometro; //kilometros entre conexiones de nodos
    
    //Lista con nombre de las ciudades
    private LinkedList<String> ciudades; //lista para almacenar las ciudades del grafo
    //Lista de tarifas para cada ciudad
    private LinkedList<Integer> tarifas; //lista para guardar el precio de envio de cada ciudad
    
    //ATRIBUTOS PARA EL METODO FLOYD
    private float [][] pesos; // genera los caminos mas corto a partir del menor tiempo
    private float [][] recorrido; //genera porque ciudades se debe pasar
    
    //VALIDADOR
    private boolean [] visitar; //lista para colocar TRUE a las ciudades que un carro debe visitar
    
    //Lista para arista del recorrido minimo
    private LinkedList<Arista> aristas; //almacena los recorrido minimo
    private LinkedList<Arista> aristas2; // lista que almacena lo recorridos minimos para hacer el conteo maximo de horas de un camion en ruta
    
    //Acumulador de peso de los recorridos
    private float peso = 0;
    //--------------------------------------------------------------------------
    
    //------------------------------- CONSTRUCTOR ------------------------------
    public Grafo(int nodos) {
        this.V = nodos; //vertices
        this.A = 0; //aristas
        this.matrizAdyacencia = new int[nodos][nodos];
        this.matrizDePeso = new float[nodos][nodos];
        this.matrizDeKilometro = new float[nodos][nodos];
        this.pesos = new float[nodos][nodos];
        this.recorrido = new float[nodos][nodos];
        
        //VALIDADOR DE NODOS QUE SE DEBEN VISITAR
        this.visitar = new boolean [nodos];
        
        //Lista para arista del recorrido minimo
        this.aristas = new LinkedList();
        this.aristas2 = new LinkedList();
        
        //Lista con nombre de las ciudades
        this.ciudades = new LinkedList();
        
        this.tarifas = new LinkedList();
        //Creacion de valor por defecto de tarifa de ciudad
        for (int i = 0; i < V; i++) {
            tarifas.add(15000);
        }
    }
    //--------------------------------------------------------------------------
    
    //--------------------------- AGREGAR ARISTA -------------------------------
    public void agregarArista(String origen, String destino, float kilometros, float peso){
        
        //Agrega ciudades para tener su identificador a partir de una lista
        if(!ciudades.contains(origen)){ //verifica que no esté la ciudad para agregarla
            ciudades.add(origen);
        }
        if(!ciudades.contains(destino)){ //verifica que no esté la ciudad para agregarla
            ciudades.add(destino);
        }
        int i = ciudades.indexOf(origen); //retorna el indice donde se guardó la ciudad
        int j = ciudades.indexOf(destino); //retorna el indice donde se guardó la ciudad
        
        //Agrega a partir del indice donde está guardada la ciudad
        matrizAdyacencia[i][j] = 1;
        matrizAdyacencia[j][i] = 1;
        
        matrizDePeso[i][j] = peso;
        matrizDePeso[j][i] = peso;
        
        matrizDeKilometro[i][j] = kilometros;
        matrizDeKilometro[j][i] = kilometros;
        
        A++; //Conteo de las aristas      
    }
    //--------------------------------------------------------------------------
    
    //------------------------------ Getters ------------------------------------
    public LinkedList<String> getCiudades() { //Retorna la lista de ciudades agregadas al grafo
        return ciudades;
    }

    public LinkedList<Arista> getAristas() { //Retorna las aristas de recorridos minimos
        return aristas;
    }

    public int getTarifas(String ciudad) { //retorna la tarifa establecida para cada ciudad
        int index = ciudades.indexOf(ciudad);
        return tarifas.get(index);
    }

    public float[][] getPesos() { //retorna la matriz de pesos minimos
        return pesos;
    }
    //--------------------------------------------------------------------------
    
    //------------------------------- Setters ----------------------------------
    public void visita(String ciudad){ //modifica el estado de la ciudad para colocarla en TRUE y saber que toca visitarla
        int index = ciudades.indexOf(ciudad);
        visitar[index] = true;
    }
    
    public void visitado(String ciudad){ //Modifica para que se especifique que no toca visitarla
        int index = ciudades.indexOf(ciudad);
        visitar[index] = false;
    }
    
    public void lista(){ //imprime el listado de ciudades en el grafo (metodo para hacer validaciones)
        for (int i = 0; i < ciudades.size(); i++) {
            System.out.println("["+i+"]: " + ciudades.get(i));
        }
    }
    
    public void agregarTarifa(String ciudad, int tarifa){// modifica la tarifa para una la ciudad especificada
        int index = ciudades.indexOf(ciudad);
        tarifas.set(index,tarifa);
    }
    //--------------------------------------------------------------------------
    
    //--------------------------------------------------------------------------
    // ENCUENTRA CADA RECORRIDO MINIMO PARA CADA UNA DE LOS NODOS
    //--------------------------------------------------------------------------
    public void floyd(){
        //Asignacion de infinitos a los pesos y kilometros donde no hay relacion
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if(i != j && matrizDePeso[i][j] == 0){
                    matrizDePeso[i][j] = 9999;
                }
                if(i != j && matrizDeKilometro[i][j] == 0){
                    matrizDeKilometro[i][j] = 9999;
                }
            }   
        }

        //Creacion y asignacion de valores de la matriz de recorridos
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if(i != j){
                    recorrido[i][j] = j;
                }
                else{
                    recorrido[i][j] = -1;
                }
            }   
        }
        
        //Copia de la matriz de pesos y kilometros
        for(int i = 0 ; i < V ; i++){   
            for(int j = 0 ; j < V ; j++){
                pesos[i][j] = matrizDePeso[i][j];
            }
        }
        
        //generador de trafico en la via
        System.out.println("Novedades sobre el trafico en el mapa: ");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                //Genera un numero al azar 
                Random trancon = new Random();
                //asigna la posibilidad de que exista un trancon
                int tapon = trancon.nextInt(100) + 1;
                //aletoriamente brinda el adicional a las horas que tomaria el recorrido
                int horasExtras = trancon.nextInt(4) + 1;
                //posibilidad de trafico de 3%
                if(tapon <= 3){
                    //asigna el numero valor de peso si el tapon entra entre la posibilidad menor al de la condicion
                    if(pesos[i][j] != 9999 && pesos[i][j] != 0){
                        pesos[i][j] += horasExtras;
                        pesos[j][i] += horasExtras;
                        /// informacion de trancones-
                        System.out.println("Trafico en [" + ciudades.get(i) + "] -> [" + ciudades.get(j) + "] tiempo extra: " + horasExtras + " horas");
                    }
                }
            }
        }
        
         // Calcular las distancias , horas mínimas y los caminos
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                //En los pivotes no importa tomar el de la interseccion porque el cero no altera valores
                for (int j = 0; j < V; j++) {
                    if ( pesos[i][k] + pesos[k][j] < pesos[i][j]) {
                        pesos[i][j] = pesos[i][k] + pesos[k][j];
                        recorrido[i][j] = k;
                    }
                }
            }
        }
    }
    //--------------------------------------------------------------------------
    
    //--------------------------------------------------------------------------
    // BRINDA CADA UNA DE LAS RUTAS PARA EL PAR DE NODOS
    //--------------------------------------------------------------------------
    public void recorridos(int origen, int destino){

        //recorrido si vale -1 significa que el trayecto es del nodo al mismo nodo
            if(recorrido[origen][destino] != -1){
                //Agregar nueva arista de recorrido
                //se va acumulando las horas de recorrido necesarias para llegar de un punto a otro
                peso += pesos[origen][destino];
                //a partir de los datos recibidos se guarda una arista en la lista de aristas
                Arista aristaNueva = new Arista(origen,destino,peso);
                aristas.add(aristaNueva);
            }   
    }
    //--------------------------------------------------------------------------

    //--------------------------------------------------------------------------
    // SE BUSCA EL RECORRIDO MINIMO ENTRE NODOS QUE SE TIENEN QUE VISITAR
    //--------------------------------------------------------------------------
    public void trayecto(){
        //se inicializa siempre el peso con cero para evitar que se acumule para otros trayectos
        peso = 0;
        //Calcula los recorridos minimos en pares de nodos
        floyd();
        
        //Define el primer trayecto mas corto
        float menor = Integer.MAX_VALUE;
        int origen = 0;
        int cooY = 0;
        
        //Validar numero de nodos por visitar
        int noditos = 0;
        for (int i = 0; i < V; i++) {
            if(visitar[i] == true){
                noditos++;
            }
        }
        
        //Recorrido minimo entre nodos por visitar
        int cont = 0;
        while(cont < noditos){   
            //Comienza a buscar el recorrido minimo entre nodos que se tiene que visitar
            for (int i = 0; i < V; i++) {
                /*en la primera iteracion desde el punto de origen BUCARAMANGA empieza a mirar cual
                entre cual ciudad de las que toca visitar tiene un menor tiempo de recorrido*/
                if(visitar[i] == true && pesos[origen][i] < menor){
                    menor = pesos[origen][i];
                    cooY = i;
                }
            }
            //Agrega el recorrido a la lista de aristas
            recorridos(origen, cooY);
            //cambia el nuevo punto de origen una vez encontrara su ruta mas corta entre ciudades por visitar
            origen = cooY;
            //informa que la ciudad ya fue visitada para evitar visitarla nuevamente
            visitar[cooY] = false;
            
            //Se vuelve a colocar el valor mayor del entero al menor para volver hacer el mismo proceso en el for
            menor = Integer.MAX_VALUE;
            cont ++;
        }
        
        //Se imprimen la ruta por seguir de ciudad en ciudad
        System.out.println("");
        System.out.println("-------------- RUTA POR SEGUIR -------------");
        //arista de recorrido
        for(int i = 0; i < aristas.size(); i++) {
            System.out.print(ciudades.get(aristas.get(i).getOrigen())+ " -> ");
            System.out.print(ciudades.get(aristas.get(i).getDestino())+ ". ");
            System.out.println("");
            
        }
        int horas = (int) aristas.get(aristas.size()-1).getPeso();  // Obtener la parte entera de las horas
        int minutos = (int) (aristas.get(aristas.size()-1).getPeso());  // Obtener la parte decimal para los minutos
        
        //devuelve el valor que toma que toma ir a las ciudades por visitar
        System.out.print("Tiempo estimado desde origen: " + horas +" horas y " + minutos + " minutos.");
        
    }
    //--------------------------------------------------------------------------
    
    //elimina los anteriores recorridos para calcular el nuevo recorrido
    public void vaciarRecorrido(){
        //Una vez terminado el proceso limpia la arista para el trayecto del siguiente camion
        aristas.clear();
    }
    
    //genera las aristas de los recorridos minimos (validaciones)
    public void impresion(){
        for (int i = 0; i < aristas.size(); i++) {
            aristas.get(i).imprimir();
        }
    }
    //--------------------------------------------------------------------------
    
    
    
    //-----------------------------------------------------------------------------------------------------------
    //Los siguientes metodos son utilizados para evitar que los vehículos tenga que recorrer demasiados tiempo por ejemplo: que recorran 127 horas
    //-----------------------------------------------------------------------------------------------------------
    public void floyd2(){
        //Asignacion de infinitos a los pesos y kilometros donde no hay relacion
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if(i != j && matrizDePeso[i][j] == 0){
                    matrizDePeso[i][j] = 9999;
                }
                if(i != j && matrizDeKilometro[i][j] == 0){
                    matrizDeKilometro[i][j] = 9999;
                }
            }   
        }

        //Creacion y asignacion de valores de la matriz de recorridos
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if(i != j){
                    recorrido[i][j] = j;
                }
                else{
                    recorrido[i][j] = -1;
                }
            }   
        }
        
        //Copia de la matriz de pesos y kilometros
        for(int i = 0 ; i < V ; i++){   
            for(int j = 0 ; j < V ; j++){
                pesos[i][j] = matrizDePeso[i][j];
            }
        }
        
        /// validaciones--------------------------------------------------------
        
         // Calcular las distancias , horas mínimas y los caminos
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                //En los pivotes no importa tomar el de la interseccion porque el cero no altera valores
                for (int j = 0; j < V; j++) {
                    if ( pesos[i][k] + pesos[k][j] < pesos[i][j]) {
                        pesos[i][j] = pesos[i][k] + pesos[k][j];
                        recorrido[i][j] = k;
                    }
                }
            }
        }
    }
    
    public void trayecto2(){
        
        //Calcula los recorridos minimos en pares de nodos
        floyd2();
        
        //Define el primer trayecto mas corto
        float menor = Integer.MAX_VALUE;
        int origen = 0;
        int cooY = 0;
        
        //Validar numero de nodos por visitar
        int noditos = 0;
        for (int i = 0; i < V; i++) {
            if(visitar[i] == true){
                noditos++;
            }
        }
        
        //Recorrido minimo entre nodos por visitar
        int cont = 0;
        while(cont < noditos){   
            //Comienza a buscar el recorrido minimo entre nodos que se tiene que visitar
            for (int i = 0; i < V; i++) {
                if(visitar[i] == true && pesos[origen][i] < menor){
                    menor = pesos[origen][i];
                    cooY = i;
                }
            }
            //Encuentra esos caminos minimos y reasigna valores para el resto
            recorridos2(origen, cooY);
            origen = cooY;
            visitar[cooY] = false;
            
            menor = Integer.MAX_VALUE;
            cont ++;
        }
        
    }
    
    public void recorridos2(int origen, int destino){
        
        // Impresion de los recorridos
        
        //recorrido si vale -1 significa que el trayecto es del nodo al mismo nodo
            if(recorrido[origen][destino] != -1){
                //Agregar nueva arista de recorrido
                peso += pesos[origen][destino];
                
                Arista aristaNueva = new Arista(origen,destino,peso);
                aristas2.add(aristaNueva);
            }   
    }
    

}
