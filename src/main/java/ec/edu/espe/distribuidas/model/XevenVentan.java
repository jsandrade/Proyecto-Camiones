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
@Table(name = "xeven_ventan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "XevenVentan.findAll", query = "SELECT x FROM XevenVentan x")
    , @NamedQuery(name = "XevenVentan.findByXevenCodven", query = "SELECT x FROM XevenVentan x WHERE x.xevenCodven = :xevenCodven")
    , @NamedQuery(name = "XevenVentan.findByXeopcCodopc", query = "SELECT x FROM XevenVentan x WHERE x.xeopcCodopc = :xeopcCodopc")
    , @NamedQuery(name = "XevenVentan.findByXevenDescri", query = "SELECT x FROM XevenVentan x WHERE x.xevenDescri = :xevenDescri")
    , @NamedQuery(name = "XevenVentan.findByXevenMensaj", query = "SELECT x FROM XevenVentan x WHERE x.xevenMensaj = :xevenMensaj")})
public class XevenVentan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "XEVEN_CODVEN")
    private String xevenCodven;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "XEOPC_CODOPC")
    private String xeopcCodopc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "XEVEN_DESCRI")
    private String xevenDescri;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "XEVEN_MENSAJ")
    private String xevenMensaj;

    public XevenVentan() {
    }

    public XevenVentan(String xevenCodven) {
        this.xevenCodven = xevenCodven;
    }

    public XevenVentan(String xevenCodven, String xeopcCodopc, String xevenDescri, String xevenMensaj) {
        this.xevenCodven = xevenCodven;
        this.xeopcCodopc = xeopcCodopc;
        this.xevenDescri = xevenDescri;
        this.xevenMensaj = xevenMensaj;
    }

    public String getXevenCodven() {
        return xevenCodven;
    }

    public void setXevenCodven(String xevenCodven) {
        this.xevenCodven = xevenCodven;
    }

    public String getXeopcCodopc() {
        return xeopcCodopc;
    }

    public void setXeopcCodopc(String xeopcCodopc) {
        this.xeopcCodopc = xeopcCodopc;
    }

    public String getXevenDescri() {
        return xevenDescri;
    }

    public void setXevenDescri(String xevenDescri) {
        this.xevenDescri = xevenDescri;
    }

    public String getXevenMensaj() {
        return xevenMensaj;
    }

    public void setXevenMensaj(String xevenMensaj) {
        this.xevenMensaj = xevenMensaj;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (xevenCodven != null ? xevenCodven.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof XevenVentan)) {
            return false;
        }
        XevenVentan other = (XevenVentan) object;
        if ((this.xevenCodven == null && other.xevenCodven != null) || (this.xevenCodven != null && !this.xevenCodven.equals(other.xevenCodven))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.distribuidas.model.XevenVentan[ xevenCodven=" + xevenCodven + " ]";
    }
    
}
