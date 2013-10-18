/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;


import java.util.Collection;
import modelo.Persona;

public interface PersonaDAO {
    
    public void create(Persona persona);

    public Persona find(Long Id);

    public void update(Persona persona);

    public void delete(Long personaId) ;

    public Collection findAll();
}
