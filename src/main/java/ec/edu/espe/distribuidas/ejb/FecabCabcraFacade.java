/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.ejb;

import ec.edu.espe.distribuidas.model.FecabCabcra;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Juan
 */
@Stateless
public class FecabCabcraFacade extends AbstractFacade<FecabCabcra> implements FecabCabcraFacadeLocal {

    @PersistenceContext(unitName = "ec.edu.espe.arquitectura_ProyectoCamiones_war_1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FecabCabcraFacade() {
        super(FecabCabcra.class);
    }
    
}
