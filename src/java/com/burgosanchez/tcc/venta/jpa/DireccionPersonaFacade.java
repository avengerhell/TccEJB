/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.burgosanchez.tcc.venta.jpa;

import com.burgosanchez.tcc.venta.ejb.DireccionPersona;
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
public class DireccionPersonaFacade extends AbstractFacade<DireccionPersona> {

    @PersistenceContext(unitName = "TccEJBPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DireccionPersonaFacade() {
        super(DireccionPersona.class);
    }
    
    public Integer obtenerSecuenciaVal() {
        Integer val = null;
        String sq = "";
        try {
            sq = "tcc.sq_direccion.nextval";
            val = super.getSecuenceVal(sq);
        } catch (Exception ex) {
            val = 0;
            System.out.println(ex);
        }
        return val;
    }
    
    public DireccionPersona obtenerDireccion(String per, String dir) {
        DireccionPersona result;

        try {
            StringBuilder sql = new StringBuilder();

            sql.append("SELECT d.* ");
            sql.append("  FROM direccion_persona d ");
            sql.append(" WHERE d.cod_persona = ?");
            sql.append("   AND d.cod_direccion = ?");
            
            Query q = getEntityManager().createNativeQuery(sql.toString(), DireccionPersona.class);
            q.setParameter(1,per);
            q.setParameter(2,dir);
            
            List l = q.getResultList();
            if (l == null || l.isEmpty()) {
                return null;
            }
            //q.setHint("javax.persistence.cache.storeMode", "REFRESH");
            result = (DireccionPersona) l.get(0);
            return result;
        } catch (Exception ex) {
            return null;
        }

    }
    
}
