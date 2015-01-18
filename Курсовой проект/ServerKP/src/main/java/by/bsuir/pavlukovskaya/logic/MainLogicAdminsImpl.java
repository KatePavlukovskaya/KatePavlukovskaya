/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.pavlukovskaya.logic;

import by.bsuir.pavlukovskaya.database.DAO.AdminsDAO;
import by.bsuir.pavlukovskaya.database.DAO.AdminsDAOImpl;

import by.bsuir.pavlukovskaya.database.model.Admins;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author itechno
 */
public class MainLogicAdminsImpl implements MainLogicAdmins {

    @Override
    public void saveAdmins(Admins admin) {
        AdminsDAO bdao = new AdminsDAOImpl();
         if(admin.getId() == 0) {
             Logger.getLogger(AddLogicGoodsImpl.class.getName()).log(Level.SEVERE, "\u0421\u043e\u0445\u0440\u0430\u043d\u0435\u043d\u0438\u0435 \u043d\u043e\u0432\u043e\u0433\u043e \u0442\u043e\u0432\u0430\u0440\u0430{0}", admin.toString());
             bdao.create(admin);
         } else {
             Logger.getLogger(AddLogicGoodsImpl.class.getName()).log(Level.SEVERE, "Обновление данных о товаре");
             bdao.update(admin);
         } 
    }

    @Override
    public List getAllAdmins() {
        AdminsDAO sdao = new AdminsDAOImpl();
        return sdao.getAdmins();
    }
    
}
