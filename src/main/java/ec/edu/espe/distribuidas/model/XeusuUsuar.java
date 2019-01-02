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
@Table(name = "xeusu_usuar")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "XeusuUsuar.findAll", query = "SELECT x FROM XeusuUsuar x")
    , @NamedQuery(name = "XeusuUsuar.findByPeempCodigo", query = "SELECT x FROM XeusuUsuar x WHERE x.peempCodigo = :peempCodigo")
    , @NamedQuery(name = "XeusuUsuar.findByXeestCodigo", query = "SELECT x FROM XeusuUsuar x WHERE x.xeestCodigo = :xeestCodigo")
    , @NamedQuery(name = "XeusuUsuar.findByXeusuPasswo", query = "SELECT x FROM XeusuUsuar x WHERE x.xeusuPasswo = :xeusuPasswo")
    , @NamedQuery(name = "XeusuUsuar.findByXeusuPfirm", query = "SELECT x FROM XeusuUsuar x WHERE x.xeusuPfirm = :xeusuPfirm")
    , @NamedQuery(name = "XeusuUsuar.findByXeusuFeccrea", query = "SELECT x FROM XeusuUsuar x WHERE x.xeusuFeccrea = :xeusuFeccrea")
    , @NamedQuery(name = "XeusuUsuar.findByXeusuFucamb", query = "SELECT x FROM XeusuUsuar x WHERE x.xeusuFucamb = :xeusuFucamb")})
public class XeusuUsuar implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "PEEMP_CODIGO")
    private String peempCodigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "XEEST_CODIGO")
    private Character xeestCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "XEUSU_PASSWO")
    private String xeusuPasswo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "XEUSU_PFIRM")
    private String xeusuPfirm;
    @Basic(optional = false)
    @NotNull
    @Column(name = "XEUSU_FECCREA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date xeusuFeccrea;
    @Basic(optional = false)
    @NotNull
    @Column(name = "XEUSU_FUCAMB")
    @Temporal(TemporalType.TIMESTAMP)
    private Date xeusuFucamb;

    public XeusuUsuar() {
    }

    public XeusuUsuar(String peempCodigo) {
        this.peempCodigo = peempCodigo;
    }

    public XeusuUsuar(String peempCodigo, Character xeestCodigo, String xeusuPasswo, String xeusuPfirm, Date xeusuFeccrea, Date xeusuFucamb) {
        this.peempCodigo = peempCodigo;
        this.xeestCodigo = xeestCodigo;
        this.xeusuPasswo = xeusuPasswo;
        this.xeusuPfirm = xeusuPfirm;
        this.xeusuFeccrea = xeusuFeccrea;
        this.xeusuFucamb = xeusuFucamb;
    }

    public String getPeempCodigo() {
        return peempCodigo;
    }

    public void setPeempCodigo(String peempCodigo) {
        this.peempCodigo = peempCodigo;
    }

    public Character getXeestCodigo() {
        return xeestCodigo;
    }

    public void setXeestCodigo(Character xeestCodigo) {
        this.xeestCodigo = xeestCodigo;
    }

    public String getXeusuPasswo() {
        return xeusuPasswo;
    }

    public void setXeusuPasswo(String xeusuPasswo) {
        this.xeusuPasswo = xeusuPasswo;
    }

    public String getXeusuPfirm() {
        return xeusuPfirm;
    }

    public void setXeusuPfirm(String xeusuPfirm) {
        this.xeusuPfirm = xeusuPfirm;
    }

    public Date getXeusuFeccrea() {
        return xeusuFeccrea;
    }

    public void setXeusuFeccrea(Date xeusuFeccrea) {
        this.xeusuFeccrea = xeusuFeccrea;
    }

    public Date getXeusuFucamb() {
        return xeusuFucamb;
    }

    public void setXeusuFucamb(Date xeusuFucamb) {
        this.xeusuFucamb = xeusuFucamb;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (peempCodigo != null ? peempCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof XeusuUsuar)) {
            return false;
        }
        XeusuUsuar other = (XeusuUsuar) object;
        if ((this.peempCodigo == null && other.peempCodigo != null) || (this.peempCodigo != null && !this.peempCodigo.equals(other.peempCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.distribuidas.model.XeusuUsuar[ peempCodigo=" + peempCodigo + " ]";
    }
    
}
