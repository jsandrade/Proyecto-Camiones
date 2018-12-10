/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.ejb;

import ec.edu.espe.distribuidas.model.PesexSexo;
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
public class SexoFacade extends AbstractFacade<PesexSexo>  {

    @PersistenceContext(unitName = "ec.edu.espe.arquitectura_ProyectoCamiones_war_1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SexoFacade() {
        super(PesexSexo.class);
    }

    public String findXCodSexo(String codSexo) {
        String value = "No encontrado.";
        String consulta;
        try {
            consulta = "FROM PesexSexo e WHERE e.pesexCodigo =?1";
            Query query = em.createQuery(consulta);
            query.setParameter(1, codSexo);
            List<PesexSexo> lista = query.getResultList();
            if (!lista.isEmpty()) {
                value = lista.get(0).getPesexDescri();
            }
        } catch (Exception e) {
            throw e;
        }
        return value;
    }
}
