package by.bsuir.pavlukovskaya.logic;

import by.bsuir.pavlukovskaya.database.DAO.OtherGoodsDAO;
import by.bsuir.pavlukovskaya.database.DAO.OtherGoodsDAOImpl;
import by.bsuir.pavlukovskaya.database.DAO.SellerDAO;
import by.bsuir.pavlukovskaya.database.DAO.SellerDAOImpl;
import by.bsuir.pavlukovskaya.database.model.OtherGoods;
import by.bsuir.pavlukovskaya.database.model.Seller;
import java.util.List;


public class MainLogicGoodsImpl implements MainLogicGoods{

    @Override
    public List getAllGoods() {
       OtherGoodsDAO bdao = new OtherGoodsDAOImpl();
        return bdao.getGoods();
    }

    @Override
    public String getSellerName(int id) {
        SellerDAO sdao = new SellerDAOImpl();
        Seller seller = (Seller) sdao.read(id);
        return  seller.getSeller_name();
    }

    @Override
    public void deleteGoods(OtherGoods Goods) {
        OtherGoodsDAO bdao = new OtherGoodsDAOImpl();
        bdao.delete(Goods.getId());
    }
    
}
