/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.ejb;

import ec.edu.espe.distribuidas.model.PeempEmplea;
import ec.edu.espe.distribuidas.model.XeusuUsuar;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Juan
 */
@Stateless
public class PeempEmpleaFacade extends AbstractFacade<PeempEmplea> implements PeempEmpleaFacadeLocal {

    @PersistenceContext(unitName = "ec.edu.espe.arquitectura_ProyectoCamiones_war_1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PeempEmpleaFacade() {
        super(PeempEmplea.class);
    }

    @Override
    public PeempEmplea findXCedula(String cedula) {
        PeempEmplea empleado=null;

        String consulta;
        try {
            consulta = "FROM PeempEmplea e WHERE e.peempCedula =?1";
            Query query = em.createQuery(consulta);
            query.setParameter(1, cedula);
            List<PeempEmplea> lista = query.getResultList();
            if (!lista.isEmpty()) {
                empleado = lista.get(0);
            }
        } catch (Exception e) {
            throw e;
        }

        return empleado;
    }

    @Override
    public PeempEmplea findXCodEmpleado(String codigoEmpleado) {
         PeempEmplea empleado=null;

        String consulta;
        try {
            consulta = "FROM PeempEmplea e WHERE e.peempCodigo  =?1";
            Query query = em.createQuery(consulta);
            query.setParameter(1, codigoEmpleado);
            List<PeempEmplea> lista = query.getResultList();
            if (!lista.isEmpty()) {
                empleado = lista.get(0);
            }
        } catch (Exception e) {
            throw e;
        }

        return empleado;
    }

}
