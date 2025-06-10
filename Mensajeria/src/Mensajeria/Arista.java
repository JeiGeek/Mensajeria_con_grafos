/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mensajeria;

/**
 *
 * @autores Steven Rey - Sara Patiño - Jeison Guarguati
 */
public class Arista {
    private int origen;
    private int destino;
    private float peso;

    public Arista(int origen, int destino, float peso) {
        this.origen = origen;
        this.peso = peso;
        this.destino = destino;
    }
    
    //----------------------------- GETTERS ----------------------------------//
    public int getOrigen() {
        return origen;
    }

    public int getDestino() {
        return destino;
    }
    

    public float getPeso() {
        return peso;
    }

    public void setDestino(int destino) {
        this.destino = destino;
    }
    
    public void imprimir(){
        System.out.println("Peso: " + peso + ". Origen: " + origen + ". Destino: " + destino + "." );
    }
    //--------------------------------------------------------------------------
}
