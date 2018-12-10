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
@Table(name = "fecab_cabcra")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FecabCabcra.findAll", query = "SELECT f FROM FecabCabcra f")
    , @NamedQuery(name = "FecabCabcra.findByFecabNumfac", query = "SELECT f FROM FecabCabcra f WHERE f.fecabNumfac = :fecabNumfac")
    , @NamedQuery(name = "FecabCabcra.findByFefopId", query = "SELECT f FROM FecabCabcra f WHERE f.fefopId = :fefopId")
    , @NamedQuery(name = "FecabCabcra.findByFecliId", query = "SELECT f FROM FecabCabcra f WHERE f.fecliId = :fecliId")
    , @NamedQuery(name = "FecabCabcra.findByPeempCodigo", query = "SELECT f FROM FecabCabcra f WHERE f.peempCodigo = :peempCodigo")
    , @NamedQuery(name = "FecabCabcra.findByFecabFecemi", query = "SELECT f FROM FecabCabcra f WHERE f.fecabFecemi = :fecabFecemi")
    , @NamedQuery(name = "FecabCabcra.findByFecabFecha", query = "SELECT f FROM FecabCabcra f WHERE f.fecabFecha = :fecabFecha")
    , @NamedQuery(name = "FecabCabcra.findByFecabSubttl", query = "SELECT f FROM FecabCabcra f WHERE f.fecabSubttl = :fecabSubttl")
    , @NamedQuery(name = "FecabCabcra.findByFecabIva", query = "SELECT f FROM FecabCabcra f WHERE f.fecabIva = :fecabIva")
    , @NamedQuery(name = "FecabCabcra.findByFecabDescue", query = "SELECT f FROM FecabCabcra f WHERE f.fecabDescue = :fecabDescue")
    , @NamedQuery(name = "FecabCabcra.findByFecabTotpag", query = "SELECT f FROM FecabCabcra f WHERE f.fecabTotpag = :fecabTotpag")})
public class FecabCabcra implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "FECAB_NUMFAC")
    private String fecabNumfac;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FEFOP_ID")
    private int fefopId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECLI_ID")
    private int fecliId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "PEEMP_CODIGO")
    private String peempCodigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECAB_FECEMI")
    @Temporal(TemporalType.DATE)
    private Date fecabFecemi;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECAB_FECHA")
    @Temporal(TemporalType.DATE)
    private Date fecabFecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECAB_SUBTTL")
    private float fecabSubttl;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECAB_IVA")
    private float fecabIva;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "FECAB_DESCUE")
    private Float fecabDescue;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECAB_TOTPAG")
    private float fecabTotpag;

    public FecabCabcra() {
    }

    public FecabCabcra(String fecabNumfac) {
        this.fecabNumfac = fecabNumfac;
    }

    public FecabCabcra(String fecabNumfac, int fefopId, int fecliId, String peempCodigo, Date fecabFecemi, Date fecabFecha, float fecabSubttl, float fecabIva, float fecabTotpag) {
        this.fecabNumfac = fecabNumfac;
        this.fefopId = fefopId;
        this.fecliId = fecliId;
        this.peempCodigo = peempCodigo;
        this.fecabFecemi = fecabFecemi;
        this.fecabFecha = fecabFecha;
        this.fecabSubttl = fecabSubttl;
        this.fecabIva = fecabIva;
        this.fecabTotpag = fecabTotpag;
    }

    public String getFecabNumfac() {
        return fecabNumfac;
    }

    public void setFecabNumfac(String fecabNumfac) {
        this.fecabNumfac = fecabNumfac;
    }

    public int getFefopId() {
        return fefopId;
    }

    public void setFefopId(int fefopId) {
        this.fefopId = fefopId;
    }

    public int getFecliId() {
        return fecliId;
    }

    public void setFecliId(int fecliId) {
        this.fecliId = fecliId;
    }

    public String getPeempCodigo() {
        return peempCodigo;
    }

    public void setPeempCodigo(String peempCodigo) {
        this.peempCodigo = peempCodigo;
    }

    public Date getFecabFecemi() {
        return fecabFecemi;
    }

    public void setFecabFecemi(Date fecabFecemi) {
        this.fecabFecemi = fecabFecemi;
    }

    public Date getFecabFecha() {
        return fecabFecha;
    }

    public void setFecabFecha(Date fecabFecha) {
        this.fecabFecha = fecabFecha;
    }

    public float getFecabSubttl() {
        return fecabSubttl;
    }

    public void setFecabSubttl(float fecabSubttl) {
        this.fecabSubttl = fecabSubttl;
    }

    public float getFecabIva() {
        return fecabIva;
    }

    public void setFecabIva(float fecabIva) {
        this.fecabIva = fecabIva;
    }

    public Float getFecabDescue() {
        return fecabDescue;
    }

    public void setFecabDescue(Float fecabDescue) {
        this.fecabDescue = fecabDescue;
    }

    public float getFecabTotpag() {
        return fecabTotpag;
    }

    public void setFecabTotpag(float fecabTotpag) {
        this.fecabTotpag = fecabTotpag;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fecabNumfac != null ? fecabNumfac.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FecabCabcra)) {
            return false;
        }
        FecabCabcra other = (FecabCabcra) object;
        if ((this.fecabNumfac == null && other.fecabNumfac != null) || (this.fecabNumfac != null && !this.fecabNumfac.equals(other.fecabNumfac))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.distribuidas.model.FecabCabcra[ fecabNumfac=" + fecabNumfac + " ]";
    }
    
}
