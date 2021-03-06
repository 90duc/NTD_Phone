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
@Table(name = "sensitive_operation")
public class SensitiveOperation implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SensitiveOperationPK operationPK;
    @Column(name = "ip")
    private String ip;
    @Column(name = "city")
    private String city;
    @Column(name = "operation")
    private String operation;

    public SensitiveOperation() {
    }

    public SensitiveOperation(SensitiveOperationPK sensitiveOperationPK) {
        this.operationPK = sensitiveOperationPK;
    }

    public SensitiveOperation(int uid, Date time) {
        this.operationPK = new SensitiveOperationPK(uid, time);
    }

    public SensitiveOperationPK getSensitiveOperationPK() {
        return operationPK;
    }

    public void setSensitiveOperationPK(SensitiveOperationPK sensitiveOperationPK) {
        this.operationPK = sensitiveOperationPK;
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

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (operationPK != null ? operationPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SensitiveOperation)) {
            return false;
        }
        SensitiveOperation other = (SensitiveOperation) object;
        if ((this.operationPK == null && other.operationPK != null) || (this.operationPK != null && !this.operationPK.equals(other.operationPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mk.entity.SensitiveOperation[ sensitiveOperationPK=" + operationPK + " ]";
    }
    
}
