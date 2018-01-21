/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.burgosanchez.tcc.venta.ejb;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author TID01
 */
@Entity
@Table(name = "CONDICION_EVENTO", catalog = "", schema = "TCC")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CondicionEvento.findAll", query = "SELECT c FROM CondicionEvento c")})
public class CondicionEvento implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CondicionEventoPK condicionEventoPK;
    @Size(max = 20)
    @Column(name = "VALOR")
    private String valor;
    @JoinColumn(name = "COD_CONDICION", referencedColumnName = "COD_CONDICION", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Condicion condicion;
    @JoinColumn(name = "COD_EVENTO", referencedColumnName = "COD_EVENTO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private EventoCab eventoCab;

    public CondicionEvento() {
    }

    public CondicionEvento(CondicionEventoPK condicionEventoPK) {
        this.condicionEventoPK = condicionEventoPK;
    }

    public CondicionEvento(String codConEve, String codEvento, String codCondicion) {
        this.condicionEventoPK = new CondicionEventoPK(codConEve, codEvento, codCondicion);
    }

    public CondicionEventoPK getCondicionEventoPK() {
        return condicionEventoPK;
    }

    public void setCondicionEventoPK(CondicionEventoPK condicionEventoPK) {
        this.condicionEventoPK = condicionEventoPK;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Condicion getCondicion() {
        return condicion;
    }

    public void setCondicion(Condicion condicion) {
        this.condicion = condicion;
    }

    public EventoCab getEventoCab() {
        return eventoCab;
    }

    public void setEventoCab(EventoCab eventoCab) {
        this.eventoCab = eventoCab;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (condicionEventoPK != null ? condicionEventoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CondicionEvento)) {
            return false;
        }
        CondicionEvento other = (CondicionEvento) object;
        if ((this.condicionEventoPK == null && other.condicionEventoPK != null) || (this.condicionEventoPK != null && !this.condicionEventoPK.equals(other.condicionEventoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.burgosanchez.tcc.venta.ejb.CondicionEvento[ condicionEventoPK=" + condicionEventoPK + " ]";
    }
    
}
