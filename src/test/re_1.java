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
public class re_1 implements Maincode.Maindata {
  
    String cname,cemail,cphone,ename,eemail,brand,color,date;
    int price,amount,carid,eid;

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCemail() {
        return cemail;
    }

    public void setCemail(String cemail) {
        this.cemail = cemail;
    }

    public String getCphone() {
        return cphone;
    }

    public void setCphone(String cphone) {
        this.cphone = cphone;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getEemail() {
        return eemail;
    }

    public void setEemail(String eemail) {
        this.eemail = eemail;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getCarid() {
        return carid;
    }

    public void setCarid(int carid) {
        this.carid = carid;
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }
   
    @Override
    public void add() {
       String insert = "insert into purchase values("
               +"'"+cname+"',"+
               "'"+cemail+"',"
               +"'"+cphone+"',"+
               eid+","+
              "'"+ename+"',"+
               "'"+eemail+"',"+
               "'"+brand+"',"+
                   carid+","+
             
                "'"+color+"',"+
                   "'"+amount+"',"+
                price+","+
                "'"+date+"'"+")";
       boolean isadd=db.go.runNonQuery(insert);
       if(isadd){
           Tools.msgBox("ok added");
       }
    }
    @Override
    public void delete() {
      String strdelete="delete from purchase"
                +" where c_name='"+cname+"'";
        boolean isdelete=db.go.runNonQuery(strdelete);
       if(isdelete){
           Tools.msgBox("ok deleted");
       }
    }

    @Override
    public void update() {
       
     
    }

    @Override
    public String getAutoNumber() {
        return db.go.getAutoNumber("sale","id");
    }

    @Override
    public void getAllRows(JTable table) {
       db.go.fillToJTable("purdata", table);
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
