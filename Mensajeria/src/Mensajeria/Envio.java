/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mensajeria;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;

/**
 *
 * @autores Steven Rey - Sara Patiño - Jeison Guarguati
 */
public class Envio {
    
    //------------------------------- ATRIBUTOS --------------------------------
    private LinkedList <Paquete> paquetes; //almacena de manera ordenada los paquetes pasados por la clase auxiliar
    private LinkedList <Paquete> aux; // almacena provicionalmente los paquetes agregados
    private LinkedList <Vehiculo> vehiculos; // genera los vehiculos que llevarán los paquetes
    private float ingresos; // acumula los ingresos obtenidos a partir del precio de envio de cada paquete
    private float costos; //indica el costo
    private Grafo g; //objeto grafo para la creacion del mapa
    //--------------------------------------------------------------------------
    
    //------------------------------- CONSTRUCTOR ------------------------------
    public Envio() {
        this.paquetes = new LinkedList();
        this.aux = new LinkedList();
        this.vehiculos = new LinkedList();
        g = new Grafo(51);
        
        //Calculo incializado en cero para utilidades de la empresa
        ingresos = 0;
        costos = 0;
        
        //creacion del mapa o grafo
        crearMapa();
    }
    //--------------------------------------------------------------------------
    
    //---------------------------- GETTERS -------------------------------------
    public LinkedList<Vehiculo> getVehiculos() { //retorna la lista los vehiculos
        return vehiculos;
    }
    public LinkedList<String> getCiudades(){ //retorna la lista de ciudades del grafo
        return g.getCiudades();
    }
    //--------------------------------------------------------------------------
    
    //--------------------------- SETTERS --------------------------------------
    public void impresionPaquetes(){
        ordenPaquetes(); //Pide primero que ordenen los paquetes por como se agregaron las aristas
        System.out.println("-------- PAQUETES POR LLEVAR -------");
        for (int i = 0; i < paquetes.size(); i++) {
            System.out.println("---- PAQUETE #" + (i+1) + " ----");
            paquetes.get(i).imprimir();
        }
    }
        
    public void listaPaquetesCamion(){//GENERA LA LISTA DE PAQUETES DE CADA CAMION
        //informa de los paquetes que no se pueden llevar por falta de vehiculos
        if(!paquetes.isEmpty()){
            System.out.println("Paquetes que por el momento no se pueden llevar por falta de vehiculos:");
            for (int i = 0; i < paquetes.size(); i++) {
                paquetes.get(i).imprimir();
            }
        }
        
        //
        System.out.println("------------------- PAQUETES DE CADA CAMION -------------------");
        for (int i = 0; i < vehiculos.size(); i++) {
            System.out.println("------------------- CAMION #" + (i+1) + " ---------------");
            vehiculos.get(i).imprimir();
        }
    }
    //--------------------------------------------------------------------------
    
