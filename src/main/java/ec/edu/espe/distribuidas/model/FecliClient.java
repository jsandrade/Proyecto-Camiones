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
@Table(name = "fecli_client")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FecliClient.findAll", query = "SELECT f FROM FecliClient f")
    , @NamedQuery(name = "FecliClient.findByFecliId", query = "SELECT f FROM FecliClient f WHERE f.fecliId = :fecliId")
    , @NamedQuery(name = "FecliClient.findByFecliRazsoc", query = "SELECT f FROM FecliClient f WHERE f.fecliRazsoc = :fecliRazsoc")
    , @NamedQuery(name = "FecliClient.findByFecliCedula", query = "SELECT f FROM FecliClient f WHERE f.fecliCedula = :fecliCedula")
    , @NamedQuery(name = "FecliClient.findByFecliRuc", query = "SELECT f FROM FecliClient f WHERE f.fecliRuc = :fecliRuc")
    , @NamedQuery(name = "FecliClient.findByFecliTelefo", query = "SELECT f FROM FecliClient f WHERE f.fecliTelefo = :fecliTelefo")
    , @NamedQuery(name = "FecliClient.findByFecliDirecc", query = "SELECT f FROM FecliClient f WHERE f.fecliDirecc = :fecliDirecc")
    , @NamedQuery(name = "FecliClient.findByFecliEstado", query = "SELECT f FROM FecliClient f WHERE f.fecliEstado = :fecliEstado")})
public class FecliClient implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECLI_ID")
    private Integer fecliId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "FECLI_RAZSOC")
    private String fecliRazsoc;
    @Size(max = 10)
    @Column(name = "FECLI_CEDULA")
    private String fecliCedula;
    @Size(max = 13)
    @Column(name = "FECLI_RUC")
    private String fecliRuc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "FECLI_TELEFO")
    private String fecliTelefo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "FECLI_DIRECC")
    private String fecliDirecc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECLI_ESTADO")
    private int fecliEstado;

    public FecliClient() {
    }

    public FecliClient(Integer fecliId) {
        this.fecliId = fecliId;
    }

    public FecliClient(Integer fecliId, String fecliRazsoc, String fecliTelefo, String fecliDirecc, int fecliEstado) {
        this.fecliId = fecliId;
        this.fecliRazsoc = fecliRazsoc;
        this.fecliTelefo = fecliTelefo;
        this.fecliDirecc = fecliDirecc;
        this.fecliEstado = fecliEstado;
    }

    public Integer getFecliId() {
        return fecliId;
    }

    public void setFecliId(Integer fecliId) {
        this.fecliId = fecliId;
    }

    public String getFecliRazsoc() {
        return fecliRazsoc;
    }

    public void setFecliRazsoc(String fecliRazsoc) {
        this.fecliRazsoc = fecliRazsoc;
    }

    public String getFecliCedula() {
        return fecliCedula;
    }

    public void setFecliCedula(String fecliCedula) {
        this.fecliCedula = fecliCedula;
    }

    public String getFecliRuc() {
        return fecliRuc;
    }

    public void setFecliRuc(String fecliRuc) {
        this.fecliRuc = fecliRuc;
    }

    public String getFecliTelefo() {
        return fecliTelefo;
    }

    public void setFecliTelefo(String fecliTelefo) {
        this.fecliTelefo = fecliTelefo;
    }

    public String getFecliDirecc() {
        return fecliDirecc;
    }

    public void setFecliDirecc(String fecliDirecc) {
        this.fecliDirecc = fecliDirecc;
    }

    public int getFecliEstado() {
        return fecliEstado;
    }

    public void setFecliEstado(int fecliEstado) {
        this.fecliEstado = fecliEstado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fecliId != null ? fecliId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FecliClient)) {
            return false;
        }
        FecliClient other = (FecliClient) object;
        if ((this.fecliId == null && other.fecliId != null) || (this.fecliId != null && !this.fecliId.equals(other.fecliId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.distribuidas.model.FecliClient[ fecliId=" + fecliId + " ]";
    }
    
}
