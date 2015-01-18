/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.pavlukovskaya.database.DAO;

import by.bsuir.pavlukovskaya.database.model.DataBaseObject;
import java.util.List;

/**
 *
 * @author itechno
 */
public interface AdminsDAO extends DAO{
    public List getAdmins();
    public DataBaseObject getAdminByName(String name);
    
}
