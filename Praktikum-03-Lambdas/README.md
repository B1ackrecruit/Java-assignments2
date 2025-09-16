
# Programmieren III (Java)
## 3. Praktikum: Lambda-Ausdrücke
Wintersemester 2023  
Christopher Auer

### Lernziele
- Lambda-Ausdrücke erstellen und verwenden
- Funktionen höherer Ordnung
- Funktionale Interfaces
- Funktionale Interfaces mit default-Methoden erweitern

### Hinweise
- Die Praktika sind eine ausgezeichnete Prüfungsvorbereitung; aber nur, wenn Sie sie eigenständig bearbeiten oder es zumindest versuchen. Nachvollziehen der Lösungsvorschläge reicht nicht aus.
- Bearbeiten Sie die Aufgaben vor dem Praktikumstermin.
- Im Praktikum können Sie Ihre Lösung zeigen und Fragen stellen.
- Je nach zeitlichem Verlauf, wird während des Praktikumstermins der Lösungsvorschlag besprochen.
- Der Lösungsvorschlag wird online gestellt, nachdem alle Gruppen das Praktikum durchlaufen haben.

---

## Aufgaben

### Aufgabe 1: Koans
Erstellen Sie eine Klasse **Koans** mit den unten beschriebenen Methoden (alle public static). Erstellen Sie eine JUnit-Test-Klasse **KoansTest** für die Methoden. Verwenden Sie die vordefinierten funktionalen Interfaces aus `java.util.function`. Keine Streams verwenden!

- **mapArray(int[] array, IntUnaryOperator f)**: Wendet f auf jeden Eintrag in array an und schreibt das Ergebnis an die gleiche Stelle. Testen Sie mit Funktionen, die eins hinzuzählen und quadrieren.
- **fillArray(int length, DoubleSupplier s)**: Erstellt einen double-Array der Länge length und belegt ihn mit von s generierten Werten. Testen Sie mit Math.PI und Zufallszahlen.
- **iterateFunction(int length, int first, IntUnaryOperator f)**: Erstellt einen int-Array, der durch wiederholte Anwendung von f gefüllt wird. Testen Sie mit Funktionen, die 1 hinzufügen und verdoppeln.
- **<T> T min(T[] elements, Comparator<T> c)**: Liefert das kleinste Element bezüglich des Comparator. Testen Sie mit Integer und String-Längen.
- **DoubleUnaryOperator createMultiplier(double d)**: Gibt eine Funktion zurück, die das Argument mit d multipliziert. Testen Sie mit verschiedenen Werten.
- **forEachArray(String[] strings, Consumer<String> c)**: Wendet c auf jeden String in strings an. Testen Sie mit einem Konsumenten, der Strings an einen StringBuilder anhängt.
- **<T> Predicate<T> duplicateChecker()**: Gibt ein Prädikat zurück, das true liefert, wenn das Argument schon einmal gesehen wurde. Testen Sie mit verschiedenen Werten.

### Aufgabe 2: Reelle Funktionen
Deklarieren Sie das funktionale Interface **RealFunction**:
```java
@FunctionalInterface
public interface RealFunction {
	double apply(double x);
}
```
Implementieren Sie JUnit-Tests für Ihre Implementierungen.

**Statische Methoden in RealFunction:**
- `constant(double c)`: f(x) = c
- `linear(double a, double b)`: f(x) = ax + b
- `sine(double a, double f)`: f(x) = a sin(f · x)
- `exp()`: f(x) = exp(x)
Verwenden Sie Lambda-Ausdrücke für die Rückgabewerte.

**Default-Methoden in RealFunction:**
- `addTo(RealFunction g)`: Gibt eine Funktion zurück, die die Werte von f und g addiert.
- `composeWith(RealFunction f)`: Gibt die Komposition (f ◦ g)(x) = f(g(x)) zurück.
- `multiplyWith(RealFunction... funs)`: Gibt eine Funktion zurück, die die Werte aller Funktionen multipliziert.
- `approxDiff(double h)`: Gibt die angenäherte Ableitung der Funktion zurück.
- Optional: `max(RealFunction... funs)`: Gibt eine Funktion zurück, die immer den maximalen Funktionswert aller Funktionen liefert.

**Reflexion:**
- Was unterscheidet funktionale Interfaces von nicht-funktionalen Interfaces?
- Was bewirkt die Annotation @FunctionalInterface und warum sollte man sie zu einem funktionalen Interface hinzufügen?