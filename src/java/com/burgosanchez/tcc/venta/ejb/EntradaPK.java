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
public class EntradaPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "COD_ENTRADA")
    private String codEntrada;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "COD_EVENTO")
    private String codEvento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "COD_CLIENTE")
    private String codCliente;

    public EntradaPK() {
    }

    public EntradaPK(String codEntrada, String codEvento, String codCliente) {
        this.codEntrada = codEntrada;
        this.codEvento = codEvento;
        this.codCliente = codCliente;
    }

    public String getCodEntrada() {
        return codEntrada;
    }

    public void setCodEntrada(String codEntrada) {
        this.codEntrada = codEntrada;
    }

    public String getCodEvento() {
        return codEvento;
    }

    public void setCodEvento(String codEvento) {
        this.codEvento = codEvento;
    }

    public String getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(String codCliente) {
        this.codCliente = codCliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codEntrada != null ? codEntrada.hashCode() : 0);
        hash += (codEvento != null ? codEvento.hashCode() : 0);
        hash += (codCliente != null ? codCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EntradaPK)) {
            return false;
        }
        EntradaPK other = (EntradaPK) object;
        if ((this.codEntrada == null && other.codEntrada != null) || (this.codEntrada != null && !this.codEntrada.equals(other.codEntrada))) {
            return false;
        }
        if ((this.codEvento == null && other.codEvento != null) || (this.codEvento != null && !this.codEvento.equals(other.codEvento))) {
            return false;
        }
        if ((this.codCliente == null && other.codCliente != null) || (this.codCliente != null && !this.codCliente.equals(other.codCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.burgosanchez.tcc.venta.ejb.EntradaPK[ codEntrada=" + codEntrada + ", codEvento=" + codEvento + ", codCliente=" + codCliente + " ]";
    }
    
}
