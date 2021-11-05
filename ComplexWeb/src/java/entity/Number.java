/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author evilmonkey19
 */
@Entity
@Table(name = "number")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Number.findAll", query = "SELECT n FROM Number n"),
    @NamedQuery(name = "Number.findById", query = "SELECT n FROM Number n WHERE n.id = :id"),
    @NamedQuery(name = "Number.findByRealN", query = "SELECT n FROM Number n WHERE n.realN = :realN"),
    @NamedQuery(name = "Number.findByImagN", query = "SELECT n FROM Number n WHERE n.imagN = :imagN")})
public class Number implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "real_n")
    private String realN;
    @Size(max = 45)
    @Column(name = "imag_n")
    private String imagN;

    public Number() {
    }

    public Number(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRealN() {
        return realN;
    }

    public void setRealN(String realN) {
        this.realN = realN;
    }

    public String getImagN() {
        return imagN;
    }

    public void setImagN(String imagN) {
        this.imagN = imagN;
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
        if (!(object instanceof Number)) {
            return false;
        }
        Number other = (Number) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Number[ id=" + id + " ]";
    }
    
}
