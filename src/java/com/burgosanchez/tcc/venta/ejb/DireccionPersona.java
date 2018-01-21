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
@Table(name = "DIRECCION_PERSONA", catalog = "", schema = "TCC")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DireccionPersona.findAll", query = "SELECT d FROM DireccionPersona d")})
public class DireccionPersona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "COD_DIRECCION")
    private String codDireccion;
    @Size(max = 500)
    @Column(name = "DETALLE")
    private String detalle;
    @JoinColumn(name = "COD_PERSONA", referencedColumnName = "COD_PERSONA")
    @ManyToOne(optional = false)
    private Persona codPersona;

    public DireccionPersona() {
    }

    public DireccionPersona(String codDireccion) {
        this.codDireccion = codDireccion;
    }

    public String getCodDireccion() {
        return codDireccion;
    }

    public void setCodDireccion(String codDireccion) {
        this.codDireccion = codDireccion;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public Persona getCodPersona() {
        return codPersona;
    }

    public void setCodPersona(Persona codPersona) {
        this.codPersona = codPersona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codDireccion != null ? codDireccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DireccionPersona)) {
            return false;
        }
        DireccionPersona other = (DireccionPersona) object;
        if ((this.codDireccion == null && other.codDireccion != null) || (this.codDireccion != null && !this.codDireccion.equals(other.codDireccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.burgosanchez.tcc.venta.ejb.DireccionPersona[ codDireccion=" + codDireccion + " ]";
    }
    
}
