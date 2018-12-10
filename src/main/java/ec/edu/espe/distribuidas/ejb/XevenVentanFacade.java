/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.ejb;

import ec.edu.espe.distribuidas.model.XevenVentan;
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
public class XevenVentanFacade extends AbstractFacade<XevenVentan>  {

    @PersistenceContext(unitName = "ec.edu.espe.arquitectura_ProyectoCamiones_war_1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public XevenVentanFacade() {
        super(XevenVentan.class);
    }
    public List<XevenVentan> findXOpcion(String codOpcion){
        List<XevenVentan> lstVentanas=null;         
        String consulta;
        try {
            consulta = "FROM XevenVentan e WHERE e.xeopcCodopc =?1";
            Query query = em.createQuery(consulta);
            query.setParameter(1, codOpcion);
            lstVentanas = query.getResultList();

        } catch (Exception e) {
            throw e;
        }

        return lstVentanas;
    }
}
