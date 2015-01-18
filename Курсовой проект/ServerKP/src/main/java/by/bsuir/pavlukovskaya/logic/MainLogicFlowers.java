package by.bsuir.pavlukovskaya.logic;

import by.bsuir.pavlukovskaya.database.model.Flowers;
import java.io.Serializable;
import java.util.List;

public interface MainLogicFlowers extends Serializable{
    
    public List getAllFlowers();
    
    public String getSellerName(int id);
    
    public void deleteFlower(Flowers flower);
}
