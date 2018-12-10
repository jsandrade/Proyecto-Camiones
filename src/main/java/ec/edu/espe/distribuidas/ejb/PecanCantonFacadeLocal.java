/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.ejb;

import ec.edu.espe.distribuidas.model.PecanCanton;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Juan
 */
@Local
public interface PecanCantonFacadeLocal {

    void create(PecanCanton pecanCanton);

    void edit(PecanCanton pecanCanton);

    void remove(PecanCanton pecanCanton);

    PecanCanton find(Object id);

    List<PecanCanton> findAll();

    List<PecanCanton> findRange(int[] range);

    int count();
    
}
