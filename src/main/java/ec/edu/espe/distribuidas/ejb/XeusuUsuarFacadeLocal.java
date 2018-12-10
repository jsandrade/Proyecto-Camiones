/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.ejb;

import ec.edu.espe.distribuidas.model.XeusuUsuar;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Juan
 */
@Local
public interface XeusuUsuarFacadeLocal {

    void create(XeusuUsuar xeusuUsuar);

    void edit(XeusuUsuar xeusuUsuar);

    void remove(XeusuUsuar xeusuUsuar);

    XeusuUsuar find(Object id);

    List<XeusuUsuar> findAll();

    List<XeusuUsuar> findRange(int[] range);

    int count();
    
    XeusuUsuar findXCodPersona(String CodigoPersona);
    
   
    
}
