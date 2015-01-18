package by.bsuir.pavlukovskaya.logic;

import by.bsuir.pavlukovskaya.database.model.OtherGoods;
import java.io.Serializable;
import java.util.List;

public interface AddLogicGoods extends Serializable{
    
     public String getSellerName(int id);
    
     public List getAllSellers();
     
     public void saveGoods(OtherGoods goods);
     
     public int getSellerId(String name);
}
