/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author yvesdegboe
 */
@Entity
@Table(name = "vente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vente.findAll", query = "SELECT v FROM Vente v"),
    @NamedQuery(name = "Vente.findById", query = "SELECT v FROM Vente v WHERE v.id = :id"),
    @NamedQuery(name = "Vente.findByDatevente", query = "SELECT v FROM Vente v WHERE v.datevente = :datevente"),
    @NamedQuery(name = "Vente.findByTotalvente", query = "SELECT v FROM Vente v WHERE v.totalvente = :totalvente")})
public class Vente extends Entitie implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "datevente")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datevente;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "totalvente")
    private Double totalvente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "venteId")
    private Collection<Lignevente> ligneventeCollection;
    @JoinColumn(name = "utiilisateur_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Utilisateur utiilisateurId;

    public Vente() {
    }

    public Vente(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDatevente() {
        return datevente;
    }

    public void setDatevente(Date datevente) {
        this.datevente = datevente;
    }

    public Double getTotalvente() {
        return totalvente;
    }

    public void setTotalvente(Double totalvente) {
        this.totalvente = totalvente;
    }

    @XmlTransient
    public Collection<Lignevente> getLigneventeCollection() {
        return ligneventeCollection;
    }

    public void setLigneventeCollection(Collection<Lignevente> ligneventeCollection) {
        this.ligneventeCollection = ligneventeCollection;
    }

    public Utilisateur getUtiilisateurId() {
        return utiilisateurId;
    }

    public void setUtiilisateurId(Utilisateur utiilisateurId) {
        this.utiilisateurId = utiilisateurId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vente)) {
            return false;
        }
        Vente other = (Vente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Vente du "+toDate();
    }
    public String toDate() {
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");  
        return df.format(datevente);
    }
}
