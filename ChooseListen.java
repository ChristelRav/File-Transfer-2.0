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
import exception.*;

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
                    MyServer s = new MyServer();
                    s.setIp(this.getp().getText1().getText());
                    s.setPort(Integer.parseInt(this.getp().getText2().getText()));
                    InfoFile inf = new InfoFile(new File(jfc.getSelectedFile().getAbsolutePath()));
                    MyClient c = new MyClient();
                    c.setPort(Integer.parseInt(this.getp().getText2().getText()));
                    c.setInfoF(inf);
                    s.start();
                    c.start();
                }
                if(btn.getText().equals("Get")){
                    int a = 0 ;
                    a++ ;
                    //this.getp().setClic(a);
                    Fen fn = new Fen();
                    System.out.println("MUST OPEN A NEW WINDOW WITH  CMD");
                }
            }
        // }catch(ErreurExcp  es){
        //     System.out.println(es.getMessage());
        //     JOptionPane jop = new JOptionPane();
        //     jop.showMessageDialog(null, es.getMessage(),"ATTENTION", JOptionPane.INFORMATION_MESSAGE);
        // }
        }catch(Exception exp){
            exp.printStackTrace();
           }
    }

}


    