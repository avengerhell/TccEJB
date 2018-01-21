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
public class SectorPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "COD_SECTOR")
    private String codSector;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "COD_EVENTO")
    private String codEvento;

    public SectorPK() {
    }

    public SectorPK(String codSector, String codEvento) {
        this.codSector = codSector;
        this.codEvento = codEvento;
    }

    public String getCodSector() {
        return codSector;
    }

    public void setCodSector(String codSector) {
        this.codSector = codSector;
    }

    public String getCodEvento() {
        return codEvento;
    }

    public void setCodEvento(String codEvento) {
        this.codEvento = codEvento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codSector != null ? codSector.hashCode() : 0);
        hash += (codEvento != null ? codEvento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SectorPK)) {
            return false;
        }
        SectorPK other = (SectorPK) object;
        if ((this.codSector == null && other.codSector != null) || (this.codSector != null && !this.codSector.equals(other.codSector))) {
            return false;
        }
        if ((this.codEvento == null && other.codEvento != null) || (this.codEvento != null && !this.codEvento.equals(other.codEvento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.burgosanchez.tcc.venta.ejb.SectorPK[ codSector=" + codSector + ", codEvento=" + codEvento + " ]";
    }
    
}
