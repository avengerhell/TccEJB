/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.burgosanchez.tcc.venta.jpa;

import com.burgosanchez.tcc.venta.bean.EventosView;
import com.burgosanchez.tcc.venta.ejb.EventoCab;
import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedList;
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
public class EventoCabFacade extends AbstractFacade<EventoCab> {

    @PersistenceContext(unitName = "TccEJBPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EventoCabFacade() {
        super(EventoCab.class);
    }

    //Obtiene la secuencia siguiente del evento
    public Integer obtenerSecuenciaVal() {
        Integer val = null;
        String sq = "";
        try {
            sq = "tcc.sq_evento_cab.nextval";
            val = super.getSecuenceVal(sq);
        } catch (Exception ex) {
            val = 0;
            System.out.println(ex);
        }
        return val;
    }

    //Obtiene los eventos via JPQL
    public List<EventoCab> obtenerEvento(Map<String, Object> parameters) {
        List<EventoCab> result;

        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT e ");
            sql.append("  FROM EventoCab e, Proveedor p  ");
            sql.append(" WHERE lower(e.nombre) like :nom ");
            sql.append("   AND lower(p.codPersona.nombre) like :prov ");
            //sql.append("   AND t.grilla.idgrilla = g.idgrilla ");
            sql.append("  AND e.codProveedor = p ");

            Query q = getEntityManager().createQuery(sql.toString(), EventoCab.class);
            for (Map.Entry<String, Object> entry : parameters.entrySet()) {
                q.setParameter(entry.getKey(), entry.getValue());
            }

            List l = q.getResultList();
            if (l == null || l.isEmpty()) {
                return null;
            }
            //q.setHint("javax.persistence.cache.storeMode", "REFRESH");
            result = (List<EventoCab>) l;
            return result;
        } catch (Exception ex) {
            /*if (ex instanceof NTIClearingEJBException) {
                throw (NTIClearingEJBException) ex;
            }

            throw new NTIClearingEJBException("Error al buscar tarifa.", ex);*/
            return null;
        }
    }

    //Obtiene todos los eventos o un evento especifico de la vista V_EVENTO y devuelve una lista de la vista
    public List<EventosView> obtenerEventos(String codEvento) {
        List<EventosView> result;

        try {
            StringBuilder sql = new StringBuilder();
            //sql.append("SELECT e.Cod_Evento,e.prov,e.TipoEv ,e.desceve,e.nomeven,e.Fec_Inicio,e.Fec_Fin,e.Estado ");
            sql.append("SELECT e.Cod_Evento,e.prov,e.tipoEv,e.desceve,e.nomeven,e.Fec_Inicio,e.Fec_Fin,e.Estado ");
            sql.append("  FROM V_EVENTO e  ");
            sql.append(" WHERE e.estado = 'A' ");
            sql.append("   AND e.Cod_Evento = nvl(?,e.cod_evento) ");

            result = new LinkedList<>();
            Query q = getEntityManager().createNativeQuery(sql.toString());
            q.setParameter(1, codEvento);
            List<Object[]> l = q.getResultList();
            if (l == null || l.isEmpty()) {
                return null;
            } else {
                for (Object[] o : l) {
                    EventosView crb = new EventosView();
                    if (o[0] != null) {
                        crb.setCodEvento((String) o[0]);
                    }
                    if (o[1] != null) {
                        crb.setProv((String) o[1]);
                    }
                    if (o[2] != null) {
                        crb.setTipoEv((String) o[2]);
                    }
                    if (o[3] != null) {
                        crb.setDesceve((String) o[3]);
                    }
                    if (o[4] != null) {
                        crb.setNomeven((String) o[4]);
                    }
                    if (o[5] != null) {
                        crb.setFecInicio((String) o[5]);
                    }
                    if (o[6] != null) {
                        crb.setFecFin((String) o[6]);
                    }
                    if (o[7] != null) {
                        crb.setEstado((String) o[7]);
                    }
                    result.add(crb);
                }
            }
            //q.setHint("javax.persistence.cache.storeMode", "REFRESH");
            return result;
        } catch (Exception ex) {
            System.out.println(ex);
            return null;
        }

    }

    public List<EventoCab> obtenerEventosUsuario(String usuario) {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT e.* ");
            sql.append("  FROM usuario u  ");
            sql.append("       join usuario_evento ue on ue.cod_usuario = u.cod_usuario ");
            sql.append("       join evento_cab e on e.cod_Evento = ue.cod_evento ");
            sql.append(" WHERE e.estado = 'A' ");
            sql.append("   AND u.cod_usuario = ?1");

            Query q = getEntityManager().createNativeQuery(sql.toString(), EventoCab.class);
            q.setParameter(1, usuario);

            return q.getResultList();
        } catch (Exception ex) {
            System.out.println(ex);
            return null;
        }

    }
    
    
}
