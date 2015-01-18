package by.bsuir.pavlukovskaya.database.DAO;

import by.bsuir.pavlukovskaya.database.model.DataBaseObject;
import java.util.List;

public interface SellerDAO extends DAO{
    public List getSellers();
    public DataBaseObject getSellerByName( String name);
}