    // ---------- Creador de mapeo de ciudades y modificador de tarifas --------
    public void crearMapa(){
        g.agregarArista("BUCARAMANGA", "SABANA DE TORRES", 121, 2.83f);
        g.agregarArista("BUCARAMANGA", "BARRANCABERMEJA", 123, 2.83f);
        g.agregarArista("BUCARAMANGA", "ZAPATOCA", 68, 2);
        g.agregarArista("BUCARAMANGA", "PAMPLONA", 125, 3.63f);
        g.agregarArista("BUCARAMANGA", "MALAGA", 153, 4.85f);
        g.agregarArista("BUCARAMANGA", "AGUACHICA", 170, 4.95f);
        g.agregarArista("BUCARAMANGA", "TUNJA", 282, 6.58f);
      
        g.agregarArista("SABANA DE TORRES", "AGUACHICA", 282, 1.88f);

        g.agregarArista("PUERTO WILCHES", "BARRANCABERMEJA", 48.3f, 1.25f);
      
        g.agregarArista("BARRANCABERMEJA", "PUERTO BERRIO", 128, 2.15f);

        g.agregarArista("ZAPATOCA", "SAN VICENTE DE CHUCURI", 47.7f, 2.15f);

        g.agregarArista("PAMPLONA", "MALAGA", 132, 3.35f);
        g.agregarArista("PAMPLONA", "CUCUTA", 76.1f, 1.81f);
        g.agregarArista("PAMPLONA", "ARAUCA", 340, 10.1f);

        g.agregarArista("MALAGA", "DUITAMA", 171, 3.96f);

        g.agregarArista("AGUACHICA", "OCAÑA", 57.8f, 1.51f);
        g.agregarArista("AGUACHICA", "VALLEDUPAR", 279,4.93f);

        g.agregarArista("OCAÑA", "CUCUTA", 201,5.15f);

        g.agregarArista("PUERTO BERRIO", "MEDELLIN", 172,3);
        g.agregarArista("PUERTO BERRIO", "RIONEGRO", 190,3.76f);
        g.agregarArista("PUERTO BERRIO", "CHIQUINQUIRA", 219,5.1f);

        g.agregarArista("VALLEDUPAR", "MAICAO", 180,3.11f);
        g.agregarArista("VALLEDUPAR", "SANTA MARTA", 259,4.8f);

        g.agregarArista("MAICAO", "RIOHACHA", 78,1.26f);

        g.agregarArista("RIOHACHA", "SANTA MARTA", 172,3);

        g.agregarArista("SANTA MARTA", "BARRANQUILLA", 103,2.25f);

        g.agregarArista("BARRANQUILLA", "SOLEDAD", 11.9f,0.58f);
        g.agregarArista("BARRANQUILLA", "CARTAGENA", 130,2.58f);

        g.agregarArista("SOLEDAD", "SINCELEJO", 228,4.25f);
      
        g.agregarArista("CARTAGENA", "COVEÑAS", 156,2.65f);
        g.agregarArista("CARTAGENA", "SINCELEJO", 174,2.96f);

        g.agregarArista("COVEÑAS", "SINCELEJO", 58.7f,1.18f);
        g.agregarArista("COVEÑAS", "MONTERIA", 93.5f,1.76f);

        g.agregarArista("SINCELEJO", "MONTERIA", 122,2.2f);

        g.agregarArista("MONTERIA", "MEDELLIN", 405,8.45f);

        g.agregarArista("MEDELLIN", "RIONEGRO", 33.7f,0.85f);
        g.agregarArista("MEDELLIN", "QUIBDO", 229,5.66f);
        g.agregarArista("MEDELLIN", "MANIZALES", 228,2.15f);
        g.agregarArista("MEDELLIN", "BOGOTA", 416,8.83f);

        g.agregarArista("QUIBDO", "CALI", 425,8.36f);

        g.agregarArista("CHIQUINQUIRA", "TUNJA", 77.2f,1.75f);

        g.agregarArista("TUNJA", "PAIPA", 41,0.76f);
        g.agregarArista("TUNJA", "BOGOTA", 139,2.5f);

        g.agregarArista("PAIPA", "DUITAMA", 13.2f,0.33f);
        
        g.agregarArista("DUITAMA", "SOGAMOSO", 20.3f,0.53f);
        
        g.agregarArista("SOGAMOSO", "YOPAL", 130,4.53f);
        
        g.agregarArista("YOPAL", "VILLAVICENCIO", 251,4.55f);

        g.agregarArista("MANIZALES", "PEREIRA", 53.4f,1.15f);

        g.agregarArista("PEREIRA", "ARMENIA", 46,1.06f);

        g.agregarArista("ARMENIA", "IBAGUE", 80.6f,2.55f);
        g.agregarArista("ARMENIA", "TULUA", 87.1f,1.36f);

        g.agregarArista("IBAGUE", "GIRARDOT", 68.2f,1.18f);

        g.agregarArista("GIRARDOT", "MELGAR", 24.9f,0.5f);
        g.agregarArista("GIRARDOT", "SOACHA", 116,2.73f);
        g.agregarArista("GIRARDOT", "NEIVA", 181,2.73f);

        g.agregarArista("MELGAR", "SOACHA", 91.4f,2.33f);

        g.agregarArista("SOACHA", "BOGOTA", 25.1f,1);
        g.agregarArista("SOACHA", "VILLAVICENCIO", 115,3.11f);

        g.agregarArista("TULUA", "PALMIRA", 78.5f,1.26f);

        g.agregarArista("BUENAVENTURA", "CALI", 114,2.55f);
        
        g.agregarArista("PALMIRA", "CALI", 33.1f,1.04f);
        
        g.agregarArista("CALI", "POPAYAN", 141,3.04f);

        g.agregarArista("NEIVA", "POPAYAN", 268,6.16f);
        g.agregarArista("NEIVA", "SAN VICENTE DEL CAGUAN", 200,6.15f);
        g.agregarArista("NEIVA", "MOCOA", 320,7.1f);

        g.agregarArista("POPAYAN", "MOCOA", 292,6.51f);
        g.agregarArista("POPAYAN", "PASTO", 244,5.65f);

        g.agregarArista("SAN VICENTE DEL CAGUAN", "MOCOA", 398,9.13f);

        g.agregarArista("MOCOA", "PASTO", 146,4.75f);
        
        g.agregarArista("PASTO", "TUMACO", 274,5.53f);

      
        //Modificar las tarifas al grafo
        g.agregarTarifa("RIOHACHA", 25000);
        g.agregarTarifa("AGUACHICA", 10000);
        g.agregarTarifa("ARAUCA", 20000);
        g.agregarTarifa("BARRANCABERMEJA", 10000);
        g.agregarTarifa("BUENAVENTURA", 20000);
        g.agregarTarifa("MAICAO", 20000);
        g.agregarTarifa("MALAGA", 10000);
        g.agregarTarifa("MOCOA", 25000);
        g.agregarTarifa("OCAÑA", 10000);
        g.agregarTarifa("PUERTO WILCHES", 10000);
        g.agregarTarifa("QUIBDO", 25000);
        g.agregarTarifa("SABANA DE TORRES", 10000);
        g.agregarTarifa("SAN VICENTE DEL CAGUAN", 20000);
        g.agregarTarifa("TUMACO", 25000);
        g.agregarTarifa("YOPAL", 20000);
        g.agregarTarifa("ZAPATOCA", 10000);
        g.agregarTarifa("SAN VICENTE DE CHUCURI", 10000);

    }
    //--------------------------------------------------------------------------
    
