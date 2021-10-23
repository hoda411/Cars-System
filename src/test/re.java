/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import project1.*;
import db.Tools;
import javax.swing.JTable;

/**
 *
 * @author ok
 */
public class re implements Maincode.Maindata {
    public int emp_id	,amount,price;
 public  String client_name,client_phone,client_email,emp_name,brand,color,date;

    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getClient_name() {
        return client_name;
    }

    public void setClient_name(String client_name) {
        this.client_name = client_name;
    }

    public String getClient_phone() {
        return client_phone;
    }

    public void setClient_phone(String client_phone) {
        this.client_phone = client_phone;
    }

    public String getClient_email() {
        return client_email;
    }

    public void setClient_email(String client_email) {
        this.client_email = client_email;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

  

    @Override
    public void add() {
       String insert = "insert into sale values("
               +"'"+client_name+"',"+
               "'"+client_phone+"',"
               +"'"+client_email+"',"+
               emp_id+","+
              "'"+emp_name+"',"+
              amount+","+
               "'"+brand+"',"+
                "'"+color+"',"+
                price+","+
                "'"+date+"'"+")";
       boolean isadd=db.go.runNonQuery(insert);
       if(isadd){
           Tools.msgBox("ok added");
       }
    }
    @Override
    public void delete() {
      String strdelete="delete from sale"
                +" where client_name='"+client_name+"'";
        boolean isdelete=db.go.runNonQuery(strdelete);
       if(isdelete){
           Tools.msgBox("ok deleted");
       }
    }

    @Override
    public void update() {
       
       String strupdate="update sale set "
               +"client_phone='"+client_phone+"',"
             +"client_email='"+client_email+"',"
                 +"emp_id="+emp_id+","
                +"emp_name='"+emp_name+"',"
                  +"amount="+amount+","
               +"brand='"+brand+"',"
                 +"color='"+color+"',"
                +"price="+price+","
               +"date='"+date+"'"
                +" where client_name='"+client_name+"'";
        
 boolean isupdate=db.go.runNonQuery(strupdate);
       if(isupdate){
           Tools.msgBox("ok uppdated");
       }
    }

    @Override
    public String getAutoNumber() {
        return db.go.getAutoNumber("sale","id");
    }

    @Override
    public void getAllRows(JTable table) {
       db.go.fillToJTable("saledate", table);
    }

    @Override
    public void getOneRows(JTable table) {
      
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
