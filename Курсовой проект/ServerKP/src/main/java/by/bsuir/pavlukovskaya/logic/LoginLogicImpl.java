package by.bsuir.pavlukovskaya.logic;

import by.bsuir.pavlukovskaya.database.DAO.AdminsDAO;
import by.bsuir.pavlukovskaya.database.DAO.AdminsDAOImpl;
import by.bsuir.pavlukovskaya.database.DAO.UserDAO;
import by.bsuir.pavlukovskaya.database.DAO.UserDAOImpl;
import by.bsuir.pavlukovskaya.database.model.Admins;
import by.bsuir.pavlukovskaya.database.model.User;
import java.util.logging.Level;
import java.util.logging.Logger;


public class LoginLogicImpl implements LoginLogic{

    @Override
    public boolean login(String login, String pass) {
        System.out.print(login);
        System.out.print(pass);
        AdminsDAO udao = new AdminsDAOImpl();
        
        Admins admin = (Admins) udao.getAdminByName(login);
        System.out.print(admin);
        if(admin != null) {
            
            if(pass.equals(admin.getPass())){
                Logger.getLogger("Аутификация пройдена пользователем: " + login);
                return true;
            }
        }
        Logger.getLogger(LoginLogicImpl.class.getName()).log(Level.SEVERE, "Аутификация не пройдена");
        return false;
    }

    @Override
    public boolean loginUser(String login, String pass) {
       System.out.print(login);
        System.out.print(pass);
        UserDAO udao = new UserDAOImpl();
        
        User user = (User) udao.getUserByName(login);
        System.out.print(user);
        if(user != null) {
            
            if(pass.equals(user.getPass())){
                Logger.getLogger("Аутификация пройдена пользователем: " + login);
                return true;
            }
        }
        Logger.getLogger(LoginLogicImpl.class.getName()).log(Level.SEVERE, "Аутификация не пройдена");
        return false;
    }
    
}
