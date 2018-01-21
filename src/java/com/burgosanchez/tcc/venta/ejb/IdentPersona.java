/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.burgosanchez.tcc.venta.ejb;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author TID01
 */
@Entity
@Table(name = "IDENT_PERSONA", catalog = "", schema = "TCC")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IdentPersona.findAll", query = "SELECT i FROM IdentPersona i")})
public class IdentPersona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "COD_IDENTIFICACION")
    private String codIdentificacion;
    @Size(max = 50)
    @Column(name = "NUMERO")
    private String numero;
    @JoinColumn(name = "COD_PERSONA", referencedColumnName = "COD_PERSONA")
    @ManyToOne(optional = false)
    private Persona codPersona;
    @JoinColumn(name = "COD_IDENT", referencedColumnName = "COD_IDENT")
    @ManyToOne(optional = false)
    private TipoIdentificacion codIdent;

    public IdentPersona() {
    }

    public IdentPersona(String codIdentificacion) {
        this.codIdentificacion = codIdentificacion;
    }

    public String getCodIdentificacion() {
        return codIdentificacion;
    }

    public void setCodIdentificacion(String codIdentificacion) {
        this.codIdentificacion = codIdentificacion;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Persona getCodPersona() {
        return codPersona;
    }

    public void setCodPersona(Persona codPersona) {
        this.codPersona = codPersona;
    }

    public TipoIdentificacion getCodIdent() {
        return codIdent;
    }

    public void setCodIdent(TipoIdentificacion codIdent) {
        this.codIdent = codIdent;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codIdentificacion != null ? codIdentificacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IdentPersona)) {
            return false;
        }
        IdentPersona other = (IdentPersona) object;
        if ((this.codIdentificacion == null && other.codIdentificacion != null) || (this.codIdentificacion != null && !this.codIdentificacion.equals(other.codIdentificacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.burgosanchez.tcc.venta.ejb.IdentPersona[ codIdentificacion=" + codIdentificacion + " ]";
    }
    
}
