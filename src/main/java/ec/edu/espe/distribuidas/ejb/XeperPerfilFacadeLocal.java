/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.ejb;

import ec.edu.espe.distribuidas.model.XeperPerfil;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Juan
 */
@Local
public interface XeperPerfilFacadeLocal {

    void create(XeperPerfil xeperPerfil);

    void edit(XeperPerfil xeperPerfil);

    void remove(XeperPerfil xeperPerfil);

    XeperPerfil find(Object id);

    List<XeperPerfil> findAll();

    List<XeperPerfil> findRange(int[] range);

    int count();
    
}
