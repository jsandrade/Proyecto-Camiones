/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.ejb;

import ec.edu.espe.distribuidas.model.XeusuUsuar;
import ec.edu.espe.distribuidas.model.XeuxpUsuper;
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
public class XeuxpUsuperFacade extends AbstractFacade<XeuxpUsuper> implements XeuxpUsuperFacadeLocal {

    @PersistenceContext(unitName = "ec.edu.espe.arquitectura_ProyectoCamiones_war_1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public XeuxpUsuperFacade() {
        super(XeuxpUsuper.class);
    }

    @Override
    public XeuxpUsuper findXUser(XeusuUsuar usuario) {
        XeuxpUsuper usuPerfil=null;
        String consulta;
        try {
            consulta = "FROM XeuxpUsuper e WHERE e.xeuxpUsuperPK.peempCodigo =?1";
            Query query = em.createQuery(consulta);
            query.setParameter(1, usuario.getPeempCodigo());
            List<XeuxpUsuper> lista = query.getResultList();
            if (!lista.isEmpty()) {
                usuPerfil = lista.get(0);
            }
        } catch (Exception e) {
            throw e;
        }
        return usuPerfil;
    }
    
}
