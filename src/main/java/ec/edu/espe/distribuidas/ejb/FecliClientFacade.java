/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.ejb;

import ec.edu.espe.distribuidas.model.FecliClient;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Juan
 */
@Stateless
public class FecliClientFacade extends AbstractFacade<FecliClient> implements FecliClientFacadeLocal {

    @PersistenceContext(unitName = "ec.edu.espe.arquitectura_ProyectoCamiones_war_1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FecliClientFacade() {
        super(FecliClient.class);
    }
    
}
