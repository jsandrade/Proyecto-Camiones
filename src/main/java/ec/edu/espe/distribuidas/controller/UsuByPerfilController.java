/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.controller;

import ec.edu.espe.distribuidas.ejb.XeperPerfilFacade;
import ec.edu.espe.distribuidas.ejb.XeuxpUsuperFacadeLocal;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import org.primefaces.model.DualListModel;

/**
 *
 * @author Juan
 */
@Named("usuByPer")
@SessionScoped
public class UsuByPerfilController implements Serializable{
    @EJB
    private XeuxpUsuperFacadeLocal usuPerfilEJB;
    @EJB
    private XeperPerfilFacade ejbFacade;
    private String tipoUsuario;
    
    private DualListModel<String> cities;

    public DualListModel<String> getCities() {
        return cities;
    }

    public void setCities(DualListModel<String> cities) {
        this.cities = cities;
    }
  
    
    private Map<String, String> mapTipo;

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public Map<String, String> getMapTipo() {
        return mapTipo;
    }

    public void setMapTipo(Map<String, String> mapTipo) {
        this.mapTipo = mapTipo;
    }

    public UsuByPerfilController() {
        mapTipo=new HashMap<String, String>();
        mapTipo.put("Administrador", "1");
        mapTipo.put("Empleado", "1");
        
        List<String> citiesSource = new ArrayList<String>();
        List<String> citiesTarget = new ArrayList<String>();
         
        citiesSource.add("San Francisco");
        citiesSource.add("London");
        citiesSource.add("Paris");
        citiesSource.add("Istanbul");
        citiesSource.add("Berlin");
        citiesSource.add("Barcelona");
        citiesSource.add("Rome");
         
        cities = new DualListModel<String>(citiesSource, citiesTarget);
         
     
   
    }
    
}
