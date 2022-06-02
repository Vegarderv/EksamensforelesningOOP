package no.abakus.observable;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

public class ObservableString {

    private String value;
    private final List<BiConsumer<String, String>> observers;

    public ObservableString(String initialValue) {
        this.value = initialValue;
        this.observers = new ArrayList<>();
    }
    
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        String oldValue = this.value;
        this.value = value;
    
        /*
        for (BiConsumer<String, String> consumer : this.observers) {
            consumer.accept(oldValue, value);
        }
         */

        this.observers.forEach(consumer -> consumer.accept(oldValue, value));
    }    

    public void addObserver(BiConsumer<String, String> observer) {
        if (observer == null) {
            throw new IllegalArgumentException("Observer is null >:(");
        }
        
        this.observers.add(observer);
    }

    @Override
    public String toString() {
        return value;
    }
}
