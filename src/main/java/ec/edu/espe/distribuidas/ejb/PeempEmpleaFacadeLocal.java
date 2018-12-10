/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.ejb;

import ec.edu.espe.distribuidas.model.PeempEmplea;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Juan
 */
@Local
public interface PeempEmpleaFacadeLocal {

    void create(PeempEmplea peempEmplea);

    void edit(PeempEmplea peempEmplea);

    void remove(PeempEmplea peempEmplea);

    PeempEmplea find(Object id);

    List<PeempEmplea> findAll();

    List<PeempEmplea> findRange(int[] range);

    int count();
    
    PeempEmplea findXCedula(String cedula);
    
}
