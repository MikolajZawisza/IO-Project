package connect4game;

public class Player {
    private int number;
    private boolean active;

    public Player(int number) {
        this.number = number;
        this.active = false;
    }

    public int getNumber() {
        return number;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

}

