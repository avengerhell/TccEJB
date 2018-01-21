/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.burgosanchez.tcc.venta.jpa;

import com.burgosanchez.tcc.venta.ejb.Persona;
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
public class PersonaFacade extends AbstractFacade<Persona> {

    @PersistenceContext(unitName = "TccEJBPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PersonaFacade() {
        super(Persona.class);
    }

    public Integer obtenerSecuenciaVal() {
        Integer val = null;
        String sq = "";
        try {
            sq = "tcc.sq_persona.nextval";
            val = super.getSecuenceVal(sq);
        } catch (Exception ex) {
            val = 0;
            System.out.println(ex);
        }
        return val;
    }

    public List<Persona> obtenerPersona(Map<String, Object> parameters) {
        List<Persona> result;

        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT p ");
            sql.append("  FROM Persona p, IdentPersona i  ");
            sql.append(" WHERE lower(p.nombre) like :nom ");
            sql.append("   AND lower(i.numero) like :docu ");
            //sql.append("   AND t.grilla.idgrilla = g.idgrilla ");
            sql.append("  AND  i.codPersona = p ");

            Query q = getEntityManager().createQuery(sql.toString(), Persona.class);
            for (Map.Entry<String, Object> entry : parameters.entrySet()) {
                q.setParameter(entry.getKey(), entry.getValue());
            }

            List l = q.getResultList();
            if (l == null || l.isEmpty()) {
                return null;
            }
            //q.setHint("javax.persistence.cache.storeMode", "REFRESH");
            result = (List<Persona>) l;
            return result;
        } catch (Exception ex) {
            /*if (ex instanceof NTIClearingEJBException) {
                throw (NTIClearingEJBException) ex;
            }

            throw new NTIClearingEJBException("Error al buscar tarifa.", ex);*/
            return null;
        }
    }

    public List<Persona> obtenerPersonaXCodCliente(String cod) {
        List<Persona> result;
        List results;

        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT p ");
            sql.append("  FROM Persona p  ");
            sql.append(" WHERE p.cod_persona = :cod ");
            

            Query q = getEntityManager().createQuery(sql.toString(), Persona.class);
            q.setParameter(1, cod);
            results = q.getResultList();
            //result =(RangoTarifaCount) q.getSingleResult();
            if(results == null || results.isEmpty()) {
                return null;
            }else{
                result = (List<Persona>) results;
                return result;
            }
           
        } catch (Exception ex) {
            
            return null;
            
        }

          
        }
    }
