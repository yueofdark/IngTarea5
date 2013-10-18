/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import service.HolaService;

/**
 *
 * @author roso
 */
public class HolaController extends SimpleFormController {
    
    private HolaService holaService;

    public void setHolaService(HolaService holaService) {
        this.holaService = holaService;
    }
    
    public HolaController() {
        //Initialize controller properties here or 
        //in the Web Application Context

        setCommandClass(Usuario.class);
        setCommandName("nombre1");
        setSuccessView("holaView");
        setFormView("nombreView");
    }
    
  
    //Use onSubmit instead of doSubmitAction 
    //when you need access to the Request, Response, or BindException objects
    
     @Override
     protected ModelAndView onSubmit(Object command) throws Exception {
     Usuario nombre = (Usuario)command;
     ModelAndView mv = new ModelAndView(getSuccessView());
     mv.addObject("holaMensaje",holaService.diHola(nombre.getNombre(),nombre.getClave()));
     
     return mv;
     }
     
}