package no.abakus.functionalinterfaces;

import java.util.function.Predicate;

public class StartsWithEPredicate implements Predicate<String> {

    @Override
    public boolean test(String arg0) {
        return arg0.startsWith("E");
    }
}
