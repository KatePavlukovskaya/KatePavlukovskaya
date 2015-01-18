
package by.bsuir.pavlukovskaya.logic;

import by.bsuir.pavlukovskaya.database.DAO.FlowerDAO;
import by.bsuir.pavlukovskaya.database.DAO.FlowerDAOImpl;
import by.bsuir.pavlukovskaya.database.DAO.SellerDAO;
import by.bsuir.pavlukovskaya.database.DAO.SellerDAOImpl;
import by.bsuir.pavlukovskaya.database.model.Seller;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author itechno
 */
public class AddLogicSellersImpl implements AddLogicSellers {

    @Override
    public String getSellerName(int id) {
        SellerDAO sdao = new SellerDAOImpl();
        Seller seller = (Seller) sdao.read(id);
        Logger.getLogger(AddLogicFlowersImpl.class.getName()).log(Level.SEVERE, "sssssssssssssssssss");
      
        return  seller.getSeller_name();
    }

    @Override
    public List getAllSellers() {
        SellerDAO sdao = new SellerDAOImpl();
        return sdao.getSellers();
    }

    @Override
    public synchronized void saveSellers(Seller seller) {
       SellerDAO bdao = new SellerDAOImpl();
         if(seller.getId() == 0) {
             Logger.getLogger(AddLogicSellersImpl.class.getName()).log(Level.SEVERE, "\u0421\u043e\u0445\u0440\u0430\u043d\u0435\u043d\u0438\u0435 \u043d\u043e\u0432\u043e\u0433\u043e \u0442\u043e\u0432\u0430\u0440\u0430{0}", seller.toString());
             bdao.create(seller);
         } else {
             Logger.getLogger(AddLogicFlowersImpl.class.getName()).log(Level.SEVERE, "Обновление данных о товаре");
             bdao.update(seller);
         } 
    }

    @Override
    public int getSellerId(String name) {
        SellerDAO sdao = new SellerDAOImpl();
        Seller seller = (Seller) sdao.getSellerByName(name);
        Logger.getLogger(AddLogicFlowersImpl.class.getName()).log(Level.SEVERE, "Отправка ID продавца");
        return  seller.getId();
    }
    
}
