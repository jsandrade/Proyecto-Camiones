/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.ejb;

import ec.edu.espe.distribuidas.model.PeprvProvin;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Juan
 */
@Local
public interface PeprvProvinFacadeLocal {

    void create(PeprvProvin peprvProvin);

    void edit(PeprvProvin peprvProvin);

    void remove(PeprvProvin peprvProvin);

    PeprvProvin find(Object id);

    List<PeprvProvin> findAll();

    List<PeprvProvin> findRange(int[] range);

    int count();
    
}
