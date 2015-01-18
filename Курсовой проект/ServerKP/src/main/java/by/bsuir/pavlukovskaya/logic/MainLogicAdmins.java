/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.pavlukovskaya.logic;

import by.bsuir.pavlukovskaya.database.model.Admins;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author itechno
 */
public interface MainLogicAdmins extends Serializable{ 
      
     public void saveAdmins(Admins admin);
      public List getAllAdmins();
}


    

