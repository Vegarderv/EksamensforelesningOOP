package no.abakus.arv;

public  class King extends Brikke {

    public King(int x, int y) {
        super(x, y);
    }

    @Override
    public boolean isValidMove(int x, int y) {
        return this.getX() <= x + 1 && this.getX() >= x - 1;
    }

    @Override
    public void move(int x, int y) {
        // TODO Auto-generated method stub
        
    }
    
}
