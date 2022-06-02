package no.abakus.comparison;

import java.util.Comparator;
import java.util.function.Function;

public class PersonComparator implements Comparator<Person>{

    private static final Comparator<Person> comp = Comparator.comparing((Person person) -> person.getSurname().toLowerCase())
            .thenComparing((Person person) -> person.getFirstName().toLowerCase());

    @Override
    public int compare(Person o1, Person o2) {
        return comp.compare(o1, o2);
    }

    
}
