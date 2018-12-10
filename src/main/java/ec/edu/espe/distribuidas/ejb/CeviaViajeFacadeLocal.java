/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.ejb;

import ec.edu.espe.distribuidas.model.CeviaViaje;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Juan
 */
@Local
public interface CeviaViajeFacadeLocal {

    void create(CeviaViaje ceviaViaje);

    void edit(CeviaViaje ceviaViaje);

    void remove(CeviaViaje ceviaViaje);

    CeviaViaje find(Object id);

    List<CeviaViaje> findAll();

    List<CeviaViaje> findRange(int[] range);

    int count();
    
}
