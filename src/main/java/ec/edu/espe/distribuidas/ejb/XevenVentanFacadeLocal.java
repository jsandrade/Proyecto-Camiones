/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.ejb;

import ec.edu.espe.distribuidas.model.XevenVentan;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Juan
 */
@Local
public interface XevenVentanFacadeLocal {

    void create(XevenVentan xevenVentan);

    void edit(XevenVentan xevenVentan);

    void remove(XevenVentan xevenVentan);

    XevenVentan find(Object id);

    List<XevenVentan> findAll();

    List<XevenVentan> findRange(int[] range);

    int count();
    
}
