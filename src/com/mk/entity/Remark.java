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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author MK
 */
@Entity
@Table(name = "remark")
@NamedQueries({
    @NamedQuery(name = "Remark.findAll", query = "SELECT b FROM Remark b")})
public class Remark implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RemarkPK pk;
    @Column(name = "time")
    @Temporal(TemporalType.DATE)
    private Date time;
    @Column(name = "text")
    private String text;
    @Column(name = "rank")
    private Integer rank;
    @Column(name = "agree")
    private Integer agree=0;
    @Column(name = "type")
    private Integer type=0;
    public Remark() {
    }

    public Remark(RemarkPK buyerRemarkPK) {
        this.pk = buyerRemarkPK;
    }

    public Remark(int pid, int uid) {
        this.pk = new RemarkPK(pid, uid);
    }

    public RemarkPK getPK() {
        return pk;
    }

    public void setPK(RemarkPK buyerRemarkPK) {
        this.pk = buyerRemarkPK;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public Integer getAgree() {
		return agree;
	}

	public void setAgree(Integer agree) {
		this.agree = agree;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (pk != null ? pk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Remark)) {
            return false;
        }
        Remark other = (Remark) object;
        if ((this.pk == null && other.pk != null) || (this.pk != null && !this.pk.equals(other.pk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mk.entity.Remark[ RemarkPK=" + pk + " ]";
    }
    
}
