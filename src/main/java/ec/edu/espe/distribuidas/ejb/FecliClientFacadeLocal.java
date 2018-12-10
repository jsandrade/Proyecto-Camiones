/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.ejb;

import ec.edu.espe.distribuidas.model.FecliClient;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Juan
 */
@Local
public interface FecliClientFacadeLocal {

    void create(FecliClient fecliClient);

    void edit(FecliClient fecliClient);

    void remove(FecliClient fecliClient);

    FecliClient find(Object id);

    List<FecliClient> findAll();

    List<FecliClient> findRange(int[] range);

    int count();
    
}
