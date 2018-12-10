/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.ejb;

import ec.edu.espe.distribuidas.model.XeopeOperfi;
import ec.edu.espe.distribuidas.model.XeperPerfil;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Juan
 */
@Local
public interface OpcionPerfilFacadeLocal {

    void create(XeopeOperfi xeopeOperfi);

    void edit(XeopeOperfi xeopeOperfi);

    void remove(XeopeOperfi xeopeOperfi);

    XeopeOperfi find(Object id);

    List<XeopeOperfi> findAll();

    List<XeopeOperfi> findRange(int[] range);

    int count();
    
     List<XeopeOperfi> findXPerfil(String codPerfil);
    
}
