/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.psp;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
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
import javax.persistence.Transient;

/**
 *
 * @author User
 */
@Entity
@Table(name = "features", catalog = "flowers", schema = "")
@NamedQueries({
    @NamedQuery(name = "Features.findAll", query = "SELECT f FROM Features f"),
    @NamedQuery(name = "Features.findByIdFeature", query = "SELECT f FROM Features f WHERE f.idFeatures = :idFeatures"),
    @NamedQuery(name = "Features.findByColor", query = "SELECT f FROM Features f WHERE f.color = :color"),
    @NamedQuery(name = "Features.findByLifetime", query = "SELECT f FROM Features f WHERE f.lifetime = :lifetime")})
public class Features implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_feature")
    private Integer idFeature;
    @Basic(optional = false)
    @Column(name = "color")
    private String color;
    @Basic(optional = false)
    @Column(name = "lifetime")
    private String lifetime;
   

    public Features() {
    }

    public Features(Integer idFeature) {
        this.idFeature = idFeature;
    }

    public Features(Integer idFeature, String color, String lifetime, int idFlower) {
        this.idFeature = idFeature;
        this.color = color;
        this.lifetime = lifetime;
      
    }

    public Integer getIdFeature() {
        return idFeature;
    }

    public void setIdFeature(Integer idFeature) {
        Integer oldIdFeature = this.idFeature;
        this.idFeature = idFeature;
        changeSupport.firePropertyChange("idFeature", oldIdFeature, idFeature);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        String oldColor = this.color;
        this.color = color;
        changeSupport.firePropertyChange("color", oldColor, color);
    }

    public String getLifetime() {
        return lifetime;
    }

    public void setLifetime(String lifetime) {
        String oldLifetime = this.lifetime;
        this.lifetime = lifetime;
        changeSupport.firePropertyChange("lifetime", oldLifetime, lifetime);
    }

  

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFeature != null ? idFeature.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Features)) {
            return false;
        }
        Features other = (Features) object;
        if ((this.idFeature == null && other.idFeature != null) || (this.idFeature != null && !this.idFeature.equals(other.idFeature))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "by.bsuir.psp.Features[ idFeature=" + idFeature + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
