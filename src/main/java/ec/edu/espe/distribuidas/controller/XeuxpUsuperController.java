package ec.edu.espe.distribuidas.controller;

import ec.edu.espe.distribuidas.model.XeuxpUsuper;
import ec.edu.espe.distribuidas.controller.util.JsfUtil;
import ec.edu.espe.distribuidas.controller.util.PaginationHelper;
import ec.edu.espe.distribuidas.ejb.XeuxpUsuperFacade;
import ec.edu.espe.distribuidas.ejb.XeuxpUsuperFacadeLocal;

import java.io.Serializable;
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

@Named("xeuxpUsuperController")
@SessionScoped
public class XeuxpUsuperController implements Serializable {

    private XeuxpUsuper current;
    private DataModel items = null;
    @EJB
    private XeuxpUsuperFacadeLocal ejbFacade;
    private PaginationHelper pagination;
    private int selectedItemIndex;

    public XeuxpUsuperController() {
    }

    public XeuxpUsuper getSelected() {
        if (current == null) {
            current = new XeuxpUsuper();
            current.setXeuxpUsuperPK(new ec.edu.espe.distribuidas.model.XeuxpUsuperPK());
            selectedItemIndex = -1;
        }
        return current;
    }

    private XeuxpUsuperFacadeLocal getFacade() {
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
        current = (XeuxpUsuper) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }

    public String prepareCreate() {
        current = new XeuxpUsuper();
        current.setXeuxpUsuperPK(new ec.edu.espe.distribuidas.model.XeuxpUsuperPK());
        selectedItemIndex = -1;
        return "Create";
    }

    public String create() {
        try {
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/BundleUsuXPerfil").getString("XeuxpUsuperCreated"));
            return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/BundleUsuXPerfil").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (XeuxpUsuper) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "Edit";
    }

    public String update() {
        try {
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/BundleUsuXPerfil").getString("XeuxpUsuperUpdated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/BundleUsuXPerfil").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String destroy() {
        current = (XeuxpUsuper) getItems().getRowData();
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
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/BundleUsuXPerfil").getString("XeuxpUsuperDeleted"));
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/BundleUsuXPerfil").getString("PersistenceErrorOccured"));
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

    public XeuxpUsuper getXeuxpUsuper(ec.edu.espe.distribuidas.model.XeuxpUsuperPK id) {
        return ejbFacade.find(id);
    }

    @FacesConverter(forClass = XeuxpUsuper.class)
    public static class XeuxpUsuperControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            XeuxpUsuperController controller = (XeuxpUsuperController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "xeuxpUsuperController");
            return controller.getXeuxpUsuper(getKey(value));
        }

        ec.edu.espe.distribuidas.model.XeuxpUsuperPK getKey(String value) {
            ec.edu.espe.distribuidas.model.XeuxpUsuperPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new ec.edu.espe.distribuidas.model.XeuxpUsuperPK();
            key.setPeempCodigo(values[0]);
            key.setXeperCodper(values[1]);
            key.setXeuxpFecasi(java.sql.Date.valueOf(values[2]));
            return key;
        }

        String getStringKey(ec.edu.espe.distribuidas.model.XeuxpUsuperPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getPeempCodigo());
            sb.append(SEPARATOR);
            sb.append(value.getXeperCodper());
            sb.append(SEPARATOR);
            sb.append(value.getXeuxpFecasi());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof XeuxpUsuper) {
                XeuxpUsuper o = (XeuxpUsuper) object;
                return getStringKey(o.getXeuxpUsuperPK());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + XeuxpUsuper.class.getName());
            }
        }

    }

}
