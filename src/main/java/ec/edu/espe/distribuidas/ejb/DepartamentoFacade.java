/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.ejb;

import ec.edu.espe.distribuidas.model.PedepDepart;
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
public class DepartamentoFacade extends AbstractFacade<PedepDepart> {

    @PersistenceContext(unitName = "ec.edu.espe.arquitectura_ProyectoCamiones_war_1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DepartamentoFacade() {
        super(PedepDepart.class);
    }

    public String findXCodDepar(String codDepar) {
        String value = "No encontrado.";
        String consulta;
        try {
            consulta = "FROM PedepDepart e WHERE e.pedepCodigo =?1";
            Query query = em.createQuery(consulta);
            query.setParameter(1, codDepar);
            List<PedepDepart> lista = query.getResultList();
            if (!lista.isEmpty()) {
                value = lista.get(0).getPedepDescri();
            }
        } catch (Exception e) {
            throw e;
        }
        return value;
    }
}
