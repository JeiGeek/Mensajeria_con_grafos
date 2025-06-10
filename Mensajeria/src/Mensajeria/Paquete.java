/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mensajeria;

import java.util.Random;

/**
 *
 * @autores Steven Rey - Sara Patiño - Jeison Guarguati
 */
public class Paquete {
    private String nombrePedido;
    private String ciudadDestino;
    private float volumen;
    private float peso;
    private String destinatario;
    private int id;

    public Paquete(String nombrePedido, String ciudadDestino, float volumen, float peso, String destinatario) {
        this.nombrePedido = nombrePedido;
        this.ciudadDestino = ciudadDestino;
        this.volumen = volumen;
        this.peso = peso;
        this.destinatario = destinatario;
        
        Random ident = new Random();
        id = ident.nextInt(1000,9999);
    }
    
    
    
    //----------------------------- GETTERS ----------------------------------//
    public String getNombrePedido() {
        return nombrePedido;
    }

    public String getCiudadDestino() {
        return ciudadDestino;
    }

    public float getVolumen() {
        return volumen;
    }

    public float getPeso() {
        return peso;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public int getId() {
        return id;
    }
    //--------------------------------------------------------------------------
    
    //------------------------------------------------------------------------//
    
    public void imprimir(){
        System.out.println("ID producto: " + id);
        System.out.println("Nombre del producto: " + nombrePedido);
        System.out.println("Destinatario: " + destinatario);
        System.out.println("Ciudad de destino: " + ciudadDestino);
        System.out.println("Peso: " + peso);
    }
    //--------------------------------------------------------------------------
}