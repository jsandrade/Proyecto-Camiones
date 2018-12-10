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

/**
 *
 * @author Juan
 */
@Embeddable
public class CevxpVixpedPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "CEPED_ID")
    private int cepedId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CEVIA_ID")
    private int ceviaId;

    public CevxpVixpedPK() {
    }

    public CevxpVixpedPK(int cepedId, int ceviaId) {
        this.cepedId = cepedId;
        this.ceviaId = ceviaId;
    }

    public int getCepedId() {
        return cepedId;
    }

    public void setCepedId(int cepedId) {
        this.cepedId = cepedId;
    }

    public int getCeviaId() {
        return ceviaId;
    }

    public void setCeviaId(int ceviaId) {
        this.ceviaId = ceviaId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) cepedId;
        hash += (int) ceviaId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CevxpVixpedPK)) {
            return false;
        }
        CevxpVixpedPK other = (CevxpVixpedPK) object;
        if (this.cepedId != other.cepedId) {
            return false;
        }
        if (this.ceviaId != other.ceviaId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.distribuidas.model.CevxpVixpedPK[ cepedId=" + cepedId + ", ceviaId=" + ceviaId + " ]";
    }
    
}
