package connect4game;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Admin
 */
public class ConnectFourControlTest {


    /**
     * Test of changePlayer method, of class ConnectFourControl.
     */
    @Test
    public void testChangePlayerOne() {
        System.out.println("changePlayerOne");
        Player active = new Player(1);
        active.setActive(true);                                  //ustawienie gracza nr1 jako aktywnego
        ConnectFourControl instance = new ConnectFourControl();
        int expResult = 2;
        int result = instance.changePlayer(active).getNumber();
        assertEquals(expResult, result);

    }
    @Test
    public void testChangePlayerTwo() {
        System.out.println("changePlayerTwo");
        Player active = new Player(2);
        active.setActive(true);                                  //ustawienie gracza nr2 jako aktywnego
        ConnectFourControl instance = new ConnectFourControl();
        int expResult = 1;
        int result = instance.changePlayer(active).getNumber();
        assertEquals(expResult, result);
    }


    /**
     * Test of checkColumn method, of class ConnectFourControl.
     */
    @Test
    public void testCheckColumnFull() {
        System.out.println("checkColumnFull");
        int k = 0;                                              //numer kolumny do sprawdzenia
        ConnectFourControl instance = new ConnectFourControl();
        for(int i=0;i<6;i++)                                    //wypelnienie kolumny nr 0
            instance.setCont(i, 0, 1);
        boolean expResult = false;
        boolean result = instance.checkColumn(k);
        assertEquals(expResult, result);
    }

    @Test
    public void testCheckColumnEmpty() {
        System.out.println("checkColumnEmpty");
        int k = 0;                                              //numer kolumny do sprawdzenia
        ConnectFourControl instance = new ConnectFourControl();
        boolean expResult = true;
        boolean result = instance.checkColumn(k);
        assertEquals(expResult, result);
    }

    /**
     * Test of checkWin method, of class ConnectFourControl.
     */
    @Test
    public void testCheckWinVertical() {
        System.out.println("checkWinVertical");
        ConnectFourControl instance = new ConnectFourControl();
        for(int i=0;i<4;i++)
            instance.setCont(i, 0, 1);
        instance.checkWin();
        boolean expResult = true;
        boolean result = instance.getWin();
        assertEquals(expResult, result);
    }

    @Test
    public void testCheckWinHorizontal() {
        System.out.println("checkWinHorizontal");
        ConnectFourControl instance = new ConnectFourControl();
        for(int i=0;i<4;i++)
            instance.setCont(0, i, 1);
        instance.checkWin();
        boolean expResult = true;
        boolean result = instance.getWin();
        assertEquals(expResult, result);
    }

    @Test
    public void testCheckWinDiagonall() {
        System.out.println("checkWinVertical");
        ConnectFourControl instance = new ConnectFourControl();
        for(int i=0;i<4;i++)
            instance.setCont(i, i, 1);
        instance.checkWin();
        boolean expResult = true;
        boolean result = instance.getWin();
        assertEquals(expResult, result);
    }

    @Test
    public void testCheckWinDiagonallTwo() {
        System.out.println("checkWinDiagonal");
        ConnectFourControl instance = new ConnectFourControl();

        instance.setCont(3, 0, 1);
        instance.setCont(2, 1, 1);
        instance.setCont(1, 2, 1);
        instance.setCont(0, 3, 1);

        instance.checkWin();
        boolean expResult = true;
        boolean result = instance.getWin();
        assertEquals(expResult, result);
    }

    @Test
    public void testCheckNoWin() {
        System.out.println("checkNoWin");
        ConnectFourControl instance = new ConnectFourControl();
        for(int i=0;i<3;i++)
            instance.setCont(i, 0, 1);
        instance.checkWin();
        boolean expResult = false;
        boolean result = instance.getWin();
        assertEquals(expResult, result);
    }

    /**
     * Test of checkDraw method, of class ConnectFourControl.
     */
    @Test
    public void testCheckDraw() {
        System.out.println("checkDraw");
        ConnectFourControl instance = new ConnectFourControl();
        for(int row=0;row<6;row++){
            for(int col=0;col<7;col++){
                instance.setCont(row, col, 1);
            }
        }
        boolean expResult = true;
        boolean result = instance.checkDraw();
        assertEquals(expResult, result);

    }

}