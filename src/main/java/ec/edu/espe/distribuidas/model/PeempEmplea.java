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
@Table(name = "peemp_emplea")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PeempEmplea.findAll", query = "SELECT p FROM PeempEmplea p")
    , @NamedQuery(name = "PeempEmplea.findByPesexCodigo", query = "SELECT p FROM PeempEmplea p WHERE p.pesexCodigo = :pesexCodigo")
    , @NamedQuery(name = "PeempEmplea.findByPeescCodigo", query = "SELECT p FROM PeempEmplea p WHERE p.peescCodigo = :peescCodigo")
    , @NamedQuery(name = "PeempEmplea.findByPedepCodigo", query = "SELECT p FROM PeempEmplea p WHERE p.pedepCodigo = :pedepCodigo")
    , @NamedQuery(name = "PeempEmplea.findByPecarCodigo", query = "SELECT p FROM PeempEmplea p WHERE p.pecarCodigo = :pecarCodigo")
    , @NamedQuery(name = "PeempEmplea.findByPedirCodigo", query = "SELECT p FROM PeempEmplea p WHERE p.pedirCodigo = :pedirCodigo")
    , @NamedQuery(name = "PeempEmplea.findByPeempApelli", query = "SELECT p FROM PeempEmplea p WHERE p.peempApelli = :peempApelli")
    , @NamedQuery(name = "PeempEmplea.findByPeempNombre", query = "SELECT p FROM PeempEmplea p WHERE p.peempNombre = :peempNombre")
    , @NamedQuery(name = "PeempEmplea.findByPeempCedula", query = "SELECT p FROM PeempEmplea p WHERE p.peempCedula = :peempCedula")
    , @NamedQuery(name = "PeempEmplea.findByPeempPasapo", query = "SELECT p FROM PeempEmplea p WHERE p.peempPasapo = :peempPasapo")
    , @NamedQuery(name = "PeempEmplea.findByPeempRuc", query = "SELECT p FROM PeempEmplea p WHERE p.peempRuc = :peempRuc")
    , @NamedQuery(name = "PeempEmplea.findByPeempFenaci", query = "SELECT p FROM PeempEmplea p WHERE p.peempFenaci = :peempFenaci")
    , @NamedQuery(name = "PeempEmplea.findByPeempFeingr", query = "SELECT p FROM PeempEmplea p WHERE p.peempFeingr = :peempFeingr")
    , @NamedQuery(name = "PeempEmplea.findByPeempFesali", query = "SELECT p FROM PeempEmplea p WHERE p.peempFesali = :peempFesali")
    , @NamedQuery(name = "PeempEmplea.findByPeempDiscapa", query = "SELECT p FROM PeempEmplea p WHERE p.peempDiscapa = :peempDiscapa")
    , @NamedQuery(name = "PeempEmplea.findByPeempCarfam", query = "SELECT p FROM PeempEmplea p WHERE p.peempCarfam = :peempCarfam")
    , @NamedQuery(name = "PeempEmplea.findByPeempCodigo", query = "SELECT p FROM PeempEmplea p WHERE p.peempCodigo = :peempCodigo")
    , @NamedQuery(name = "PeempEmplea.findByPeempTelefo", query = "SELECT p FROM PeempEmplea p WHERE p.peempTelefo = :peempTelefo")
    , @NamedQuery(name = "PeempEmplea.findByPeempEmail", query = "SELECT p FROM PeempEmplea p WHERE p.peempEmail = :peempEmail")
    , @NamedQuery(name = "PeempEmplea.findByPeempEstado", query = "SELECT p FROM PeempEmplea p WHERE p.peempEstado = :peempEstado")})
