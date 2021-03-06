/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.ejb;

import ec.edu.espe.distribuidas.model.CepedPedid;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Juan
 */
@Local
public interface CepedPedidFacadeLocal {

    void create(CepedPedid cepedPedid);

    void edit(CepedPedid cepedPedid);

    void remove(CepedPedid cepedPedid);

    CepedPedid find(Object id);

    List<CepedPedid> findAll();

    List<CepedPedid> findRange(int[] range);

    int count();
    
}
