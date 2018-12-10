/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.ejb;

import ec.edu.espe.distribuidas.model.XeopcOpcion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Juan
 */
@Local
public interface OpcionFacadeLocal {

    void create(XeopcOpcion xeopcOpcion);

    void edit(XeopcOpcion xeopcOpcion);

    void remove(XeopcOpcion xeopcOpcion);

    XeopcOpcion find(Object id);

    List<XeopcOpcion> findAll();

    List<XeopcOpcion> findRange(int[] range);

    int count();
    
    
}
