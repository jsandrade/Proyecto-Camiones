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
@Table(name = "cetie_tienda")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CetieTienda.findAll", query = "SELECT c FROM CetieTienda c")
    , @NamedQuery(name = "CetieTienda.findByCetieId", query = "SELECT c FROM CetieTienda c WHERE c.cetieId = :cetieId")
    , @NamedQuery(name = "CetieTienda.findByPedirCodigo", query = "SELECT c FROM CetieTienda c WHERE c.pedirCodigo = :pedirCodigo")
    , @NamedQuery(name = "CetieTienda.findByCetieNombre", query = "SELECT c FROM CetieTienda c WHERE c.cetieNombre = :cetieNombre")
    , @NamedQuery(name = "CetieTienda.findByCetieTelefo", query = "SELECT c FROM CetieTienda c WHERE c.cetieTelefo = :cetieTelefo")
    , @NamedQuery(name = "CetieTienda.findByCetieEstado", query = "SELECT c FROM CetieTienda c WHERE c.cetieEstado = :cetieEstado")})
public class CetieTienda implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CETIE_ID")
    private Integer cetieId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "PEDIR_CODIGO")
    private String pedirCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "CETIE_NOMBRE")
    private String cetieNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "CETIE_TELEFO")
    private String cetieTelefo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CETIE_ESTADO")
    private int cetieEstado;

    public CetieTienda() {
    }

    public CetieTienda(Integer cetieId) {
        this.cetieId = cetieId;
    }

    public CetieTienda(Integer cetieId, String pedirCodigo, String cetieNombre, String cetieTelefo, int cetieEstado) {
        this.cetieId = cetieId;
        this.pedirCodigo = pedirCodigo;
        this.cetieNombre = cetieNombre;
        this.cetieTelefo = cetieTelefo;
        this.cetieEstado = cetieEstado;
    }

    public Integer getCetieId() {
        return cetieId;
    }

    public void setCetieId(Integer cetieId) {
        this.cetieId = cetieId;
    }

    public String getPedirCodigo() {
        return pedirCodigo;
    }

    public void setPedirCodigo(String pedirCodigo) {
        this.pedirCodigo = pedirCodigo;
    }

    public String getCetieNombre() {
        return cetieNombre;
    }

    public void setCetieNombre(String cetieNombre) {
        this.cetieNombre = cetieNombre;
    }

    public String getCetieTelefo() {
        return cetieTelefo;
    }

    public void setCetieTelefo(String cetieTelefo) {
        this.cetieTelefo = cetieTelefo;
    }

    public int getCetieEstado() {
        return cetieEstado;
    }

    public void setCetieEstado(int cetieEstado) {
        this.cetieEstado = cetieEstado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cetieId != null ? cetieId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CetieTienda)) {
            return false;
        }
        CetieTienda other = (CetieTienda) object;
        if ((this.cetieId == null && other.cetieId != null) || (this.cetieId != null && !this.cetieId.equals(other.cetieId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.distribuidas.model.CetieTienda[ cetieId=" + cetieId + " ]";
    }
    
}
