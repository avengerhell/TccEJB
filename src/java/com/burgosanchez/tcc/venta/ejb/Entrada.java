/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.burgosanchez.tcc.venta.ejb;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
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
@Table(name = "ENTRADA", catalog = "", schema = "TCC")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Entrada.findAll", query = "SELECT e FROM Entrada e")})
public class Entrada implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EntradaPK entradaPK;
    @Size(max = 256)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Column(name = "NUMERO")
    private BigInteger numero;
    @JoinColumn(name = "COD_CLIENTE", referencedColumnName = "COD_CLIENTE", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Cliente cliente;
    @JoinColumn(name = "COD_EVENTO", referencedColumnName = "COD_EVENTO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private EventoCab eventoCab;
    @JoinColumns({
        @JoinColumn(name = "COD_HORARIO", referencedColumnName = "COD_HORARIO"),
        @JoinColumn(name = "COD_EVENTO", referencedColumnName = "COD_EVENTO", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Horario horario;
    @JoinColumns({
        @JoinColumn(name = "COD_LISTA", referencedColumnName = "COD_LISTA"),
        @JoinColumn(name = "COD_EVENTO", referencedColumnName = "COD_EVENTO", insertable = false, updatable = false),
        @JoinColumn(name = "COD_SECTOR", referencedColumnName = "COD_SECTOR")})
    @ManyToOne(optional = false)
    private ListaPrecio listaPrecio;
    @JoinColumns({
        @JoinColumn(name = "COD_SECTOR", referencedColumnName = "COD_SECTOR",insertable = false, updatable = false),
        @JoinColumn(name = "COD_EVENTO", referencedColumnName = "COD_EVENTO", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Sector sector;

    public Entrada() {
    }

    public Entrada(EntradaPK entradaPK) {
        this.entradaPK = entradaPK;
    }

    public Entrada(String codEntrada, String codEvento, String codCliente) {
        this.entradaPK = new EntradaPK(codEntrada, codEvento, codCliente);
    }

    public EntradaPK getEntradaPK() {
        return entradaPK;
    }

    public void setEntradaPK(EntradaPK entradaPK) {
        this.entradaPK = entradaPK;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigInteger getNumero() {
        return numero;
    }

    public void setNumero(BigInteger numero) {
        this.numero = numero;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public EventoCab getEventoCab() {
        return eventoCab;
    }

    public void setEventoCab(EventoCab eventoCab) {
        this.eventoCab = eventoCab;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public ListaPrecio getListaPrecio() {
        return listaPrecio;
    }

    public void setListaPrecio(ListaPrecio listaPrecio) {
        this.listaPrecio = listaPrecio;
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
        hash += (entradaPK != null ? entradaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Entrada)) {
            return false;
        }
        Entrada other = (Entrada) object;
        if ((this.entradaPK == null && other.entradaPK != null) || (this.entradaPK != null && !this.entradaPK.equals(other.entradaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.burgosanchez.tcc.venta.ejb.Entrada[ entradaPK=" + entradaPK + " ]";
    }
    
}
