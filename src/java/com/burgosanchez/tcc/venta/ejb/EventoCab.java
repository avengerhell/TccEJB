/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.burgosanchez.tcc.venta.ejb;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author TID01
 */
@Entity
@Table(name = "EVENTO_CAB", catalog = "", schema = "TCC")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EventoCab.findAll", query = "SELECT e FROM EventoCab e")})
public class EventoCab implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "COD_EVENTO")
    private String codEvento;
    @Size(max = 256)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FEC_CONTRATO")
    @Temporal(TemporalType.DATE)
    private Date fecContrato;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FEC_INICIO")
    @Temporal(TemporalType.DATE)
    private Date fecInicio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "ESTADO")
    private String estado;
    @Column(name = "FEC_FIN")
    @Temporal(TemporalType.DATE)
    private Date fecFin;
    @JoinColumn(name = "COD_PROVEEDOR", referencedColumnName = "COD_PROVEEDOR")
    @ManyToOne(optional = false)
    private Proveedor codProveedor;
    @JoinColumn(name = "COD_TIPO", referencedColumnName = "COD_TIPO")
    @ManyToOne(optional = false)
    private TipoEvento codTipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eventoCab")
    private List<Sector> sectorList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eventoCab")
    private List<LocalidadEvento> localidadEventoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eventoCab")
    private List<Horario> horarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eventoCab")
    private List<CondicionEvento> condicionEventoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eventoCab")
    private List<Entrada> entradaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eventoCab")
    private List<ListaPrecio> listaPrecioList;

    public EventoCab() {
    }

    public EventoCab(String codEvento) {
        this.codEvento = codEvento;
    }

    public EventoCab(String codEvento, String nombre, Date fecContrato, Date fecInicio, String estado) {
        this.codEvento = codEvento;
        this.nombre = nombre;
        this.fecContrato = fecContrato;
        this.fecInicio = fecInicio;
        this.estado = estado;
    }

    public String getCodEvento() {
        return codEvento;
    }

    public void setCodEvento(String codEvento) {
        this.codEvento = codEvento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecContrato() {
        return fecContrato;
    }

    public void setFecContrato(Date fecContrato) {
        this.fecContrato = fecContrato;
    }

    public Date getFecInicio() {
        return fecInicio;
    }

    public void setFecInicio(Date fecInicio) {
        this.fecInicio = fecInicio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFecFin() {
        return fecFin;
    }

    public void setFecFin(Date fecFin) {
        this.fecFin = fecFin;
    }

    public Proveedor getCodProveedor() {
        return codProveedor;
    }

    public void setCodProveedor(Proveedor codProveedor) {
        this.codProveedor = codProveedor;
    }

    public TipoEvento getCodTipo() {
        return codTipo;
    }

    public void setCodTipo(TipoEvento codTipo) {
        this.codTipo = codTipo;
    }

    @XmlTransient
    public List<Sector> getSectorList() {
        return sectorList;
    }

    public void setSectorList(List<Sector> sectorList) {
        this.sectorList = sectorList;
    }

    @XmlTransient
    public List<LocalidadEvento> getLocalidadEventoList() {
        return localidadEventoList;
    }

    public void setLocalidadEventoList(List<LocalidadEvento> localidadEventoList) {
        this.localidadEventoList = localidadEventoList;
    }

    @XmlTransient
    public List<Horario> getHorarioList() {
        return horarioList;
    }

    public void setHorarioList(List<Horario> horarioList) {
        this.horarioList = horarioList;
    }

    @XmlTransient
    public List<CondicionEvento> getCondicionEventoList() {
        return condicionEventoList;
    }

    public void setCondicionEventoList(List<CondicionEvento> condicionEventoList) {
        this.condicionEventoList = condicionEventoList;
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
        hash += (codEvento != null ? codEvento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EventoCab)) {
            return false;
        }
        EventoCab other = (EventoCab) object;
        if ((this.codEvento == null && other.codEvento != null) || (this.codEvento != null && !this.codEvento.equals(other.codEvento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.burgosanchez.tcc.venta.ejb.EventoCab[ codEvento=" + codEvento + " ]";
    }
    
}
