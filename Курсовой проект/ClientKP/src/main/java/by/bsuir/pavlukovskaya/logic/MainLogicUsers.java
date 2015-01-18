/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.pavlukovskaya.logic;

import by.bsuir.pavlukovskaya.database.model.OtherGoods;
import by.bsuir.pavlukovskaya.database.model.User;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author itechno
 */
public interface MainLogicUsers extends Serializable{
      
     public void saveUsers(User user);
      public List getAllUsers();
}

