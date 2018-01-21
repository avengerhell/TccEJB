/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.burgosanchez.tcc.venta.ejb;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author TID01
 */
@Entity
@Table(name = "TIPO_IDENTIFICACION", catalog = "", schema = "TCC")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoIdentificacion.findAll", query = "SELECT t FROM TipoIdentificacion t")})
public class TipoIdentificacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "COD_IDENT")
    private String codIdent;
    @Size(max = 50)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codIdent")
    private List<IdentPersona> identPersonaList;

    public TipoIdentificacion() {
    }

    public TipoIdentificacion(String codIdent) {
        this.codIdent = codIdent;
    }

    public String getCodIdent() {
        return codIdent;
    }

    public void setCodIdent(String codIdent) {
        this.codIdent = codIdent;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<IdentPersona> getIdentPersonaList() {
        return identPersonaList;
    }

    public void setIdentPersonaList(List<IdentPersona> identPersonaList) {
        this.identPersonaList = identPersonaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codIdent != null ? codIdent.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoIdentificacion)) {
            return false;
        }
        TipoIdentificacion other = (TipoIdentificacion) object;
        if ((this.codIdent == null && other.codIdent != null) || (this.codIdent != null && !this.codIdent.equals(other.codIdent))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.burgosanchez.tcc.venta.ejb.TipoIdentificacion[ codIdent=" + codIdent + " ]";
    }
    
}
