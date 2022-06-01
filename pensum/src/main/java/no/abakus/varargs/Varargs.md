# Varargs - variabelt antall argumenter

## Eksempel

Finn maks av 5 tall

```java
public double max(double d1, double d2, double d3, double d4, double d5) {
    double max = d1;
    if (d2 > max) {
        max = d2;
    }

    if (d3 > max) {
        max = d3;
    }

    if (d4 > max) {
        max = d4;
    }

    if (d5 > max) {
        max = d5;
    }

    return max;
}
```

Finn maks av 10 tall? Finn maks av ukjent antall?

Bruker et array *(Eller en liste)*!

```java
public double max(double[] numbers) {
    if (numbers.length == 0) {
        throw new IllegalArgumentException("No numbers >:(");
    }
    
    // Legg merke til at vi her starter med å sette til verdi 
    // på indeks 0!
    double max = numbers[0];

    // Og derfor her kan starte løkken på i = 1 istedenfor i = 0
    for (int i = 1; i < numbers.length; i++) {
        if (numbers[i] > max) {
            max = numbers[i];
        }
    }

    return max;
}
```

Ok, mye ryddigere ista! Men hvordan blir det dersom vi skal bruke dette?

```java
double maxVal = max(new double[]{1.1, 2.3, 4.5, 6.7});
```

Litt tungtvint.

**VARARGS**

```java
// Legg merke til at eneste endring her vs. tidligere er at [] har blitt
// "...". Det er fordi når du definerer en metode med varargs vil 
// argumentet bli behandlet av java som et array 
public double max(double... numbers) {
    if (numbers.length == 0) {
        throw new IllegalArgumentException("No numbers >:(");
    }
    
    // Legg merke til at vi her starter med å sette til verdi 
    // på indeks 0!
    double max = numbers[0];

    // Og derfor her kan starte løkken på i = 1 istedenfor i = 0
    for (int i = 1; i < numbers.length; i++) {
        if (numbers[i] > max) {
            max = numbers[i];
        }
    }

    return max;
}
```

Nå kan vi skrive;
```java
double maxVal = max(1.1, 2.3, 4.5, 6.7);
```

Viktig å huske: **Varargs argumenter kan ta imot 0 verdier, dvs. ingen verdier!** `max()` er altså nå et lovlig kall, helt uten noen argumenter. Vi må derfor validere. Dette kan gjøres sånn som vist over, altså tilsvarende som om man tok inn et array, eller kan gjøres ved å utnytte at vi også kan kombinere varargs med normale argumenter, slik;

```java
public double max(double num1, double... numbers) {
    double max = num1;

    for (int i = 0; i < numbers.length; i++) {
        if (numbers[i] > max) {
            max = numbers[i];
        }
    }

    return max;
}
```