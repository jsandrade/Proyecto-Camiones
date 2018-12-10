/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.ejb;

import ec.edu.espe.distribuidas.model.XesisSistem;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Juan
 */
@Local
public interface XesisSistemFacadeLocal {

    void create(XesisSistem xesisSistem);

    void edit(XesisSistem xesisSistem);

    void remove(XesisSistem xesisSistem);

    XesisSistem find(Object id);

    List<XesisSistem> findAll();

    List<XesisSistem> findRange(int[] range);

    int count();
    
    
    
}
