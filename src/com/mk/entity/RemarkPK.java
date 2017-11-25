/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mk.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author MK
 */
@Embeddable
public class RemarkPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "pid")
    private int pid;
    @Basic(optional = false)
    @Column(name = "uid")
    private int uid;

    public RemarkPK() {
    }

    public RemarkPK(int pid, int uid) {
        this.pid = pid;
        this.uid = uid;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) pid;
        hash += (int) uid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RemarkPK)) {
            return false;
        }
        RemarkPK other = (RemarkPK) object;
        if (this.pid != other.pid) {
            return false;
        }
        if (this.uid != other.uid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mk.entity.WanterRemarkPK[ pid=" + pid + ", uid=" + uid + " ]";
    }
    
}
