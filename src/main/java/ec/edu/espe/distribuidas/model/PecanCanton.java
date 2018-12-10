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
@Table(name = "pecan_canton")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PecanCanton.findAll", query = "SELECT p FROM PecanCanton p")
    , @NamedQuery(name = "PecanCanton.findByPepaiCodigo", query = "SELECT p FROM PecanCanton p WHERE p.pecanCantonPK.pepaiCodigo = :pepaiCodigo")
    , @NamedQuery(name = "PecanCanton.findByPeprvCodigo", query = "SELECT p FROM PecanCanton p WHERE p.pecanCantonPK.peprvCodigo = :peprvCodigo")
    , @NamedQuery(name = "PecanCanton.findByPecanCodigo", query = "SELECT p FROM PecanCanton p WHERE p.pecanCantonPK.pecanCodigo = :pecanCodigo")
    , @NamedQuery(name = "PecanCanton.findByPecanDescri", query = "SELECT p FROM PecanCanton p WHERE p.pecanDescri = :pecanDescri")})
public class PecanCanton implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PecanCantonPK pecanCantonPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "PECAN_DESCRI")
    private String pecanDescri;

    public PecanCanton() {
    }

    public PecanCanton(PecanCantonPK pecanCantonPK) {
        this.pecanCantonPK = pecanCantonPK;
    }

    public PecanCanton(PecanCantonPK pecanCantonPK, String pecanDescri) {
        this.pecanCantonPK = pecanCantonPK;
        this.pecanDescri = pecanDescri;
    }

    public PecanCanton(String pepaiCodigo, String peprvCodigo, String pecanCodigo) {
        this.pecanCantonPK = new PecanCantonPK(pepaiCodigo, peprvCodigo, pecanCodigo);
    }

    public PecanCantonPK getPecanCantonPK() {
        return pecanCantonPK;
    }

    public void setPecanCantonPK(PecanCantonPK pecanCantonPK) {
        this.pecanCantonPK = pecanCantonPK;
    }

    public String getPecanDescri() {
        return pecanDescri;
    }

    public void setPecanDescri(String pecanDescri) {
        this.pecanDescri = pecanDescri;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pecanCantonPK != null ? pecanCantonPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PecanCanton)) {
            return false;
        }
        PecanCanton other = (PecanCanton) object;
        if ((this.pecanCantonPK == null && other.pecanCantonPK != null) || (this.pecanCantonPK != null && !this.pecanCantonPK.equals(other.pecanCantonPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.distribuidas.model.PecanCanton[ pecanCantonPK=" + pecanCantonPK + " ]";
    }
    
}
