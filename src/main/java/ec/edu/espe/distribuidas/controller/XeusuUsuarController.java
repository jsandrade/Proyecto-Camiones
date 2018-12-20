package ec.edu.espe.distribuidas.controller;

import ec.edu.espe.distribuidas.model.XeusuUsuar;
import ec.edu.espe.distribuidas.controller.util.JsfUtil;
import ec.edu.espe.distribuidas.controller.util.PaginationHelper;
import ec.edu.espe.distribuidas.ejb.EstadoSeguridades;
import ec.edu.espe.distribuidas.ejb.PeempEmpleaFacadeLocal;
import ec.edu.espe.distribuidas.ejb.XeusuUsuarFacade;
import ec.edu.espe.distribuidas.ejb.XeusuUsuarFacadeLocal;
import ec.edu.espe.distribuidas.model.PeempEmplea;
import ec.edu.espe.distribuidas.model.XeestEstado;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;

@Named("xeusuUsuarController")
@SessionScoped
public class XeusuUsuarController implements Serializable {

    private XeusuUsuar current;
    private DataModel items = null;
    @EJB
    private XeusuUsuarFacadeLocal usuEJB;
    private PaginationHelper pagination;
    private int selectedItemIndex;
    
    @EJB
    private EstadoSeguridades estadoEJB;
    
    @EJB
    private PeempEmpleaFacadeLocal empleadoEJB;
    
    private String Estado;

    private Map<String, String> mapEstado;
    private Map<String, String> mapEmpleados;

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public Map<String, String> getMapEstado() {
        return mapEstado;
    }

    public void setMapEstado(Map<String, String> mapEstado) {
        this.mapEstado = mapEstado;
    }

    public Map<String, String> getMapEmpleados() {
        return mapEmpleados;
    }

    public void setMapEmpleados(Map<String, String> mapEmpleados) {
        this.mapEmpleados = mapEmpleados;
    }
    
    
    private void ColocarOpciones() {
        mapEstado = new HashMap<String, String>();
        for (XeestEstado estSeg : estadoEJB.findAll()) {
            mapEstado.put(estSeg.getXeestDescri(),estSeg.getXeestCodigo());
            
        }
        mapEmpleados=new HashMap<>();
        Map<String,String> codUsuarios=new HashMap<String,String>();
        for (XeusuUsuar auxUsu:usuEJB.findAll()) {
            codUsuarios.put(auxUsu.getPeempCodigo(), auxUsu.getPeempCodigo());
        }
        List<PeempEmplea> lstEmpleados=empleadoEJB.findAll();
        System.out.println("Usuarios: "+codUsuarios.size()+"  Empleados: "+lstEmpleados.size());
        for (int i = 0; i < lstEmpleados.size(); i++) {
            PeempEmplea E=lstEmpleados.get(i);
            if (!codUsuarios.containsKey(E.getPeempCodigo())) {
                mapEmpleados.put(E.getPeempNombre()+" "+E.getPeempApelli(), E.getPeempCodigo());
            }else{
                System.out.println("Compara con: "+E.getPeempCodigo());
            }
        }

    }

    public XeusuUsuarController() {
        
    }

    public XeusuUsuar getSelected() {
        if (current == null) {
            current = new XeusuUsuar();
            selectedItemIndex = -1;
        }
        return current;
    }

    private XeusuUsuarFacadeLocal getFacade() {
        return usuEJB;
    }

    public PaginationHelper getPagination() {
        if (pagination == null) {
            pagination = new PaginationHelper(10) {

                @Override
                public int getItemsCount() {
                    return getFacade().count();
                }

                @Override
                public DataModel createPageDataModel() {
                    return new ListDataModel(getFacade().findRange(new int[]{getPageFirstItem(), getPageFirstItem() + getPageSize()}));
                }
            };
        }
        return pagination;
    }

    public String prepareList() {
        recreateModel();
        return "List";
    }

    public String prepareView() {
        current = (XeusuUsuar) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }

    public String prepareCreate() {
        current = new XeusuUsuar();
        selectedItemIndex = -1;
        ColocarOpciones();
        return "Create";
    }

    public String create() {
        try {
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("XeusuUsuarCreated"));
            return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (XeusuUsuar) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "Edit";
    }

    public String update() {
        try {
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("XeusuUsuarUpdated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String destroy() {
        current = (XeusuUsuar) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        performDestroy();
        recreatePagination();
        recreateModel();
        return "List";
    }

    public String destroyAndView() {
        performDestroy();
        recreateModel();
        updateCurrentItem();
        if (selectedItemIndex >= 0) {
            return "View";
        } else {
            // all items were removed - go back to list
            recreateModel();
            return "List";
        }
    }

    private void performDestroy() {
        try {
            getFacade().remove(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("XeusuUsuarDeleted"));
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
        }
    }

    private void updateCurrentItem() {
        int count = getFacade().count();
        if (selectedItemIndex >= count) {
            // selected index cannot be bigger than number of items:
            selectedItemIndex = count - 1;
            // go to previous page if last page disappeared:
            if (pagination.getPageFirstItem() >= count) {
                pagination.previousPage();
            }
        }
        if (selectedItemIndex >= 0) {
            current = getFacade().findRange(new int[]{selectedItemIndex, selectedItemIndex + 1}).get(0);
        }
    }

    public DataModel getItems() {
        if (items == null) {
            items = getPagination().createPageDataModel();
        }
        return items;
    }

    private void recreateModel() {
        items = null;
    }

    private void recreatePagination() {
        pagination = null;
    }

    public String next() {
        getPagination().nextPage();
        recreateModel();
        return "List";
    }

    public String previous() {
        getPagination().previousPage();
        recreateModel();
        return "List";
    }

    public SelectItem[] getItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(usuEJB.findAll(), false);
    }

    public SelectItem[] getItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(usuEJB.findAll(), true);
    }

    public XeusuUsuar getXeusuUsuar(java.lang.String id) {
        return usuEJB.find(id);
    }

    @FacesConverter(forClass = XeusuUsuar.class)
    public static class XeusuUsuarControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            XeusuUsuarController controller = (XeusuUsuarController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "xeusuUsuarController");
            return controller.getXeusuUsuar(getKey(value));
        }

        java.lang.String getKey(String value) {
            java.lang.String key;
            key = value;
            return key;
        }

        String getStringKey(java.lang.String value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof XeusuUsuar) {
                XeusuUsuar o = (XeusuUsuar) object;
                return getStringKey(o.getPeempCodigo());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + XeusuUsuar.class.getName());
            }
        }

    }

}
