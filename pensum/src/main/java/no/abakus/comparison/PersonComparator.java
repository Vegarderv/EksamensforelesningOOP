package no.abakus.comparison;

import java.util.Comparator;

public class PersonComparator implements Comparator<Person>{

    private static final Comparator<Person> comp = Comparator.comparing(Person::getSurname).thenComparing(Person::getFirstName);

    @Override
    public int compare(Person o1, Person o2) {
        return comp.compare(o1, o2);
    }

    
}
