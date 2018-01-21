/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.burgosanchez.tcc.venta.bean;

import java.util.Date;

/**
 *
 * @author Diego
 */
public class EntradaCliente {
    private String descripcionEvento;
    private String nombreEvento;
    private Date inicioEvento;
    private Date finEvento;
    private String numeroEntrada;
    private String nobmrePersona;
    private Date inicioHora;
    private Date finHorario;
    private String sector;
    private String codEntrada;

    public String getCodEvento() {
        return codEvento;
    }

    public void setCodEvento(String codEvento) {
        this.codEvento = codEvento;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    private String codEvento;
    private String cedula;
    
    public EntradaCliente() {
    }

    public String getDescripcionEvento() {
        return descripcionEvento;
    }

    public void setDescripcionEvento(String descripcionEvento) {
        this.descripcionEvento = descripcionEvento;
    }

    public String getNombreEvento() {
        return nombreEvento;
    }

    public void setNombreEvento(String nombreEvento) {
        this.nombreEvento = nombreEvento;
    }

    public Date getInicioEvento() {
        return inicioEvento;
    }

    public void setInicioEvento(Date inicioEvento) {
        this.inicioEvento = inicioEvento;
    }

    public Date getFinEvento() {
        return finEvento;
    }

    public void setFinEvento(Date finEvento) {
        this.finEvento = finEvento;
    }

    public String getNumeroEntrada() {
        return numeroEntrada;
    }

    public void setNumeroEntrada(String numeroEntrada) {
        this.numeroEntrada = numeroEntrada;
    }

    public String getNobmrePersona() {
        return nobmrePersona;
    }

    public void setNobmrePersona(String nobmrePersona) {
        this.nobmrePersona = nobmrePersona;
    }

    public Date getInicioHora() {
        return inicioHora;
    }

    public void setInicioHora(Date inicioHora) {
        this.inicioHora = inicioHora;
    }

    public Date getFinHorario() {
        return finHorario;
    }

    public void setFinHorario(Date finHorario) {
        this.finHorario = finHorario;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getCodEntrada() {
        return codEntrada;
    }

    public void setCodEntrada(String codEntrada) {
        this.codEntrada = codEntrada;
    }
 
}
