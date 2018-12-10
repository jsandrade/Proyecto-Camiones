/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.ejb;

import ec.edu.espe.distribuidas.model.FefopForpag;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Juan
 */
@Local
public interface FefopForpagFacadeLocal {

    void create(FefopForpag fefopForpag);

    void edit(FefopForpag fefopForpag);

    void remove(FefopForpag fefopForpag);

    FefopForpag find(Object id);

    List<FefopForpag> findAll();

    List<FefopForpag> findRange(int[] range);

    int count();
    
}
