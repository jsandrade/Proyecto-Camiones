/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.ejb;

import ec.edu.espe.distribuidas.model.PeprqParro;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Juan
 */
@Local
public interface PeprqParroFacadeLocal {

    void create(PeprqParro peprqParro);

    void edit(PeprqParro peprqParro);

    void remove(PeprqParro peprqParro);

    PeprqParro find(Object id);

    List<PeprqParro> findAll();

    List<PeprqParro> findRange(int[] range);

    int count();
    
}
