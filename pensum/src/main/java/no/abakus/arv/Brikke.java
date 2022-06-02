package no.abakus.arv;

public abstract class Brikke implements IBrikke {
    
    private int x;
    private int y;

    public Brikke(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int getX() {
        return x;
    }
    protected void setX(int x) {
        if (x <= 8 && x >= 0) {
            this.x = x;
        }
    }
    public int getY() {
        return y;
    }
    protected void setY(int y) {
        if (y <= 8 && y >= 0) {
            this.y = y;
        }
    }

    public abstract boolean isValidMove(int x, int y);
    
    public abstract void move(int x, int y);
}
