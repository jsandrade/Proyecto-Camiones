/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.ejb;

import ec.edu.espe.distribuidas.model.CetieTienda;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Juan
 */
@Local
public interface CetieTiendaFacadeLocal {

    void create(CetieTienda cetieTienda);

    void edit(CetieTienda cetieTienda);

    void remove(CetieTienda cetieTienda);

    CetieTienda find(Object id);

    List<CetieTienda> findAll();

    List<CetieTienda> findRange(int[] range);

    int count();
    
}
