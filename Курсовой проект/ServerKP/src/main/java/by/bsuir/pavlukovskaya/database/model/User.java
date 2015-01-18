package by.bsuir.pavlukovskaya.database.model;

import java.io.Serializable;
import java.util.Objects;

public class User extends DataBaseObject implements Serializable {

    private String login;
    private String pass;

    public User() {
    }

    public User(int id) {
        this.setId(id);
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + this.getId();
        hash = 41 * hash + Objects.hashCode(this.login);
        hash = 41 * hash + Objects.hashCode(this.pass);
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
        final User other = (User) obj;
         if (this.getId() != other.getId()) {
            return false;
        }
        if (!Objects.equals(this.login, other.login)) {
            return false;
        }
        if (!Objects.equals(this.pass, other.pass)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "User{" +"id_user=" + getId() + ", login=" + login + ", pass=" + pass + '}';
    }
    
    
}
