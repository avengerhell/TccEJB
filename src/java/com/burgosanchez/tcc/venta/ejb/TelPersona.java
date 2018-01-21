/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.burgosanchez.tcc.venta.ejb;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author TID01
 */
@Entity
@Table(name = "TEL_PERSONA", catalog = "", schema = "TCC")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TelPersona.findAll", query = "SELECT t FROM TelPersona t")})
public class TelPersona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "COD_TELEFONO")
    private String codTelefono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "NUMERO")
    private String numero;
    @Size(max = 2)
    @Column(name = "TIPO")
    private String tipo;
    @JoinColumn(name = "COD_PERSONA", referencedColumnName = "COD_PERSONA")
    @ManyToOne(optional = false)
    private Persona codPersona;

    public TelPersona() {
    }

    public TelPersona(String codTelefono) {
        this.codTelefono = codTelefono;
    }

    public TelPersona(String codTelefono, String numero) {
        this.codTelefono = codTelefono;
        this.numero = numero;
    }

    public String getCodTelefono() {
        return codTelefono;
    }

    public void setCodTelefono(String codTelefono) {
        this.codTelefono = codTelefono;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Persona getCodPersona() {
        return codPersona;
    }

    public void setCodPersona(Persona codPersona) {
        this.codPersona = codPersona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codTelefono != null ? codTelefono.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TelPersona)) {
            return false;
        }
        TelPersona other = (TelPersona) object;
        if ((this.codTelefono == null && other.codTelefono != null) || (this.codTelefono != null && !this.codTelefono.equals(other.codTelefono))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.burgosanchez.tcc.venta.ejb.TelPersona[ codTelefono=" + codTelefono + " ]";
    }
    
}
