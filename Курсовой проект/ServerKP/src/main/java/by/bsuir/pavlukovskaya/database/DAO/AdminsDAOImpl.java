/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.pavlukovskaya.database.DAO;

import by.bsuir.pavlukovskaya.database.DBConnectionPool;
import by.bsuir.pavlukovskaya.database.model.Admins;
import by.bsuir.pavlukovskaya.database.model.DataBaseObject;
import by.bsuir.pavlukovskaya.database.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author itechno
 */
public class AdminsDAOImpl implements AdminsDAO {

    @Override
    public List getAdmins() {
        Admins admin= null;
        Connection connection = null;
        DBConnectionPool dbcp = DBConnectionPool.init();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List users = new ArrayList();
        try{
            connection = dbcp.getConnection();
            ps = connection.prepareStatement("SELECT * FROM admins");
            rs = ps.executeQuery();
            while(rs.next()) {
                admin = new Admins(rs.getInt("id_admins"));
                admin.setLogin(rs.getString("login"));
                admin.setPass(rs.getString("pass"));
                users.add(admin);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbcp.freeConnection(connection);
            finallyBlock(ps, rs);
        }
        return users;
    }

    @Override
    public DataBaseObject getAdminByName(String name) {
        Admins admin = null;
        Connection connection = null;
        DBConnectionPool dbcp = DBConnectionPool.init();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            connection = dbcp.getConnection();
            ps = connection.prepareStatement("SELECT * FROM admins WHERE login = ?");
            ps.setString(1, name);
            rs = ps.executeQuery();
            rs.next();
            admin = new Admins(rs.getInt("id_admins"));
            admin.setLogin(rs.getString("login"));
            admin.setPass(rs.getString("pass"));
        } catch (SQLException ex) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbcp.freeConnection(connection);
            finallyBlock(ps, rs);
        }
        return admin;
    }

    @Override
    public int create(DataBaseObject object) {
        Admins admin = (Admins) object;
        Connection connection = null;
        DBConnectionPool dbcp = DBConnectionPool.init();
        PreparedStatement ps = null;
        try{
            connection = dbcp.getConnection();
            ps = connection.prepareStatement("INSERT INTO admins (login, pass) VALUES (?,?)");
            ps.setString(1, admin.getLogin());
            ps.setString(2, admin.getPass());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbcp.freeConnection(connection);
            finallyBlock(ps, null);
        }
        return 0;
    }

    @Override
    public DataBaseObject read(int id) {
       Admins admin = new Admins(id);
        Connection connection = null;
        DBConnectionPool dbcp = DBConnectionPool.init();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            connection = dbcp.getConnection();
            ps = connection.prepareStatement("SELECT login, pass FROM admins WHERE id_admins = ?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            rs.next();
            admin.setLogin(rs.getString("login"));
            admin.setPass(rs.getString("pass"));
        } catch (SQLException ex) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbcp.freeConnection(connection);
            finallyBlock(ps, rs);
        }
        return admin;
    }

    @Override
    public void update(DataBaseObject newObject) {
        Admins newAdmin = (Admins) newObject;
        Connection connection = null;
        DBConnectionPool dbcp = DBConnectionPool.init();
        PreparedStatement ps = null;
        try{
            connection = dbcp.getConnection();
            ps = connection.prepareStatement("UPDATE admins SET login = ? , pass = ? WHERE id_admins = ?");
            ps.setString(1, newAdmin.getLogin());
            ps.setString(2, newAdmin.getPass());
            ps.setInt   (3, newAdmin.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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
            ps = connection.prepareStatement("DELETE FROM admins WHERE id_admins = ?");
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
