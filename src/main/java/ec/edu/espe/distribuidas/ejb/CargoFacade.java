/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.ejb;

import ec.edu.espe.distribuidas.model.PecarCargo;
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
public class CargoFacade extends AbstractFacade<PecarCargo> {

    @PersistenceContext(unitName = "ec.edu.espe.arquitectura_ProyectoCamiones_war_1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CargoFacade() {
        super(PecarCargo.class);
    }
    public String findXCodCargo(String codCargo) {
        String value = "No encontrado.";
        String consulta;
        try {
            consulta = "FROM PecarCargo e WHERE e.pecarCargoPK.pecarCodigo =?1";
            Query query = em.createQuery(consulta);
            query.setParameter(1, codCargo);
            List<PecarCargo> lista = query.getResultList();
            if (!lista.isEmpty()) {
                value = lista.get(0).getPecarDescri();
            }
        } catch (Exception e) {
            throw e;
        }
        return value;
    }
}
