package by.bsuir.pavlukovskaya.database.DAO;

import by.bsuir.pavlukovskaya.database.DBConnectionPool;
import by.bsuir.pavlukovskaya.database.model.DataBaseObject;
import by.bsuir.pavlukovskaya.database.model.Flowers;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class FlowerDAOImpl implements FlowerDAO{

    @Override
    public List getFlowers() {
        Flowers flower = null;
        Connection connection = null;
        DBConnectionPool dbcp = DBConnectionPool.init();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List flowers = new ArrayList();
        try{
            connection = dbcp.getConnection();
            ps = connection.prepareStatement("SELECT * FROM flowers");
            rs = ps.executeQuery();
            while(rs.next()) {
                flower = new Flowers(rs.getInt("id_flower"));
                flower.setFlower_name(rs.getString("flower_name"));
                flower.setLifetime(rs.getInt("lifetime"));
                flower.setPrice(rs.getInt("price"));
                flower.setAmount(rs.getInt("amount"));
                flower.setId_seller(rs.getInt("id_seller"));
                
                flowers.add(flower);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FlowerDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbcp.freeConnection(connection);
            finallyBlock(ps, rs);
        }
        return flowers;
    }

    @Override
    public int create(DataBaseObject object) {
        Flowers flower = (Flowers) object;
        Connection connection = null;
        DBConnectionPool dbcp = DBConnectionPool.init();
        PreparedStatement ps = null;
        try{
            connection = dbcp.getConnection();
            ps = connection.prepareStatement("INSERT INTO flowers (flower_name, lifetime, price, amount, id_seller) VALUES (?,?,?,?,?)");
            ps.setString(1, flower.getFlower_name());
            ps.setInt(2, flower.getLifetime());
            ps.setFloat(3, flower.getPrice());
            ps.setInt(4, flower.getAmount());
            ps.setInt(5, flower.getId_seller());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(FlowerDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbcp.freeConnection(connection);
            finallyBlock(ps, null);
        }
        return 0;
    }

    @Override
    public DataBaseObject read(int id) {
        Flowers flower = new Flowers(id);
        Connection connection = null;
        DBConnectionPool dbcp = DBConnectionPool.init();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            connection = dbcp.getConnection();
            ps = connection.prepareStatement("SELECT flower_name, lifetime, price, amount, id_seller FROM flowers WHERE id = ?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            rs.next();
            flower.setFlower_name(rs.getString("flower_name"));
            flower.setLifetime(rs.getInt("lifetime"));
            flower.setPrice(rs.getInt("price"));
            flower.setAmount(rs.getInt("amount"));
            flower.setId_seller(rs.getInt("id_seller"));
        } catch (SQLException ex) {
            Logger.getLogger(FlowerDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbcp.freeConnection(connection);
            finallyBlock(ps, rs);
        }
        return flower;
    }

    @Override
    public void update(DataBaseObject newObject) {
        Flowers newFlower = (Flowers) newObject;
        Connection connection = null;
        DBConnectionPool dbcp = DBConnectionPool.init();
        PreparedStatement ps = null;
        try{
            connection = dbcp.getConnection();
            ps = connection.prepareStatement("UPDATE flowers SET flower_name = ?, lifetime = ?, price = ?, amount = ?, id_seller = ? WHERE id_flower = ?");
            ps.setString(1, newFlower.getFlower_name());
            ps.setInt   (2, newFlower.getLifetime());
            ps.setFloat (3, newFlower.getPrice());
            ps.setInt   (4, newFlower.getAmount());
            ps.setInt   (5, newFlower.getId_seller());
            ps.setInt   (6, newObject.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FlowerDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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
            ps = connection.prepareStatement("DELETE FROM flowers WHERE id_flower = ?");
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(FlowerDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(FlowerDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
