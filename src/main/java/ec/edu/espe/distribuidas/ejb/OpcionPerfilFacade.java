/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.ejb;

import ec.edu.espe.distribuidas.model.XeopeOperfi;
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
public class OpcionPerfilFacade extends AbstractFacade<XeopeOperfi> implements OpcionPerfilFacadeLocal {

    @PersistenceContext(unitName = "ec.edu.espe.arquitectura_ProyectoCamiones_war_1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OpcionPerfilFacade() {
        super(XeopeOperfi.class);
    }

    @Override
    public List<XeopeOperfi> findXPerfil(String codPerfil) {
        
        List<XeopeOperfi> lstOpcionesPerfil =null;
        String consulta;
        try {
            System.out.println("COD: "+codPerfil);
            consulta = "FROM XeopeOperfi e WHERE e.xeperCodper =?1";
            Query query = em.createQuery(consulta);
            query.setParameter(1, codPerfil);
            lstOpcionesPerfil = query.getResultList();
            
        } catch (Exception e) {
            throw e;
        }
        return lstOpcionesPerfil;
    }
    
}
