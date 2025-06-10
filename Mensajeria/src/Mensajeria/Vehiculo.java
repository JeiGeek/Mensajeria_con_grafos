/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mensajeria;

import java.util.LinkedList;

/**
 *
 * @autores Steven Rey - Sara Patiño - Jeison Guarguati
 */
public class Vehiculo {
    
    private int numeroVehiculo;
    private float peso;
    private float volumen;
    private final float PESOMAX = 8500; //KILOGRAMOS
    private final float VOLUMENMAX = 25000; //METROS CUBICOS
    LinkedList <Paquete> pedidos;

    public Vehiculo(int numeroVehiculo) {
        this.numeroVehiculo = numeroVehiculo;
        this.pedidos = new LinkedList();
        this.peso = 0;
        this.volumen = 0;
    }
    
    public void agregarPedidos(Paquete pedido){
        pedidos.add(pedido);
    }
    
    //--------------------------- GETTERS ------------------------------------//
    public int getNumeroVehiculo() {
        return numeroVehiculo;
    }

    public LinkedList<Paquete> getPedidos() {
        return pedidos;
    }

    public float getPESOMAX() {
        return PESOMAX;
    }

    public float getVOLUMENMAX() {
        return VOLUMENMAX;
    }
    //--------------------------------------------------------------------------
    
    //---------------------------- SETTERS -----------------------------------//
    public void setPeso(float peso) {
        this.peso = peso;
    }

    public void setVolumen(float volumen) {
        this.volumen = volumen;
    }
    //--------------------------------------------------------------------------
    
    //--------------------------------------------------------------------------
    public void imprimir(){
        System.out.println("-------- PAQUETES POR LLEVAR -------");
        for (int i = 0; i < pedidos.size(); i++) {
            System.out.println("---- PAQUETE #" + (i+1) + " ----");
            pedidos.get(i).imprimir();
        }
    }
    //--------------------------------------------------------------------------
}
