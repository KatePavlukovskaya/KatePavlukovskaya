package by.bsuir.pavlukovskaya.database.DAO;

import by.bsuir.pavlukovskaya.database.model.DataBaseObject;
import java.util.List;


public interface UserDAO extends DAO{
    public List getUsers();
    public DataBaseObject getUserByName(String name);
}
