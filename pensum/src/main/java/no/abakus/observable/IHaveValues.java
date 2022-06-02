package no.abakus.observable;

public class IHaveValues {
    
    private final ObservableString string1;
    private final ObservableString string2;
    private final ObservableString string3;

    public IHaveValues() {
        this.string1 = new ObservableString("Hei");
        this.string2 = new ObservableString("på");
        this.string3 = new ObservableString("deg");
    }

    public ObservableString getString1() {
        return string1;
    }

    public ObservableString getString2() {
        return string2;
    }

    public ObservableString getString3() {
        return string3;
    }

    @Override
    public String toString() {
        return "IHaveValues [string1=" + string1 + ", string2=" + string2 + ", string3=" + string3 + "]";
    }

    public static void main(String[] args) {
        IHaveValues values = new IHaveValues();
        System.out.println(values);

        values.getString2().addObserver(new Observer());
        values.getString3().addObserver((oldValue, newValue) -> {
            System.out.println(oldValue + " -> " + newValue);
        });

        values.getString3().setValue("Jeg er endret");
        System.out.println(values);
    }
}
