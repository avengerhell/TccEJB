/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.burgosanchez.tcc.venta.ejb;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "SECTOR", catalog = "", schema = "TCC")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sector.findAll", query = "SELECT s FROM Sector s")})
public class Sector implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SectorPK sectorPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "ILIMITADO")
    private String ilimitado;
    @Column(name = "CANTIDAD")
    private BigInteger cantidad;
    @JoinColumn(name = "COD_EVENTO", referencedColumnName = "COD_EVENTO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private EventoCab eventoCab;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sector")
    private List<Entrada> entradaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sector")
    private List<ListaPrecio> listaPrecioList;

    public Sector() {
    }

    public Sector(SectorPK sectorPK) {
        this.sectorPK = sectorPK;
    }

    public Sector(SectorPK sectorPK, String descripcion, String ilimitado) {
        this.sectorPK = sectorPK;
        this.descripcion = descripcion;
        this.ilimitado = ilimitado;
    }

    public Sector(String codSector, String codEvento) {
        this.sectorPK = new SectorPK(codSector, codEvento);
    }

    public SectorPK getSectorPK() {
        return sectorPK;
    }

    public void setSectorPK(SectorPK sectorPK) {
        this.sectorPK = sectorPK;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getIlimitado() {
        return ilimitado;
    }

    public void setIlimitado(String ilimitado) {
        this.ilimitado = ilimitado;
    }

    public BigInteger getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigInteger cantidad) {
        this.cantidad = cantidad;
    }

    public EventoCab getEventoCab() {
        return eventoCab;
    }

    public void setEventoCab(EventoCab eventoCab) {
        this.eventoCab = eventoCab;
    }

    @XmlTransient
    public List<Entrada> getEntradaList() {
        return entradaList;
    }

    public void setEntradaList(List<Entrada> entradaList) {
        this.entradaList = entradaList;
    }

    @XmlTransient
    public List<ListaPrecio> getListaPrecioList() {
        return listaPrecioList;
    }

    public void setListaPrecioList(List<ListaPrecio> listaPrecioList) {
        this.listaPrecioList = listaPrecioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sectorPK != null ? sectorPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sector)) {
            return false;
        }
        Sector other = (Sector) object;
        if ((this.sectorPK == null && other.sectorPK != null) || (this.sectorPK != null && !this.sectorPK.equals(other.sectorPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.burgosanchez.tcc.venta.ejb.Sector[ sectorPK=" + sectorPK + " ]";
    }
    
}
