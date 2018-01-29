/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.burgosanchez.tcc.venta.jpa;

import com.burgosanchez.tcc.venta.ejb.ListaPrecio;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    public List<ListaPrecio> obtenerCondicionEven(String cod) {

        try {
            StringBuilder sb = new StringBuilder();

            sb.append(" SELECT l ");
            sb.append(" FROM ListaPrecio l ");
            sb.append(" WHERE l.eventoCab.codEvento = ?1 ");

            Query q = getEntityManager().createQuery(sb.toString());
            q.setParameter(1, cod);

            return (List<ListaPrecio>) q.getResultList();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public Boolean verificaLista(String codEvento, String codSector, Date inicio, Date fin) {

        try {
            StringBuilder sb = new StringBuilder();
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

            sb.append(" SELECT l.* ");
            sb.append(" from lista_precio l ");
            sb.append(" where cod_evento = ?1 ");
            sb.append("   and cod_sector = ?2 ");
            sb.append("   and (?3 between l.fec_inicio and l.fec_fin ");
            sb.append("        or ?4 between l.fec_inicio and l.fec_fin ");
            sb.append("        or l.fec_inicio between ?5 and ?6 ");
            sb.append("        or l.fec_fin between ?7 and ?8)");

            Query q = getEntityManager().createNativeQuery(sb.toString());
            q.setParameter(1, codEvento);
            q.setParameter(2, codSector);
            q.setParameter(3, format.format(inicio));
            q.setParameter(4, format.format(fin));
            q.setParameter(5, format.format(inicio));
            q.setParameter(6, format.format(fin));
            q.setParameter(7, format.format(inicio));
            q.setParameter(8, format.format(fin));
            List<Object> l = q.getResultList();
            if (!l.isEmpty()) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}
