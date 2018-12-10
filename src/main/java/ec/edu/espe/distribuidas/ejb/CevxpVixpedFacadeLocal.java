/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.ejb;

import ec.edu.espe.distribuidas.model.CevxpVixped;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Juan
 */
@Local
public interface CevxpVixpedFacadeLocal {

    void create(CevxpVixped cevxpVixped);

    void edit(CevxpVixped cevxpVixped);

    void remove(CevxpVixped cevxpVixped);

    CevxpVixped find(Object id);

    List<CevxpVixped> findAll();

    List<CevxpVixped> findRange(int[] range);

    int count();
    
}
