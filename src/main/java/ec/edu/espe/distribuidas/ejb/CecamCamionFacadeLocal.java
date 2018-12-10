/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.ejb;

import ec.edu.espe.distribuidas.model.CecamCamion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Juan
 */
@Local
public interface CecamCamionFacadeLocal {

    void create(CecamCamion cecamCamion);

    void edit(CecamCamion cecamCamion);

    void remove(CecamCamion cecamCamion);

    CecamCamion find(Object id);

    List<CecamCamion> findAll();

    List<CecamCamion> findRange(int[] range);

    int count();
    
}