    //------ Con este metodo se ingresan los paquetes que se van a llevar ------
    public void agregarPaquete(String nombrePedido, String ciudadDestino, float volumen, float peso, String destinatario){
        aux.add(new Paquete(nombrePedido, ciudadDestino, volumen, peso, destinatario)); //se agrega primeramente a una lista auxiliar
    }
    //--------------------------------------------------------------------------

    //----- ORDENAR LOS PAQUETES SEGUN EL ORDEN DE LAS CIUDADES EN EL GRAFO ----
    public void ordenPaquetes(){
        paquetes.clear(); //primero se quita todos los elementos de la lista paquetes (esto para cuando se va hacer esta accion por segunda vez o mas)
        //SE ORDENAN LAS CIUDADES A PARTIR DEL ORDEN PROPUESTO A LA HORA DE CREAR El GRAFO
        
        //El primer for va pasando de ciudad en ciudad segun el orden en que se guardaron las ciudades
        for(int i = 1; i < g.getCiudades().size(); i++) {
            //El segundo for guarda los paquetes a medida que el destino de paquete es igual a la ciudad iterada por el primer for
            for (int j = 0; j < aux.size(); j++) {
                String destino = aux.get(j).getCiudadDestino();
                //VALIDA PRIORIDAD DE PEDIDO POR MEDIO DE LA LISTA DE CIUDADES DE LA CLASE GRAFO
                if(destino.equals(g.getCiudades().get(i))){
                    paquetes.add(aux.get(j));
                }
             }
        }
    }
    //--------------------------------------------------------------------------
    
