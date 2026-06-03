import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class decrypt extends JPanel{
   JPanel decryption = new JPanel(new BorderLayout());
   public int shouldI = 0;        
   JPanel low = null; 

   public decrypt(){
      setPreferredSize(new Dimension(750,700));
      setBackground(Color.LIGHT_GRAY);
      add(decryption);

      JPanel up = new JPanel(new GridLayout(2,2,20,20));
      up.setBackground(Color.LIGHT_GRAY);
      JLabel sent = new JLabel("Enter the sentence you want to decrypt:");
      sent.setFont(new Font("ariel",Font.PLAIN,20));
      up.add(sent);
      JTextField sentence = new JTextField();
      up.add(sentence);
      JLabel input = new JLabel("Please enter the key: ");
      input.setFont(new Font("ariel",Font.PLAIN,20));
      up.add(input);
      JTextField key = new JTextField();
      up.add(key);

      decryption.add(up,BorderLayout.CENTER);

      key.addActionListener( e ->{
         int lock = Integer.parseInt(key.getText());
         char[] alpha = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
         String fta =  "";
         sentence.setText(sentence.getText().toLowerCase());

         for(int i=0; i<(sentence.getText()).length(); i++){
            if(Character.isLetter((sentence.getText()).charAt(i))){
               for(int t=0; t<26; t++){
                  if(sentence.getText().charAt(i)== alpha[t]){
                     if(((t-lock)<0)){
                        int no = reducer(t-lock);
                        fta += alpha[no];
                     }else{
                        fta += alpha[t-lock];
                        break;
                     }
                  }
               }
            }else{
               fta += (sentence.getText()).charAt(i);
            } 
         }

         if(shouldI > 0){
            decryption.remove(low);           
         }
         low = new JPanel(new BorderLayout(1,1));       
         low.setPreferredSize(new Dimension(750,200));
         JTextField answer = new JTextField("Your decrypted message is: "+ fta);
         answer.setSize(750,100);
         answer.setEditable(false);
         answer.setFont(new Font("Arial",Font.PLAIN,25));
         
         ImageIcon icon = new ImageIcon("C:\\Users\\Student\\Desktop\\Y3S1\\Math 236\\Back.png");
         Image img = icon.getImage().getScaledInstance(750, 300, Image.SCALE_SMOOTH);
         ImageIcon backMg = new ImageIcon(img);
         JButton back = new JButton(backMg);
         back.setPreferredSize(new Dimension(750, 70));
         low.add(answer,BorderLayout.NORTH);
         low.add(back,BorderLayout.CENTER);

         back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
               JPanel dis = (JPanel) decrypt.this.getParent();
               dis.removeAll();
               dis.setPreferredSize(new Dimension(750,700));
               dis.add(new Display());
               dis.revalidate();
               dis.repaint();
            }
         });
         decryption.add(low,BorderLayout.SOUTH);
         shouldI++;

         decryption.revalidate();
         decryption.repaint();
      });
      
   }
   public static int reducer(int numb){
      while (numb<0){
         numb += 26;
      }
      return numb;
   }
}