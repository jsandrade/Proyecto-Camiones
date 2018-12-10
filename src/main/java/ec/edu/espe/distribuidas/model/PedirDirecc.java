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
@Table(name = "pedir_direcc")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PedirDirecc.findAll", query = "SELECT p FROM PedirDirecc p")
    , @NamedQuery(name = "PedirDirecc.findByPedirCodigo", query = "SELECT p FROM PedirDirecc p WHERE p.pedirCodigo = :pedirCodigo")
    , @NamedQuery(name = "PedirDirecc.findByPepaiCodigo", query = "SELECT p FROM PedirDirecc p WHERE p.pepaiCodigo = :pepaiCodigo")
    , @NamedQuery(name = "PedirDirecc.findByPeprvCodigo", query = "SELECT p FROM PedirDirecc p WHERE p.peprvCodigo = :peprvCodigo")
    , @NamedQuery(name = "PedirDirecc.findByPecanCodigo", query = "SELECT p FROM PedirDirecc p WHERE p.pecanCodigo = :pecanCodigo")
    , @NamedQuery(name = "PedirDirecc.findByPeprqCodigo", query = "SELECT p FROM PedirDirecc p WHERE p.peprqCodigo = :peprqCodigo")
    , @NamedQuery(name = "PedirDirecc.findByPedirCllpri", query = "SELECT p FROM PedirDirecc p WHERE p.pedirCllpri = :pedirCllpri")
    , @NamedQuery(name = "PedirDirecc.findByPedirCllsec", query = "SELECT p FROM PedirDirecc p WHERE p.pedirCllsec = :pedirCllsec")
    , @NamedQuery(name = "PedirDirecc.findByPedirDescri", query = "SELECT p FROM PedirDirecc p WHERE p.pedirDescri = :pedirDescri")})
public class PedirDirecc implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "PEDIR_CODIGO")
    private String pedirCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "PEPAI_CODIGO")
    private String pepaiCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "PEPRV_CODIGO")
    private String peprvCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "PECAN_CODIGO")
    private String pecanCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "PEPRQ_CODIGO")
    private String peprqCodigo;
    @Size(max = 50)
    @Column(name = "PEDIR_CLLPRI")
    private String pedirCllpri;
    @Size(max = 50)
    @Column(name = "PEDIR_CLLSEC")
    private String pedirCllsec;
    @Size(max = 100)
    @Column(name = "PEDIR_DESCRI")
    private String pedirDescri;

    public PedirDirecc() {
    }

    public PedirDirecc(String pedirCodigo) {
        this.pedirCodigo = pedirCodigo;
    }

    public PedirDirecc(String pedirCodigo, String pepaiCodigo, String peprvCodigo, String pecanCodigo, String peprqCodigo) {
        this.pedirCodigo = pedirCodigo;
        this.pepaiCodigo = pepaiCodigo;
        this.peprvCodigo = peprvCodigo;
        this.pecanCodigo = pecanCodigo;
        this.peprqCodigo = peprqCodigo;
    }

    public String getPedirCodigo() {
        return pedirCodigo;
    }

    public void setPedirCodigo(String pedirCodigo) {
        this.pedirCodigo = pedirCodigo;
    }

    public String getPepaiCodigo() {
        return pepaiCodigo;
    }

    public void setPepaiCodigo(String pepaiCodigo) {
        this.pepaiCodigo = pepaiCodigo;
    }

    public String getPeprvCodigo() {
        return peprvCodigo;
    }

    public void setPeprvCodigo(String peprvCodigo) {
        this.peprvCodigo = peprvCodigo;
    }

    public String getPecanCodigo() {
        return pecanCodigo;
    }

    public void setPecanCodigo(String pecanCodigo) {
        this.pecanCodigo = pecanCodigo;
    }

    public String getPeprqCodigo() {
        return peprqCodigo;
    }

    public void setPeprqCodigo(String peprqCodigo) {
        this.peprqCodigo = peprqCodigo;
    }

    public String getPedirCllpri() {
        return pedirCllpri;
    }

    public void setPedirCllpri(String pedirCllpri) {
        this.pedirCllpri = pedirCllpri;
    }

    public String getPedirCllsec() {
        return pedirCllsec;
    }

    public void setPedirCllsec(String pedirCllsec) {
        this.pedirCllsec = pedirCllsec;
    }

    public String getPedirDescri() {
        return pedirDescri;
    }

    public void setPedirDescri(String pedirDescri) {
        this.pedirDescri = pedirDescri;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pedirCodigo != null ? pedirCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PedirDirecc)) {
            return false;
        }
        PedirDirecc other = (PedirDirecc) object;
        if ((this.pedirCodigo == null && other.pedirCodigo != null) || (this.pedirCodigo != null && !this.pedirCodigo.equals(other.pedirCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.distribuidas.model.PedirDirecc[ pedirCodigo=" + pedirCodigo + " ]";
    }
    
}
