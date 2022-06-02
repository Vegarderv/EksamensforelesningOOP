package no.abakus.iteration;

import java.util.Iterator;

public class NumberIterator implements Iterator<Integer> {

    private int numOfInts;
    private int currentInt = 0;

    public NumberIterator(int numOfInts) {
        this.numOfInts = numOfInts;
    }

    @Override
    public boolean hasNext() {
        return currentInt < numOfInts;
    }

    @Override
    public Integer next() {
        if (!this.hasNext()) {
            throw new IllegalStateException();
        }
        currentInt++;
        return currentInt - 1;
    }
    
}
