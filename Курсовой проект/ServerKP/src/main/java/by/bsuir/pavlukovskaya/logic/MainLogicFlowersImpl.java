package by.bsuir.pavlukovskaya.logic;

import by.bsuir.pavlukovskaya.database.DAO.FlowerDAO;
import by.bsuir.pavlukovskaya.database.DAO.FlowerDAOImpl;
import by.bsuir.pavlukovskaya.database.DAO.SellerDAO;
import by.bsuir.pavlukovskaya.database.DAO.SellerDAOImpl;
import by.bsuir.pavlukovskaya.database.model.Flowers;
import by.bsuir.pavlukovskaya.database.model.Seller;
import java.util.List;

public class MainLogicFlowersImpl implements MainLogicFlowers{

    @Override
    public List getAllFlowers() {
        FlowerDAO bdao = new FlowerDAOImpl();
        return bdao.getFlowers();
    }

    @Override
    public String getSellerName(int id) {
        SellerDAO sdao = new SellerDAOImpl();
        Seller seller = (Seller) sdao.read(id);
        return  seller.getSeller_name();
    }

    @Override
    public void deleteFlower(Flowers flower) {
        FlowerDAO bdao = new FlowerDAOImpl();
        bdao.delete(flower.getId());
    }
    
}
