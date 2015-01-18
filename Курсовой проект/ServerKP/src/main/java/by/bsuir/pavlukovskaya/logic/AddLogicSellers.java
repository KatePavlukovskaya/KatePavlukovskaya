/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.pavlukovskaya.logic;


import by.bsuir.pavlukovskaya.database.model.Seller;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author itechno
 */
public interface AddLogicSellers extends Serializable{
    
     public String getSellerName(int id);
    
     public List getAllSellers();
     
     public void saveSellers(Seller seller);
     
     public int getSellerId(String name);
    
}
