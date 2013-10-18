/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

/**
 *
 * @author roso
 */
public class HolaService {
    public String diHola(String nombre,String clave){
        //abrir la Base de datos
        return "Usuario: "+nombre+"\n"+"clave: "+clave;
    }
}