package by.bsuir.pavlukovskaya.database.model;

import java.io.Serializable;
import java.util.Objects;

public class Seller extends DataBaseObject implements Serializable {
    
    private String seller_name;
    private String info;
    
    public Seller(){}
    
    public Seller(int id){
        this.setId(id);
    }

    /**
     * @return the seller_name
     */
    public String getSeller_name() {
        return seller_name;
    }

    /**
     * @param seller_name the seller_name to set
     */
    public void setSeller_name(String seller_name) {
        this.seller_name = seller_name;
    }

    /**
     * @return the info
     */
    public String getInfo() {
        return info;
    }

    /**
     * @param info the info to set
     */
    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.getId();
        hash = 41 * hash + Objects.hashCode(this.seller_name);
        hash = 41 * hash + Objects.hashCode(this.info);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Seller other = (Seller) obj;
        if (this.getId() != other.getId()) {
            return false;
        }
        if (!Objects.equals(this.seller_name, other.seller_name)) {
            return false;
        }
        if (!Objects.equals(this.info, other.info)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Seller{" +"id_seller=" + getId() + ", seller_name=" + seller_name + ", info=" + info + '}';
    }
    
}
