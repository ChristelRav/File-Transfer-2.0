package figure;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import listen.*;

public class FilePan extends JPanel {
    JLabel lb;
    JLabel lb1 , lb2 , lb3;
    JTextField text1 , text2 , text3;
    JButton get , send;

    public JLabel getLb() {return lb;}                  public void setLb(JLabel lb) {this.lb = lb;}

    public JLabel getLb1() {return lb1;}                public void setLb1(JLabel lb1) {this.lb1 = lb1;}
    public JLabel getLb2() {return lb2;}                public void setLb2(JLabel lb2) {this.lb2 = lb2;}
    public JLabel getLb3() {return lb3;}                public void setLb3(JLabel lb3) {this.lb3 = lb3;}

    public JButton getChoose() {return get;}         public void setChoose(JButton choose) {this.get = choose;}
    public JButton getSend() {return send;}             public void setSend(JButton send) {this.send = send;}

    public JTextField getText1() {return text1;}        public void setText1(JTextField text1) {this.text1 = text1;}
    public JTextField getText2() {return text2;}        public void setText2(JTextField text2) {this.text2 = text2;}
    public JTextField getText3() {return text3;}        public void setText3(JTextField text3) {this.text3 = text3;}

    
}
