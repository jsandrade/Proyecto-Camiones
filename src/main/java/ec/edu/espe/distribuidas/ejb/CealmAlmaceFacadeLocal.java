/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.ejb;

import ec.edu.espe.distribuidas.model.CealmAlmace;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Juan
 */
@Local
public interface CealmAlmaceFacadeLocal {

    void create(CealmAlmace cealmAlmace);

    void edit(CealmAlmace cealmAlmace);

    void remove(CealmAlmace cealmAlmace);

    CealmAlmace find(Object id);

    List<CealmAlmace> findAll();

    List<CealmAlmace> findRange(int[] range);

    int count();
    
}
