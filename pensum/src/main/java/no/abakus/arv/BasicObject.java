package no.abakus.arv;

public class BasicObject {

    private String str;
    private int number;

    @Override
    public String toString() {
        return "String:" + str + " ,Number" + number;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object arg0) {
        if (!(arg0 instanceof BasicObject)) {
            return false;
        }
        BasicObject obj = (BasicObject) arg0;
        return this.str.equals(obj.getStr()) && this.number == obj.number;
    }
    
}
