/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Juan
 */
@Entity
@Table(name = "fefop_forpag")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FefopForpag.findAll", query = "SELECT f FROM FefopForpag f")
    , @NamedQuery(name = "FefopForpag.findByFefopId", query = "SELECT f FROM FefopForpag f WHERE f.fefopId = :fefopId")
    , @NamedQuery(name = "FefopForpag.findByFefopDescri", query = "SELECT f FROM FefopForpag f WHERE f.fefopDescri = :fefopDescri")
    , @NamedQuery(name = "FefopForpag.findByFeforEstado", query = "SELECT f FROM FefopForpag f WHERE f.feforEstado = :feforEstado")})
public class FefopForpag implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "FEFOP_ID")
    private Integer fefopId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "FEFOP_DESCRI")
    private String fefopDescri;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FEFOR_ESTADO")
    private int feforEstado;

    public FefopForpag() {
    }

    public FefopForpag(Integer fefopId) {
        this.fefopId = fefopId;
    }

    public FefopForpag(Integer fefopId, String fefopDescri, int feforEstado) {
        this.fefopId = fefopId;
        this.fefopDescri = fefopDescri;
        this.feforEstado = feforEstado;
    }

    public Integer getFefopId() {
        return fefopId;
    }

    public void setFefopId(Integer fefopId) {
        this.fefopId = fefopId;
    }

    public String getFefopDescri() {
        return fefopDescri;
    }

    public void setFefopDescri(String fefopDescri) {
        this.fefopDescri = fefopDescri;
    }

    public int getFeforEstado() {
        return feforEstado;
    }

    public void setFeforEstado(int feforEstado) {
        this.feforEstado = feforEstado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fefopId != null ? fefopId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FefopForpag)) {
            return false;
        }
        FefopForpag other = (FefopForpag) object;
        if ((this.fefopId == null && other.fefopId != null) || (this.fefopId != null && !this.fefopId.equals(other.fefopId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.distribuidas.model.FefopForpag[ fefopId=" + fefopId + " ]";
    }
    
}
