
package by.bsuir.pavlukovskaya.database.model;

import java.io.Serializable;
import java.util.Objects;

public class Flowers extends DataBaseObject implements Serializable{
    
    private int id_flower;
    private String flower_name;
    private int lifetime;
    private float price;
    private int amount;
    private int id_seller;
    
    public Flowers(){}
    
    public Flowers(int id) {
        this.setId(id);
    }
 
    public int getId_flower() {
        return id_flower;
    }
  
    public void setId_flower(int id_flower) {
        this.id_flower = id_flower;
    }

    public String getFlower_name() {
        return flower_name;
    }
    
    public void setFlower_name(String flower_name) {
        this.flower_name = flower_name;
    }

    public int getLifetime() {
        return lifetime;
    }

    public void setLifetime(int lifetime) {
        this.lifetime = lifetime;
    }

    public float getPrice() {
        return price;
    }
    
    public void setPrice(int price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getId_seller() {
        return id_seller;
    }

    public void setId_seller(int id_seller) {
        this.id_seller = id_seller;
    }

 
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + this.getId();
        hash = 53 * hash + this.id_flower;
        hash = 53 * hash + Objects.hashCode(this.flower_name);
        hash = 53 * hash + this.lifetime;
        hash = 53 * hash + Float.floatToIntBits(this.price);
        hash = 53 * hash + this.amount;
        hash = 53 * hash + this.id_seller;
        return hash;
    }

    @Override
    public String toString() {
       return "Flower{" + "id_flower=" + getId() + ", flower_name=" + flower_name + ", lifetime=" + lifetime + ", price=" + price + ", amount=" + amount + ", id_seller=" + id_seller + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Flowers other = (Flowers) obj;
        if (this.getId() != other.getId()) {
            return false;
        }
        if (!Objects.equals(this.flower_name, other.flower_name)) {
            return false;
        }
        if (this.lifetime != other.lifetime) {
            return false;
        }
        if (Float.floatToIntBits(this.price) != Float.floatToIntBits(other.price)) {
            return false;
        }
        if (this.amount != other.amount) {
            return false;
        }
        if (this.id_seller != other.id_seller) {
            return false;
        }
        return true;
    }
    
    
}
