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
@Table(name = "xerol_rol")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "XerolRol.findAll", query = "SELECT x FROM XerolRol x")
    , @NamedQuery(name = "XerolRol.findByXeperCodper", query = "SELECT x FROM XerolRol x WHERE x.xeperCodper = :xeperCodper")
    , @NamedQuery(name = "XerolRol.findByXerolInserc", query = "SELECT x FROM XerolRol x WHERE x.xerolInserc = :xerolInserc")
    , @NamedQuery(name = "XerolRol.findByXerolActual", query = "SELECT x FROM XerolRol x WHERE x.xerolActual = :xerolActual")
    , @NamedQuery(name = "XerolRol.findByXerolElimin", query = "SELECT x FROM XerolRol x WHERE x.xerolElimin = :xerolElimin")
    , @NamedQuery(name = "XerolRol.findByXerolConsul", query = "SELECT x FROM XerolRol x WHERE x.xerolConsul = :xerolConsul")})
public class XerolRol implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "XEPER_CODPER")
    private String xeperCodper;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "XEROL_INSERC")
    private String xerolInserc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "XEROL_ACTUAL")
    private String xerolActual;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "XEROL_ELIMIN")
    private String xerolElimin;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "XEROL_CONSUL")
    private String xerolConsul;

    public XerolRol() {
    }

    public XerolRol(String xeperCodper) {
        this.xeperCodper = xeperCodper;
    }

    public XerolRol(String xeperCodper, String xerolInserc, String xerolActual, String xerolElimin, String xerolConsul) {
        this.xeperCodper = xeperCodper;
        this.xerolInserc = xerolInserc;
        this.xerolActual = xerolActual;
        this.xerolElimin = xerolElimin;
        this.xerolConsul = xerolConsul;
    }

    public String getXeperCodper() {
        return xeperCodper;
    }

    public void setXeperCodper(String xeperCodper) {
        this.xeperCodper = xeperCodper;
    }

    public String getXerolInserc() {
        return xerolInserc;
    }

    public void setXerolInserc(String xerolInserc) {
        this.xerolInserc = xerolInserc;
    }

    public String getXerolActual() {
        return xerolActual;
    }

    public void setXerolActual(String xerolActual) {
        this.xerolActual = xerolActual;
    }

    public String getXerolElimin() {
        return xerolElimin;
    }

    public void setXerolElimin(String xerolElimin) {
        this.xerolElimin = xerolElimin;
    }

    public String getXerolConsul() {
        return xerolConsul;
    }

    public void setXerolConsul(String xerolConsul) {
        this.xerolConsul = xerolConsul;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (xeperCodper != null ? xeperCodper.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof XerolRol)) {
            return false;
        }
        XerolRol other = (XerolRol) object;
        if ((this.xeperCodper == null && other.xeperCodper != null) || (this.xeperCodper != null && !this.xeperCodper.equals(other.xeperCodper))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.distribuidas.model.XerolRol[ xeperCodper=" + xeperCodper + " ]";
    }
    
}
