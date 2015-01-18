/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.pavlukovskaya.logic;

import by.bsuir.pavlukovskaya.database.DAO.SellerDAO;
import by.bsuir.pavlukovskaya.database.DAO.SellerDAOImpl;
import by.bsuir.pavlukovskaya.database.model.OtherGoods;
import by.bsuir.pavlukovskaya.database.model.Seller;
import java.util.List;

/**
 *
 * @author itechno
 */
public class MainLogicSellersImpl implements MainLogicSellers {

    @Override
    public List getAllSellers() {
        SellerDAO bdao = new SellerDAOImpl();
        return bdao.getSellers();
    } 
    
    @Override
    public String getSellerName(int id) {
         SellerDAO sdao = new SellerDAOImpl();
        Seller seller = (Seller) sdao.read(id);
        return  seller.getSeller_name();
    } 

    @Override
    public void deleteSellers(Seller seller) {
         SellerDAO bdao = new SellerDAOImpl();
        bdao.delete(seller.getId());
    }
    
}
