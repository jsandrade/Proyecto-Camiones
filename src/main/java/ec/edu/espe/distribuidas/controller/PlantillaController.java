/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.controller;


import ec.edu.espe.distribuidas.model.XeusuUsuar;
import java.io.Serializable;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class PlantillaController implements Serializable{
    private XeusuUsuar us;

    public XeusuUsuar getUs() {
        return us;
    }


    
    public void verificarSesion(){
        us=null;
        try {
            FacesContext context=FacesContext.getCurrentInstance();
            us=(XeusuUsuar)context.getExternalContext().getSessionMap().get("usuario");
            if (us==null) {
                context.getExternalContext().redirect("./../permisos.xhtml");
            }
        } catch (Exception e) {
        }
        
    }
}