    //----------------- COLOCAR LOS PAQUETES EN CADA CAMION --------------------
    public void pedidosAVehiculos(){
        //Se vacia la lista de vehiculos por si ya antes fue llamado el metodo
        vehiculos.clear();
        
        //Se organizan primeramente los paquetes
        ordenPaquetes();
        
        //Se hace recorridos minimos pero destinado para poder conocer cuantas horas requiere ir de un lugar a otro
        g.trayecto2();
        
        //EMPIEZA CONTEO DE CARROS DE LA EMPPRESA QUE ES UN MAXIMO DE 15
        int numCarros = 1;
        //Variable para conteo en el while
        int cont = 0;
        
        //Se comienza a agregar los paquetes hasta que no hallan mas en la lista o se llegue al maximo de carros
        while(!paquetes.isEmpty() && numCarros <= 15){
            //Variable para validar que no exceda tiempos demasiados altos
            float horas = 0;
            //VARIABLES PARA VALIDAR QUE EL CAMION NO LLEGUE AL LIMITE DE PESO O VOLUMEN
            int peso = 0;
            int volumen = 0;
            
            //CREA UN NUEVO VEHICULO
            Vehiculo carro = new Vehiculo(numCarros);
            
            //VALIDA SI HAY PAQUETES QUE SUPEREN EL PESO MAXIMO O EL VOLUMEN MAXIMO
            while(cont < paquetes.size()){
                if(paquetes.get(cont).getPeso() > carro.getPESOMAX() || paquetes.get(cont).getVolumen() > carro.getVOLUMENMAX() && cont < paquetes.size()){
                    System.out.println("XXXXXXXXXXXXXXXXXXX PAQUETE IMPOSIBLE DE LLEVAR XXXXXXXXXXXXXXXXXXXXXXX");
                    paquetes.get(cont).imprimir();
                    paquetes.remove(cont);
                }
                //si no cumple la condicion de exceso de peso pasa al siguiente pedido
                else{
                    cont++;
                }
            }
            
            //COLOCA LOS PAQUETES EN CADA CAMION
            String origen = "BUCARAMANGA";
            cont = 0; //mantiene el contador ante del while en cero
            int canti = 0; //calcula cuantos pedidos van en el carro
            
            //Se montan los paquetes al vehiculo
            while(cont < paquetes.size()){
                //VALIDA QUE NO SE SUPERE EL VOLUMEN Y EL PESO DEL CAMION
                if( peso + paquetes.get(cont).getPeso() <= carro.getPESOMAX() && volumen + paquetes.get(cont).getVolumen()<=carro.getVOLUMENMAX() && horas <= 20){
                    //agrega el paquete al vehiculo
                    carro.agregarPedidos(paquetes.get(cont));
                    //Va acumulando el peso y volumen que va soportando el camion para evitar que supere el maximo
                    peso += paquetes.get(cont).getPeso();
                    volumen += paquetes.get(cont).getVolumen();
                    
                    //ACUMULA LAS HORAS PARA EVITAR LAPSOS DEMASIADOS LARGOS DE TIEMPO
                        //esta condicion evita que si dos o mas paquetes van para el mismo destino, no acumule horas de trayecto
                    if(!origen.equals(paquetes.get(cont).getCiudadDestino())){
                        //se obtiene las coordenadas del origen y el destino para luego saber el tiempo de trayecto
                        int x = g.getCiudades().indexOf(origen);
                        int y = g.getCiudades().indexOf(paquetes.get(cont).getCiudadDestino());
                        //se van acumulando a las horas a partir del metodo especifico de recorrido minimo para el tiempo maximo
                        horas += g.getPesos()[x][y];
                        //se cambia el origen por el destino para repetir el proceso
                        origen = paquetes.get(cont).getCiudadDestino();
                    }
                    //una vez agregado el paquete se quita de la lista paquetes
                    paquetes.remove(cont);
                    //hace conteo de cuantos pedidos van en el vehiculo
                    canti++;
                }
                else{
                    /*
                    Pasa al siguiente pedido si por ejemplo queda poco espacio en el camion y el pedido excede el peso maximo o se
                    llegó al limite de horas por recorrido
                    */
                    cont++;
                }
            }
            
            //SE AGREGA EL CARRO A UNA LISTA VEHICULOS
            vehiculos.add(carro);
            //cuentas los carros
            numCarros++;
        }
    }
    //--------------------------------------------------------------------------

