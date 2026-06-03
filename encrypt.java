import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class encrypt extends JPanel{
   JPanel encryption = new JPanel(new BorderLayout());
   public int shouldI = 0;        
   JPanel low = null;             

   public encrypt(){
      setPreferredSize(new Dimension(750,700));
      setBackground(Color.LIGHT_GRAY);
      add(encryption);

      //create our first upper panel
      JPanel up = new JPanel(new GridLayout(2,2,20,20));
      up.setBackground(Color.LIGHT_GRAY);
      //lable
      JLabel sent = new JLabel("Enter the sentence you want to encrypt:");
      sent.setFont(new Font("ariel",Font.PLAIN,20));
      up.add(sent);
      //text
      JTextField sentence = new JTextField();
      up.add(sentence);
      //label 2
      JLabel input = new JLabel("Please enter the key: ");
      input.setFont(new Font("ariel",Font.PLAIN,20));
      up.add(input);
      //text 2
      JTextField key = new JTextField();
      up.add(key);

      add(up,BorderLayout.CENTER);

      //action listener after the key
      key.addActionListener( e ->{
         int lock = Integer.parseInt(key.getText());
         char[] alpha = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
         String fta =  "";
         sentence.setText(sentence.getText().toLowerCase());

         //Tokenation
         for(int i=0; i<(sentence.getText()).length(); i++){
            if(Character.isLetter((sentence.getText()).charAt(i))){
               for(int t=0; t<26; t++){
                  if(sentence.getText().charAt(i)== alpha[t]){
                     if(((t+lock)>25)){
                        int no = reducer(t+lock);
                        fta += alpha[no];
                     }else{
                        fta += alpha[t+lock];
                        break;
                     }
                  }
               }
            }else{
               fta += (sentence.getText()).charAt(i);
            } 
         }

         //Lower panel
         if(shouldI > 0){
            remove(low);           
         }
         low = new JPanel(new BorderLayout(1,1));       
         low.setPreferredSize(new Dimension(750,200));
         JTextField answer = new JTextField("Your encrypted message is: "+ fta);
         answer.setSize(750,100);
         answer.setEditable(false);
         answer.setFont(new Font("Arial",Font.PLAIN,25));
         //create the back button
         ImageIcon icon = new ImageIcon("C:\\Users\\Student\\Desktop\\Y3S1\\Math 236\\Back.png");
         Image img = icon.getImage().getScaledInstance(750, 300, Image.SCALE_SMOOTH);
         ImageIcon backMg = new ImageIcon(img);
         JButton back = new JButton(backMg);
         back.setPreferredSize(new Dimension(750, 70));
         low.add(answer,BorderLayout.NORTH);
         low.add(back,BorderLayout.CENTER);

         //actionListener for the buttton(Usng a different one because I cant declare e again inside it)
       back.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e){
            JPanel dis = (JPanel) encrypt.this.getParent();
            dis.removeAll();
            dis.setPreferredSize(new Dimension(750,700));
            dis.add(new Display());
            dis.revalidate();
            dis.repaint();
         }
      });
         add(low,BorderLayout.SOUTH);
         shouldI++;

         //again we refresh
         revalidate();
         repaint();
      });
   }

   public static int reducer(int numb){
      while (numb>25){
         numb -= 26;
      }
      return numb;
   }
}