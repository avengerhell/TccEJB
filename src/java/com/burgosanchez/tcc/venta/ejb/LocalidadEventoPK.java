/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.burgosanchez.tcc.venta.ejb;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author TID01
 */
@Embeddable
public class LocalidadEventoPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "COD_LOC_EVE")
    private String codLocEve;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "COD_EVENTO")
    private String codEvento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "COD_LOCALIDAD")
    private String codLocalidad;

    public LocalidadEventoPK() {
    }

    public LocalidadEventoPK(String codLocEve, String codEvento, String codLocalidad) {
        this.codLocEve = codLocEve;
        this.codEvento = codEvento;
        this.codLocalidad = codLocalidad;
    }

    public String getCodLocEve() {
        return codLocEve;
    }

    public void setCodLocEve(String codLocEve) {
        this.codLocEve = codLocEve;
    }

    public String getCodEvento() {
        return codEvento;
    }

    public void setCodEvento(String codEvento) {
        this.codEvento = codEvento;
    }

    public String getCodLocalidad() {
        return codLocalidad;
    }

    public void setCodLocalidad(String codLocalidad) {
        this.codLocalidad = codLocalidad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codLocEve != null ? codLocEve.hashCode() : 0);
        hash += (codEvento != null ? codEvento.hashCode() : 0);
        hash += (codLocalidad != null ? codLocalidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LocalidadEventoPK)) {
            return false;
        }
        LocalidadEventoPK other = (LocalidadEventoPK) object;
        if ((this.codLocEve == null && other.codLocEve != null) || (this.codLocEve != null && !this.codLocEve.equals(other.codLocEve))) {
            return false;
        }
        if ((this.codEvento == null && other.codEvento != null) || (this.codEvento != null && !this.codEvento.equals(other.codEvento))) {
            return false;
        }
        if ((this.codLocalidad == null && other.codLocalidad != null) || (this.codLocalidad != null && !this.codLocalidad.equals(other.codLocalidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.burgosanchez.tcc.venta.ejb.LocalidadEventoPK[ codLocEve=" + codLocEve + ", codEvento=" + codEvento + ", codLocalidad=" + codLocalidad + " ]";
    }
    
}
