package by.bsuir.pavlukovskaya.manager;

import by.bsuir.pavlukovskaya.logic.AddLogicFlowers;
import by.bsuir.pavlukovskaya.logic.AddLogicFlowersImpl;
import by.bsuir.pavlukovskaya.logic.AddLogicGoods;
import by.bsuir.pavlukovskaya.logic.AddLogicGoodsImpl;
import by.bsuir.pavlukovskaya.logic.AddLogicSellers;
import by.bsuir.pavlukovskaya.logic.AddLogicSellersImpl;
import by.bsuir.pavlukovskaya.logic.LoginLogic;
import by.bsuir.pavlukovskaya.logic.LoginLogicImpl;
import by.bsuir.pavlukovskaya.logic.MainLogicAdmins;
import by.bsuir.pavlukovskaya.logic.MainLogicAdminsImpl;
import by.bsuir.pavlukovskaya.logic.MainLogicFlowers;
import by.bsuir.pavlukovskaya.logic.MainLogicFlowersImpl;
import by.bsuir.pavlukovskaya.logic.MainLogicGoods;
import by.bsuir.pavlukovskaya.logic.MainLogicGoodsImpl;
import by.bsuir.pavlukovskaya.logic.MainLogicSellers;
import by.bsuir.pavlukovskaya.logic.MainLogicSellersImpl;
import by.bsuir.pavlukovskaya.logic.MainLogicUsers;
import by.bsuir.pavlukovskaya.logic.MainLogicUsersImpl;
import java.rmi.RemoteException;


public class EntityManagerImpl implements EntityManager{

    @Override
    public  synchronized LoginLogic getLoginManager() {
       return new LoginLogicImpl();
    }

    @Override
    public MainLogicFlowers getMainManagerFlowers() {
        return new MainLogicFlowersImpl();
    }

    @Override
    public MainLogicGoods getMainManagerGoods() {
        return new MainLogicGoodsImpl();
    }

    @Override
    public AddLogicFlowers getAddManagerFlowers() {
        return new AddLogicFlowersImpl();
    }

    @Override
    public AddLogicGoods getAddManagerGoods() {
        return new AddLogicGoodsImpl();
    }

    @Override
    public MainLogicSellers getMainManagerSellers()  {
        return new MainLogicSellersImpl();
    }

    @Override
    public AddLogicSellers getAddManagerSellers() throws RemoteException {
       return new AddLogicSellersImpl();
    }

    @Override
    public MainLogicUsers getMainManagerUsers() throws RemoteException {
         return new MainLogicUsersImpl();
    }

    @Override
    public MainLogicAdmins getMainManagerAdmins() throws RemoteException {
        return new MainLogicAdminsImpl();
    }
    
   
    
}
