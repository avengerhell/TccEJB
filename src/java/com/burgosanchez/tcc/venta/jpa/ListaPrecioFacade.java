/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.burgosanchez.tcc.venta.jpa;

import com.burgosanchez.tcc.venta.ejb.ListaPrecio;
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
public class ListaPrecioFacade extends AbstractFacade<ListaPrecio> {

    @PersistenceContext(unitName = "TccEJBPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ListaPrecioFacade() {
        super(ListaPrecio.class);
    }
    
    public Integer obtenerSecuenciaVal() {
        Integer val = null;
        String sq = "";
        try {
            sq = "tcc.sq_lista_precio.nextval";
            val = super.getSecuenceVal(sq);
        } catch (Exception ex) {
            val = 0;
            System.out.println(ex);
        }
        return val;
    }
    
    public List<ListaPrecio> obtenerCondicionEven(String cod){
        
        try{
            StringBuilder sb = new StringBuilder();

            sb.append(" SELECT l ");
            sb.append(" FROM ListaPrecio l ");
            sb.append(" WHERE l.eventoCab.codEvento = ?1 ");

            Query q = getEntityManager().createQuery(sb.toString());
            q.setParameter(1, cod);

            return (List<ListaPrecio>) q.getResultList();
        }catch(Exception e){
            System.out.println(e);
            return null;
        }
    }
}
