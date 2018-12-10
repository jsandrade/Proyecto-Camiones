/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Juan
 */
@Entity
@Table(name = "fedef_detfac")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FedefDetfac.findAll", query = "SELECT f FROM FedefDetfac f")
    , @NamedQuery(name = "FedefDetfac.findByFedefId", query = "SELECT f FROM FedefDetfac f WHERE f.fedefDetfacPK.fedefId = :fedefId")
    , @NamedQuery(name = "FedefDetfac.findByCepedId", query = "SELECT f FROM FedefDetfac f WHERE f.fedefDetfacPK.cepedId = :cepedId")
    , @NamedQuery(name = "FedefDetfac.findByFecabNumfac", query = "SELECT f FROM FedefDetfac f WHERE f.fedefDetfacPK.fecabNumfac = :fecabNumfac")
    , @NamedQuery(name = "FedefDetfac.findByFedefCosto", query = "SELECT f FROM FedefDetfac f WHERE f.fedefCosto = :fedefCosto")})
public class FedefDetfac implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FedefDetfacPK fedefDetfacPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FEDEF_COSTO")
    private float fedefCosto;

    public FedefDetfac() {
    }

    public FedefDetfac(FedefDetfacPK fedefDetfacPK) {
        this.fedefDetfacPK = fedefDetfacPK;
    }

    public FedefDetfac(FedefDetfacPK fedefDetfacPK, float fedefCosto) {
        this.fedefDetfacPK = fedefDetfacPK;
        this.fedefCosto = fedefCosto;
    }

    public FedefDetfac(int fedefId, int cepedId, String fecabNumfac) {
        this.fedefDetfacPK = new FedefDetfacPK(fedefId, cepedId, fecabNumfac);
    }

    public FedefDetfacPK getFedefDetfacPK() {
        return fedefDetfacPK;
    }

    public void setFedefDetfacPK(FedefDetfacPK fedefDetfacPK) {
        this.fedefDetfacPK = fedefDetfacPK;
    }

    public float getFedefCosto() {
        return fedefCosto;
    }

    public void setFedefCosto(float fedefCosto) {
        this.fedefCosto = fedefCosto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fedefDetfacPK != null ? fedefDetfacPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FedefDetfac)) {
            return false;
        }
        FedefDetfac other = (FedefDetfac) object;
        if ((this.fedefDetfacPK == null && other.fedefDetfacPK != null) || (this.fedefDetfacPK != null && !this.fedefDetfacPK.equals(other.fedefDetfacPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.distribuidas.model.FedefDetfac[ fedefDetfacPK=" + fedefDetfacPK + " ]";
    }
    
}
