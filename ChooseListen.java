package listen;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

import file.Function;

import java.io.*;
import java.lang.reflect.InaccessibleObjectException;
import java.sql.*;
import java.util.*;
import figure.Panel;
import file.*;

public class ChooseListen implements ActionListener{  
   Panel p;
   
   
   public Panel getp() {return p;}     public void setp(Panel p) {this.p = p;}
   
   public ChooseListen(Panel p ){ this.setp(p);}

    public void actionPerformed(ActionEvent e){
     try{
            if(e.getSource() instanceof JButton )
            {
                Vector<String> str = new Vector<String>();
                JButton btn =new JButton();
                btn = (JButton)e.getSource();
                
               
                if(btn.getText().equals("Send")){
                    JFileChooser jfc = new JFileChooser();
                    jfc.setDialogTitle("choose a file to send");
            
                    if(jfc.showOpenDialog(null) == jfc.APPROVE_OPTION){
                       
                    }
                    File f = new File(jfc.getSelectedFile().getAbsolutePath());
                    System.out.println(jfc.getSelectedFile().getAbsolutePath());
                    System.out.println("IP "+this.getp().getText1().getText());
                    System.out.println("PORT "+this.getp().getText2().getText());
                    Server s = new Server();


                    s.setIp(this.getp().getText1().getText());   s.getPort();
                    s.setPathreceive(this.getp().getText2().getText()+"/");
                    s.setFreceive(f);

                    Client c = new Client();
                    c.setFileSend(s.getFreceive());
                 
                    s.start();
                    c.start();

                    s.setFreceive(new File(s.createFilename(c)));
                    System.out.println("AAAAAAAAAAAAAAAA"+s.getFreceive());

                    Server1 s1  = new Server1();
                    s1.setIp("127.0.0.1");   s1.setPort(2015);
                    s1.setPathreceive(this.getp().getText3().getText()+"/");
                    s1.setFreceive(s.getFreceive());
                    
                    s1.start();
                    
                }
            }
        }catch(Exception exp){
          System.out.println(exp);
        }
    }

}


    