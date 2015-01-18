package by.bsuir.pavlukovskaya.database.model;

import java.io.Serializable;
import java.util.Objects;

public class Admins extends DataBaseObject implements Serializable{
    
    private String login;
    private String pass;

    public Admins(){}
    
    public Admins(int id) {
        this.setId(id);
    }

    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the pass
     */
    public String getPass() {
        return pass;
    }

    /**
     * @param pass the pass to set
     */
    public void setPass(String pass) {
        this.pass = pass;
    }
    
    
}
