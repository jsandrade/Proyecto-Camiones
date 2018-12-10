/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.ejb;

import ec.edu.espe.distribuidas.model.PedepDepart;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Juan
 */
@Local
public interface PedepDepartFacadeLocal {

    void create(PedepDepart pedepDepart);

    void edit(PedepDepart pedepDepart);

    void remove(PedepDepart pedepDepart);

    PedepDepart find(Object id);

    List<PedepDepart> findAll();

    List<PedepDepart> findRange(int[] range);

    int count();
    
}
