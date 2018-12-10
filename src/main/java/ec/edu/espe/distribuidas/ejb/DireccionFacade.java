/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.ejb;

import ec.edu.espe.distribuidas.model.PedirDirecc;
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
public class DireccionFacade extends AbstractFacade<PedirDirecc> {

    @PersistenceContext(unitName = "ec.edu.espe.arquitectura_ProyectoCamiones_war_1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DireccionFacade() {
        super(PedirDirecc.class);
    }

    public String findXCodDireccion(String codDireccion) {
        String value = "No encontrado.";
        String consulta;
        try {
            consulta = "FROM PedirDirecc e WHERE e.pedirCodigo =?1";
            Query query = em.createQuery(consulta);
            query.setParameter(1, codDireccion);
            List<PedirDirecc> lista = query.getResultList();
            if (!lista.isEmpty()) {
                value = lista.get(0).getPedirCllpri()+" y "
                        +lista.get(0).getPedirCllsec()+", "
                        +lista.get(0).getPedirDescri();
            }
        } catch (Exception e) {
            throw e;
        }
        return value;
    }
}
