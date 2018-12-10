/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.ejb;

import ec.edu.espe.distribuidas.model.PecarCargo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Juan
 */
@Local
public interface PecarCargoFacadeLocal {

    void create(PecarCargo pecarCargo);

    void edit(PecarCargo pecarCargo);

    void remove(PecarCargo pecarCargo);

    PecarCargo find(Object id);

    List<PecarCargo> findAll();

    List<PecarCargo> findRange(int[] range);

    int count();
    
}
