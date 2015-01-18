package by.bsuir.pavlukovskaya.logic;


import by.bsuir.pavlukovskaya.database.DAO.FlowerDAO;
import by.bsuir.pavlukovskaya.database.DAO.FlowerDAOImpl;
import by.bsuir.pavlukovskaya.database.DAO.OtherGoodsDAO;
import by.bsuir.pavlukovskaya.database.DAO.OtherGoodsDAOImpl;
import by.bsuir.pavlukovskaya.database.DAO.SellerDAO;
import by.bsuir.pavlukovskaya.database.DAO.SellerDAOImpl;
import by.bsuir.pavlukovskaya.database.model.OtherGoods;
import by.bsuir.pavlukovskaya.database.model.Seller;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AddLogicGoodsImpl implements AddLogicGoods{

    @Override
    public String getSellerName(int id) {
       SellerDAO sdao = new SellerDAOImpl();
       Seller seller = (Seller) sdao.read(id);
       Logger.getLogger(AddLogicGoodsImpl.class.getName()).log(Level.SEVERE, "\u041e\u0442\u043f\u0440\u0430\u0432\u043a\u0430 \u0438\u043c\u0435\u043d\u0438 \u043f\u0440\u043e\u0434\u0430\u0432\u0446\u0430{0}");
      
       return  seller.getSeller_name();
    }

    @Override
    public List getAllSellers() {
        SellerDAO sdao = new SellerDAOImpl();
        return sdao.getSellers();
    }

    @Override
    public void saveGoods(OtherGoods goods) {
        OtherGoodsDAO bdao = new OtherGoodsDAOImpl();
         if(goods.getId() == 0) {
             Logger.getLogger(AddLogicGoodsImpl.class.getName()).log(Level.SEVERE, "\u0421\u043e\u0445\u0440\u0430\u043d\u0435\u043d\u0438\u0435 \u043d\u043e\u0432\u043e\u0433\u043e \u0442\u043e\u0432\u0430\u0440\u0430{0}", goods.toString());
             bdao.create(goods);
         } else {
             Logger.getLogger(AddLogicGoodsImpl.class.getName()).log(Level.SEVERE, "Обновление данных о товаре");
             bdao.update(goods);
         } 
    }

    @Override
    public int getSellerId(String name) {
        SellerDAO sdao = new SellerDAOImpl();
        Seller seller = (Seller) sdao.getSellerByName(name);
        Logger.getLogger(AddLogicGoodsImpl.class.getName()).log(Level.SEVERE, "Отправка ID продавца");
        return  seller.getId(); 
    }

 
}
