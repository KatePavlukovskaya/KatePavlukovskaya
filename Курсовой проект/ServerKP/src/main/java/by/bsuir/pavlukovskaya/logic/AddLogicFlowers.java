package by.bsuir.pavlukovskaya.logic;

import by.bsuir.pavlukovskaya.database.model.Flowers;
import java.io.Serializable;
import java.util.List;

public interface AddLogicFlowers extends Serializable{
    
     public String getSellerName(int id);
    
     public List getAllSellers();
     
     public void saveFlower(Flowers flower);
     
     public int getSellerId(String name);
}
