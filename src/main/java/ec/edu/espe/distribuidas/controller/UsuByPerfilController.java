/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.controller;

import ec.edu.espe.distribuidas.ejb.PeempEmpleaFacadeLocal;
import ec.edu.espe.distribuidas.ejb.XeperPerfilFacade;
import ec.edu.espe.distribuidas.ejb.XeusuUsuarFacadeLocal;
import ec.edu.espe.distribuidas.ejb.XeuxpUsuperFacadeLocal;
import ec.edu.espe.distribuidas.model.PeempEmplea;
import ec.edu.espe.distribuidas.model.XeusuUsuar;
import ec.edu.espe.distribuidas.model.XeuxpUsuper;
import ec.edu.espe.distribuidas.model.XeuxpUsuperPK;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Named;
import org.primefaces.model.DualListModel;
import sun.security.util.Pem;

/**
 *
 * @author Juan
 */
@Named("usuByPer")
@SessionScoped
public class UsuByPerfilController implements Serializable {

    @EJB
    private XeuxpUsuperFacadeLocal usuXPerfilEJB;
    @EJB
    private XeperPerfilFacade ejbFacade;
    @EJB
    private PeempEmpleaFacadeLocal empleadoEJB;
    private String tipoUsuario;

    private List<String> userSource;
    private List<String> userTarget;

    private DualListModel<String> dualUsuarios;

    public DualListModel<String> getDualUsuarios() {
        return dualUsuarios;
    }

    public void setDualUsuarios(DualListModel<String> dualUsuarios) {
        this.dualUsuarios = dualUsuarios;
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
        mapTipo = new HashMap<String, String>();
        mapTipo.put("Administrador", "001");
        mapTipo.put("Empleado", "002");

        List<String> citiesSource = new ArrayList<String>();
        List<String> citiesTarget = new ArrayList<String>();

        dualUsuarios = new DualListModel<String>(citiesSource, citiesTarget);

    }

    public void cargarUsuarios(AjaxBehaviorEvent event) {
        FacesContext context = FacesContext.getCurrentInstance();
        userSource = new ArrayList<>();
        userTarget = new ArrayList<>();
        llenarDatosE();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Lista actualizada"));

        dualUsuarios = new DualListModel<>(userSource, userTarget);
    }

    private void llenarDatosE() {
        List<XeuxpUsuper> lstUxuXPerfil = usuXPerfilEJB.findAll();
        List<PeempEmplea> lstEmpelados = empleadoEJB.findAll();
        //Mapa para nombres de usuario con codigo de usuario
        Map<String, PeempEmplea> mapEmpleados = new HashMap<String, PeempEmplea>();
        for (PeempEmplea E : lstEmpelados) {
            mapEmpleados.put(E.getPeempCodigo(), E);
        }
        for (XeuxpUsuper pUs : lstUxuXPerfil) {
            PeempEmplea get = mapEmpleados.get(pUs.getXeuxpUsuperPK().getPeempCodigo());
            if (pUs.getXeuxpUsuperPK().getXeperCodper().equals(tipoUsuario)) {
                userTarget.add(get.getPeempNombre() + " " + get.getPeempApelli());
            } else {
                userSource.add(get.getPeempNombre() + " " + get.getPeempApelli());
            }
        }

    }

    public void cambiarPermisos() {
        List<XeuxpUsuper> lstUxuXPerfil = usuXPerfilEJB.findAll();
        List<PeempEmplea> lstEmpelados = empleadoEJB.findAll();
        //Mapa para nombres de usuario con codigo de usuario
        Map<String, PeempEmplea> mapEmpleados = new HashMap<String, PeempEmplea>();
        for (PeempEmplea E : lstEmpelados) {
            mapEmpleados.put(E.getPeempNombre() + " " + E.getPeempApelli(), E);
        }
        //Mapa para usuaios por pefil
        Map<String, XeuxpUsuper> mapUsuXPerfil = new HashMap<String, XeuxpUsuper>();
        for (XeuxpUsuper U : lstUxuXPerfil) {
            mapUsuXPerfil.put(U.getXeuxpUsuperPK().getPeempCodigo(), U);
        }

        FacesContext context = FacesContext.getCurrentInstance();
        if (!tipoUsuario.equals("0")) {
            for (String nomUsuario : dualUsuarios.getTarget()) {
                PeempEmplea get = mapEmpleados.get(nomUsuario);
                XeuxpUsuper get1 = mapUsuXPerfil.get(get.getPeempCodigo());
                if (!get1.getXeuxpUsuperPK().getXeperCodper().equals(tipoUsuario)) {
                    usuXPerfilEJB.remove(get1);
                    XeuxpUsuperPK xeuxpUsuperPK = get1.getXeuxpUsuperPK();
                    xeuxpUsuperPK.setXeperCodper(tipoUsuario);
                    get1.setXeuxpUsuperPK(xeuxpUsuperPK);
                    get1.setXeuxpFeccam(new Date());
                    usuXPerfilEJB.create(get1);
                }
            }
        } else {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "Es necesario que seleccione un tipo de cuenta"));
        }
    }

}
