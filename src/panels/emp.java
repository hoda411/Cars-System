/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panels;

import db.Tools;
import javax.swing.JTable;

/**
 *
 * @author ok
 */
public class emp implements Maincode.Maindata {
    
    int id,salary;
    String name,address,email,phone;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public void add() {
       String insert = "insert into employee values("
               +id+","+
               "'"+name+"',"
               +salary+","+
               "'"+email+"',"+
              "'"+ phone+"',"+
             "'"+ salary+"'"+")";
       boolean isadd=db.go.runNonQuery(insert);
       if(isadd){
           Tools.msgBox("ok added");
       }
    }

    @Override
     public void delete() {
        String strdelete="delete from employee"
                +" where id="+id;
        boolean isdelete=db.go.runNonQuery(strdelete);
       if(isdelete){
           Tools.msgBox("ok deleted");
       }
    }

    @Override
    public void update() {
       
        String strupdate="update employee set "
               +"name='"+name+"',"
             +"salary="+salary+","
                 +"email='"+email+"',"
                +"phone='"+phone+"',"
         +"address='"+address+"'"
                +" where id="+id;
        
 boolean isupdate=db.go.runNonQuery(strupdate);
       if(isupdate){
           Tools.msgBox("ok uppdated");
       }
                
    }

    @Override
    public String getAutoNumber() {
        return db.go.getAutoNumber("employee","id");
    }

    @Override
    public void getAllRows(JTable table) {
          db.go.fillToJTable("emptest1", table);
    }

    @Override
    public void getOneRows(JTable table) {
         String strSelect="select * from  emptest1 "
               +" where number="+id;
       db.go.fillToJTable(strSelect, table);
    }

    @Override
    public void getCustomRows(String statement, JTable table) {
         db.go.fillToJTable(statement, table);
    }

    @Override
    public String getValueByName(String name) {
       String strselect ="select id from employee"
              +" where name='"+name+"'";
      String strval=(String)db.go.getTableData(strselect).Items[0][0];
      return strval;
    }

    @Override
    public String getNameByValue(String value) {
         String strselect ="select name from employee"
              +" where id="+value;
      String strName=(String)db.go.getTableData(strselect).Items[0][0];
      return strName;
    }
    
    
    
}
