# Funksjonelle Grensesnitt

## Definisjon

Fra [Java docs](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/function/package-summary.html):

> Functional interfaces provide target types for lambda expressions and method references. Each functional interface has a single abstract method, called the functional method for that functional interface, to which the lambda expression's parameter and return types are matched or adapted.

**???????**

Litt mer "casual" definisjon; funksjonelle grensesnitt definerer grensesnitt som representerer vanlige tilfeller av funksjoner/metoder som f. eks. en funksjon som tar inn noe og spytter ut noe annet, eller en funksjon som bare spytter ut noe uten input.

Basic oppskrift for funksjonelle grensesnitt:
 1. Finn et mønster for metoder som er brukt mye (eks. en funksjon som tar inn en type av noe og spytter ut noe annet)
 2. Smack inn noe type parameters
 3. ???
 4. **Profit**

En generisk funksjon med et argument og en return-type:
```java
public interface Function<T,R> {
  public abstract  R apply(T arg0);
}
```

Heldigvis skal vi sjeldent lage funksjonelle grensesnitt. Java definerer disse for oss i [java.util.function-pakken](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/function/package-summary.html).

## Viktige eksempler

 - `Function`
 - `Consumer`
 - `Supplier`
 - `Predicate`

Disse har gjerne også special cases for
 - Flere argumenter (e. g. `BiConsumer`)
 - Primitives (e. g. `DoubleSupplier`) 

 Brukt mye i streams!