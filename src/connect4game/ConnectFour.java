package connect4game;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class ConnectFour extends JFrame{


    public ConnectFour() throws InterruptedException {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int locX=(int) dim.getWidth()*4/12;
        int locY=(int) dim.getHeight()*2/12;
        ConnectFourPanel pan = new ConnectFourPanel();
        this.setTitle("Projekt Zaliczeniowy / 4 w rzędzie / 22.01.2019 / MZ ");
        this.setSize(350,520);
        this.setLocation(locX, locY);
        this.add(pan);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setFocusable(true);
        this.setResizable(false);
    }

    public static void main(String[] args) throws InterruptedException {
        new ConnectFour();
    }

}