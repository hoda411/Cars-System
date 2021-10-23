
package Control;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author mahmoud magdy
 */
public class Jmycombo extends JComboBox {
    public Jmycombo  (){
    setOpaque(false);
    }
    
    @Override
    protected void paintComponent(Graphics g){
    g.setColor(getBackground());
    g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 20, 20);
    super.paintComponent(g);
    }
    @Override
    protected void paintBorder(Graphics g){
  g.setColor(new Color(0, 102, 153));
    g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 20, 20);
   
    }    
}
