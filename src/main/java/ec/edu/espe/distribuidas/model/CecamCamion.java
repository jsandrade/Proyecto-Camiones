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
@Table(name = "cecam_camion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CecamCamion.findAll", query = "SELECT c FROM CecamCamion c")
    , @NamedQuery(name = "CecamCamion.findByCecamMatric", query = "SELECT c FROM CecamCamion c WHERE c.cecamMatric = :cecamMatric")
    , @NamedQuery(name = "CecamCamion.findByCecamVolume", query = "SELECT c FROM CecamCamion c WHERE c.cecamVolume = :cecamVolume")
    , @NamedQuery(name = "CecamCamion.findByCecamPeso", query = "SELECT c FROM CecamCamion c WHERE c.cecamPeso = :cecamPeso")
    , @NamedQuery(name = "CecamCamion.findByCecamEstado", query = "SELECT c FROM CecamCamion c WHERE c.cecamEstado = :cecamEstado")})
public class CecamCamion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "CECAM_MATRIC")
    private String cecamMatric;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CECAM_VOLUME")
    private float cecamVolume;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CECAM_PESO")
    private float cecamPeso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CECAM_ESTADO")
    private int cecamEstado;

    public CecamCamion() {
    }

    public CecamCamion(String cecamMatric) {
        this.cecamMatric = cecamMatric;
    }

    public CecamCamion(String cecamMatric, float cecamVolume, float cecamPeso, int cecamEstado) {
        this.cecamMatric = cecamMatric;
        this.cecamVolume = cecamVolume;
        this.cecamPeso = cecamPeso;
        this.cecamEstado = cecamEstado;
    }

    public String getCecamMatric() {
        return cecamMatric;
    }

    public void setCecamMatric(String cecamMatric) {
        this.cecamMatric = cecamMatric;
    }

    public float getCecamVolume() {
        return cecamVolume;
    }

    public void setCecamVolume(float cecamVolume) {
        this.cecamVolume = cecamVolume;
    }

    public float getCecamPeso() {
        return cecamPeso;
    }

    public void setCecamPeso(float cecamPeso) {
        this.cecamPeso = cecamPeso;
    }

    public int getCecamEstado() {
        return cecamEstado;
    }

    public void setCecamEstado(int cecamEstado) {
        this.cecamEstado = cecamEstado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cecamMatric != null ? cecamMatric.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CecamCamion)) {
            return false;
        }
        CecamCamion other = (CecamCamion) object;
        if ((this.cecamMatric == null && other.cecamMatric != null) || (this.cecamMatric != null && !this.cecamMatric.equals(other.cecamMatric))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.distribuidas.model.CecamCamion[ cecamMatric=" + cecamMatric + " ]";
    }
    
}
