/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.burgosanchez.tcc.venta.jpa;

/**
 *
 * @author TID01
 */
import com.burgosanchez.tcc.venta.bean.Basicos;

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
public class BasicosFacade extends AbstractFacade<Basicos> {

    @PersistenceContext(unitName = "TccEJBPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BasicosFacade() {
        super(Basicos.class);
    }
    public List<Basicos> obtenerBasicos(String codigo) {
       
        StringBuilder sql = new StringBuilder();
        List<Basicos> result;
        List results;
        try {
            sql.append("SELECT b.cod_tele,"
                            + "b.cod_per,"
                            + "b.num_tel,"
                            + "b.tipo_num,"
                            + "b.cod_ident,"
                            + "b.cod_tipo_id,"
                            + "b.num_iden,"
                            + "b.tipo_iden,"
                            + "b.cod_dir,"
                            + "b.deta_dir ");
            sql.append("  FROM v_basicos b where b.cod_per = ?");
            //EntityManager em = getEntityManager();
            Query q = em.createNativeQuery(sql.toString(), "BasicosResult");
            q.setParameter(1, codigo);
            results = q.getResultList();
            //result =(RangoTarifaCount) q.getSingleResult();
            if(results == null || results.isEmpty()) {
                return null;
            }else{
                result = (List<Basicos>) results;
                return result;
            }
           
        } catch (Exception ex) {
            
            return null;
            
        }
        
    }

    
}
