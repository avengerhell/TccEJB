/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.burgosanchez.tcc.venta.jpa;

import com.burgosanchez.tcc.venta.ejb.CondicionEvento;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author TID01
 */
@Stateless
public class CondicionEventoFacade extends AbstractFacade<CondicionEvento> {

    @PersistenceContext(unitName = "TccEJBPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CondicionEventoFacade() {
        super(CondicionEvento.class);
    }
    
    public Integer obtenerSecuenciaVal() {
        Integer val = null;
        String sq = "";
        try {
            sq = "tcc.sq_condicion_evento.nextval";
            val = super.getSecuenceVal(sq);
        } catch (Exception ex) {
            val = 0;
            System.out.println(ex);
        }
        return val;
    }
    public List<CondicionEvento> obtenerCondicionEven(String cod){
        
        try{
            StringBuilder sb = new StringBuilder();

            sb.append(" SELECT c ");
            sb.append(" FROM CondicionEvento c ");
            sb.append(" WHERE c.eventoCab.codEvento = ?1 ");

            Query q = getEntityManager().createQuery(sb.toString());
            q.setParameter(1, cod);

            return (List<CondicionEvento>) q.getResultList();
        }catch(Exception e){
            System.out.println(e);
            return null;
        }
    }
}
