/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.ejb;

import ec.edu.espe.distribuidas.model.XerolRol;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Juan
 */
@Local
public interface XerolRolFacadeLocal {

    void create(XerolRol xerolRol);

    void edit(XerolRol xerolRol);

    void remove(XerolRol xerolRol);

    XerolRol find(Object id);

    List<XerolRol> findAll();

    List<XerolRol> findRange(int[] range);

    int count();
    
}
