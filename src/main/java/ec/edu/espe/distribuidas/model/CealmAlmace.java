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
@Table(name = "cealm_almace")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CealmAlmace.findAll", query = "SELECT c FROM CealmAlmace c")
    , @NamedQuery(name = "CealmAlmace.findByCealmId", query = "SELECT c FROM CealmAlmace c WHERE c.cealmId = :cealmId")
    , @NamedQuery(name = "CealmAlmace.findByPedirCodigo", query = "SELECT c FROM CealmAlmace c WHERE c.pedirCodigo = :pedirCodigo")
    , @NamedQuery(name = "CealmAlmace.findByCealmTelefo", query = "SELECT c FROM CealmAlmace c WHERE c.cealmTelefo = :cealmTelefo")
    , @NamedQuery(name = "CealmAlmace.findByCealmEstado", query = "SELECT c FROM CealmAlmace c WHERE c.cealmEstado = :cealmEstado")})
public class CealmAlmace implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CEALM_ID")
    private Integer cealmId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "PEDIR_CODIGO")
    private String pedirCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "CEALM_TELEFO")
    private String cealmTelefo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CEALM_ESTADO")
    private int cealmEstado;

    public CealmAlmace() {
    }

    public CealmAlmace(Integer cealmId) {
        this.cealmId = cealmId;
    }

    public CealmAlmace(Integer cealmId, String pedirCodigo, String cealmTelefo, int cealmEstado) {
        this.cealmId = cealmId;
        this.pedirCodigo = pedirCodigo;
        this.cealmTelefo = cealmTelefo;
        this.cealmEstado = cealmEstado;
    }

    public Integer getCealmId() {
        return cealmId;
    }

    public void setCealmId(Integer cealmId) {
        this.cealmId = cealmId;
    }

    public String getPedirCodigo() {
        return pedirCodigo;
    }

    public void setPedirCodigo(String pedirCodigo) {
        this.pedirCodigo = pedirCodigo;
    }

    public String getCealmTelefo() {
        return cealmTelefo;
    }

    public void setCealmTelefo(String cealmTelefo) {
        this.cealmTelefo = cealmTelefo;
    }

    public int getCealmEstado() {
        return cealmEstado;
    }

    public void setCealmEstado(int cealmEstado) {
        this.cealmEstado = cealmEstado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cealmId != null ? cealmId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CealmAlmace)) {
            return false;
        }
        CealmAlmace other = (CealmAlmace) object;
        if ((this.cealmId == null && other.cealmId != null) || (this.cealmId != null && !this.cealmId.equals(other.cealmId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.distribuidas.model.CealmAlmace[ cealmId=" + cealmId + " ]";
    }
    
}
