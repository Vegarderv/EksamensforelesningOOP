package no.abakus.observable;

public interface ObserverInterface {
    
    void onChange(String oldValue, String newValue);
}
