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
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Juan
 */
@Embeddable
public class XeuxpUsuperPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "PEEMP_CODIGO")
    private String peempCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "XEPER_CODPER")
    private String xeperCodper;
    @Basic(optional = false)
    @NotNull
    @Column(name = "XEUXP_FECASI")
    @Temporal(TemporalType.DATE)
    private Date xeuxpFecasi;

    public XeuxpUsuperPK() {
    }

    public XeuxpUsuperPK(String peempCodigo, String xeperCodper, Date xeuxpFecasi) {
        this.peempCodigo = peempCodigo;
        this.xeperCodper = xeperCodper;
        this.xeuxpFecasi = xeuxpFecasi;
    }

    public String getPeempCodigo() {
        return peempCodigo;
    }

    public void setPeempCodigo(String peempCodigo) {
        this.peempCodigo = peempCodigo;
    }

    public String getXeperCodper() {
        return xeperCodper;
    }

    public void setXeperCodper(String xeperCodper) {
        this.xeperCodper = xeperCodper;
    }

    public Date getXeuxpFecasi() {
        return xeuxpFecasi;
    }

    public void setXeuxpFecasi(Date xeuxpFecasi) {
        this.xeuxpFecasi = xeuxpFecasi;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (peempCodigo != null ? peempCodigo.hashCode() : 0);
        hash += (xeperCodper != null ? xeperCodper.hashCode() : 0);
        hash += (xeuxpFecasi != null ? xeuxpFecasi.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof XeuxpUsuperPK)) {
            return false;
        }
        XeuxpUsuperPK other = (XeuxpUsuperPK) object;
        if ((this.peempCodigo == null && other.peempCodigo != null) || (this.peempCodigo != null && !this.peempCodigo.equals(other.peempCodigo))) {
            return false;
        }
        if ((this.xeperCodper == null && other.xeperCodper != null) || (this.xeperCodper != null && !this.xeperCodper.equals(other.xeperCodper))) {
            return false;
        }
        if ((this.xeuxpFecasi == null && other.xeuxpFecasi != null) || (this.xeuxpFecasi != null && !this.xeuxpFecasi.equals(other.xeuxpFecasi))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.distribuidas.model.XeuxpUsuperPK[ peempCodigo=" + peempCodigo + ", xeperCodper=" + xeperCodper + ", xeuxpFecasi=" + xeuxpFecasi + " ]";
    }
    
}
