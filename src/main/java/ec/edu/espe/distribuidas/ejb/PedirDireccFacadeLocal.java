/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.ejb;

import ec.edu.espe.distribuidas.model.PedirDirecc;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Juan
 */
@Local
public interface PedirDireccFacadeLocal {

    void create(PedirDirecc pedirDirecc);

    void edit(PedirDirecc pedirDirecc);

    void remove(PedirDirecc pedirDirecc);

    PedirDirecc find(Object id);

    List<PedirDirecc> findAll();

    List<PedirDirecc> findRange(int[] range);

    int count();
    
}
