
package by.bsuir.pavlukovskaya.database.model;


import java.io.Serializable;
import java.util.Objects;

public class OtherGoods extends DataBaseObject implements Serializable{
    
    private int id_goods;
    private String goods_name;
    private float price;
    private int amount;
    private int id_seller;
    
     public OtherGoods(){}
    
    public OtherGoods(int id) {
        this.setId(id);
    }

    
    public int getId_goods() {
        return id_goods;
    }

    
    public void setId_goods(int id_goods) {
        this.id_goods = id_goods;
    }

    

   
    public String getGoods_name() {
        return goods_name;
    }

   
    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }

   
    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
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
        hash = 73 * hash + this.getId();
        hash = 73 * hash + this.id_goods;
        hash = 73 * hash + Objects.hashCode(this.goods_name);
        hash = 73 * hash + Float.floatToIntBits(this.price);
        hash = 73 * hash + this.amount;
        hash = 73 * hash + this.id_seller;
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
        final OtherGoods other = (OtherGoods) obj;
        if (this.getId() != other.getId()) {
            return false;
        }
        if (!Objects.equals(this.goods_name, other.goods_name)) {
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

    @Override
    public String toString() {
        return "OtherGoods{" + "id_goods=" + getId() + ", goods_name=" + goods_name + ", price=" + price + ", amount=" + amount + ", id_seller=" + id_seller + '}';
    }
   
 
    
    
}
