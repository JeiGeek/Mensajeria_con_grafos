/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mensajeria;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Jeison
 */
public class main {
         
    public static void main(String[] args) {

        
        Screen pantalla =  new Screen();
        pantalla.listaDefectoPaquetes();
        pantalla.setVisible(true);
        pantalla.setLocationRelativeTo(pantalla);
        
        
        
    }
}
