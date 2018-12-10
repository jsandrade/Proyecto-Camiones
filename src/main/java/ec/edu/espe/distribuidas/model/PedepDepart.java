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
@Table(name = "pedep_depart")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PedepDepart.findAll", query = "SELECT p FROM PedepDepart p")
    , @NamedQuery(name = "PedepDepart.findByPedepCodigo", query = "SELECT p FROM PedepDepart p WHERE p.pedepCodigo = :pedepCodigo")
    , @NamedQuery(name = "PedepDepart.findByPedepDescri", query = "SELECT p FROM PedepDepart p WHERE p.pedepDescri = :pedepDescri")
    , @NamedQuery(name = "PedepDepart.findByPedepEstado", query = "SELECT p FROM PedepDepart p WHERE p.pedepEstado = :pedepEstado")})
public class PedepDepart implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "PEDEP_CODIGO")
    private String pedepCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "PEDEP_DESCRI")
    private String pedepDescri;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PEDEP_ESTADO")
    private int pedepEstado;

    public PedepDepart() {
    }

    public PedepDepart(String pedepCodigo) {
        this.pedepCodigo = pedepCodigo;
    }

    public PedepDepart(String pedepCodigo, String pedepDescri, int pedepEstado) {
        this.pedepCodigo = pedepCodigo;
        this.pedepDescri = pedepDescri;
        this.pedepEstado = pedepEstado;
    }

    public String getPedepCodigo() {
        return pedepCodigo;
    }

    public void setPedepCodigo(String pedepCodigo) {
        this.pedepCodigo = pedepCodigo;
    }

    public String getPedepDescri() {
        return pedepDescri;
    }

    public void setPedepDescri(String pedepDescri) {
        this.pedepDescri = pedepDescri;
    }

    public int getPedepEstado() {
        return pedepEstado;
    }

    public void setPedepEstado(int pedepEstado) {
        this.pedepEstado = pedepEstado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pedepCodigo != null ? pedepCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PedepDepart)) {
            return false;
        }
        PedepDepart other = (PedepDepart) object;
        if ((this.pedepCodigo == null && other.pedepCodigo != null) || (this.pedepCodigo != null && !this.pedepCodigo.equals(other.pedepCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.distribuidas.model.PedepDepart[ pedepCodigo=" + pedepCodigo + " ]";
    }
    
}
