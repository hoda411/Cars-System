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
public class sup implements Maincode.Maindata{
    int id;
    String name,phone,address,email,company;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
    
     @Override
    public void add() {
       String insert = "insert into suppliers values("
               +id+","+
               "'"+name+"',"
               +"'"+phone+"',"+
               "'"+email+"',"+
              "'"+ address+"',"+
              "'"+ company+"'"+")";
       boolean isadd=db.go.runNonQuery(insert);
       if(isadd){
           Tools.msgBox("ok added");
       }
    }
    @Override
    public void delete() {
        String strdelete="delete from suppliers"
                +" where id="+id;
        boolean isdelete=db.go.runNonQuery(strdelete);
       if(isdelete){
           Tools.msgBox("ok deleted");
       }
    }

    @Override
    public void update() {
       
        String strupdate="update suppliers set "
               +"name='"+name+"',"
             +"phone='"+phone+"',"
                 +"email='"+email+"',"
                +"address='"+address+"',"
         +"company='"+company+"'"
                +" where id="+id;
        
 boolean isupdate=db.go.runNonQuery(strupdate);
       if(isupdate){
           Tools.msgBox("ok uppdated");
       }
                
    }

    @Override
    public String getAutoNumber() {
        return db.go.getAutoNumber("suppliers","id");
    }

    @Override
    public void getAllRows(JTable table) {
       db.go.fillToJTable("suptest1", table);
    }

    @Override
    public void getOneRows(JTable table) {
       String strSelect="select * from  suptest1 "
               +" where number="+id;
       db.go.fillToJTable(strSelect, table);
    }

    @Override
    public void getCustomRows(String statement, JTable table) {
        db.go.fillToJTable(statement, table);
    }

    @Override
    public String getValueByName(String brand) {
       String strselect ="select id from suppliers"
              +" where brand='"+brand+"'";
      String strval=(String)db.go.getTableData(strselect).Items[0][0];
      return strval;
    }

    @Override
    public String getNameByValue(String value) {
       String strselect ="select brand from suppliers"
              +" where id="+value;
      String strName=(String)db.go.getTableData(strselect).Items[0][0];
      return strName;
    }
    
    
}
