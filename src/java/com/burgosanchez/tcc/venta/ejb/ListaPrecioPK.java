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
public class ListaPrecioPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "COD_LISTA")
    private String codLista;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "COD_EVENTO")
    private String codEvento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "COD_SECTOR")
    private String codSector;

    public ListaPrecioPK() {
    }

    public ListaPrecioPK(String codLista, String codEvento, String codSector) {
        this.codLista = codLista;
        this.codEvento = codEvento;
        this.codSector = codSector;
    }

    public String getCodLista() {
        return codLista;
    }

    public void setCodLista(String codLista) {
        this.codLista = codLista;
    }

    public String getCodEvento() {
        return codEvento;
    }

    public void setCodEvento(String codEvento) {
        this.codEvento = codEvento;
    }

    public String getCodSector() {
        return codSector;
    }

    public void setCodSector(String codSector) {
        this.codSector = codSector;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codLista != null ? codLista.hashCode() : 0);
        hash += (codEvento != null ? codEvento.hashCode() : 0);
        hash += (codSector != null ? codSector.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ListaPrecioPK)) {
            return false;
        }
        ListaPrecioPK other = (ListaPrecioPK) object;
        if ((this.codLista == null && other.codLista != null) || (this.codLista != null && !this.codLista.equals(other.codLista))) {
            return false;
        }
        if ((this.codEvento == null && other.codEvento != null) || (this.codEvento != null && !this.codEvento.equals(other.codEvento))) {
            return false;
        }
        if ((this.codSector == null && other.codSector != null) || (this.codSector != null && !this.codSector.equals(other.codSector))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.burgosanchez.tcc.venta.ejb.ListaPrecioPK[ codLista=" + codLista + ", codEvento=" + codEvento + ", codSector=" + codSector + " ]";
    }
    
}
