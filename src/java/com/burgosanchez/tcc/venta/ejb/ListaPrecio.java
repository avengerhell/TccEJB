/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.burgosanchez.tcc.venta.ejb;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author TID01
 */
@Entity
@Table(name = "LISTA_PRECIO", catalog = "", schema = "TCC")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ListaPrecio.findAll", query = "SELECT l FROM ListaPrecio l")})
public class ListaPrecio implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ListaPrecioPK listaPrecioPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VALOR")
    private BigInteger valor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FEC_INICIO")
    @Temporal(TemporalType.DATE)
    private Date fecInicio;
    @Column(name = "FEC_FIN")
    @Temporal(TemporalType.DATE)
    private Date fecFin;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "listaPrecio")
    private List<Entrada> entradaList;
    @JoinColumn(name = "COD_EVENTO", referencedColumnName = "COD_EVENTO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private EventoCab eventoCab;
    @JoinColumns({
        @JoinColumn(name = "COD_SECTOR", referencedColumnName = "COD_SECTOR", insertable = false, updatable = false),
        @JoinColumn(name = "COD_EVENTO", referencedColumnName = "COD_EVENTO", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Sector sector;

    public ListaPrecio() {
    }

    public ListaPrecio(ListaPrecioPK listaPrecioPK) {
        this.listaPrecioPK = listaPrecioPK;
    }

    public ListaPrecio(ListaPrecioPK listaPrecioPK, BigInteger valor, Date fecInicio) {
        this.listaPrecioPK = listaPrecioPK;
        this.valor = valor;
        this.fecInicio = fecInicio;
    }

    public ListaPrecio(String codLista, String codEvento, String codSector) {
        this.listaPrecioPK = new ListaPrecioPK(codLista, codEvento, codSector);
    }

    public ListaPrecioPK getListaPrecioPK() {
        return listaPrecioPK;
    }

    public void setListaPrecioPK(ListaPrecioPK listaPrecioPK) {
        this.listaPrecioPK = listaPrecioPK;
    }

    public BigInteger getValor() {
        return valor;
    }

    public void setValor(BigInteger valor) {
        this.valor = valor;
    }

    public Date getFecInicio() {
        return fecInicio;
    }

    public void setFecInicio(Date fecInicio) {
        this.fecInicio = fecInicio;
    }

    public Date getFecFin() {
        return fecFin;
    }

    public void setFecFin(Date fecFin) {
        this.fecFin = fecFin;
    }

    @XmlTransient
    public List<Entrada> getEntradaList() {
        return entradaList;
    }

    public void setEntradaList(List<Entrada> entradaList) {
        this.entradaList = entradaList;
    }

    public EventoCab getEventoCab() {
        return eventoCab;
    }

    public void setEventoCab(EventoCab eventoCab) {
        this.eventoCab = eventoCab;
    }

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (listaPrecioPK != null ? listaPrecioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ListaPrecio)) {
            return false;
        }
        ListaPrecio other = (ListaPrecio) object;
        if ((this.listaPrecioPK == null && other.listaPrecioPK != null) || (this.listaPrecioPK != null && !this.listaPrecioPK.equals(other.listaPrecioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.burgosanchez.tcc.venta.ejb.ListaPrecio[ listaPrecioPK=" + listaPrecioPK + " ]";
    }
    
}
