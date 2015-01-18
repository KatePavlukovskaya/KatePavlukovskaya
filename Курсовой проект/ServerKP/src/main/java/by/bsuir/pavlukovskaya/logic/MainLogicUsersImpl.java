/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.pavlukovskaya.logic;

import by.bsuir.pavlukovskaya.database.DAO.OtherGoodsDAO;
import by.bsuir.pavlukovskaya.database.DAO.OtherGoodsDAOImpl;
import by.bsuir.pavlukovskaya.database.DAO.SellerDAO;
import by.bsuir.pavlukovskaya.database.DAO.SellerDAOImpl;
import by.bsuir.pavlukovskaya.database.DAO.UserDAO;
import by.bsuir.pavlukovskaya.database.DAO.UserDAOImpl;
import by.bsuir.pavlukovskaya.database.model.User;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author itechno
 */
public class MainLogicUsersImpl implements MainLogicUsers {

    @Override
    public void saveUsers(User user) {
        UserDAO bdao = new UserDAOImpl();
         if(user.getId() == 0) {
             Logger.getLogger(AddLogicGoodsImpl.class.getName()).log(Level.SEVERE, "\u0421\u043e\u0445\u0440\u0430\u043d\u0435\u043d\u0438\u0435 \u043d\u043e\u0432\u043e\u0433\u043e \u0442\u043e\u0432\u0430\u0440\u0430{0}", user.toString());
             bdao.create(user);
         } else {
             Logger.getLogger(AddLogicGoodsImpl.class.getName()).log(Level.SEVERE, "Обновление данных о товаре");
             bdao.update(user);
         } 
    }

    @Override
    public List getAllUsers() {
        UserDAO sdao = new UserDAOImpl();
        return sdao.getUsers();
    }
    
}
