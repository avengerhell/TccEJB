/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.burgosanchez.tcc.venta.bean;

import java.io.Serializable;

/**
 *
 * @author TID01
 */
public class Basicos implements Serializable{
    private String codTele;
    private String codPer;
    private String numTel;
    private String tipoNum;
    private String codIdent;
    private String codTipoId;
    private String numIden;
    private String tipoIden;
    private String codDir;
    private String detaDir;
    
    public Basicos(){
    }

    public Basicos(String codTele, String codPer, String numTel, String tipoNum, String codIdent, String codTipoId, String numIden, String tipoIden, String codDir, String detaDir) {
        this.codTele = codTele;
        this.codPer = codPer;
        this.numTel = numTel;
        this.tipoNum = tipoNum;
        this.codIdent = codIdent;
        this.codTipoId = codTipoId;
        this.numIden = numIden;
        this.tipoIden = tipoIden;
        this.codDir = codDir;
        this.detaDir = detaDir;
    }

    public String getCodTele() {
        return codTele;
    }

    public void setCodTele(String codTele) {
        this.codTele = codTele;
    }

    public String getCodPer() {
        return codPer;
    }

    public void setCodPer(String codPer) {
        this.codPer = codPer;
    }

    public String getNumTel() {
        return numTel;
    }

    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }

    public String getTipoNum() {
        return tipoNum;
    }

    public void setTipoNum(String tipoNum) {
        this.tipoNum = tipoNum;
    }

    public String getCodIdent() {
        return codIdent;
    }

    public void setCodIdent(String codIdent) {
        this.codIdent = codIdent;
    }

    public String getCodTipoId() {
        return codTipoId;
    }

    public void setCodTipoId(String codTipoId) {
        this.codTipoId = codTipoId;
    }

    public String getNumIden() {
        return numIden;
    }

    public void setNumIden(String numIden) {
        this.numIden = numIden;
    }

    public String getTipoIden() {
        return tipoIden;
    }

    public void setTipoIden(String tipoIden) {
        this.tipoIden = tipoIden;
    }

    public String getCodDir() {
        return codDir;
    }

    public void setCodDir(String codDir) {
        this.codDir = codDir;
    }

    public String getDetaDir() {
        return detaDir;
    }

    public void setDetaDir(String detaDir) {
        this.detaDir = detaDir;
    }

    
   
       
    
}
