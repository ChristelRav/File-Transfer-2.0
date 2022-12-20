package figure;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JTextField;
import listen.*;
import exception.*;
public class Panel extends JPanel {
    JLabel lb;
    JLabel lb1 , lb2 , lb3;
    JTextField text1 , text2 , text3;
    JButton get , send;
    int clic = 0;

    public int getClic() throws Exception {
        if (this.clic == 1) {
            String er = "Re-ouvrir tout la fenetre";
            ErreurExcp ee = new ErreurExcp(er);
            throw ee;
            // JOptionPane jop = new JOptionPane();
            // jop.showMessageDialog(null, ee.getMessage(),"ATTENTION", JOptionPane.INFORMATION_MESSAGE);

        }
        return clic;
    }
    public void setClic(int clic) {
        this.clic = clic;
    }

    public JLabel getLb() {return lb;}                  public void setLb(JLabel lb) {this.lb = lb;}

    public JLabel getLb1() {return lb1;}                public void setLb1(JLabel lb1) {this.lb1 = lb1;}
    public JLabel getLb2() {return lb2;}                public void setLb2(JLabel lb2) {this.lb2 = lb2;}
    public JLabel getLb3() {return lb3;}                public void setLb3(JLabel lb3) {this.lb3 = lb3;}

    public JButton getChoose() {return get;}         public void setChoose(JButton choose) {this.get = choose;}
    public JButton getSend() {return send;}             public void setSend(JButton send) {this.send = send;}

    public JTextField getText1() {return text1;}        public void setText1(JTextField text1) {this.text1 = text1;}
    public JTextField getText2() {return text2;}        public void setText2(JTextField text2) {this.text2 = text2;}
    public JTextField getText3() {return text3;}        public void setText3(JTextField text3) {this.text3 = text3;}

    public JPanel constructPanel(){
        JPanel pan = new JPanel();
        pan.setLayout(null);

        lb = new JLabel("CLIENT TRANSFER");
        lb.setBounds(200, 0, 170, 100);
        pan.add(lb);

        lb1 = new JLabel("IP address");
        lb1.setBounds(100, 80, 100, 40);
        pan.add(lb1);
        lb2 = new JLabel("Port");
        lb2.setBounds(100, 130, 100, 40);
        pan.add(lb2);
     
        text1 = new JTextField();
        text1.setBounds(200, 90, 170, 30);
        pan.add(text1);
        text2 = new JTextField();
        text2.setBounds(200, 140, 170, 30);
        pan.add(text2);

        get = new JButton("Get");
        get.setBounds(230, 250, 100,30);
        get.addActionListener(new ChooseListen(this));
       // pan.add(get);

        send = new JButton("Send");
        send.setBounds(230, 200, 100,30);
        send.addActionListener(new ChooseListen(this));
        pan.add(send);

        return pan;
    }
}
