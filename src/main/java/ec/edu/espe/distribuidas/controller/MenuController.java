package ec.edu.espe.distribuidas.controller;

import ec.edu.espe.distribuidas.ejb.OpcionFacade;
import ec.edu.espe.distribuidas.model.XeopeOperfi;
import ec.edu.espe.distribuidas.model.XeusuUsuar;
import ec.edu.espe.distribuidas.model.XeuxpUsuper;
import ec.edu.espe.distribuidas.model.XevenVentan;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;
import ec.edu.espe.distribuidas.ejb.OpcionPerfilFacadeLocal;
import ec.edu.espe.distribuidas.ejb.XeuxpUsuperFacadeLocal;
import ec.edu.espe.distribuidas.ejb.XeusuUsuarFacadeLocal;
import ec.edu.espe.distribuidas.ejb.XevenVentanFacade;
import ec.edu.espe.distribuidas.model.XeopcOpcion;

@Named
@SessionScoped
public class MenuController implements Serializable {

    //USUARIO PERFIL
    @EJB
    private XeuxpUsuperFacadeLocal usuPerfilEjb;
    //USUARIO
    @EJB
    private XeusuUsuarFacadeLocal usuarioEjb;
    //VENTANA
    @EJB
    private XevenVentanFacade ventanaEjb;
    //OPCIONES PERFIL
    @EJB
    private OpcionPerfilFacadeLocal opcPerfilEJB;
    @EJB
    private OpcionFacade opcionEJB;

    //Lista de OPcionesPerfil
    private List<XeopeOperfi> lstOpcPerfil;
    private List<XevenVentan> lstVentanas;
    private List<XeopcOpcion> lstOpciones;

    private MenuModel model;

    @PostConstruct
    public void init() {
        //this.listarMenus();
        model = new DefaultMenuModel();
        this.establecerPermisos();

    }

    public MenuModel getModel() {
        return model;
    }

    public void listarMenus() {
        try {

        } catch (Exception e) {
        }
    }

    public void establecerPermisos() {
        XeusuUsuar us;
        XeuxpUsuper usPerfil = null;

        FacesContext context = FacesContext.getCurrentInstance();
        us = (XeusuUsuar) context.getExternalContext().getSessionMap().get("usuario");

        usPerfil = usuPerfilEjb.findXUser(us);
        if (usPerfil != null) {
            lstOpcPerfil = opcPerfilEJB.findXPerfil(usPerfil.getXeuxpUsuperPK().getXeperCodper());
        }
        DefaultMenuItem item = new DefaultMenuItem("Principal");
        item.setUrl("principal.xhtml");
        item.setIcon("ui-icon-home");
        item.setStyle("color:black;");
        model.addElement(item);
        DefaultSubMenu primerSubMenu;

        lstOpciones = opcionEJB.findAll();
        for (XeopeOperfi opt : lstOpcPerfil) {

            //Verificar si es padre, busco las ventanas que tiene <1 es padre
            lstVentanas = ventanaEjb.findXOpcion(opt.getXeopcCodopc());
            System.out.println("Numero: " + lstVentanas.size());
            for (XeopcOpcion subOpt : lstOpciones) {
                if (subOpt.getXeopcCodopc().equals(opt.getXeopcCodopc())) {
                    if (lstVentanas.size() > 1) {
                        primerSubMenu = new DefaultSubMenu(subOpt.getXeopcDescri());
                        for (XevenVentan aux : lstVentanas) {
                            item = new DefaultMenuItem(aux.getXevenDescri());
                            item.setUrl(aux.getXevenMensaj());
                            primerSubMenu.addElement(item);
                        }
                        model.addElement(primerSubMenu);
                    } else {
                        item = new DefaultMenuItem(subOpt.getXeopcDescri());
                        item.setUrl("../View/peempEmplea/List.xhtml");
                        model.addElement(item);
                    }

                }
            }
        }
    }

    public void cerrarSesion() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
    }
}
