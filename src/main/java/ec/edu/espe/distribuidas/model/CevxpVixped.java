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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Juan
 */
@Entity
@Table(name = "cevxp_vixped")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CevxpVixped.findAll", query = "SELECT c FROM CevxpVixped c")
    , @NamedQuery(name = "CevxpVixped.findByCepedId", query = "SELECT c FROM CevxpVixped c WHERE c.cevxpVixpedPK.cepedId = :cepedId")
    , @NamedQuery(name = "CevxpVixped.findByCeviaId", query = "SELECT c FROM CevxpVixped c WHERE c.cevxpVixpedPK.ceviaId = :ceviaId")
    , @NamedQuery(name = "CevxpVixped.findByPeempCodigo", query = "SELECT c FROM CevxpVixped c WHERE c.peempCodigo = :peempCodigo")})
public class CevxpVixped implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CevxpVixpedPK cevxpVixpedPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "PEEMP_CODIGO")
    private String peempCodigo;

    public CevxpVixped() {
    }

    public CevxpVixped(CevxpVixpedPK cevxpVixpedPK) {
        this.cevxpVixpedPK = cevxpVixpedPK;
    }

    public CevxpVixped(CevxpVixpedPK cevxpVixpedPK, String peempCodigo) {
        this.cevxpVixpedPK = cevxpVixpedPK;
        this.peempCodigo = peempCodigo;
    }

    public CevxpVixped(int cepedId, int ceviaId) {
        this.cevxpVixpedPK = new CevxpVixpedPK(cepedId, ceviaId);
    }

    public CevxpVixpedPK getCevxpVixpedPK() {
        return cevxpVixpedPK;
    }

    public void setCevxpVixpedPK(CevxpVixpedPK cevxpVixpedPK) {
        this.cevxpVixpedPK = cevxpVixpedPK;
    }

    public String getPeempCodigo() {
        return peempCodigo;
    }

    public void setPeempCodigo(String peempCodigo) {
        this.peempCodigo = peempCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cevxpVixpedPK != null ? cevxpVixpedPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CevxpVixped)) {
            return false;
        }
        CevxpVixped other = (CevxpVixped) object;
        if ((this.cevxpVixpedPK == null && other.cevxpVixpedPK != null) || (this.cevxpVixpedPK != null && !this.cevxpVixpedPK.equals(other.cevxpVixpedPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.distribuidas.model.CevxpVixped[ cevxpVixpedPK=" + cevxpVixpedPK + " ]";
    }
    
}
