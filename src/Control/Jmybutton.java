
package Control;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author mahmoud magdy
 */
public class Jmybutton extends JButton{
    public Jmybutton  (){
    
    setForeground(Color.white); 
    setCursor(new Cursor(Cursor.HAND_CURSOR));
    
    }
    
    @Override
    protected void paintComponent(Graphics g){
    g.setColor(new Color(70 , 130 , 180));
    g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 20, 20);
    super.paintComponent(g);
    }
    @Override
    protected void paintBorder(Graphics g){
    g.setColor(new Color(0, 102, 153));
    g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 20, 20);
   
    }    
}
