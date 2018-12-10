/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.ejb;

import ec.edu.espe.distribuidas.model.FedefDetfac;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Juan
 */
@Local
public interface FedefDetfacFacadeLocal {

    void create(FedefDetfac fedefDetfac);

    void edit(FedefDetfac fedefDetfac);

    void remove(FedefDetfac fedefDetfac);

    FedefDetfac find(Object id);

    List<FedefDetfac> findAll();

    List<FedefDetfac> findRange(int[] range);

    int count();
    
}
