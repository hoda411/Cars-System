/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

/**
 *
 * @author ok
 */
import db.Tools;
import db.Tools.Table;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
public class go {
    
    private static String url="";
    private static String dbName="Project1";
    private static Connection con;
    
    private static void setURL(){
        url="jdbc:mysql://localhost:3306/"+dbName
                +"?useUnicode=true&characterEncoding=UTF-8";
    }
    
    private static void setConnection(){
        
        try {
            setURL();
            con=DriverManager.getConnection(url,"root","");
        } catch (SQLException ex) {
           Tools.msgBox(ex.getMessage());
        }
    }
    
    public static boolean checkUserAndPass(String username,String password){
        try{
         setConnection();
         Statement stmt=con.createStatement();
         String strCheck="Select * from users where "
                 +"username='"+username+"' and "
                 +"pass='"+password+"'";
         stmt.executeQuery(strCheck);
         while(stmt.getResultSet().next()){
             con.close();
             return true;
         }
        }
        catch(SQLException ex){
           Tools.msgBox(ex.getMessage()); 
        }
        return false;
    }
    // insert , update , delete
    public static boolean runNonQuery(String sqlStatement){
        
        try{
            setConnection();
            Statement stmt=con.createStatement();
            stmt.execute(sqlStatement);
            con.close();
            return true;
        }
        catch(SQLException ex){
            Tools.msgBox(ex.getMessage());
            return false;
        }
    }
    
    
    
    public static String getAutoNumber(String tableName,String columnName){
        
        try{
           setConnection();
           Statement stmt =con.createStatement();
           String strAuto="select max("+columnName+")+1 as autonum"
                   +" from "+tableName;
           stmt.executeQuery(strAuto);
           String Num="";
           while(stmt.getResultSet().next()){
               Num=stmt.getResultSet().getString("autonum");
           }
           con.close();
           if(Num==null||"".equals(Num)){
               return "1";
           }
           else 
               return Num;
        }
         catch(SQLException ex){
            Tools.msgBox(ex.getMessage());
            return "0";
        }
    }
    
    public  static Table getTableData(String statement){
        
        Tools t=new Tools();
        try{
            setConnection();
           Statement stmt =con.createStatement();
           ResultSet rs;
           rs=stmt.executeQuery(statement);
           ResultSetMetaData rsmd=rs.getMetaData();
         int c=rsmd.getColumnCount();
         Table table =t.new  Table(c);
         while(rs.next()){
             Object row[]=new Object[c];
             for(int i=0;i<c;i++){
                 row[i]=rs.getString(i+1);
             }
             table.addNewRow(row);
         }
         con.close();
         return table;
        }
        catch(SQLException ex){
            Tools.msgBox(ex.getMessage());
           return t.new Table(0);
        }
    }
    
    
    public static  void fillCombo(String tableName,String columnName,JComboBox combo){
        try{
             setConnection();
           Statement stmt =con.createStatement();
           ResultSet rs;
           String strSelect="select "+ columnName +" from "+tableName;
           rs=stmt.executeQuery(strSelect);
           rs.last();
           int c=rs.getRow();
           rs.beforeFirst();
           String Values[]=new String[c];
           int i=0;
           while(rs.next()){
               Values[i]=rs.getString(1);
               i++;
           }
           con.close();
           combo.setModel(new DefaultComboBoxModel(Values));
        }
         catch(SQLException ex){
            Tools.msgBox(ex.getMessage());
         }
    }
    
   
    public static void fillToJTable(String tableNameOrSelectStatement,JTable table){
        
        try{
            setConnection();
           Statement stmt =con.createStatement();
           ResultSet rs;
           String SPart=tableNameOrSelectStatement.substring(0,7).toLowerCase();
           String StrSelect;
           if("select ".equals(SPart)){
               StrSelect =tableNameOrSelectStatement;
           }
           else{
               StrSelect="select * from "+tableNameOrSelectStatement;
           }
           rs=stmt.executeQuery(StrSelect);
           ResultSetMetaData rsmd=rs.getMetaData();
           int c=rsmd.getColumnCount();
          DefaultTableModel model=(DefaultTableModel)table.getModel();
           Vector row = new Vector();
           model.setRowCount(0);
           while(rs.next()){
               row=new Vector(c);
               for(int i=1;i<=c;i++){
                   row.add(rs.getString(i));
               }
               model.addRow(row);
           }
           if(table.getColumnCount()!=c){
               Tools.msgBox("Error");
           }
           con.close();
           
        }
        
        catch(SQLException ex){
            Tools.msgBox(ex.getMessage());
         }
    }
    
    
    
    
}
