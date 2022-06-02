package no.abakus.modifiers;

/**
 * En brukerklasse i en applikasjon der
 * flere brukere kan ha samme brukernavn.
 * 
 * Derfor må vi ha en ID slik at vi kan skille
 * brukere fra hverandre.
 */
public class User {

    private int ID = 0;

    private final String username;
    private String password;
    private final int userID;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.userID = ID;
        ID++;
    }

    public int getID() {
        return this.userID;
    }

    public static void main(String[] args) {
        User user1 = new User("Vegard", "12345678");
        User user2 = new User("Eirik", "Lorgen");
        System.out.println(user1.getID());
        System.out.println(user2.getID());
    }

}