/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.burgosanchez.tcc.venta.jpa;

import com.burgosanchez.tcc.venta.bean.UsuariosView;
import com.burgosanchez.tcc.venta.ejb.EventoCab;
import com.burgosanchez.tcc.venta.ejb.Sector;
import com.burgosanchez.tcc.venta.ejb.Usuario;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
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
public class UsuarioFacade extends AbstractFacade<Usuario> {

    @PersistenceContext(unitName = "TccEJBPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }

    public List<Usuario> obtenerUsuario(Map<String, Object> parameters) {
        List<Usuario> result;

        try {
            StringBuilder sql = new StringBuilder();

            sql.append("SELECT u ");
            sql.append("  FROM Usuario u  ");
            sql.append(" WHERE lower(u.usuarioPK.codUsuario) like :user ");
            sql.append("   AND lower(u.password) like :pass ");

            Query q = getEntityManager().createQuery(sql.toString(), Usuario.class);
            for (Map.Entry<String, Object> entry : parameters.entrySet()) {
                q.setParameter(entry.getKey(), entry.getValue());
            }

            List l = q.getResultList();
            if (l == null || l.isEmpty()) {
                return null;
            } else {
                //q.setHint("javax.persistence.cache.storeMode", "REFRESH");
                result = (List<Usuario>) l;
                return result;
            }
        } catch (Exception ex) {
            System.out.println(ex);
            return null;
        }

    }

    public void insertarUsuarioEvento(Usuario u, EventoCab ev,Sector s) {
        List<Usuario> result;

        try {
            StringBuilder sql = new StringBuilder();

            sql.append("INSERT INTO USUARIO_EVENTO (cod_evento,cod_usuario, cod_sector)");
            sql.append("  VALUES (?1,?2,?3) ");
            
            

            Query q = getEntityManager().createNativeQuery(sql.toString());

            q.setParameter(2, u.getUsuarioPK().getCodUsuario());
            q.setParameter(1, ev.getCodEvento());
            q.setParameter(3, s.getSectorPK().getCodSector());

            q.executeUpdate();
            
        } catch (Exception ex) {
            System.out.println(ex);
        }

    }

    public List<UsuariosView> obtUsuarioDato(String codUsuario) {
        List<UsuariosView> result;

        try {
            StringBuilder sql = new StringBuilder();

            sql.append("SELECT u.Cod_Usuario,u.Password, u.Nombre,u.Apellido, u.direccion,u.nacimiento,u.tipo_id,u.identidad,u.telefono ");
            sql.append("  FROM V_USUARIO u  ");
            sql.append(" WHERE u.Cod_Usuario = nvl(?,u.Cod_Usuario) ");

            result = new LinkedList<>();
            Query q = getEntityManager().createNativeQuery(sql.toString());
            q.setParameter(1, codUsuario);
            List<Object[]> l = q.getResultList();
            if (l == null || l.isEmpty()) {
                return null;
            } else {
                for (Object[] o : l) {
                    UsuariosView crb = new UsuariosView();
                    if (o[0] != null) {
                        crb.setCodUsuario((String) o[0]);
                    }
                    if (o[1] != null) {
                        crb.setPassword((String) o[1]);
                    }
                    if (o[2] != null) {
                        crb.setNombre((String) o[2]);
                    }
                    if (o[3] != null) {
                        crb.setApellido((String) o[3]);
                    }
                    if (o[4] != null) {
                        crb.setDireccion((String) o[4]);
                    }
                    if (o[5] != null) {
                        crb.setNacimiento((String) o[5]);
                    }
                    if (o[6] != null) {
                        crb.setTipoId((String) o[6]);
                    }
                    if (o[7] != null) {
                        crb.setIdentidad((String) o[7]);
                    }
                    if (o[8] != null) {
                        crb.setTelefono((String) o[8]);
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

    public String crearUsuario(String pais,
            String nombre,
            String apellido,
            String sexo,
            Date nacimiento,
            String codId,
            String numeroId,
            String direccion,
            String numTel,
            String usuario,
            String pass,
            String tipoUsu) {
        String mensaje = "";
        StoredProcedureQuery sp = getEntityManager().createStoredProcedureQuery("tcc.prc_crear_usuario");

        sp.registerStoredProcedureParameter("p_pais", String.class, ParameterMode.IN);
        sp.registerStoredProcedureParameter("p_nombre", String.class, ParameterMode.IN);
        sp.registerStoredProcedureParameter("p_apellido", String.class, ParameterMode.IN);
        sp.registerStoredProcedureParameter("p_sexo", String.class, ParameterMode.IN);
        sp.registerStoredProcedureParameter("p_fecha_n", Date.class, ParameterMode.IN);
        sp.registerStoredProcedureParameter("p_codId", String.class, ParameterMode.IN);
        sp.registerStoredProcedureParameter("p_numId", String.class, ParameterMode.IN);
        sp.registerStoredProcedureParameter("p_direccion", String.class, ParameterMode.IN);
        sp.registerStoredProcedureParameter("p_num_tel", String.class, ParameterMode.IN);
        sp.registerStoredProcedureParameter("p_usuario", String.class, ParameterMode.IN);
        sp.registerStoredProcedureParameter("p_pass", String.class, ParameterMode.IN);
        sp.registerStoredProcedureParameter("p_tipo", String.class, ParameterMode.IN);

        sp.setParameter("p_pais", pais);
        sp.setParameter("p_nombre", nombre);
        sp.setParameter("p_apellido", apellido);
        sp.setParameter("p_sexo", sexo);
        sp.setParameter("p_fecha_n", nacimiento);
        sp.setParameter("p_codId", codId);
        sp.setParameter("p_numId", numeroId);
        sp.setParameter("p_direccion", direccion);
        sp.setParameter("p_num_tel", numTel);
        sp.setParameter("p_usuario", usuario);
        sp.setParameter("p_pass", pass);
        sp.setParameter("p_tipo", tipoUsu);
        boolean queryResult = sp.execute();
        //mensaje = String.valueOf(sp.getOutputParameterValue("v_mensaje"));

        return mensaje;
    }

    public String actualizaUsuario(String codIdPer,
            String numId,
            String codPer,
            String codDireccion,
            String direccion,
            String codTel,
            String numTel,
            String codCliente,
            String estadoCliente,
            String tipoCliente,
            String usuario,
            String pass) {
        String mensaje = "";
        StoredProcedureQuery sp = getEntityManager().createStoredProcedureQuery("tcc.prc_actualiza_usuario");

        sp.registerStoredProcedureParameter("p_cod_id_p", String.class, ParameterMode.IN);
        sp.registerStoredProcedureParameter("p_numId", String.class, ParameterMode.IN);
        sp.registerStoredProcedureParameter("p_cod_persona", String.class, ParameterMode.IN);
        sp.registerStoredProcedureParameter("p_coddire", String.class, ParameterMode.IN);
        sp.registerStoredProcedureParameter("p_direccion", String.class, ParameterMode.IN);
        sp.registerStoredProcedureParameter("p_cod_tel", String.class, ParameterMode.IN);
        sp.registerStoredProcedureParameter("p_num_tel", String.class, ParameterMode.IN);
        sp.registerStoredProcedureParameter("p_cod_cli", String.class, ParameterMode.IN);
        sp.registerStoredProcedureParameter("p_esta_clie", String.class, ParameterMode.IN);
        sp.registerStoredProcedureParameter("p_ti_clie", String.class, ParameterMode.IN);
        sp.registerStoredProcedureParameter("p_usuario", String.class, ParameterMode.IN);
        sp.registerStoredProcedureParameter("p_pass", String.class, ParameterMode.IN);

        sp.setParameter("p_cod_id_p", codIdPer);
        sp.setParameter("p_numId", numId);
        sp.setParameter("p_cod_persona", codPer);
        sp.setParameter("p_coddire", codDireccion);
        sp.setParameter("p_direccion", direccion);
        sp.setParameter("p_cod_tel", codTel);
        sp.setParameter("p_num_tel", numTel);
        sp.setParameter("p_cod_cli", codCliente);
        sp.setParameter("p_esta_clie", estadoCliente);
        sp.setParameter("p_ti_clie", tipoCliente);
        sp.setParameter("p_usuario", usuario);
        sp.setParameter("p_pass", pass);
        boolean queryResult = sp.execute();
        //mensaje = String.valueOf(sp.getOutputParameterValue("v_mensaje"));

        return mensaje;
    }

    public String busquedaEventoUsuario(String codUsuario) {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("Select t.cod_evento from USUARIO_EVENTO t where t.cod_usuario = ?1 ");
            Query q = getEntityManager().createNativeQuery(sql.toString());
            q.setParameter(1, codUsuario);
            String l = (String) q.getSingleResult();
            if (l == null || l.isEmpty()) {
                return null;
            } else {
                return l;
            }
        } catch (Exception ex) {
            System.out.println(ex);
            return null;
        }
    }

    public List<Usuario> obtenerUsuario2(Map<String, Object> parameters) {
        List<Usuario> result;

        try {
            StringBuilder sql = new StringBuilder();

            sql.append("SELECT u ");
            sql.append("  FROM Usuario u  ");
            sql.append(" WHERE lower(u.usuarioPK.codUsuario) like :user ");

            Query q = getEntityManager().createQuery(sql.toString());
            for (Map.Entry<String, Object> entry : parameters.entrySet()) {
                q.setParameter(entry.getKey(), entry.getValue());
            }

            List l = q.getResultList();
            if (l == null || l.isEmpty()) {
                return null;
            } else {
                //q.setHint("javax.persistence.cache.storeMode", "REFRESH");
                result = (List<Usuario>) l;
                return result;
            }
        } catch (Exception ex) {
            System.out.println(ex);
            return null;
        }

    }
}
