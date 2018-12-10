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
@Table(name = "peprv_provin")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PeprvProvin.findAll", query = "SELECT p FROM PeprvProvin p")
    , @NamedQuery(name = "PeprvProvin.findByPepaiCodigo", query = "SELECT p FROM PeprvProvin p WHERE p.peprvProvinPK.pepaiCodigo = :pepaiCodigo")
    , @NamedQuery(name = "PeprvProvin.findByPeprvCodigo", query = "SELECT p FROM PeprvProvin p WHERE p.peprvProvinPK.peprvCodigo = :peprvCodigo")
    , @NamedQuery(name = "PeprvProvin.findByPeprvDescri", query = "SELECT p FROM PeprvProvin p WHERE p.peprvDescri = :peprvDescri")})
public class PeprvProvin implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PeprvProvinPK peprvProvinPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "PEPRV_DESCRI")
    private String peprvDescri;

    public PeprvProvin() {
    }

    public PeprvProvin(PeprvProvinPK peprvProvinPK) {
        this.peprvProvinPK = peprvProvinPK;
    }

    public PeprvProvin(PeprvProvinPK peprvProvinPK, String peprvDescri) {
        this.peprvProvinPK = peprvProvinPK;
        this.peprvDescri = peprvDescri;
    }

    public PeprvProvin(String pepaiCodigo, String peprvCodigo) {
        this.peprvProvinPK = new PeprvProvinPK(pepaiCodigo, peprvCodigo);
    }

    public PeprvProvinPK getPeprvProvinPK() {
        return peprvProvinPK;
    }

    public void setPeprvProvinPK(PeprvProvinPK peprvProvinPK) {
        this.peprvProvinPK = peprvProvinPK;
    }

    public String getPeprvDescri() {
        return peprvDescri;
    }

    public void setPeprvDescri(String peprvDescri) {
        this.peprvDescri = peprvDescri;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (peprvProvinPK != null ? peprvProvinPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PeprvProvin)) {
            return false;
        }
        PeprvProvin other = (PeprvProvin) object;
        if ((this.peprvProvinPK == null && other.peprvProvinPK != null) || (this.peprvProvinPK != null && !this.peprvProvinPK.equals(other.peprvProvinPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.distribuidas.model.PeprvProvin[ peprvProvinPK=" + peprvProvinPK + " ]";
    }
    
}
