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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Juan
 */
@Entity
@Table(name = "ceped_pedid")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CepedPedid.findAll", query = "SELECT c FROM CepedPedid c")
    , @NamedQuery(name = "CepedPedid.findByCepedId", query = "SELECT c FROM CepedPedid c WHERE c.cepedId = :cepedId")
    , @NamedQuery(name = "CepedPedid.findByCetieId", query = "SELECT c FROM CepedPedid c WHERE c.cetieId = :cetieId")
    , @NamedQuery(name = "CepedPedid.findByCealmId", query = "SELECT c FROM CepedPedid c WHERE c.cealmId = :cealmId")
    , @NamedQuery(name = "CepedPedid.findByCepedPeso", query = "SELECT c FROM CepedPedid c WHERE c.cepedPeso = :cepedPeso")
    , @NamedQuery(name = "CepedPedid.findByCepedVolume", query = "SELECT c FROM CepedPedid c WHERE c.cepedVolume = :cepedVolume")
    , @NamedQuery(name = "CepedPedid.findByCepedDistan", query = "SELECT c FROM CepedPedid c WHERE c.cepedDistan = :cepedDistan")
    , @NamedQuery(name = "CepedPedid.findByCepedCosto", query = "SELECT c FROM CepedPedid c WHERE c.cepedCosto = :cepedCosto")
    , @NamedQuery(name = "CepedPedid.findByCepedEstado", query = "SELECT c FROM CepedPedid c WHERE c.cepedEstado = :cepedEstado")})
public class CepedPedid implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CEPED_ID")
    private Integer cepedId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CETIE_ID")
    private int cetieId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CEALM_ID")
    private int cealmId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CEPED_PESO")
    private float cepedPeso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CEPED_VOLUME")
    private float cepedVolume;
    @Column(name = "CEPED_DISTAN")
    private Integer cepedDistan;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CEPED_COSTO")
    private float cepedCosto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CEPED_ESTADO")
    private int cepedEstado;

    public CepedPedid() {
    }

    public CepedPedid(Integer cepedId) {
        this.cepedId = cepedId;
    }

    public CepedPedid(Integer cepedId, int cetieId, int cealmId, float cepedPeso, float cepedVolume, float cepedCosto, int cepedEstado) {
        this.cepedId = cepedId;
        this.cetieId = cetieId;
        this.cealmId = cealmId;
        this.cepedPeso = cepedPeso;
        this.cepedVolume = cepedVolume;
        this.cepedCosto = cepedCosto;
        this.cepedEstado = cepedEstado;
    }

    public Integer getCepedId() {
        return cepedId;
    }

    public void setCepedId(Integer cepedId) {
        this.cepedId = cepedId;
    }

    public int getCetieId() {
        return cetieId;
    }

    public void setCetieId(int cetieId) {
        this.cetieId = cetieId;
    }

    public int getCealmId() {
        return cealmId;
    }

    public void setCealmId(int cealmId) {
        this.cealmId = cealmId;
    }

    public float getCepedPeso() {
        return cepedPeso;
    }

    public void setCepedPeso(float cepedPeso) {
        this.cepedPeso = cepedPeso;
    }

    public float getCepedVolume() {
        return cepedVolume;
    }

    public void setCepedVolume(float cepedVolume) {
        this.cepedVolume = cepedVolume;
    }

    public Integer getCepedDistan() {
        return cepedDistan;
    }

    public void setCepedDistan(Integer cepedDistan) {
        this.cepedDistan = cepedDistan;
    }

    public float getCepedCosto() {
        return cepedCosto;
    }

    public void setCepedCosto(float cepedCosto) {
        this.cepedCosto = cepedCosto;
    }

    public int getCepedEstado() {
        return cepedEstado;
    }

    public void setCepedEstado(int cepedEstado) {
        this.cepedEstado = cepedEstado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cepedId != null ? cepedId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CepedPedid)) {
            return false;
        }
        CepedPedid other = (CepedPedid) object;
        if ((this.cepedId == null && other.cepedId != null) || (this.cepedId != null && !this.cepedId.equals(other.cepedId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.distribuidas.model.CepedPedid[ cepedId=" + cepedId + " ]";
    }
    
}
