/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.burgosanchez.tcc.venta.jpa;


import com.burgosanchez.tcc.venta.ejb.Proveedor;
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
public class ProveedorFacade extends AbstractFacade<Proveedor> {

    @PersistenceContext(unitName = "TccEJBPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProveedorFacade() {
        super(Proveedor.class);
    }
    
    public Integer obtenerSecuenciaVal() {
        Integer val = null;
        String sq = "";
        try {
            sq = "tcc.sq_proveedor.nextval";
            val = super.getSecuenceVal(sq);
        } catch (Exception ex) {
            val = 0;
            System.out.println(ex);
        }
        return val;
    }
    
    public List<Proveedor> obtenerProveedor(String re) {
        List<Proveedor> result;

        try {
            StringBuilder sql = new StringBuilder();

            sql.append("SELECT pr.* ");
            sql.append("  FROM proveedor pr ");
            sql.append("  JOIN persona p on pr.cod_persona = p.cod_persona ");
            sql.append(" WHERE lower(p.cod_persona) = ?");
            
            Query q = getEntityManager().createNativeQuery(sql.toString(), Proveedor.class);
            q.setParameter(1,re);
            
            List l = q.getResultList();
            if (l == null || l.isEmpty()) {
                return null;
            }
            //q.setHint("javax.persistence.cache.storeMode", "REFRESH");
            result = (List<Proveedor>) l;
            return result;
        } catch (Exception ex) {
            return null;
        }

    }
}
