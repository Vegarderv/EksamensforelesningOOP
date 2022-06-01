# Generelle tips

1. Ikke kalle klasser det samme som noe annet (e.g. `List`)
2. Når du returnerer lister etc.; Skal man kunne endre disse?
    - `Collections.unmodifiableList(list)` (og tilsvarende for set, etc.)
    - Kan også bare lage en ny array list med samme elementer (`new ArrayList(list)`)
3. `==` sammenligner referanse i minnet, altså må disse være "helt like" (komme fra samme plass). `#equals` kan være nyttig for å se om to objekter "inneholder" det samme. Eksempelvis:
  ```java
  Person person1 = new Person("Vegard");
  Person person2 = new Person("Vegard");
  ```
  Her blir 

# Streams

1. Forskjell på `#toList()` (IMMUTABLE) og `.collect(Collectors.toList())` (MUTABLE)