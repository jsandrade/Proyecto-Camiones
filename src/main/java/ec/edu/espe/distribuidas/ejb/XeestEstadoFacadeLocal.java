/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.ejb;

import ec.edu.espe.distribuidas.model.XeestEstado;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Juan
 */
@Local
public interface XeestEstadoFacadeLocal {

    void create(XeestEstado xeestEstado);

    void edit(XeestEstado xeestEstado);

    void remove(XeestEstado xeestEstado);

    XeestEstado find(Object id);

    List<XeestEstado> findAll();

    List<XeestEstado> findRange(int[] range);

    int count();
    
}
