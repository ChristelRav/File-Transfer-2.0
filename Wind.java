package figure;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Wind extends JFrame {
    Pan pan;

    public Wind(){
        pan = new Pan();
        setSize(500, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        this.add(pan.constructPanel());
        setVisible(true);
    }
}
