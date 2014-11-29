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
@Table(name = "flower", catalog = "magazinflowers", schema = "")
@NamedQueries({
    @NamedQuery(name = "Flower.findAll", query = "SELECT f FROM Flower f"),
    @NamedQuery(name = "Flower.findByIdFlower", query = "SELECT f FROM Flower f WHERE f.idFlower = :idFlower"),
    @NamedQuery(name = "Flower.findByName", query = "SELECT f FROM Flower f WHERE f.name = :name"),
    @NamedQuery(name = "Flower.findByVarieties", query = "SELECT f FROM Flower f WHERE f.varieties = :varieties"),
    @NamedQuery(name = "Flower.findByIdFeatures", query = "SELECT f FROM Flower f WHERE f.idFeatures = :idFeatures")})
public class Flower implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_flower")
    private Integer idFlower;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "varieties")
    private String varieties;
    @Basic(optional = false)
    @Column(name = "id_features")
    private int idFeatures;

    public Flower() {
    }

    public Flower(Integer idFlower) {
        this.idFlower = idFlower;
    }

    public Flower(Integer idFlower, String name, String varieties, int idFeatures) {
        this.idFlower = idFlower;
        this.name = name;
        this.varieties = varieties;
        this.idFeatures = idFeatures;
    }

    public Integer getIdFlower() {
        return idFlower;
    }

    public void setIdFlower(Integer idFlower) {
        Integer oldIdFlower = this.idFlower;
        this.idFlower = idFlower;
        changeSupport.firePropertyChange("idFlower", oldIdFlower, idFlower);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        String oldName = this.name;
        this.name = name;
        changeSupport.firePropertyChange("name", oldName, name);
    }

    public String getVarieties() {
        return varieties;
    }

    public void setVarieties(String varieties) {
        String oldVarieties = this.varieties;
        this.varieties = varieties;
        changeSupport.firePropertyChange("varieties", oldVarieties, varieties);
    }

    public int getIdFeatures() {
        return idFeatures;
    }

    public void setIdFeatures(int idFeatures) {
        int oldIdFeatures = this.idFeatures;
        this.idFeatures = idFeatures;
        changeSupport.firePropertyChange("idFeatures", oldIdFeatures, idFeatures);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFlower != null ? idFlower.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Flower)) {
            return false;
        }
        Flower other = (Flower) object;
        if ((this.idFlower == null && other.idFlower != null) || (this.idFlower != null && !this.idFlower.equals(other.idFlower))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "by.bsuir.psp.Flower[ idFlower=" + idFlower + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
