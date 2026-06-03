import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.*;

public class theCore extends JFrame{
   public static void main(String[] args){
      //my frame
      JFrame frame = new JFrame("Welcome to encrption or decrption");
      frame.setSize(750,700);

      //mage icon
      ImageIcon image = new ImageIcon("C:\\Users\\Student\\Desktop\\Y3S1\\Math 236\\sweetie.png");
      if(image.getImage() == null){
         System.out.println("Image not found");
      }
      frame.setIconImage(image.getImage());

      //now the outer panel that has ummh
      JPanel outer =  new JPanel(new BorderLayout());
      outer.setBorder(BorderFactory.createEmptyBorder(70,90,70,90));
      outer.setBackground(Color.LIGHT_GRAY);

      //now inner panel
      JPanel inner = new JPanel(new BorderLayout()){
         ImageIcon ints = new ImageIcon("C:\\Users\\Student\\Desktop\\Y3S1\\Math 236\\Untitled.png");
      
         @Override
         protected void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(ints.getImage(),0,0,getWidth(),getHeight(),this);
         }
      };
      // Now lets try to add a label on top of the panel
      JLabel label = new JLabel("Welcome to encrption and decryption");
      label.setForeground(Color.WHITE);
      label.setFont(new Font("Trebuchet MS",Font.CENTER_BASELINE,20));
      inner.setLayout(new BorderLayout());
      inner.setBorder(BorderFactory.createEmptyBorder(100,100,100,100));
      inner.add(label,BorderLayout.NORTH);
      //Now we addd another Jpanel and everything else
      Display disp =  new Display();
      inner.add(disp);

      outer.add(inner);
      frame.add(outer);
      frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
      frame.setVisible(true);
   } 
   //action listener
}
