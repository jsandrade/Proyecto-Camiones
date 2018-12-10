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
@Table(name = "xeopc_opcion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "XeopcOpcion.findAll", query = "SELECT x FROM XeopcOpcion x")
    , @NamedQuery(name = "XeopcOpcion.findByXeopcCodopc", query = "SELECT x FROM XeopcOpcion x WHERE x.xeopcCodopc = :xeopcCodopc")
    , @NamedQuery(name = "XeopcOpcion.findByXesisCodsis", query = "SELECT x FROM XeopcOpcion x WHERE x.xesisCodsis = :xesisCodsis")
    , @NamedQuery(name = "XeopcOpcion.findByXeopcDescri", query = "SELECT x FROM XeopcOpcion x WHERE x.xeopcDescri = :xeopcDescri")})
public class XeopcOpcion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "XEOPC_CODOPC")
    private String xeopcCodopc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "XESIS_CODSIS")
    private String xesisCodsis;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "XEOPC_DESCRI")
    private String xeopcDescri;

    public XeopcOpcion() {
    }

    public XeopcOpcion(String xeopcCodopc) {
        this.xeopcCodopc = xeopcCodopc;
    }

    public XeopcOpcion(String xeopcCodopc, String xesisCodsis, String xeopcDescri) {
        this.xeopcCodopc = xeopcCodopc;
        this.xesisCodsis = xesisCodsis;
        this.xeopcDescri = xeopcDescri;
    }

    public String getXeopcCodopc() {
        return xeopcCodopc;
    }

    public void setXeopcCodopc(String xeopcCodopc) {
        this.xeopcCodopc = xeopcCodopc;
    }

    public String getXesisCodsis() {
        return xesisCodsis;
    }

    public void setXesisCodsis(String xesisCodsis) {
        this.xesisCodsis = xesisCodsis;
    }

    public String getXeopcDescri() {
        return xeopcDescri;
    }

    public void setXeopcDescri(String xeopcDescri) {
        this.xeopcDescri = xeopcDescri;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (xeopcCodopc != null ? xeopcCodopc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof XeopcOpcion)) {
            return false;
        }
        XeopcOpcion other = (XeopcOpcion) object;
        if ((this.xeopcCodopc == null && other.xeopcCodopc != null) || (this.xeopcCodopc != null && !this.xeopcCodopc.equals(other.xeopcCodopc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.distribuidas.model.XeopcOpcion[ xeopcCodopc=" + xeopcCodopc + " ]";
    }
    
}
