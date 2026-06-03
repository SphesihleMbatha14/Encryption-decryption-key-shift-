import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Display extends JPanel {
   JPanel dis = new JPanel(new BorderLayout());
   public Display(){
      setPreferredSize(new Dimension(750,700));
      setLayout(new BorderLayout());
      setBackground(Color.LIGHT_GRAY);

      //Add the text label
      JPanel st = new JPanel();
      st.setBackground(Color.LIGHT_GRAY);
      st.setPreferredSize(new Dimension(750,150));
      JLabel msg = new JLabel("How can we help you today, would you like to: ");
      msg.setFont(new Font("Georgia",Font.PLAIN,50));
      st.add(msg);
      dis.add(st,BorderLayout.NORTH);

      //now we add the 2 buttons
      JPanel but = new JPanel(new GridLayout(1,2,50,50));
      but.setPreferredSize(new Dimension(750,100));
      but.setBackground(Color.LIGHT_GRAY);
      //Encrption button
      JButton encpButton = new JButton("Encrypt");
      encpButton.setPreferredSize(new Dimension(100,30));
      but.add(encpButton);
      //action listener for this one
      encpButton.addActionListener(e -> {
         encrypt enc = new encrypt();
         dis.removeAll();
         dis.add(enc);
         Display.this.revalidate();
         Display.this.repaint();
       });
      
      

      //decrypt button
      JButton deButton = new JButton("Decrypt");
      deButton.setPreferredSize(new Dimension(100,30));
      
      but.add(deButton);
      deButton.addActionListener(e ->{
         decrypt dee = new decrypt();
         dis.removeAll();
         dis.add(dee);
         Display.this.revalidate();
         Display.this.repaint();
      });
      //filler panel
      JPanel fill = new JPanel();
      fill.setBackground(Color.LIGHT_GRAY);
      fill.setPreferredSize(new Dimension(750,170));
      dis.add(fill,BorderLayout.SOUTH);

      dis.add(but,BorderLayout.CENTER);
      //add dis
      add(dis);
   }
}
