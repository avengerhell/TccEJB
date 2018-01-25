/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.burgosanchez.tcc.venta.jpa;

import com.burgosanchez.tcc.venta.ejb.Horario;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;

/**
 *
 * @author TID01
 */
@Stateless
public class HorarioFacade extends AbstractFacade<Horario> {

    @PersistenceContext(unitName = "TccEJBPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public HorarioFacade() {
        super(Horario.class);
    }

    public Integer obtenerSecuenciaVal() {
        Integer val = null;
        String sq = "";
        try {
            sq = "tcc.sq_horario.nextval";
            val = super.getSecuenceVal(sq);
        } catch (Exception ex) {
            val = 0;
            System.out.println(ex);
        }
        return val;
    }

    public void generaHorarios(String evento, String hora_desde, String hora_hasta,
            String fecha_desde, String fecha_hasta,
            Integer dia_desde, Integer dia_hasta, Integer periodo,String apertura) throws ParseException {
        
        StoredProcedureQuery sp = getEntityManager().createStoredProcedureQuery("tcc.crea_horarios");
        sp.registerStoredProcedureParameter("hora_desde", String.class, ParameterMode.IN);
        sp.registerStoredProcedureParameter("hora_hasta", String.class, ParameterMode.IN);
        sp.registerStoredProcedureParameter("fecha_desde", String.class, ParameterMode.IN);
        sp.registerStoredProcedureParameter("fecha_hasta", String.class, ParameterMode.IN);
        sp.registerStoredProcedureParameter("dia_desde", Integer.class, ParameterMode.IN);
        sp.registerStoredProcedureParameter("dia_hasta", Integer.class, ParameterMode.IN);
        sp.registerStoredProcedureParameter("periodo", Integer.class, ParameterMode.IN);
        sp.registerStoredProcedureParameter("evento", String.class, ParameterMode.IN);
        sp.registerStoredProcedureParameter("apertura", String.class, ParameterMode.IN);


        sp.setParameter("hora_desde", hora_desde);
        sp.setParameter("hora_hasta", hora_hasta);
        sp.setParameter("fecha_desde", fecha_desde);
        sp.setParameter("fecha_hasta", fecha_hasta);
        sp.setParameter("dia_desde", dia_desde);
        sp.setParameter("dia_hasta", dia_hasta);
        sp.setParameter("periodo", periodo);
        sp.setParameter("evento", evento);
        sp.setParameter("apertura", apertura);

        sp.execute();
    }
    
    public void generaHorarios2(String evento, String hora_desde, String hora_hasta,
            String fecha_desde, String fecha_hasta,String apertura) throws ParseException {
        
        StoredProcedureQuery sp = getEntityManager().createStoredProcedureQuery("tcc.crea_horarios2");
        sp.registerStoredProcedureParameter("hora_desde", String.class, ParameterMode.IN);
        sp.registerStoredProcedureParameter("hora_hasta", String.class, ParameterMode.IN);
        sp.registerStoredProcedureParameter("fecha_desde", String.class, ParameterMode.IN);
        sp.registerStoredProcedureParameter("fecha_hasta", String.class, ParameterMode.IN);
        sp.registerStoredProcedureParameter("evento", String.class, ParameterMode.IN);
        sp.registerStoredProcedureParameter("apertura", String.class, ParameterMode.IN);


        sp.setParameter("hora_desde", hora_desde);
        sp.setParameter("hora_hasta", hora_hasta);
        sp.setParameter("fecha_desde", fecha_desde);
        sp.setParameter("fecha_hasta", fecha_hasta);
        sp.setParameter("evento", evento);
        sp.setParameter("apertura", apertura);

        sp.execute();
    }
    
    
    public List<Horario> obtenerHorarioEven(String cod){
        try{
            StringBuilder sb = new StringBuilder();

            sb.append(" SELECT h ");
            sb.append(" FROM Horario h ");
            sb.append(" WHERE h.eventoCab.codEvento = ?1 ");

            Query q = getEntityManager().createQuery(sb.toString());
            q.setParameter(1, cod);

            return (List<Horario>) q.getResultList();
        }catch(Exception e){
            System.out.println(e);
            return null;
        }
    }
}
