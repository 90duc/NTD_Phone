/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mk.entity;

import java.io.Serializable;
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
@Table(name = "imgs")
@NamedQueries({
    @NamedQuery(name = "Imgs.findAll", query = "SELECT i FROM Imgs i")})
public class Imgs implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ImgsPK imgsPK;

    public Imgs() {
    }

    public Imgs(ImgsPK imgsPK) {
        this.imgsPK = imgsPK;
    }

    public Imgs(int pid, String image) {
        this.imgsPK = new ImgsPK(pid, image);
    }

    public ImgsPK getImgsPK() {
        return imgsPK;
    }

    public void setImgsPK(ImgsPK imgsPK) {
        this.imgsPK = imgsPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (imgsPK != null ? imgsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Imgs)) {
            return false;
        }
        Imgs other = (Imgs) object;
        if ((this.imgsPK == null && other.imgsPK != null) || (this.imgsPK != null && !this.imgsPK.equals(other.imgsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mk.entity.Imgs[ imgsPK=" + imgsPK + " ]";
    }
    
}
