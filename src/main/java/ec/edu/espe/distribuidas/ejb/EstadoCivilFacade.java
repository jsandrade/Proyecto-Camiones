/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.ejb;

import ec.edu.espe.distribuidas.model.PeescEstciv;
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
public class EstadoCivilFacade extends AbstractFacade<PeescEstciv> {

    @PersistenceContext(unitName = "ec.edu.espe.arquitectura_ProyectoCamiones_war_1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstadoCivilFacade() {
        super(PeescEstciv.class);
    }

    public String findXCodEstCiv(String codEstCiv) {
        String value = "No encontrado.";
        String consulta;
        try {
            consulta = "FROM PeescEstciv e WHERE e.peescCodigo =?1";
            Query query = em.createQuery(consulta);
            query.setParameter(1, codEstCiv);
            List<PeescEstciv> lista = query.getResultList();
            if (!lista.isEmpty()) {
                value = lista.get(0).getPeescDescri();
            }
        } catch (Exception e) {
            throw e;
        }
        return value;
    }

}
