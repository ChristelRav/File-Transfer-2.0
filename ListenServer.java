package listen;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.util.*;
import figure.Pan;
import fichier.*;

public class ListenServer implements ActionListener{  
   Pan p;
   
   
   public Pan getp() {return p;}     public void setp(Pan p) {this.p = p;}
   
   public ListenServer(Pan p ){ this.setp(p);}

    public void actionPerformed(ActionEvent e){
     try{
            if(e.getSource() instanceof JButton )
            {
                Vector<String> str = new Vector<String>();
                JButton btn =new JButton();
                btn = (JButton)e.getSource();               
                if(btn.getText().equals("ok")){
                    System.out.println("tableau");
                    MyServer s = new MyServer();
                    s.start();
                }
        
            }
        }catch(Exception exp){
          System.out.println(exp);
        }
    }

}