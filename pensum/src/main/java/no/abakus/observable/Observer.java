package no.abakus.observable;

import java.util.function.BiConsumer;

public class Observer implements BiConsumer<String, String>, ObserverInterface {

    @Override
    public void accept(String oldValue, String newValue) {
        System.out.println("Value changed from \"" + oldValue + "\" to \"" + newValue + "\"");
    }

    @Override
    public void onChange(String oldValue, String newValue) {
        System.out.println("Value changed from \"" + oldValue + "\" to \"" + newValue + "\"");
    }
}
