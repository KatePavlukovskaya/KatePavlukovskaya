package by.bsuir.psp;

import javax.swing.table.AbstractTableModel;
import java.sql.*;
import java.util.ArrayList;



public class FlowerTableModel extends AbstractTableModel{
    private int colnum=4;
    private int rownum;
    
 

    private String[] colNames={
        "IDFlower","Name","Varieties","IDFeature"
    };
    private  ArrayList<String[]> ResultSets;
    
    /** Creates a new instance of FoodTableModel */
    public FlowerTableModel(ResultSet rs) {
      
      ResultSets=new ArrayList<String[]>();  
    
      try{
        while(rs.next()){
      
              String[] row={
                rs.getString("id_flower"),rs.getString("name"), rs.getString("varieties"), rs.getString("id_features")
          
            };
            ResultSets.add(row);
      
         }   
      }
      catch(Exception e){
          System.out.println("Exception in TableModel");
            }
        
    }
    public Object getValueAt(int rowindex, int columnindex) {
        
       String[] row=getResultSets().get(rowindex);
       return row[columnindex];
        
    }

    public int getRowCount() {
        return getResultSets().size();
    }

    public int getColumnCount() {
        return getColnum();
    }

    public String getColumnName(int param) {

       return getColNames()[param];
    }

    /**
     * @return the colnum
     */
    public int getColnum() {
        return colnum;
    }

    /**
     * @param colnum the colnum to set
     */
    public void setColnum(int colnum) {
        this.colnum = colnum;
    }

    /**
     * @return the rownum
     */
    public int getRownum() {
        return rownum;
    }

    /**
     * @param rownum the rownum to set
     */
    public void setRownum(int rownum) {
        this.rownum = rownum;
    }

    /**
     * @return the colNames
     */
    public String[] getColNames() {
        return colNames;
    }

    /**
     * @param colNames the colNames to set
     */
    public void setColNames(String[] colNames) {
        this.colNames = colNames;
    }

    /**
     * @return the ResultSets
     */
    public ArrayList<String[]> getResultSets() {
        return ResultSets;
    }

    /**
     * @param ResultSets the ResultSets to set
     */
    public void setResultSets(ArrayList<String[]> ResultSets) {
        this.ResultSets = ResultSets;
    }
   
 

}
