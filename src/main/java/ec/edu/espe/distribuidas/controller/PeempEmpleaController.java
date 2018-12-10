package ec.edu.espe.distribuidas.controller;

import ec.edu.espe.distribuidas.ejb.CargoFacade;
import ec.edu.espe.distribuidas.ejb.DepartamentoFacade;
import ec.edu.espe.distribuidas.ejb.DireccionFacade;
import ec.edu.espe.distribuidas.ejb.EstadoCivilFacade;
import ec.edu.espe.distribuidas.ejb.PeempEmpleaFacadeLocal;
import ec.edu.espe.distribuidas.ejb.SexoFacade;
import ec.edu.espe.distribuidas.model.PecarCargo;
import ec.edu.espe.distribuidas.model.PedepDepart;
import ec.edu.espe.distribuidas.model.PeempEmplea;
import ec.edu.espe.distribuidas.model.PeescEstciv;
import ec.edu.espe.distribuidas.model.PesexSexo;
import ec.edu.espe.distribuidas.util.JsfUtil;
import ec.edu.espe.distribuidas.util.PaginationHelper;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;
import javax.annotation.PostConstruct;
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

@Named("peempEmpleaController")
@SessionScoped
public class PeempEmpleaController implements Serializable {

    private PeempEmplea current;
    private DataModel items = null;
    @EJB
    private PeempEmpleaFacadeLocal ejbFacade;
    private PaginationHelper pagination;
    private int selectedItemIndex;

    @EJB
    private SexoFacade sexoEJB;
    @EJB
    private EstadoCivilFacade estCivilEJB;
    @EJB
    private DireccionFacade direccionEJB;
    @EJB
    private DepartamentoFacade departamentoEJB;
    @EJB
    private CargoFacade cargoEJB;

    private String Sexo;
    private String EstadoCivil;
    private String Discapacidad;
    private String Departamento;
    private String Cargo;
    private String Estado;
    private String Direccion;

    private Map<String, String> mapSexo;
    private Map<String, String> mapEstCivil;
    private Map<String, String> mapDepartamento;
    private Map<String, String> mapCargo;
    private Map<String, String> mapDiscapacidad;
    private Map<String, String> mapEstado;

    public Map<String, String> getMapDiscapacidad() {
        return mapDiscapacidad;
    }

    public Map<String, String> getMapEstado() {
        return mapEstado;
    }

    public Map<String, String> getMapDepartamento() {
        return mapDepartamento;
    }

    public Map<String, String> getMapCargo() {
        return mapCargo;
    }

    
    
    public Map<String, String> getMapEstCivil() {
        return mapEstCivil;
    }

    public Map<String, String> getMapSexo() {
        return mapSexo;
    }

    public String getSexo() {
        return Sexo;
    }

    public String getEstadoCivil() {
        return EstadoCivil;
    }

    public String getDiscapacidad() {
        return Discapacidad;
    }

    public String getDepartamento() {
        return Departamento;
    }

    public String getCargo() {
        return Cargo;
    }

    public String getEstado() {
        return Estado;
    }

    public String getDireccion() {
        return Direccion;
    }

    public PeempEmpleaController() {
    }

    public PeempEmplea getSelected() {
        if (current == null) {
            current = new PeempEmplea();
            selectedItemIndex = -1;

        }

        return current;
    }

    private void obtenerDatosEspecificos(PeempEmplea actual) {
        //ESTADO
        if (actual.getPeempEstado() == 1) {
            Estado = "Activo";
        } else {
            Estado = "Deshabilitado";
        }
        //SEXO
        Sexo = sexoEJB.findXCodSexo(actual.getPesexCodigo() + "");
        //ESTADO CIVIL
        EstadoCivil = estCivilEJB.findXCodEstCiv(actual.getPeescCodigo() + "");
        //Discapacidad
        if (actual.getPeempDiscapa() == 1) {
            Discapacidad = "Ninguna";
        } else {
            Discapacidad = "Visual";
        }
        //Departamento
        Departamento = departamentoEJB.findXCodDepar(actual.getPedepCodigo());
        //Cargo
        Cargo = cargoEJB.findXCodCargo(actual.getPecarCodigo());
        //Direccion
        Direccion = direccionEJB.findXCodDireccion(actual.getPedirCodigo());
    }

    private PeempEmpleaFacadeLocal getFacade() {
        return ejbFacade;
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
        current = (PeempEmplea) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        obtenerDatosEspecificos(current);
        return "View";
    }

    public String prepareCreate() {
        current = new PeempEmplea();
        selectedItemIndex = -1;
        int num1,num2,num3;
        char car1,car2;
        num1=(int) (Math.random() * 10);
        num2=(int) (Math.random() * 10);
        num3=(int) (Math.random() * 10);
        car1=(char) ((int)(Math.random() * (91-65)+65));
        car2=(char) ((int)(Math.random() * (91-65)+65));
        current.setPeempCodigo(num1+""+car1+num3+num2+car2);
        ColocarOpciones();
        return "Create";
    }

    public String create() {
        try {
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("PeempEmpleaCreated"));
            return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (PeempEmplea) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        ColocarOpciones();
        return "Edit";
    }

    //Colocar las opciones de los datos a escoger
    private void ColocarOpciones() {
        mapSexo = new HashMap<String, String>();
        for (PesexSexo sex : sexoEJB.findAll()) {
            mapSexo.put(sex.getPesexDescri(),sex.getPesexCodigo());
            
        }
        mapEstCivil = new HashMap<String, String>();
        for (PeescEstciv est : estCivilEJB.findAll()) {
            mapEstCivil.put(est.getPeescDescri(),est.getPeescCodigo());
        }
        mapDepartamento=new HashMap<String, String>();
        for(PedepDepart dep:departamentoEJB.findAll()){
            mapDepartamento.put(dep.getPedepDescri(), dep.getPedepCodigo());
        }
        mapCargo= new HashMap<String, String>();
        for(PecarCargo car:cargoEJB.findAll()){
            mapCargo.put(car.getPecarDescri(),car.getPecarCargoPK().getPecarCodigo());
        }
            mapDiscapacidad= new HashMap<String, String>();
            mapDiscapacidad.put("Visual", "1");
            mapDiscapacidad.put("Auditiva", "2");
            mapDiscapacidad.put("Ninguna", "3");
            mapDiscapacidad.put("Otro", "4");
            mapEstado= new HashMap<String, String>();
            mapEstado.put("Habilitado", "1");
            mapEstado.put("Deshabilitado", "2");

    }

    public String update() {
        try {
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("PeempEmpleaUpdated"));
            obtenerDatosEspecificos(current);
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String destroy() {
        current = (PeempEmplea) getItems().getRowData();
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
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("PeempEmpleaDeleted"));
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
        return JsfUtil.getSelectItems(ejbFacade.findAll(), false);
    }

    public SelectItem[] getItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), true);
    }

    public PeempEmplea getPeempEmplea(java.lang.String id) {
        return ejbFacade.find(id);
    }

    @FacesConverter(forClass = PeempEmplea.class)
    public static class PeempEmpleaControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            PeempEmpleaController controller = (PeempEmpleaController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "peempEmpleaController");
            return controller.getPeempEmplea(getKey(value));
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
            if (object instanceof PeempEmplea) {
                PeempEmplea o = (PeempEmplea) object;
                return getStringKey(o.getPeempCodigo());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + PeempEmplea.class.getName());
            }
        }

    }

}
