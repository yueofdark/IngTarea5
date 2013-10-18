/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicio;

/**
 *
 * @author Martin
 */
public class ServiciosPersona {
    
    public String imprimeDatos(String mensaje,String clave,String nombre, String tipo){
        String rpta="";
        rpta="<p>"+mensaje+" Correctamente</p>"
                + "<p>Nombre:  "+nombre+"</p>"
                + "<p>Clave: "+clave+"</p>"
                + "<p>Tipo: "+tipo+"</p>";
        return rpta;
    }
}
