/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.ejb;

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
public class XeusuUsuarFacade extends AbstractFacade<XeusuUsuar> implements XeusuUsuarFacadeLocal {

    @PersistenceContext(unitName = "ec.edu.espe.arquitectura_ProyectoCamiones_war_1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public XeusuUsuarFacade() {
        super(XeusuUsuar.class);
    }

    @Override
    public XeusuUsuar findXCodPersona(String CodigoPersona) {
        XeusuUsuar usuario=null;         
        String consulta;
        try {
            consulta = "FROM XeusuUsuar e WHERE e.peempCodigo =?1";
            Query query = em.createQuery(consulta);
            query.setParameter(1, CodigoPersona);
            List<XeusuUsuar> lista = query.getResultList();
            if (!lista.isEmpty()) {
                usuario = lista.get(0);
            }
        } catch (Exception e) {
            throw e;
        }

        return usuario;
    }
    
}
