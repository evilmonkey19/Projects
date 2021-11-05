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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author evilmonkey19
 */
@Entity
@Table(name = "Incidencies")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Incidencies.findAll", query = "SELECT i FROM Incidencies i"),
    @NamedQuery(name = "Incidencies.findById", query = "SELECT i FROM Incidencies i WHERE i.id = :id"),
    @NamedQuery(name = "Incidencies.findByCentre", query = "SELECT i FROM Incidencies i WHERE i.centre = :centre"),
    @NamedQuery(name = "Incidencies.findByCarrer", query = "SELECT i FROM Incidencies i WHERE i.carrer = :carrer"),
    @NamedQuery(name = "Incidencies.findByCausa", query = "SELECT i FROM Incidencies i WHERE i.causa = :causa"),
    @NamedQuery(name = "Incidencies.findByRelevancia", query = "SELECT i FROM Incidencies i WHERE i.relevancia = :relevancia")})
public class Incidencies implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Centre")
    private String centre;
    @Size(max = 45)
    @Column(name = "Carrer")
    private String carrer;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Causa")
    private String causa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Relevancia")
    private String relevancia;

    public Incidencies() {
    }

    public Incidencies(Integer id) {
        this.id = id;
    }

    public Incidencies(Integer id, String centre, String causa, String relevancia) {
        this.id = id;
        this.centre = centre;
        this.causa = causa;
        this.relevancia = relevancia;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCentre() {
        return centre;
    }

    public void setCentre(String centre) {
        this.centre = centre;
    }

    public String getCarrer() {
        return carrer;
    }

    public void setCarrer(String carrer) {
        this.carrer = carrer;
    }

    public String getCausa() {
        return causa;
    }

    public void setCausa(String causa) {
        this.causa = causa;
    }

    public String getRelevancia() {
        return relevancia;
    }

    public void setRelevancia(String relevancia) {
        this.relevancia = relevancia;
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
        if (!(object instanceof Incidencies)) {
            return false;
        }
        Incidencies other = (Incidencies) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Incidencies[ id=" + id + " ]";
    }
    
}
