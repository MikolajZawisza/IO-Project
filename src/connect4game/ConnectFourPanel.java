package connect4game;

import java.awt.Color;
import static java.awt.Color.black;
import static java.awt.Color.red;
//import static java.awt.Color.white;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JButton;
import javax.swing.JPanel;


public class ConnectFourPanel extends JPanel implements MouseListener,MouseMotionListener,ActionListener{
    ConnectFourControl con;
    Circle circle;
    Circle circlePlayerOne;
    Circle circlePlayerTwo;
    boolean checkCol;
    Player active;
    private JButton newGameButton;
    private JButton exitButton;
    Color colorNewGame;
    Color colorExit;

    public ConnectFourPanel() throws InterruptedException {
        this.con = new ConnectFourControl();
        active = con.getPlayerOne();
        this.circle = new Circle(new Color(0xFFFFFF));
        this.circlePlayerOne = new Circle(black);
        this.circlePlayerTwo = new Circle(red);
        this.newGameButton = new JButton("Nowa Gra");
        this.exitButton = new JButton("Koniec Gry");
        colorNewGame = new Color(0xFFFFFF);
        colorExit = new Color(0xFFFFFF);
        checkCol = true;

        newGameButton.addActionListener(this);
        exitButton.addActionListener(this);
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    public void insertCircle(MouseEvent me){
        double mX = me.getX();
        double mY = me.getY();
        for(int col=0;col<7;col++){
            if(mX > 2*col+25+col*39 && mX < 2*col+25+col*39+39 && mY > 145 && mY < 388){
                if(con.checkColumn(col)){
                    this.checkCol = true;
                    break;
                }
                else{
                    this.checkCol = false;
                    break;
                }
            }
            this.checkCol = false;
        }
    }

    public void paintCircle(Graphics g){
        for(int row=0;row<6;row++){
            for(int col=0;col<7;col++){
                if(con.getCont(row, col) == 0){
                    g.setColor(circle.getColor());
                    g.fillOval(2*col+25+col*39,2*row+145+row*39,39,39);
                }
                else if(con.getCont(row, col) == 1){
                    g.setColor(circlePlayerOne.getColor());
                    g.fillOval(2*col+25+col*39,2*row+145+row*39,39,39);
                }
                else if(con.getCont(row, col) == 2){
                    g.setColor(circlePlayerTwo.getColor());
                    g.fillOval(2*col+25+col*39,2*row+145+row*39,39,39);
                }
            }
        }
    }

    @Override
    public void paintComponent(Graphics g){

        this.newGameButton.setSize(133, 50);
        this.newGameButton.setForeground(Color.black);
        this.newGameButton.setFont(new Font("Arial",Font.BOLD,18));
        this.newGameButton.setLocation(25, 50);
        this.newGameButton.setBackground(colorNewGame);
        if(this.newGameButton.getModel().isRollover())
            colorNewGame = new Color(0xffcccc);

        this.exitButton.setSize(133, 50);
        this.exitButton.setForeground(Color.black);
        this.exitButton.setFont(new Font("Arial",Font.BOLD,18));
        this.exitButton.setLocation(172, 50);
        this.exitButton.setBackground(colorExit);
        if(this.exitButton.getModel().isRollover())
            colorExit = new Color(0xffcccc);

        add(this.newGameButton);
        add(this.exitButton);

        g.setColor(new Color(0xb7b5b5));
        g.fillRect(0,0,350,510);

        paintCircle(g);
        g.setFont(new Font("Arial",Font.BOLD,18));
        g.setColor(red);
        if(con.getWin()){
            g.drawString("Wygrał gracz nr " + active.getNumber(), 95, 435);
        }
        else if(con.getDraw()){
            g.drawString("Remis" , 140, 435);
        }
        else{
            g.drawString("Tura gracza nr " + active.getNumber(), 99, 435);
        }

    }

    @Override
    public void mouseClicked(MouseEvent me) {

        if(!con.getWin()){
            insertCircle(me);
            con.checkWin();
            repaint(); // Odświeżanie widoku komponentu - paintComponent
            if(checkCol && !con.getWin())
                active = con.changePlayer(active);
        }
    }

    @Override
    public void mouseMoved(MouseEvent me) {
        int startX=me.getX();
        int startY=me.getY();
        colorNewGame = new Color(0xFFFFFF);
        colorExit = new Color(0xFFFFFF);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if(source == this.newGameButton)
        {
            this.con = new ConnectFourControl();
            active = con.getPlayerOne();
            repaint();
        }
        else if(source == this.exitButton)
        {
            System.exit(1);
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent me) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseDragged(MouseEvent me) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
