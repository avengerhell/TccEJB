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
public class CondicionEventoPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "COD_CON_EVE")
    private String codConEve;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "COD_EVENTO")
    private String codEvento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "COD_CONDICION")
    private String codCondicion;

    public CondicionEventoPK() {
    }

    public CondicionEventoPK(String codConEve, String codEvento, String codCondicion) {
        this.codConEve = codConEve;
        this.codEvento = codEvento;
        this.codCondicion = codCondicion;
    }

    public String getCodConEve() {
        return codConEve;
    }

    public void setCodConEve(String codConEve) {
        this.codConEve = codConEve;
    }

    public String getCodEvento() {
        return codEvento;
    }

    public void setCodEvento(String codEvento) {
        this.codEvento = codEvento;
    }

    public String getCodCondicion() {
        return codCondicion;
    }

    public void setCodCondicion(String codCondicion) {
        this.codCondicion = codCondicion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codConEve != null ? codConEve.hashCode() : 0);
        hash += (codEvento != null ? codEvento.hashCode() : 0);
        hash += (codCondicion != null ? codCondicion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CondicionEventoPK)) {
            return false;
        }
        CondicionEventoPK other = (CondicionEventoPK) object;
        if ((this.codConEve == null && other.codConEve != null) || (this.codConEve != null && !this.codConEve.equals(other.codConEve))) {
            return false;
        }
        if ((this.codEvento == null && other.codEvento != null) || (this.codEvento != null && !this.codEvento.equals(other.codEvento))) {
            return false;
        }
        if ((this.codCondicion == null && other.codCondicion != null) || (this.codCondicion != null && !this.codCondicion.equals(other.codCondicion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.burgosanchez.tcc.venta.ejb.CondicionEventoPK[ codConEve=" + codConEve + ", codEvento=" + codEvento + ", codCondicion=" + codCondicion + " ]";
    }
    
}
