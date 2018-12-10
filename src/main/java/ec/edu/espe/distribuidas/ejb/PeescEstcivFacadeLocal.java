/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.ejb;

import ec.edu.espe.distribuidas.model.PeescEstciv;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Juan
 */
@Local
public interface PeescEstcivFacadeLocal {

    void create(PeescEstciv peescEstciv);

    void edit(PeescEstciv peescEstciv);

    void remove(PeescEstciv peescEstciv);

    PeescEstciv find(Object id);

    List<PeescEstciv> findAll();

    List<PeescEstciv> findRange(int[] range);

    int count();
    
}
