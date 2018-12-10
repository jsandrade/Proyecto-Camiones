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
public class PeprqParroPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "PEPAI_CODIGO")
    private String pepaiCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "PEPRV_CODIGO")
    private String peprvCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "PECAN_CODIGO")
    private String pecanCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "PEPRQ_CODIGO")
    private String peprqCodigo;

    public PeprqParroPK() {
    }

    public PeprqParroPK(String pepaiCodigo, String peprvCodigo, String pecanCodigo, String peprqCodigo) {
        this.pepaiCodigo = pepaiCodigo;
        this.peprvCodigo = peprvCodigo;
        this.pecanCodigo = pecanCodigo;
        this.peprqCodigo = peprqCodigo;
    }

    public String getPepaiCodigo() {
        return pepaiCodigo;
    }

    public void setPepaiCodigo(String pepaiCodigo) {
        this.pepaiCodigo = pepaiCodigo;
    }

    public String getPeprvCodigo() {
        return peprvCodigo;
    }

    public void setPeprvCodigo(String peprvCodigo) {
        this.peprvCodigo = peprvCodigo;
    }

    public String getPecanCodigo() {
        return pecanCodigo;
    }

    public void setPecanCodigo(String pecanCodigo) {
        this.pecanCodigo = pecanCodigo;
    }

    public String getPeprqCodigo() {
        return peprqCodigo;
    }

    public void setPeprqCodigo(String peprqCodigo) {
        this.peprqCodigo = peprqCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pepaiCodigo != null ? pepaiCodigo.hashCode() : 0);
        hash += (peprvCodigo != null ? peprvCodigo.hashCode() : 0);
        hash += (pecanCodigo != null ? pecanCodigo.hashCode() : 0);
        hash += (peprqCodigo != null ? peprqCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PeprqParroPK)) {
            return false;
        }
        PeprqParroPK other = (PeprqParroPK) object;
        if ((this.pepaiCodigo == null && other.pepaiCodigo != null) || (this.pepaiCodigo != null && !this.pepaiCodigo.equals(other.pepaiCodigo))) {
            return false;
        }
        if ((this.peprvCodigo == null && other.peprvCodigo != null) || (this.peprvCodigo != null && !this.peprvCodigo.equals(other.peprvCodigo))) {
            return false;
        }
        if ((this.pecanCodigo == null && other.pecanCodigo != null) || (this.pecanCodigo != null && !this.pecanCodigo.equals(other.pecanCodigo))) {
            return false;
        }
        if ((this.peprqCodigo == null && other.peprqCodigo != null) || (this.peprqCodigo != null && !this.peprqCodigo.equals(other.peprqCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.distribuidas.model.PeprqParroPK[ pepaiCodigo=" + pepaiCodigo + ", peprvCodigo=" + peprvCodigo + ", pecanCodigo=" + pecanCodigo + ", peprqCodigo=" + peprqCodigo + " ]";
    }
    
}
