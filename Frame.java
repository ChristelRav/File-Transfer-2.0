package figure;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Frame extends JFrame {
    Panel pan;

    public Frame(){
        pan = new Panel();
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        this.add(pan.constructPanel());
        setVisible(true);
    }
}