public class PeempEmplea implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PESEX_CODIGO")
    private Character pesexCodigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PEESC_CODIGO")
    private Character peescCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "PEDEP_CODIGO")
    private String pedepCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "PECAR_CODIGO")
    private String pecarCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "PEDIR_CODIGO")
    private String pedirCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "PEEMP_APELLI")
    private String peempApelli;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "PEEMP_NOMBRE")
    private String peempNombre;
    @Size(max = 10)
    @Column(name = "PEEMP_CEDULA")
    private String peempCedula;
    @Size(max = 20)
    @Column(name = "PEEMP_PASAPO")
    private String peempPasapo;
    @Size(max = 13)
    @Column(name = "PEEMP_RUC")
    private String peempRuc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PEEMP_FENACI")
    @Temporal(TemporalType.DATE)
    private Date peempFenaci;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PEEMP_FEINGR")
    @Temporal(TemporalType.DATE)
    private Date peempFeingr;
    @Column(name = "PEEMP_FESALI")
    @Temporal(TemporalType.DATE)
    private Date peempFesali;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PEEMP_DISCAPA")
    private Character peempDiscapa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PEEMP_CARFAM")
    private short peempCarfam;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "PEEMP_CODIGO")
    private String peempCodigo;
    @Size(max = 15)
    @Column(name = "PEEMP_TELEFO")
    private String peempTelefo;
    @Size(max = 50)
    @Column(name = "PEEMP_EMAIL")
    private String peempEmail;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PEEMP_ESTADO")
    private int peempEstado;

    public PeempEmplea() {
    }

    public PeempEmplea(String peempCodigo) {
        this.peempCodigo = peempCodigo;
    }

    public PeempEmplea(String peempCodigo, Character pesexCodigo, Character peescCodigo, String pedepCodigo, String pecarCodigo, String pedirCodigo, String peempApelli, String peempNombre, Date peempFenaci, Date peempFeingr, Character peempDiscapa, short peempCarfam, int peempEstado) {
        this.peempCodigo = peempCodigo;
        this.pesexCodigo = pesexCodigo;
        this.peescCodigo = peescCodigo;
        this.pedepCodigo = pedepCodigo;
        this.pecarCodigo = pecarCodigo;
        this.pedirCodigo = pedirCodigo;
        this.peempApelli = peempApelli;
        this.peempNombre = peempNombre;
        this.peempFenaci = peempFenaci;
        this.peempFeingr = peempFeingr;
        this.peempDiscapa = peempDiscapa;
        this.peempCarfam = peempCarfam;
        this.peempEstado = peempEstado;
    }

    public Character getPesexCodigo() {
        return pesexCodigo;
    }

    public void setPesexCodigo(Character pesexCodigo) {
        this.pesexCodigo = pesexCodigo;
    }

    public Character getPeescCodigo() {
        return peescCodigo;
    }

    public void setPeescCodigo(Character peescCodigo) {
        this.peescCodigo = peescCodigo;
    }

    public String getPedepCodigo() {
        return pedepCodigo;
    }

    public void setPedepCodigo(String pedepCodigo) {
        this.pedepCodigo = pedepCodigo;
    }

    public String getPecarCodigo() {
        return pecarCodigo;
    }

    public void setPecarCodigo(String pecarCodigo) {
        this.pecarCodigo = pecarCodigo;
    }

    public String getPedirCodigo() {
        return pedirCodigo;
    }

    public void setPedirCodigo(String pedirCodigo) {
        this.pedirCodigo = pedirCodigo;
    }

    public String getPeempApelli() {
        return peempApelli;
    }

    public void setPeempApelli(String peempApelli) {
        this.peempApelli = peempApelli;
    }

    public String getPeempNombre() {
        return peempNombre;
    }

    public void setPeempNombre(String peempNombre) {
        this.peempNombre = peempNombre;
    }

    public String getPeempCedula() {
        return peempCedula;
    }

    public void setPeempCedula(String peempCedula) {
        this.peempCedula = peempCedula;
    }

    public String getPeempPasapo() {
        return peempPasapo;
    }

    public void setPeempPasapo(String peempPasapo) {
        this.peempPasapo = peempPasapo;
    }

    public String getPeempRuc() {
        return peempRuc;
    }

    public void setPeempRuc(String peempRuc) {
        this.peempRuc = peempRuc;
    }

    public Date getPeempFenaci() {
        return peempFenaci;
    }

    public void setPeempFenaci(Date peempFenaci) {
        this.peempFenaci = peempFenaci;
    }

    public Date getPeempFeingr() {
        return peempFeingr;
    }

    public void setPeempFeingr(Date peempFeingr) {
        this.peempFeingr = peempFeingr;
    }

    public Date getPeempFesali() {
        return peempFesali;
    }

    public void setPeempFesali(Date peempFesali) {
        this.peempFesali = peempFesali;
    }

    public Character getPeempDiscapa() {
        return peempDiscapa;
    }

    public void setPeempDiscapa(Character peempDiscapa) {
        this.peempDiscapa = peempDiscapa;
    }

    public short getPeempCarfam() {
        return peempCarfam;
    }

    public void setPeempCarfam(short peempCarfam) {
        this.peempCarfam = peempCarfam;
    }

    public String getPeempCodigo() {
        return peempCodigo;
    }

    public void setPeempCodigo(String peempCodigo) {
        this.peempCodigo = peempCodigo;
    }

    public String getPeempTelefo() {
        return peempTelefo;
    }

    public void setPeempTelefo(String peempTelefo) {
        this.peempTelefo = peempTelefo;
    }

    public String getPeempEmail() {
        return peempEmail;
    }

    public void setPeempEmail(String peempEmail) {
        this.peempEmail = peempEmail;
    }

    public int getPeempEstado() {
        return peempEstado;
    }

    public void setPeempEstado(int peempEstado) {
        this.peempEstado = peempEstado;
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
        if (!(object instanceof PeempEmplea)) {
            return false;
        }
        PeempEmplea other = (PeempEmplea) object;
        if ((this.peempCodigo == null && other.peempCodigo != null) || (this.peempCodigo != null && !this.peempCodigo.equals(other.peempCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.distribuidas.model.PeempEmplea[ peempCodigo=" + peempCodigo + " ]";
    }
    
}
