/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Juan
 */
@Embeddable
public class FedefDetfacPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "FEDEF_ID")
    private int fedefId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CEPED_ID")
    private int cepedId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "FECAB_NUMFAC")
    private String fecabNumfac;

    public FedefDetfacPK() {
    }

    public FedefDetfacPK(int fedefId, int cepedId, String fecabNumfac) {
        this.fedefId = fedefId;
        this.cepedId = cepedId;
        this.fecabNumfac = fecabNumfac;
    }

    public int getFedefId() {
        return fedefId;
    }

    public void setFedefId(int fedefId) {
        this.fedefId = fedefId;
    }

    public int getCepedId() {
        return cepedId;
    }

    public void setCepedId(int cepedId) {
        this.cepedId = cepedId;
    }

    public String getFecabNumfac() {
        return fecabNumfac;
    }

    public void setFecabNumfac(String fecabNumfac) {
        this.fecabNumfac = fecabNumfac;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) fedefId;
        hash += (int) cepedId;
        hash += (fecabNumfac != null ? fecabNumfac.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FedefDetfacPK)) {
            return false;
        }
        FedefDetfacPK other = (FedefDetfacPK) object;
        if (this.fedefId != other.fedefId) {
            return false;
        }
        if (this.cepedId != other.cepedId) {
            return false;
        }
        if ((this.fecabNumfac == null && other.fecabNumfac != null) || (this.fecabNumfac != null && !this.fecabNumfac.equals(other.fecabNumfac))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.distribuidas.model.FedefDetfacPK[ fedefId=" + fedefId + ", cepedId=" + cepedId + ", fecabNumfac=" + fecabNumfac + " ]";
    }
    
}
