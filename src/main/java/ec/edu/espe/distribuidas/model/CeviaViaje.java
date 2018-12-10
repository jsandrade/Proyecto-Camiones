/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Juan
 */
@Entity
@Table(name = "cevia_viaje")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CeviaViaje.findAll", query = "SELECT c FROM CeviaViaje c")
    , @NamedQuery(name = "CeviaViaje.findByCeviaId", query = "SELECT c FROM CeviaViaje c WHERE c.ceviaId = :ceviaId")
    , @NamedQuery(name = "CeviaViaje.findByCecamMatric", query = "SELECT c FROM CeviaViaje c WHERE c.cecamMatric = :cecamMatric")
    , @NamedQuery(name = "CeviaViaje.findByCeviaFprvij", query = "SELECT c FROM CeviaViaje c WHERE c.ceviaFprvij = :ceviaFprvij")
    , @NamedQuery(name = "CeviaViaje.findByCeviaFfivij", query = "SELECT c FROM CeviaViaje c WHERE c.ceviaFfivij = :ceviaFfivij")
    , @NamedQuery(name = "CeviaViaje.findByCeviaVolume", query = "SELECT c FROM CeviaViaje c WHERE c.ceviaVolume = :ceviaVolume")
    , @NamedQuery(name = "CeviaViaje.findByCeviaPeso", query = "SELECT c FROM CeviaViaje c WHERE c.ceviaPeso = :ceviaPeso")
    , @NamedQuery(name = "CeviaViaje.findByCeviaEstado", query = "SELECT c FROM CeviaViaje c WHERE c.ceviaEstado = :ceviaEstado")})
public class CeviaViaje implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CEVIA_ID")
    private Integer ceviaId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "CECAM_MATRIC")
    private String cecamMatric;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CEVIA_FPRVIJ")
    @Temporal(TemporalType.DATE)
    private Date ceviaFprvij;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CEVIA_FFIVIJ")
    @Temporal(TemporalType.DATE)
    private Date ceviaFfivij;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CEVIA_VOLUME")
    private float ceviaVolume;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CEVIA_PESO")
    private float ceviaPeso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CEVIA_ESTADO")
    private int ceviaEstado;

    public CeviaViaje() {
    }

    public CeviaViaje(Integer ceviaId) {
        this.ceviaId = ceviaId;
    }

    public CeviaViaje(Integer ceviaId, String cecamMatric, Date ceviaFprvij, Date ceviaFfivij, float ceviaVolume, float ceviaPeso, int ceviaEstado) {
        this.ceviaId = ceviaId;
        this.cecamMatric = cecamMatric;
        this.ceviaFprvij = ceviaFprvij;
        this.ceviaFfivij = ceviaFfivij;
        this.ceviaVolume = ceviaVolume;
        this.ceviaPeso = ceviaPeso;
        this.ceviaEstado = ceviaEstado;
    }

    public Integer getCeviaId() {
        return ceviaId;
    }

    public void setCeviaId(Integer ceviaId) {
        this.ceviaId = ceviaId;
    }

    public String getCecamMatric() {
        return cecamMatric;
    }

    public void setCecamMatric(String cecamMatric) {
        this.cecamMatric = cecamMatric;
    }

    public Date getCeviaFprvij() {
        return ceviaFprvij;
    }

    public void setCeviaFprvij(Date ceviaFprvij) {
        this.ceviaFprvij = ceviaFprvij;
    }

    public Date getCeviaFfivij() {
        return ceviaFfivij;
    }

    public void setCeviaFfivij(Date ceviaFfivij) {
        this.ceviaFfivij = ceviaFfivij;
    }

    public float getCeviaVolume() {
        return ceviaVolume;
    }

    public void setCeviaVolume(float ceviaVolume) {
        this.ceviaVolume = ceviaVolume;
    }

    public float getCeviaPeso() {
        return ceviaPeso;
    }

    public void setCeviaPeso(float ceviaPeso) {
        this.ceviaPeso = ceviaPeso;
    }

    public int getCeviaEstado() {
        return ceviaEstado;
    }

    public void setCeviaEstado(int ceviaEstado) {
        this.ceviaEstado = ceviaEstado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ceviaId != null ? ceviaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CeviaViaje)) {
            return false;
        }
        CeviaViaje other = (CeviaViaje) object;
        if ((this.ceviaId == null && other.ceviaId != null) || (this.ceviaId != null && !this.ceviaId.equals(other.ceviaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.distribuidas.model.CeviaViaje[ ceviaId=" + ceviaId + " ]";
    }
    
}
