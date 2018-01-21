/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.burgosanchez.tcc.venta.bean;

/**
 *
 * @author TID01
 */
public class EventosView {

    private String codEvento;
    private String prov;//proveedor
    private String tipoEv;//tipo evento
    private String desceve;
    private String nomeven;
    private String fecInicio;
    private String fecFin;
    private String estado;

    public String getCodEvento() {
        return codEvento;
    }

    public void setCodEvento(String codEvento) {
        this.codEvento = codEvento;
    }

    public String getProv() {
        return prov;
    }

    public void setProv(String prov) {
        this.prov = prov;
    }

    public String getTipoEv() {
        return tipoEv;
    }

    public void setTipoEv(String tipoEv) {
        this.tipoEv = tipoEv;
    }

    public String getDesceve() {
        return desceve;
    }

    public void setDesceve(String desceve) {
        this.desceve = desceve;
    }

    public String getNomeven() {
        return nomeven;
    }

    public void setNomeven(String nomeven) {
        this.nomeven = nomeven;
    }

    public String getFecInicio() {
        return fecInicio;
    }

    public void setFecInicio(String fecInicio) {
        this.fecInicio = fecInicio;
    }

    public String getFecFin() {
        return fecFin;
    }

    public void setFecFin(String fecFin) {
        this.fecFin = fecFin;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
