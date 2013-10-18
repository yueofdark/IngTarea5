/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.PersonaSpringDAO;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import modelo.Persona;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import servicio.ServiciosPersona;
import javax.servlet.http.HttpServletResponse;

/** 
 *
 * @author yue
 */
public class controladorPersona extends SimpleFormController {

    public controladorPersona() {
        setCommandClass(Persona.class);
        setCommandName("afe");
        setFormView("index");
    }

    @Override
    protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {
        List<Persona> listado=new ArrayList(1);
        String accion = "No seleccionada ";
        Persona persona = (Persona) command;
        int opcionSeleccionada = verificaAccion(request);

        switch (opcionSeleccionada) {
            case 0: {insertar(persona);accion = "Almacenado";break;}
            case 1: {persona=buscar(persona);eliminar(persona);accion = "Eliminado";break;}
            case 2: {modificar(persona);accion = "Modificado";break;}
            case 3: {persona=buscar(persona);accion = "Consultado";break;}
            case 4: {listado=listar();accion = "Listado";break;}
        }

        ModelAndView mv = new ModelAndView(getSuccessView());
        
        if(opcionSeleccionada==0 || opcionSeleccionada==1 || opcionSeleccionada==2 ){
            mv.addObject("respuestaServidor",
                serviciosPersona.imprimeDatos(accion,
                persona.getClave(), persona.getNombre(),
                persona.getTipo()));
        }else if(opcionSeleccionada==3){
            mv.addObject("afe", persona);
        }else if(opcionSeleccionada==4){
            mv.addObject("listado",listado);
        }
        return mv;
    }

    private int verificaAccion(HttpServletRequest request) {
        if ("Insertar".equals(request.getParameter("Insertar"))) {
            return 0;
        } else if ("Eliminar".equals(request.getParameter("Eliminar"))) {
            return 1;
        } else if ("Modificar".equals(request.getParameter("Modificar"))) {
            return 2;
        } else if ("Buscar".equals(request.getParameter("Buscar"))) {
            return 3;
        } else if ("Listar".equals(request.getParameter("Listar"))) {
            return 4;
        }
        return -1;
    }

    private void insertar(Persona persona) {
        setSuccessView("respuesta");
        personaSpringDAO.create(persona);
    }

    private void eliminar(Persona persona) {
        setSuccessView("respuesta");
        personaSpringDAO.delete(persona.getId());
    }

    private void modificar(Persona persona) {
        setSuccessView("respuesta");
        personaSpringDAO.update(persona);
    }

    private Persona buscar(Persona persona) {
        setSuccessView("index");
        return personaSpringDAO.find(persona.getId());
    }

    private List<Persona> listar() {
        setSuccessView("listado");
        return (List<Persona>)personaSpringDAO.findAll();
    }

    public void setServiciosPersona(ServiciosPersona serviciosPersona) {
        this.serviciosPersona = serviciosPersona;
    }

    public void setPersonaSpringDAO(PersonaSpringDAO personaSpringDAO) {
        this.personaSpringDAO = personaSpringDAO;
    }
    private ServiciosPersona serviciosPersona;
    private PersonaSpringDAO personaSpringDAO;
}
