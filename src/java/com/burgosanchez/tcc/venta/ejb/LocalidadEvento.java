/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.burgosanchez.tcc.venta.ejb;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author TID01
 */
@Entity
@Table(name = "LOCALIDAD_EVENTO", catalog = "", schema = "TCC")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LocalidadEvento.findAll", query = "SELECT l FROM LocalidadEvento l")})
public class LocalidadEvento implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected LocalidadEventoPK localidadEventoPK;
    @JoinColumn(name = "COD_EVENTO", referencedColumnName = "COD_EVENTO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private EventoCab eventoCab;
    @JoinColumn(name = "COD_LOCALIDAD", referencedColumnName = "COD_LOCALIDAD", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Localidad localidad;

    public LocalidadEvento() {
    }

    public LocalidadEvento(LocalidadEventoPK localidadEventoPK) {
        this.localidadEventoPK = localidadEventoPK;
    }

    public LocalidadEvento(String codLocEve, String codEvento, String codLocalidad) {
        this.localidadEventoPK = new LocalidadEventoPK(codLocEve, codEvento, codLocalidad);
    }

    public LocalidadEventoPK getLocalidadEventoPK() {
        return localidadEventoPK;
    }

    public void setLocalidadEventoPK(LocalidadEventoPK localidadEventoPK) {
        this.localidadEventoPK = localidadEventoPK;
    }

    public EventoCab getEventoCab() {
        return eventoCab;
    }

    public void setEventoCab(EventoCab eventoCab) {
        this.eventoCab = eventoCab;
    }

    public Localidad getLocalidad() {
        return localidad;
    }

    public void setLocalidad(Localidad localidad) {
        this.localidad = localidad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (localidadEventoPK != null ? localidadEventoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LocalidadEvento)) {
            return false;
        }
        LocalidadEvento other = (LocalidadEvento) object;
        if ((this.localidadEventoPK == null && other.localidadEventoPK != null) || (this.localidadEventoPK != null && !this.localidadEventoPK.equals(other.localidadEventoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.burgosanchez.tcc.venta.ejb.LocalidadEvento[ localidadEventoPK=" + localidadEventoPK + " ]";
    }
    
}
