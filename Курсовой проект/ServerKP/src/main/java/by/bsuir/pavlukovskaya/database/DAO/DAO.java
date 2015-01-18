
package by.bsuir.pavlukovskaya.database.DAO;

import by.bsuir.pavlukovskaya.database.model.DataBaseObject;
import java.io.Serializable;

public interface DAO extends Serializable{
    
    public int create(DataBaseObject object);
    public DataBaseObject read(int id);
    public void update(DataBaseObject newObject);
    public void delete(int id);
}
