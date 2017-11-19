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
public class ImgsPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "pid")
    private int pid;
    @Basic(optional = false)
    @Column(name = "image")
    private String image;

    public ImgsPK() {
    }

    public ImgsPK(int pid, String image) {
        this.pid = pid;
        this.image = image;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) pid;
        hash += (image != null ? image.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ImgsPK)) {
            return false;
        }
        ImgsPK other = (ImgsPK) object;
        if (this.pid != other.pid) {
            return false;
        }
        if ((this.image == null && other.image != null) || (this.image != null && !this.image.equals(other.image))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mk.entity.ImgsPK[ pid=" + pid + ", image=" + image + " ]";
    }
    
}
