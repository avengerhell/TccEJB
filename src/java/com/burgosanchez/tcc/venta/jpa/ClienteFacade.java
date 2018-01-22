/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.burgosanchez.tcc.venta.jpa;

import com.burgosanchez.tcc.venta.ejb.Cliente;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author TID01
 */
@Stateless
public class ClienteFacade extends AbstractFacade<Cliente> {

    @PersistenceContext(unitName = "TccEJBPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClienteFacade() {
        super(Cliente.class);
    }

    public Integer obtenerSecuenciaVal() {
        Integer val = null;
        String sq = "";
        try {
            sq = "tcc.sq_cliente.nextval";
            val = super.getSecuenceVal(sq);
        } catch (Exception ex) {
            val = 0;
            System.out.println(ex);
        }
        return val;
    }

    public List<Cliente> obtenerCliente(String re) {
        List<Cliente> result;

        try {
            StringBuilder sql = new StringBuilder();

            sql.append("SELECT c.* ");
            sql.append("  FROM CLIENTE c ");
            sql.append("  JOIN persona p on c.cod_persona = p.cod_persona ");
            sql.append(" WHERE lower(p.cod_persona) = ?");

            Query q = getEntityManager().createNativeQuery(sql.toString(), Cliente.class);
            q.setParameter(1, re);

            List l = q.getResultList();
            if (l == null || l.isEmpty()) {
                return null;
            }
            //q.setHint("javax.persistence.cache.storeMode", "REFRESH");
            result = (List<Cliente>) l;
            return result;
        } catch (Exception ex) {
            return null;
        }

    }

    public List<Cliente> obtenerClientexNom(String nombre) {
        List<Cliente> result;

        try {
            StringBuilder sql = new StringBuilder();

            sql.append("SELECT b.* ");
            sql.append("  FROM Persona a, Cliente b ");
            sql.append("  WHERE a.cod_Persona = b.cod_Persona ");
            sql.append(" AND lower(a.nombre) like ?");

            Query q = getEntityManager().createNativeQuery(sql.toString(), Cliente.class);
            q.setParameter(1, nombre);

            List l = q.getResultList();
            if (l == null || l.isEmpty()) {
                return null;
            } else {
                //q.setHint("javax.persistence.cache.storeMode", "REFRESH");
                result = (List<Cliente>) l;
                return result;
            }
        } catch (Exception ex) {
            System.out.println(ex);
            return null;
        }

    }

}
