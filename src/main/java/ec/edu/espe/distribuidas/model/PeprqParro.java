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
@Table(name = "peprq_parro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PeprqParro.findAll", query = "SELECT p FROM PeprqParro p")
    , @NamedQuery(name = "PeprqParro.findByPepaiCodigo", query = "SELECT p FROM PeprqParro p WHERE p.peprqParroPK.pepaiCodigo = :pepaiCodigo")
    , @NamedQuery(name = "PeprqParro.findByPeprvCodigo", query = "SELECT p FROM PeprqParro p WHERE p.peprqParroPK.peprvCodigo = :peprvCodigo")
    , @NamedQuery(name = "PeprqParro.findByPecanCodigo", query = "SELECT p FROM PeprqParro p WHERE p.peprqParroPK.pecanCodigo = :pecanCodigo")
    , @NamedQuery(name = "PeprqParro.findByPeprqCodigo", query = "SELECT p FROM PeprqParro p WHERE p.peprqParroPK.peprqCodigo = :peprqCodigo")
    , @NamedQuery(name = "PeprqParro.findByPeprqDescri", query = "SELECT p FROM PeprqParro p WHERE p.peprqDescri = :peprqDescri")})
public class PeprqParro implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PeprqParroPK peprqParroPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "PEPRQ_DESCRI")
    private String peprqDescri;

    public PeprqParro() {
    }

    public PeprqParro(PeprqParroPK peprqParroPK) {
        this.peprqParroPK = peprqParroPK;
    }

    public PeprqParro(PeprqParroPK peprqParroPK, String peprqDescri) {
        this.peprqParroPK = peprqParroPK;
        this.peprqDescri = peprqDescri;
    }

    public PeprqParro(String pepaiCodigo, String peprvCodigo, String pecanCodigo, String peprqCodigo) {
        this.peprqParroPK = new PeprqParroPK(pepaiCodigo, peprvCodigo, pecanCodigo, peprqCodigo);
    }

    public PeprqParroPK getPeprqParroPK() {
        return peprqParroPK;
    }

    public void setPeprqParroPK(PeprqParroPK peprqParroPK) {
        this.peprqParroPK = peprqParroPK;
    }

    public String getPeprqDescri() {
        return peprqDescri;
    }

    public void setPeprqDescri(String peprqDescri) {
        this.peprqDescri = peprqDescri;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (peprqParroPK != null ? peprqParroPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PeprqParro)) {
            return false;
        }
        PeprqParro other = (PeprqParro) object;
        if ((this.peprqParroPK == null && other.peprqParroPK != null) || (this.peprqParroPK != null && !this.peprqParroPK.equals(other.peprqParroPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.distribuidas.model.PeprqParro[ peprqParroPK=" + peprqParroPK + " ]";
    }
    
}
