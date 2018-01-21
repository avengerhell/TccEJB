/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.burgosanchez.tcc.venta.jpa;

import com.burgosanchez.tcc.venta.ejb.TelPersona;
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
public class TelPersonaFacade extends AbstractFacade<TelPersona> {

    @PersistenceContext(unitName = "TccEJBPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TelPersonaFacade() {
        super(TelPersona.class);
    }
    
    public Integer obtenerSecuenciaVal() {
        Integer val = null;
        String sq = "";
        try {
            sq = "tcc.sq_telefono.nextval";
            val = super.getSecuenceVal(sq);
        } catch (Exception ex) {
            val = 0;
            System.out.println(ex);
        }
        return val;
    }
    
   public TelPersona obtenerTelefono(String per, String tel) {
        TelPersona result;

        try {
            StringBuilder sql = new StringBuilder();

            sql.append("SELECT t.* ");
            sql.append("  FROM tel_persona t ");
            sql.append(" WHERE t.cod_persona = ?");
            sql.append("   AND t.cod_telefono = ?");
            
            Query q = getEntityManager().createNativeQuery(sql.toString(), TelPersona.class);
            q.setParameter(1,per);
            q.setParameter(2,tel);
            
            List l = q.getResultList();
            if (l == null || l.isEmpty()) {
                return null;
            }
            //q.setHint("javax.persistence.cache.storeMode", "REFRESH");
            result = (TelPersona) l.get(0);
            return result;
        } catch (Exception ex) {
            return null;
        }

    }
    
}
