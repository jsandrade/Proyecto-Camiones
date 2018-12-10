/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.ejb;

import ec.edu.espe.distribuidas.model.FecabCabcra;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Juan
 */
@Local
public interface FecabCabcraFacadeLocal {

    void create(FecabCabcra fecabCabcra);

    void edit(FecabCabcra fecabCabcra);

    void remove(FecabCabcra fecabCabcra);

    FecabCabcra find(Object id);

    List<FecabCabcra> findAll();

    List<FecabCabcra> findRange(int[] range);

    int count();
    
}
