/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.burgosanchez.tcc.venta.jpa;

import com.burgosanchez.tcc.venta.ejb.LocalidadEvento;
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
public class LocalidadEventoFacade extends AbstractFacade<LocalidadEvento> {

    @PersistenceContext(unitName = "TccEJBPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LocalidadEventoFacade() {
        super(LocalidadEvento.class);
    }
    
    public Integer obtenerSecuenciaVal() {
        Integer val = null;
        String sq = "";
        try {
            sq = "tcc.sq_localidad_evento.nextval";
            val = super.getSecuenceVal(sq);
        } catch (Exception ex) {
            val = 0;
            System.out.println(ex);
        }
        return val;
    }
    
     public List<LocalidadEvento> obtenerLocal(String cod){
        
        try{
            StringBuilder sb = new StringBuilder();

            sb.append(" SELECT l ");
            sb.append(" FROM LocalidadEvento l ");
            sb.append(" WHERE l.eventoCab.codEvento = ?1 ");

            Query q = getEntityManager().createQuery(sb.toString());
            q.setParameter(1, cod);

            return (List<LocalidadEvento>) q.getResultList();
        }catch(Exception e){
            System.out.println(e);
            return null;
        }
    }
}
