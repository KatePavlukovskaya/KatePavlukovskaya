package by.bsuir.pavlukovskaya.database.DAO;

import by.bsuir.pavlukovskaya.database.DBConnectionPool;
import by.bsuir.pavlukovskaya.database.model.DataBaseObject;
import by.bsuir.pavlukovskaya.database.model.Seller;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class SellerDAOImpl implements SellerDAO{

    @Override
    public List getSellers() {
        Seller seller = null;
        Connection connection = null;
        DBConnectionPool dbcp = DBConnectionPool.init();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List sellers = new ArrayList();
        try{
            connection = dbcp.getConnection();
            ps = connection.prepareStatement("SELECT * FROM seller");
            rs = ps.executeQuery();
            while(rs.next()) {
                seller = new Seller(rs.getInt("id_seller"));
                seller.setSeller_name(rs.getString("seller_name"));
                seller.setInfo(rs.getString("info"));
                sellers.add(seller);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SellerDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbcp.freeConnection(connection);
            finallyBlock(ps, rs);
        }
        return sellers;
    }

    @Override
    public DataBaseObject getSellerByName(String name) {
        Seller seller = null;
        Connection connection = null;
        DBConnectionPool dbcp = DBConnectionPool.init();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            connection = dbcp.getConnection();
            ps = connection.prepareStatement("SELECT id_seller, seller_name FROM seller WHERE seller_name = ?");
            ps.setString(1, name);
            rs = ps.executeQuery();
            rs.next();
            seller = new Seller(rs.getInt("id_seller"));
            seller.setSeller_name(rs.getString("seller_name"));
        } catch (SQLException ex) {
            Logger.getLogger(SellerDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbcp.freeConnection(connection);
            finallyBlock(ps, rs);
        }
        return seller;
    }

    @Override
    public int create(DataBaseObject object) {
        Seller seller = (Seller) object;
        Connection connection = null;
        DBConnectionPool dbcp = DBConnectionPool.init();
        PreparedStatement ps = null;
        try{
            connection = dbcp.getConnection();
            ps = connection.prepareStatement("INSERT INTO seller (seller_name, info) VALUES (?, ?)");
            ps.setString(1, seller.getSeller_name());
            ps.setString(2, seller.getInfo());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(SellerDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbcp.freeConnection(connection);
            finallyBlock(ps, null);
        }
        return 0;
    }

    @Override
    public DataBaseObject read(int id) {
        Seller seller = new Seller(id);
        Connection connection = null;
        DBConnectionPool dbcp = DBConnectionPool.init();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            connection = dbcp.getConnection();
            ps = connection.prepareStatement("SELECT seller_name, info FROM seller WHERE id_seller = ?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            rs.next();
            seller.setSeller_name(rs.getString("seller_name"));
            seller.setInfo(rs.getString("info"));
        } catch (SQLException ex) {
            Logger.getLogger(SellerDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbcp.freeConnection(connection);
            finallyBlock(ps, rs);
        }
        return seller;
    }

    @Override
    public void update(DataBaseObject newObject) {
        Seller newSeller = (Seller) newObject;
        Connection connection = null;
        DBConnectionPool dbcp = DBConnectionPool.init();
        PreparedStatement ps = null;
        try{
            connection = dbcp.getConnection();
            ps = connection.prepareStatement("UPDATE seller SET seller_name = ?, info = ? WHERE id_seller = ?");
            ps.setString(1, newSeller.getSeller_name());
            ps.setString(2, newSeller.getInfo());
            ps.setInt   (3, newSeller.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SellerDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbcp.freeConnection(connection);
            finallyBlock(ps, null);
        }
    }

    @Override
    public void delete(int id) {
        Connection connection = null;
        DBConnectionPool dbcp = DBConnectionPool.init();
        PreparedStatement ps = null;
        try{
            connection = dbcp.getConnection();
            ps = connection.prepareStatement("DELETE FROM seller WHERE id_seller = ?");
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(SellerDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbcp.freeConnection(connection);
            finallyBlock(ps, null);
        }
    }
    
    private void finallyBlock(Statement ps, ResultSet rs) {
        try {
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
            Logger.getLogger(SellerDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
