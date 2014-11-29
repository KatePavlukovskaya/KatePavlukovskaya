/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.psp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class FlowerForm extends javax.swing.JFrame {

    /**
     * Creates new form FlowerForm
     */
    private MyDBConnection mdbc;
    private java.sql.Statement stmt;
 
    
    public FlowerForm() {
        mdbc=new MyDBConnection();
        mdbc.init();
        Connection conn=mdbc.getMyConnection();
        try {
            stmt= conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(FlowerForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        jTextField4 = new javax.swing.JTextField();
        magazinflowersPUEntityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("magazinflowersPU").createEntityManager();
        flowerQuery = java.beans.Beans.isDesignTime() ? null : magazinflowersPUEntityManager.createQuery("SELECT f FROM Flower f");
        flowerList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : flowerQuery.getResultList();
        jPanel1 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        jTextField4.setText("jTextField4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        jTextField1.setForeground(new java.awt.Color(102, 0, 102));
        jPanel1.add(jTextField1);
        jTextField1.setBounds(150, 210, 140, 30);

        jTextField3.setForeground(new java.awt.Color(102, 0, 102));
        jPanel1.add(jTextField3);
        jTextField3.setBounds(150, 290, 140, 30);

        jTextField5.setForeground(new java.awt.Color(102, 0, 102));
        jPanel1.add(jTextField5);
        jTextField5.setBounds(150, 330, 140, 30);

        jTextField2.setForeground(new java.awt.Color(102, 0, 102));
        jPanel1.add(jTextField2);
        jTextField2.setBounds(150, 250, 140, 30);

        jTextField6.setForeground(new java.awt.Color(102, 0, 102));
        jPanel1.add(jTextField6);
        jTextField6.setBounds(420, 210, 130, 30);

        jLabel2.setFont(new java.awt.Font("Curlz MT", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 0, 102));
        jLabel2.setText("Flowers");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(390, 10, 140, 40);

        jLabel4.setFont(new java.awt.Font("Curlz MT", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 0, 102));
        jLabel4.setText("Name");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(20, 250, 55, 33);

        jLabel5.setFont(new java.awt.Font("Curlz MT", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 0, 102));
        jLabel5.setText("Varieties");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(20, 290, 90, 30);

        jLabel7.setFont(new java.awt.Font("Curlz MT", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 0, 102));
        jLabel7.setText("ID Flower");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(310, 210, 100, 33);

        jLabel3.setFont(new java.awt.Font("Curlz MT", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 0, 102));
        jLabel3.setText("ID Flower");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(20, 210, 100, 33);

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, flowerList, jTable1);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${idFlower}"));
        columnBinding.setColumnName("Id Flower");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${name}"));
        columnBinding.setColumnName("Name");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${varieties}"));
        columnBinding.setColumnName("Varieties");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${idFeatures}"));
        columnBinding.setColumnName("Id Features");
        columnBinding.setColumnClass(Integer.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();

        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(40, 60, 510, 130);

        jButton3.setFont(new java.awt.Font("Curlz MT", 0, 24)); // NOI18N
        jButton3.setForeground(new java.awt.Color(102, 0, 102));
        jButton3.setText("Next Table");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(410, 370, 150, 30);

        jButton2.setFont(new java.awt.Font("Curlz MT", 0, 24)); // NOI18N
        jButton2.setForeground(new java.awt.Color(102, 0, 102));
        jButton2.setText("Delete");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(440, 260, 100, 30);

        jButton1.setFont(new java.awt.Font("Curlz MT", 0, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(102, 0, 102));
        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(170, 370, 100, 30);

        jLabel6.setFont(new java.awt.Font("Curlz MT", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 0, 102));
        jLabel6.setText("ID Features");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(20, 330, 110, 33);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/by/bsuir/psp/2.jpeg"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 590, 410);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
         String id_flower=jTextField6.getText();
        
        
        String insertStr="";        
        try{
            
            insertStr="DELETE FROM flower WHERE id_flower="+quotate(id_flower)+";";
            
            int done=stmt.executeUpdate(insertStr);         
           
           
            getContentPane().removeAll();
            initComponents();
        
        }
        catch(Exception e){           
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String id_flower=jTextField1.getText();
        String name=jTextField2.getText();        
        String varieties=jTextField3.getText();  
        String id_features=jTextField5.getText();
      
        
        String insertStr="";        
        try{
            
            insertStr="INSERT INTO flower (id_flower, name, varieties, id_features) VALUES("
                    +quotate(id_flower)+","
                    +quotate(name)+","
                    +quotate(varieties)+","
                    +quotate(id_features)+");";
            
            int done=stmt.executeUpdate(insertStr);
                     
           
            getContentPane().removeAll();
            initComponents();        
        }
        catch(Exception e){           
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            FeaturesForm f=new FeaturesForm();
            f.setVisible(true);
            dispose();
        } catch (SQLException ex) {
            Logger.getLogger(FlowerForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed
 public ResultSet getResultFromCars() {
        
        ResultSet rs=null;
        
        try{
            rs=stmt.executeQuery("Select * from flower");
        
        }
        catch(SQLException e){}
        
        return rs;
        
    }
    /**
     * @param args the command line arguments
     */
   

    
     public String quotate(String content){
    
        return "'"+content+"'";
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.util.List<by.bsuir.psp.Flower> flowerList;
    private javax.persistence.Query flowerQuery;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.persistence.EntityManager magazinflowersPUEntityManager;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}