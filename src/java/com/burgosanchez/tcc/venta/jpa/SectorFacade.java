/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.burgosanchez.tcc.venta.jpa;

import com.burgosanchez.tcc.venta.ejb.Sector;
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
public class SectorFacade extends AbstractFacade<Sector> {

    @PersistenceContext(unitName = "TccEJBPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SectorFacade() {
        super(Sector.class);
    }
    
    public Integer obtenerSecuenciaVal() {
        Integer val = null;
        String sq = "";
        try {
            sq = "tcc.sq_sector.nextval";
            val = super.getSecuenceVal(sq);
        } catch (Exception ex) {
            val = 0;
            System.out.println(ex);
        }
        return val;
    }
    public List<Sector> obtenerSectorEven(String cod){
        Sector sec = new Sector();
        try{
            StringBuilder sb = new StringBuilder();

            sb.append(" SELECT s ");
            sb.append(" FROM Sector s ");
            sb.append(" WHERE s.eventoCab.codEvento = ?1 ");

            Query q = getEntityManager().createQuery(sb.toString());
            q.setParameter(1, cod);

            return (List<Sector>) q.getResultList();
        }catch(Exception e){
            System.out.println(e);
            return null;
        }
    }
}
