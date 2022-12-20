package figure;

import javax.swing.JFrame;

import java.util.Vector;

import javax.swing.*;
import javax.swing.table.*;

import org.w3c.dom.Text;

import fichier.*;
import java.awt.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.sql.*;
import java.lang.reflect.*;
import listen.*;
public class Fen extends JFrame {
    JTable table;
    JLabel att;
    JLabel att2;
    JButton ok;
    JTextField text;
    JTextField ip;
    public JTextField getText() {
        return text;
    }
    public void setText(JTextField text) {
        this.text = text;
    }
    public JTextField getipField() {
        return ip;
    }
    public void setipgetipField(JTextField text) {
        this.ip = text;
    }
    public Fen(){     
        JFrame f = new JFrame("Affiche Salaire  Employe");
        MyServer s = new MyServer();
        Vector<String> vs = s.checkFile();
        Vector<String> title = new  Vector<String>();
        title.add("The Files");
        String [] titre = new String [title.size()];
        titre [0] = title.get(0);
        Vector< Vector<String>> vvs = new Vector< Vector<String> >();
        vvs.add(vs);
        String [][] str = new String [vs.size()][title.size()];
        for (int i = 0; i < vvs.size(); i++) {
            for (int j = 0; j < vvs.get(i).size() ; j++) {
             str [j][i]= vvs.get(i).get(j);              
            }
        }
          table = new JTable(str,titre);
          JScrollPane scroll = new JScrollPane(table);

          att= new JLabel("copy file");
          att.setBounds(50,220, 300, 100);
          att2= new JLabel("Ip Address");
          att2.setBounds(30,120, 300, 100);
          text = new JTextField();
          text.setBounds(100, 250, 200, 30);
          ip = new JTextField();
          ip.setBounds(100, 150, 200, 30);

          ok = new JButton("Get");
          ok.setBounds(200, 285, 75, 50);

          scroll.setPreferredSize(new Dimension(200, 300));
          this.add(ok);
          this.add(text);
          this.add(ip);
          this.add(att);
          this.add(att2);
          this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
          this.getContentPane().add(scroll);
          this.setSize(400, 500);
          ok.addActionListener(new Listen(this));
          this.setVisible(true);
        }
    
}
