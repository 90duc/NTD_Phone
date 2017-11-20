/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mk.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author MK
 */
@Entity
@Table(name = "login_info")
public class LoginInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected LoginInfoPK loginInfoPK;
    @Column(name = "ip")
    private String ip;
    @Column(name = "city")
    private String city;
    @Column(name = "product")
    private String product;

    public LoginInfo() {
    }

    public LoginInfo(LoginInfoPK loginInfoPK) {
        this.loginInfoPK = loginInfoPK;
    }

    public LoginInfo(int uid, Date time) {
        this.loginInfoPK = new LoginInfoPK(uid, time);
    }

    public LoginInfoPK getLoginInfoPK() {
        return loginInfoPK;
    }

    public void setLoginInfoPK(LoginInfoPK loginInfoPK) {
        this.loginInfoPK = loginInfoPK;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (loginInfoPK != null ? loginInfoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LoginInfo)) {
            return false;
        }
        LoginInfo other = (LoginInfo) object;
        if ((this.loginInfoPK == null && other.loginInfoPK != null) || (this.loginInfoPK != null && !this.loginInfoPK.equals(other.loginInfoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mk.entity.LoginInfo[ loginInfoPK=" + loginInfoPK + " ]";
    }
    
}
