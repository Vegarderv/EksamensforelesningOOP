# Generelle tips

1. Ikke kalle klasser det samme som noe annet (e.g. `List`)
2. Når du returnerer lister etc.; Skal man kunne endre disse?
    - `Collections.unmodifiableList(list)` (og tilsvarende for set, etc.)
    - Kan også bare lage en ny array list med samme elementer (`new ArrayList(list)`)
3. `==` sammenligner referanse i minnet, altså må disse være "helt like" (komme fra samme plass). `#equals` kan være nyttig for å se om to objekter "inneholder" det samme (Og er generelt det man vil bruke). Eksempelvis:
    ```java
    Person person1 = new Person("Vegard");
    Person person2 = new Person("Vegard");
    ```
    Her blir `person1 == person2` til `false`, mens `person1.equals(person2)` (Dersom `#equals()` er implementert slik) vil være `true`. Dersom det ene objektet kan være `null` kan `Objects.equals(person1, person2)` være nyttig da denne sjekker for `null` før den sammenligner.

    For strenger bør `#equals` (eller `#equalsIgnoreCase`) også brukes, men for primitive typer (`int`, `float`, `double`, `boolean`, `char`, `long`) brukes `==`.
4. Såkalt "type parameters" (e.g. `List<type parameter her>`) godtar ikke primitive 

5. Alt pensum ligger her: https://www.ntnu.no/wiki/display/tdt4100/Faginnhold

# Streams

1. Forskjell på `#toList()` (IMMUTABLE) og `.collect(Collectors.toList())` (MUTABLE)