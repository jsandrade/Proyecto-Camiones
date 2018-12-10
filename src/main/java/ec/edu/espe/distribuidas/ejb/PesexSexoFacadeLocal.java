/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.ejb;

import ec.edu.espe.distribuidas.model.PesexSexo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Juan
 */
@Local
public interface PesexSexoFacadeLocal {

    void create(PesexSexo pesexSexo);

    void edit(PesexSexo pesexSexo);

    void remove(PesexSexo pesexSexo);

    PesexSexo find(Object id);

    List<PesexSexo> findAll();

    List<PesexSexo> findRange(int[] range);

    int count();
    
}
