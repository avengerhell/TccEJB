/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.burgosanchez.tcc.venta.jpa;

import com.burgosanchez.tcc.venta.bean.EntradaCliente;
import com.burgosanchez.tcc.venta.bean.EntradaView;
import com.burgosanchez.tcc.venta.bean.TotalEventoChart;
import com.burgosanchez.tcc.venta.ejb.Entrada;
import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedList;
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
public class EntradaFacade extends AbstractFacade<Entrada> {

    @PersistenceContext(unitName = "TccEJBPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EntradaFacade() {
        super(Entrada.class);
    }
    
    
    //Lista todas las entradas del usuario, se obtiene desde la vista v_entrada
    public List<EntradaView> obtenerEntradas(String usuario){
        List<EntradaView> result;

        try {
            StringBuilder sql = new StringBuilder();

            sql.append("SELECT e.num_entrada,e.estado_entrada,e.desc_entrada, ");
            sql.append("       e.nombre_evento,e.desc_evento,e.estado_evento,  ");
            sql.append("       e.precio,e.sector_even,e.horario_inicio,  ");
            sql.append("       e.localidad,e.nombre_persona,e.usuario  ");
            sql.append("  FROM V_ENTRADA e  ");
            sql.append(" WHERE e.Cod_Usuario = nvl(?,e.Cod_Usuario) ");
            //sql.append("   AND e.Cod_Evento = nvl(?,e.cod_evento) ");
     
            result  = new LinkedList<>();
            Query q = getEntityManager().createNativeQuery(sql.toString());
            q.setParameter(1, usuario);
            List<Object[]> l = q.getResultList();
            if (l == null || l.isEmpty()) {
                return null;
            }else{
                for (Object[] o : l) {
                    EntradaView crb = new EntradaView();
                    if (o[0] != null) {
                        crb.setNumEntrada((String) o[0]);
                    }
                    if (o[1] != null) {
                        crb.setEstadoEntrada((String) o[1]);
                    }
                    if (o[2] != null) {
                        crb.setDescEntrada((String) o[2]);
                    }
                    if (o[3] != null) {
                        crb.setNombreEvento((String) o[3]);
                    }
                    if (o[4] != null) {
                        crb.setDescEvento((String) o[4]);
                    }
                    if (o[5] != null) {
                        crb.setEstadoEvento((String) o[5]);
                    }
                    if (o[6] != null) {
                        crb.setPrecio((String) o[6]);
                    }
                    if (o[7] != null) {
                        crb.setSectorEven((String) o[7]);
                    }
                    if (o[8] != null) {
                        crb.setHorarioInicio((String) o[8]);
                    }
                    if (o[9] != null) {
                        crb.setLocalidad((String) o[9]);
                    }
                    if (o[10] != null) {
                        crb.setNombrePersona((String) o[10]);
                    }
                    if (o[11] != null) {
                        crb.setUsuario((String) o[11]);
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
    
    //Llama al procedimiento de reservar entrada con los parametros solicitados
    public String reservarEvento(String evento, 
                                 String cliente, 
                                 String horario, 
                                 String lista, 
                                 String sector, 
                                 String descripcion,
                                 String numero){
        String mensaje = "";
        StoredProcedureQuery sp = getEntityManager().createStoredProcedureQuery("tcc.prc_reserva_entrada");
        
        sp.registerStoredProcedureParameter("evento", String.class, ParameterMode.IN);
        sp.registerStoredProcedureParameter("cliente", String.class, ParameterMode.IN);
        sp.registerStoredProcedureParameter("horario", String.class, ParameterMode.IN);
        sp.registerStoredProcedureParameter("lista", String.class, ParameterMode.IN);
        sp.registerStoredProcedureParameter("sector", String.class, ParameterMode.IN);
        sp.registerStoredProcedureParameter("descripcion", String.class, ParameterMode.IN);
        //sp.registerStoredProcedureParameter("numero", String.class, ParameterMode.IN);
        sp.registerStoredProcedureParameter("v_mensaje", String.class, ParameterMode.OUT);

        //Si se envía null a la función Postgres, se pierde.
        sp.setParameter("evento", evento);
        sp.setParameter("cliente", cliente);
        sp.setParameter("horario", horario);
        sp.setParameter("lista", lista);
        sp.setParameter("sector", sector);
        sp.setParameter("descripcion", descripcion);
        //sp.setParameter("numero", numero);
        boolean queryResult = sp.execute();
        mensaje = String.valueOf(sp.getOutputParameterValue("v_mensaje"));
        
        return mensaje;
    }
    
    //Invoca al procedimiento para cancelar la reserva/entrada
     public String cancelaReserva(String entrada){
        String mensaje = "";
        StoredProcedureQuery sp = getEntityManager().createStoredProcedureQuery("tcc.prc_cancela_entrada");
        
        sp.registerStoredProcedureParameter("entra", String.class, ParameterMode.IN);

        sp.setParameter("entra", entrada);
        
        boolean queryResult = sp.execute();
        
        return mensaje;
    }
     public List<EntradaCliente> obtenerEntradasClientes(String cedula, String evento){
        List<EntradaCliente> result;

        try {
            StringBuilder sql = new StringBuilder();

            sql.append("select a.descripcion_evento, ");
            sql.append("a.nombre_evento,  ");
            sql.append("a.inicio_evento,  ");
            sql.append("a.fin_evento,  ");
            sql.append("a.nombre_persona,  ");
            sql.append("a.inicio_horario,  ");
            sql.append("a.fin_horario,  ");
            sql.append("a.sector,  ");
            sql.append("a.cod_entrada   ");
            sql.append("a.cedula   ");
            sql.append("a.cod_evento   ");
            sql.append("  from tcc.v_entrada_cliente a  ");
            sql.append(" where a.cedula = ?1");
            sql.append("   and a.cod_evento = ?2");
            
     
            result  = new LinkedList<>();
            Query q = getEntityManager().createNativeQuery(sql.toString());
            q.setParameter(1, cedula);
            q.setParameter(2, evento);
            List<Object[]> l = q.getResultList();
            if (l == null || l.isEmpty()) {
                return null;
            }else{
                for (Object[] o : l) {
                    EntradaCliente crb = new EntradaCliente();
                    if (o[0] != null) {
                        crb.setDescripcionEvento((String) o[0]);
                    }
                    if (o[1] != null) {
                        crb.setNombreEvento((String) o[1]);
                    }
                    if (o[2] != null) {
                        crb.setInicioEvento((Date) o[2]);
                    }
                    if (o[3] != null) {
                        crb.setFinEvento((Date) o[3]);
                    }
                    if (o[4] != null) {
                        crb.setNumeroEntrada((String) o[4]);
                    }
                    if (o[5] != null) {
                        crb.setNobmrePersona((String) o[5]);
                    }
                    if (o[6] != null) {
                        crb.setInicioHora((Date) o[6]);
                    }
                    if (o[7] != null) {
                        crb.setFinHorario((Date) o[7]);
                    }
                    if (o[8] != null) {
                        crb.setSector((String) o[8]);
                    }
                    if (o[9] != null) {
                        crb.setCodEntrada((String) o[9]);
                    }
                    if (o[10] != null) {
                        crb.setCedula((String) o[10]);
                    }
                    if (o[11] != null) {
                        crb.setCodEvento((String) o[11]);
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
     
    public List<TotalEventoChart> obtenerTotalEntradas(){
        List<TotalEventoChart> result;

        try {
            StringBuilder sql = new StringBuilder();

            sql.append("select ev.nombre, count(e.cod_entrada) ");
            sql.append("  from entrada e   ");
            sql.append("        join evento_cab ev on ev.cod_evento = e.cod_evento  ");
            sql.append("    group by ev.nombre  ");
            result  = new LinkedList<>();
            Query q = getEntityManager().createNativeQuery(sql.toString());
            
            List<Object[]> l = q.getResultList();
            if (l == null || l.isEmpty()) {
                return null;
            }else{
                for (Object[] o : l) {
                    TotalEventoChart crb = new TotalEventoChart();
                    if (o[0] != null) {
                        crb.setNombre((String) o[0]);
                    }
                    if (o[1] != null) {
                        crb.setTotal((BigDecimal) o[1]);
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
    
    public List<TotalEventoChart> obtenerTotalEntradasSexo(String sexo){
        List<TotalEventoChart> result;

        try {
            StringBuilder sql = new StringBuilder();

            sql.append("select ev.nombre,count(e.cod_entrada) ");
            sql.append("  from entrada e   ");
            sql.append("       join cliente c on c.cod_cliente = e.cod_cliente  ");
            sql.append("       join persona p on p.cod_persona = c.cod_persona  ");
            sql.append("       join evento_cab ev on ev.cod_evento = e.cod_evento  ");
            sql.append(" where p.sexo = ?1  ");
            sql.append("  group by ev.nombre,Decode(p.sexo,'H','Hombre','Mujer') ");
            sql.append("    order by 1  ");
            result  = new LinkedList<>();
            Query q = getEntityManager().createNativeQuery(sql.toString());
            q.setParameter(1, sexo);
            List<Object[]> l = q.getResultList();
            if (l == null || l.isEmpty()) {
                return null;
            }else{
                for (Object[] o : l) {
                    TotalEventoChart crb = new TotalEventoChart();
                    if (o[0] != null) {
                        crb.setNombre((String) o[0]);
                    }
                    if (o[1] != null) {
                        crb.setTotal((BigDecimal) o[1]);
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
}
