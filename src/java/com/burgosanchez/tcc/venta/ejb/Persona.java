/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.burgosanchez.tcc.venta.ejb;

import com.burgosanchez.tcc.venta.bean.Basicos;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author TID01
 */
@Entity
@Table(name = "PERSONA", catalog = "", schema = "TCC")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Persona.findAll", query = "SELECT p FROM Persona p")})
@SqlResultSetMapping(name = "BasicosResult",
        classes = {
                @ConstructorResult(targetClass = Basicos.class,
                        columns = {
                                @ColumnResult(name = "cod_tele", type = String.class),
                                @ColumnResult(name = "cod_per", type = String.class),
                                @ColumnResult(name = "num_tel", type = String.class),
                                @ColumnResult(name = "tipo_num", type = String.class),
                                @ColumnResult(name = "cod_ident", type = String.class),
                                @ColumnResult(name = "cod_tipo_id", type = String.class),
                                @ColumnResult(name = "num_iden", type = String.class),
                                @ColumnResult(name = "tipo_iden", type = String.class),
                                @ColumnResult(name = "cod_dir", type = String.class),
                                @ColumnResult(name = "deta_dir", type = String.class)
                                })
        })
public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "COD_PERSONA")
    private String codPersona;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "APELLIDO")
    private String apellido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "SEXO")
    private String sexo;
    @Column(name = "FEC_NACIMIENTO")
    @Temporal(TemporalType.DATE)
    private Date fecNacimiento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codPersona")
    private List<Proveedor> proveedorList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codPersona")
    private List<DireccionPersona> direccionPersonaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codPersona")
    private List<Cliente> clienteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codPersona")
    private List<IdentPersona> identPersonaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "persona")
    private List<Usuario> usuarioList;
    @JoinColumn(name = "COD_PAIS", referencedColumnName = "COD_PAIS")
    @ManyToOne(optional = false)
    private Pais codPais;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codPersona")
    private List<TelPersona> telPersonaList;

    public Persona() {
    }

    public Persona(String codPersona) {
        this.codPersona = codPersona;
    }

    public Persona(String codPersona, String nombre, String apellido, String sexo) {
        this.codPersona = codPersona;
        this.nombre = nombre;
        this.apellido = apellido;
        this.sexo = sexo;
    }

    public String getCodPersona() {
        return codPersona;
    }

    public void setCodPersona(String codPersona) {
        this.codPersona = codPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getFecNacimiento() {
        return fecNacimiento;
    }

    public void setFecNacimiento(Date fecNacimiento) {
        this.fecNacimiento = fecNacimiento;
    }

    @XmlTransient
    public List<Proveedor> getProveedorList() {
        return proveedorList;
    }

    public void setProveedorList(List<Proveedor> proveedorList) {
        this.proveedorList = proveedorList;
    }

    @XmlTransient
    public List<DireccionPersona> getDireccionPersonaList() {
        return direccionPersonaList;
    }

    public void setDireccionPersonaList(List<DireccionPersona> direccionPersonaList) {
        this.direccionPersonaList = direccionPersonaList;
    }

    @XmlTransient
    public List<Cliente> getClienteList() {
        return clienteList;
    }

    public void setClienteList(List<Cliente> clienteList) {
        this.clienteList = clienteList;
    }

    @XmlTransient
    public List<IdentPersona> getIdentPersonaList() {
        return identPersonaList;
    }

    public void setIdentPersonaList(List<IdentPersona> identPersonaList) {
        this.identPersonaList = identPersonaList;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    public Pais getCodPais() {
        return codPais;
    }

    public void setCodPais(Pais codPais) {
        this.codPais = codPais;
    }

    @XmlTransient
    public List<TelPersona> getTelPersonaList() {
        return telPersonaList;
    }

    public void setTelPersonaList(List<TelPersona> telPersonaList) {
        this.telPersonaList = telPersonaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codPersona != null ? codPersona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.codPersona == null && other.codPersona != null) || (this.codPersona != null && !this.codPersona.equals(other.codPersona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.burgosanchez.tcc.venta.ejb.Persona[ codPersona=" + codPersona + " ]";
    }
    
}
