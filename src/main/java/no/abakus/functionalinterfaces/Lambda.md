# Lambda

Dersom et grensesnitt i java har bare 1 metode som skal implementeres (1 abstrakt metode), kan det defineres på såkalt lambda form. Spesielt mye brukt for funksjonelle grensesnitt.

**Eksempel:**

Ønsker å finne alle fra en liste som oppfyller noe krav. Dette er da et såkalt `Predicate` (Funksjon fra gitt type til boolsk verdi). Vi kan da definere et krav om at alle personer skal ha navn som starter med `E` slik

```java
Predicate<Person> predicate = new Predicate<Person>() {
    @Override
    public boolean test(Person person) {
        return person.getName().startsWith("E");
    }
}
```

Mye kode for veldig lite! Lambdaversjon;
```java
Predicate<Person> predicate = person -> person.getName().startsWith("E");
```
(Husk paranteser dersom du skal ta inn flere verdier)

## Method reference

Hva om vi har en metode allerede som gjør det vi ønsker? 

```java
public boolean doesNameStartWithE(Person person) {
    return person.getName().startsWith("E");
}
```