    //-------------------- Simula la entrega de pedidos ------------------------
    public void entregaPedido(){
        //Inicializa los costos e ingresos en cero por si qe simula una segunda vez o mas
        costos = 0;
        ingresos = 0;
        
        //Se montan los pedidos al vehiculo
        pedidosAVehiculos();
        
        //Se comienza el proceso de impresion de envios de cada vehiculo
        for (int i = 0; i < vehiculos.size(); i++) {
            System.out.println("");
            System.out.println("//------------------------------- CAMION #" + (i+1) + " -------------------------//");
            //Cantidad de pedidos en el carro
            int cantidad = vehiculos.get(i).getPedidos().size();
            
            for (int j = 0; j < cantidad; j++) {
                //VALIDAR LAS CIUADES A VISITAR CON LOS PEDIDOS
                String destino =  vehiculos.get(i).getPedidos().get(j).getCiudadDestino();
                g.visita(destino);
            }
            
            // Se hace los recorridos minimos para cada ciudad a visitar
            g.trayecto();
            
            
            System.out.println("");
            System.out.println("/---------------------- ENTREGA DE PAQUETE ----------------------/");

            //Obtener la fecha actual
            LocalDateTime fechaActual = LocalDateTime.now();
            //Formato de como se muestra la fecha            
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            //impresion de la fecha actual
            System.out.println("Fecha actual: " + fechaActual.format(formatter));
            
            float tiempo = 0; //acumula el tiempo para llegada de cada pedido
            //Impresion de cada paquete en vehiculo con sus respectiva informacion
            for (int j = 0; j < cantidad; j++) {
                //VALIDAR LAS CIUADES A VISITAR CON LOS PEDIDOS
                String destino =  vehiculos.get(i).getPedidos().get(j).getCiudadDestino();
                g.visitado(destino);
                
                //genera el pedido para estimar su entrega
                System.out.println("------------------- PAQUETE #" + (j+1) + " ---------------");
                System.out.println("ID: " + vehiculos.get(i).getPedidos().get(j).getId());
                System.out.println("Nombre del producto: " + vehiculos.get(i).getPedidos().get(j).getNombrePedido());
                System.out.println("Nombre del destinatario: " + vehiculos.get(i).getPedidos().get(j).getDestinatario());
                System.out.println("Ciudad de destino: " + vehiculos.get(i).getPedidos().get(j).getCiudadDestino());
                
                //Calculo de precio del envio
                 //valor de la tarifa a la ciudad espeficia de destino
                int destinoCosto = g.getTarifas(vehiculos.get(i).getPedidos().get(j).getCiudadDestino());
                 //se agrega costo adicional por el peso que tenga (por cada kilogramo)
                int costoTotal = 3000 * ( (int) vehiculos.get(i).getPedidos().get(j).getPeso() )+ destinoCosto - 3000;
                System.out.println("Costo de envio: " + costoTotal);
                
                //Acumulacion de ingresos
                ingresos += costoTotal;
                
                //calcula el tiempo de llegada de cada pedido a su ciudad de destino                
                for (int k = 0; k < g.getAristas().size(); k++) {
                    if(destino.equals(g.getCiudades().get(g.getAristas().get(k).getDestino()))){
                        tiempo = g.getAristas().get(k).getPeso();
                    }
                }
                
                //A partir de la fecha actual se obtiene la estimacion de cuando llega el pedido a la ciudad de destino
                //Agregar la cantidad de horas que transcurren
                int temp = (int) tiempo;
                LocalDateTime nuevaFecha = fechaActual.plusHours(temp);

                System.out.println("fecha estimada de llegada del pedido: " + nuevaFecha.format(formatter));
            }
            
            //elimina los anteriores recorridos para calcular el nuevo recorrido del siguiente camion
            g.vaciarRecorrido();

            System.out.println("----------------------------------------------------------------------");
            
            //Generacion de ganancias a partir de los ingresos y costos
            costos = (float) (ingresos * 0.4);
            
            
        }
        
    }
    
    //Genera costos ingresos y utilidades despues de simular un envio
    public void utilidades(){
        if(ingresos != 0){
            System.out.println("-> Ingresos totales de la empresa: " + ingresos);
            System.out.println("-> Costos totales de la empresa: " + costos);
            System.out.println("-> Utilidades totales de la empresa: " + (int)(ingresos - costos));
            System.out.println("");
            
        }
        else{
            System.out.println("Todavía no se ha simulado envio para obtener las utilidades.");
        }
    }
    
}
