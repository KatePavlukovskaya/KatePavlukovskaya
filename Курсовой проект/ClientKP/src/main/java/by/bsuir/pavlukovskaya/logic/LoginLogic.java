package by.bsuir.pavlukovskaya.logic;

import java.io.Serializable;

public interface LoginLogic extends Serializable{
    
    public boolean login(String login, String pass);
    public boolean loginUser(String login, String pass);
}
