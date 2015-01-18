package by.bsuir.pavlukovskaya.logic;

import by.bsuir.pavlukovskaya.database.model.OtherGoods;
import java.io.Serializable;
import java.util.List;

public interface MainLogicGoods extends Serializable{
    
    public List getAllGoods();
    
    public String getSellerName(int id);
    
    public void deleteGoods(OtherGoods Goods);
}
