package by.bsuir.pavlukovskaya.database.DAO;


import by.bsuir.pavlukovskaya.database.DBConnectionPool;
import by.bsuir.pavlukovskaya.database.model.OtherGoods;
import by.bsuir.pavlukovskaya.database.model.DataBaseObject;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OtherGoodsDAOImpl implements OtherGoodsDAO{

    @Override
    public List getGoods() {
        OtherGoods goods = null;
        Connection connection = null;
        DBConnectionPool dbcp = DBConnectionPool.init();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List otherGoods= new ArrayList();
        try{
            connection = dbcp.getConnection();
            ps = connection.prepareStatement("SELECT * FROM otherGoods");
            rs = ps.executeQuery();
            while(rs.next()) {
                goods = new OtherGoods(rs.getInt("id_goods"));
                goods.setGoods_name(rs.getString("goods_name"));
                goods.setPrice(rs.getFloat("goods_price"));
                goods.setAmount(rs.getInt("amount"));
                goods.setId_seller(rs.getInt("id_seller"));
                
                otherGoods.add(goods);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OtherGoodsDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbcp.freeConnection(connection);
            finallyBlock(ps, rs);
        }
        return otherGoods;
    }

    @Override
    public int create(DataBaseObject object) {
        OtherGoods goods = (OtherGoods) object;
        Connection connection = null;
        DBConnectionPool dbcp = DBConnectionPool.init();
        PreparedStatement ps = null;
        try{
            connection = dbcp.getConnection();
            ps = connection.prepareStatement("INSERT INTO otherGoods (goods_name, goods_price, amount, id_seller) VALUES (?,?,?,?)");
            ps.setString(1, goods.getGoods_name());
            ps.setFloat(2, goods.getPrice());
            ps.setInt(3, goods.getAmount());
            ps.setInt(4, goods.getId_seller());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(OtherGoodsDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbcp.freeConnection(connection);
            finallyBlock(ps, null);
        }
        return 0;
    }

    @Override
    public DataBaseObject read(int id) {
        OtherGoods goods = new OtherGoods(id);
        Connection connection = null;
        DBConnectionPool dbcp = DBConnectionPool.init();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            connection = dbcp.getConnection();
            ps = connection.prepareStatement("SELECT goods_name, goods_price, amount, id_seller FROM otherGoods WHERE id_goods = ?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            rs.next();
            goods.setGoods_name(rs.getString("goods_name"));
            goods.setPrice(rs.getFloat("goods_price"));
            goods.setAmount(rs.getInt("amount"));
            goods.setId_seller(rs.getInt("id_seller"));
        } catch (SQLException ex) {
            Logger.getLogger(OtherGoodsDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbcp.freeConnection(connection);
            finallyBlock(ps, rs);
        }
        return goods;
    }

    @Override
    public void update(DataBaseObject newObject) {
        OtherGoods newGoods = (OtherGoods) newObject;
        Connection connection = null;
        DBConnectionPool dbcp = DBConnectionPool.init();
        PreparedStatement ps = null;
        try{
            connection = dbcp.getConnection();
            ps = connection.prepareStatement("UPDATE otherGoods SET goods_name = ?, goods_price = ?, amount = ?, id_seller = ? WHERE id_goods = ?");
            ps.setString(1, newGoods.getGoods_name());
            ps.setFloat (2, newGoods.getPrice());
            ps.setInt   (3, newGoods.getAmount());
            ps.setInt   (4, newGoods.getId_seller());
            ps.setInt   (5, newObject.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(OtherGoodsDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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
            ps = connection.prepareStatement("DELETE FROM otherGoods WHERE id_goods = ?");
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(OtherGoodsDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(OtherGoodsDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
