package figure;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JTextField;
import listen.*;

public class Pan extends JPanel {
    JLabel lb;
    JLabel lb1 , lb2 , lb3;
    JTextField text1 , text2 , text3;
    JButton choose , send;

    public JLabel getLb() {return lb;}                  public void setLb(JLabel lb) {this.lb = lb;}

    public JLabel getLb1() {return lb1;}                public void setLb1(JLabel lb1) {this.lb1 = lb1;}
    public JLabel getLb2() {return lb2;}                public void setLb2(JLabel lb2) {this.lb2 = lb2;}
    public JLabel getLb3() {return lb3;}                public void setLb3(JLabel lb3) {this.lb3 = lb3;}

    public JButton getChoose() {return choose;}         public void setChoose(JButton choose) {this.choose = choose;}
    public JButton getSend() {return send;}             public void setSend(JButton send) {this.send = send;}

    public JTextField getText1() {return text1;}        public void setText1(JTextField text1) {this.text1 = text1;}
    public JTextField getText2() {return text2;}        public void setText2(JTextField text2) {this.text2 = text2;}
    public JTextField getText3() {return text3;}        public void setText3(JTextField text3) {this.text3 = text3;}

    public JPanel constructPanel(){
        JPanel pan = new JPanel();
        pan.setLayout(null);

        lb = new JLabel("SERVER TRANSFER");
        lb.setBounds(200, 0, 170, 100);
        pan.add(lb);

        lb1 = new JLabel("IP address");
        lb1.setBounds(100, 80, 100, 40);
        pan.add(lb1);
     
        text1 = new JTextField();
        text1.setBounds(200, 90, 170, 30);
        pan.add(text1);

        send = new JButton("ok");
        send.setBounds(230, 130, 100,30);
        send.addActionListener(new ListenServer(this));
        pan.add(send);

        return pan;
    }
}
