package by.bsuir.pavlukovskaya.manager;

import by.bsuir.pavlukovskaya.logic.AddLogicFlowers;
import by.bsuir.pavlukovskaya.logic.AddLogicGoods;
import by.bsuir.pavlukovskaya.logic.AddLogicSellers;
import by.bsuir.pavlukovskaya.logic.LoginLogic;
import by.bsuir.pavlukovskaya.logic.MainLogicAdmins;
import by.bsuir.pavlukovskaya.logic.MainLogicFlowers;
import by.bsuir.pavlukovskaya.logic.MainLogicGoods;
import by.bsuir.pavlukovskaya.logic.MainLogicSellers;
import by.bsuir.pavlukovskaya.logic.MainLogicUsers;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface EntityManager extends Remote{
    public LoginLogic getLoginManager() throws RemoteException;
    public MainLogicFlowers getMainManagerFlowers() throws RemoteException;
    public MainLogicGoods getMainManagerGoods() throws RemoteException;
    public MainLogicSellers getMainManagerSellers() throws RemoteException;
    public MainLogicUsers getMainManagerUsers() throws RemoteException;
    public AddLogicFlowers getAddManagerFlowers() throws RemoteException;
    public AddLogicGoods getAddManagerGoods() throws RemoteException;
    public AddLogicSellers getAddManagerSellers() throws RemoteException;
       public MainLogicAdmins getMainManagerAdmins() throws RemoteException;
}
