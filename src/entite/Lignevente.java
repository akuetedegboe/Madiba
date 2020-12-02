/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author yvesdegboe
 */
@Entity
@Table(name = "lignevente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lignevente.findAll", query = "SELECT l FROM Lignevente l"),
    @NamedQuery(name = "Lignevente.findById", query = "SELECT l FROM Lignevente l WHERE l.id = :id"),
    @NamedQuery(name = "Lignevente.findByQte", query = "SELECT l FROM Lignevente l WHERE l.qte = :qte"),
    @NamedQuery(name = "Lignevente.findByPrixtotal", query = "SELECT l FROM Lignevente l WHERE l.prixtotal = :prixtotal")})
public class Lignevente extends Entitie implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "qte")
    private Double qte;
    @Column(name = "prixtotal")
    private Double prixtotal;
    @JoinColumn(name = "article_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Article articleId;
    @JoinColumn(name = "vente_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Vente venteId;

    public Lignevente() {
    }

    public Lignevente(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getQte() {
        return qte;
    }

    public void setQte(Double qte) {
        this.qte = qte;
    }

    public Double getPrixtotal() {
        return prixtotal;
    }

    public void setPrixtotal(Double prixtotal) {
        this.prixtotal = prixtotal;
    }

    public Article getArticleId() {
        return articleId;
    }

    public void setArticleId(Article articleId) {
        this.articleId = articleId;
    }

    public Vente getVenteId() {
        return venteId;
    }

    public void setVenteId(Vente venteId) {
        this.venteId = venteId;
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
        if (!(object instanceof Lignevente)) {
            return false;
        }
        Lignevente other = (Lignevente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entite.Lignevente[ id=" + id + " ]";
    }
    
}
