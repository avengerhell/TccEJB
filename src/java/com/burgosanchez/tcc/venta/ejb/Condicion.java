/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.burgosanchez.tcc.venta.ejb;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "CONDICION", catalog = "", schema = "TCC")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Condicion.findAll", query = "SELECT c FROM Condicion c")})
public class Condicion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "COD_CONDICION")
    private String codCondicion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Size(max = 30)
    @Column(name = "VALOR")
    private String valor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "condicion")
    private List<CondicionEvento> condicionEventoList;

    public Condicion() {
    }

    public Condicion(String codCondicion) {
        this.codCondicion = codCondicion;
    }

    public Condicion(String codCondicion, String descripcion) {
        this.codCondicion = codCondicion;
        this.descripcion = descripcion;
    }

    public String getCodCondicion() {
        return codCondicion;
    }

    public void setCodCondicion(String codCondicion) {
        this.codCondicion = codCondicion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    @XmlTransient
    public List<CondicionEvento> getCondicionEventoList() {
        return condicionEventoList;
    }

    public void setCondicionEventoList(List<CondicionEvento> condicionEventoList) {
        this.condicionEventoList = condicionEventoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codCondicion != null ? codCondicion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Condicion)) {
            return false;
        }
        Condicion other = (Condicion) object;
        if ((this.codCondicion == null && other.codCondicion != null) || (this.codCondicion != null && !this.codCondicion.equals(other.codCondicion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.burgosanchez.tcc.venta.ejb.Condicion[ codCondicion=" + codCondicion + " ]";
    }
    
}
