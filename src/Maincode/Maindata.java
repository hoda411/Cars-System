/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Maincode;

import javax.swing.JTable;

/**
 *
 * @author ok
 */
public interface Maindata {
    
    public void add();
    public void delete();
    public void update();
    public String getAutoNumber();
    public void getAllRows(JTable table);
    public void getOneRows(JTable table);
    public void getCustomRows(String statement,JTable table);
    
     public String getValueByName(String name);
      public String getNameByValue(String value);


    
    
}
