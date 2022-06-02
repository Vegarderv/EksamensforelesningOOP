package no.abakus.comparison;

import java.util.Arrays;
import java.util.List;

public class PersonSorter {

    public static void main(String[] args) {
        Person user1 = new User("Vegard", "Ervik");
        Person user2 = new User("egard", "rvik");
        Person user3 = new User("egard", "Ervik");
        List<Person> personList = Arrays.asList(user1, user2, user3);
        System.out.println(personList);
        personList.sort(new PersonComparator());
        System.out.println(personList);
    }
    
}
