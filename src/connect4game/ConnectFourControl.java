package connect4game;

public class ConnectFourControl {
    private int cont[][];
    private boolean win;
    private boolean draw;
    private Player playerOne;
    private Player playerTwo;

    public ConnectFourControl() {
        this.playerOne = new Player(1);
        this.playerTwo = new Player(2);
        this.cont = new int[6][7];
        this.win = false;
        this.draw = false;
        this.playerOne.setActive(true);

        for(int row=0;row<6;row++){
            for(int col=0;col<7;col++){
                cont[row][col]=0;
            }

        }

    }

    public void setCont(int i, int j, int value) {
        this.cont[i][j] = value;
    }


    public int getCont(int i, int j) {
        return cont[i][j];
    }

    public boolean getWin() {
        return win;
    }

    public boolean getDraw() {
        return draw;
    }

    public Player getPlayerOne() {
        return playerOne;
    }



    public Player changePlayer(Player active){
        if(active.getActive())
        {
            active.setActive(false);
            if(active.getNumber() == 1){
                playerTwo.setActive(true);
                return playerTwo;
            }
            else{
                playerOne.setActive(true);
                return playerOne;
            }
        }
        else return active;
    }

    public boolean checkColumn(int i){
        for(int row=5;row>=0;row--){
            if(cont[row][i] == 0){
                if(playerOne.getActive())
                    cont[row][i]=playerOne.getNumber();
                else if(playerTwo.getActive())
                    cont[row][i]=playerTwo.getNumber();
                return true;
            }
        }
        return false;
    }

    public void checkWin(){
        Player active;
        if(playerOne.getActive())
            active = playerOne;
        else
            active = playerTwo;

        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 7; col++) {
                if (cont[row][col] != active.getNumber()) {
                    continue;
                }

                if (row + 3 < 6 && cont[row][col] == cont[row+1][col] && cont[row][col] == cont[row+2][col] && cont[row][col] == cont[row+3][col]) {
                    win = true;
                }

                if (col + 3 < 7) {
                    if (cont[row][col] == cont[row][col+1] && cont[row][col] == cont[row][col+2] && cont[row][col] == cont[row][col+3]) {
                        win = true;
                    }
                    if (row + 3 < 6 && cont[row][col] == cont[row+1][col+1] && cont[row][col] == cont[row+2][col+2] && cont[row][col] == cont[row+3][col+3]) {
                        win = true;
                    }
                    if (row - 3 >= 0 && cont[row][col] == cont[row-1][col+1] && cont[row][col] == cont[row-2][col+2] && cont[row][col] == cont[row-3][col+3]) {
                        win = true;
                    }
                }
            }
        }
        if(win != true)
            checkDraw();

    }

    public boolean checkDraw(){
        for(int row=0;row<6;row++){
            for(int col=0;col<7;col++){
                if(cont[row][col] == 0){
                    this.draw = false;
                    return false;
                }
            }
        }
        this.draw = true;
        return true;
    }
}