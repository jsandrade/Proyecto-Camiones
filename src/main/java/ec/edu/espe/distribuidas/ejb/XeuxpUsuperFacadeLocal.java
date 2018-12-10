/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.ejb;

import ec.edu.espe.distribuidas.model.XeusuUsuar;
import ec.edu.espe.distribuidas.model.XeuxpUsuper;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Juan
 */
@Local
public interface XeuxpUsuperFacadeLocal {

    void create(XeuxpUsuper xeuxpUsuper);

    void edit(XeuxpUsuper xeuxpUsuper);

    void remove(XeuxpUsuper xeuxpUsuper);

    XeuxpUsuper find(Object id);

    List<XeuxpUsuper> findAll();

    List<XeuxpUsuper> findRange(int[] range);

    int count();
    
    XeuxpUsuper findXUser(XeusuUsuar usuario);
    
}
