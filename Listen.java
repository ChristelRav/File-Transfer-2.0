package listen;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.lang.reflect.InaccessibleObjectException;
import java.util.*;
import figure.Panel;
import figure.Fen;
import fichier.*;

public class Listen implements ActionListener{  
   Fen p;
   
   
   public Fen getf() {return p;}     public void setf(Fen p) {this.p = p;}
   
   public Listen(Fen p ){ this.setf(p);}

    public void actionPerformed(ActionEvent e){
     try{
            if(e.getSource() instanceof JButton )
            {
                Vector<String> str = new Vector<String>();
                JButton btn =new JButton();
                btn = (JButton)e.getSource();
                
               
                if(btn.getText().equals("Get")){
                    System.out.println("BUTTON");
                    System.out.println(this.getf().getText().getText());
                    MyServer s = new MyServer();
                    s.setBoo(true);
                     InfoFile info = new InfoFile(new File("REPOSITORY/"+this.getf().getText().getText()));
                     s.setInfoF(info);
                     MyClient c = new MyClient();
                     c.setIp(this.getf().getipField().getText());
                     c.setBoo(true);
                     s.start();
                     c.start();
                     //this.getf().setVisible(false);
                     
                }
            }
        }catch(Exception exp){
          System.out.println(exp);
        }
    }

}


    