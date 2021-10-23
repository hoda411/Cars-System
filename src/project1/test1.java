/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project1;

import db.Tools;
import javax.swing.JTable;

/**
 *
 * @author ok
 */
public class test1 implements Maincode.Maindata {
  int id,amount,price;
   String brand,color,date;

    public int getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void add() {
       String insert = "insert into car values("
               +id+","+
               "'"+brand+"',"
               +"'"+color+"',"+
               "'"+date+"',"+
               price+","+
               amount+")";
       boolean isadd=db.go.runNonQuery(insert);
       if(isadd){
           Tools.msgBox("ok added");
       }
    }
    @Override
    public void delete() {
        String strdelete="delete from car"
                +" where id="+id;
        boolean isdelete=db.go.runNonQuery(strdelete);
       if(isdelete){
           Tools.msgBox("ok deleted");
       }
       
    }

    @Override
    public void update() {
       
        String strupdate="update car set "
               +"brand='"+brand+"',"
             +"color='"+color+"',"
                 +"date='"+date+"',"
                +"price="+price+","
         +"amount="+amount
                +" where id="+id;
        
 boolean isupdate=db.go.runNonQuery(strupdate);
       if(isupdate){
           Tools.msgBox("ok uppdated");
       }
                
    }

    @Override
    public String getAutoNumber() {
        return db.go.getAutoNumber("car","id");
    }

    @Override
    public void getAllRows(JTable table) {
       db.go.fillToJTable("cartest1", table);
    }

    @Override
    public void getOneRows(JTable table) {
       String strSelect="select * from  cartest1 "
               +" where number="+id;
       db.go.fillToJTable(strSelect, table);
    }

    @Override
    public void getCustomRows(String statement, JTable table) {
        db.go.fillToJTable(statement, table);
    }

    @Override
    public String getValueByName(String brand) {
       String strselect ="select id from car"
              +" where brand='"+brand+"'";
      String strval=(String)db.go.getTableData(strselect).Items[0][0];
      return strval;
    }

    @Override
    public String getNameByValue(String value) {
       String strselect ="select brand from car"
              +" where id="+value;
      String strName=(String)db.go.getTableData(strselect).Items[0][0];
      return strName;
    }
    
}
