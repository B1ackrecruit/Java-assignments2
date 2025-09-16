
# Programmieren III (Java)
## 4. Praktikum: Streams
Wintersemester 2023  
Christopher Auer

### Lernziele
- Arbeiten mit Streams
- Erzeugen
- Abbilden
- Terminieren
- Aggregieren von Daten mit collect

### Hinweise
- Die Praktika sind eine ausgezeichnete Prüfungsvorbereitung; aber nur, wenn Sie sie eigenständig bearbeiten oder es zumindest versuchen. Nachvollziehen der Lösungsvorschläge reicht nicht aus.
- Bearbeiten Sie die Aufgaben vor dem Praktikumstermin.
- Im Praktikum können Sie Ihre Lösung zeigen und Fragen stellen.
- Je nach zeitlichem Verlauf, wird während des Praktikumstermins der Lösungsvorschlag besprochen.
- Der Lösungsvorschlag wird online gestellt, nachdem alle Gruppen das Praktikum durchlaufen haben.

---

## Aufgaben

### Aufgabe 1: Koans
Erstellen Sie eine Klasse **Koans** mit den unten beschriebenen Methoden (alle public static). Erstellen Sie eine JUnit-Test-Klasse **KoansTest** für die Methoden. Lösen Sie die Aufgaben jeweils mit Streams, ohne Schleifen oder andere Kontrollstrukturen. Verwenden Sie Lambda-Ausdrücke für funktionale Interfaces.

- **distinctEntries(Collection<T> entries)**: Gibt die Anzahl unterschiedlicher Einträge in entries zurück.
- **countEvenNumbers(int[] numbers)**: Gibt die Anzahl gerader Zahlen im Array zurück.
- **intsFromStrings(String... strings)**: Wandelt ein Array von Strings in ein Array von ints um.
- **randomSum(int n)**: Erzeugt einen double-Array ansteigender Zufallszahlen mit n Einträgen.
- **dotProduct(double[] v1, double[] v2)**: Berechnet das Skalarprodukt von v1 und v2.
- **stringsForLength(Collection<String> strings)**: Erstellt eine Map von Stringlängen zu Listen von Strings mit dieser Länge.
- **collatzSeries(int start)**: Erstellt einen unbegrenzten LongStream mit der Collatz-Folge ab start.
- **collatzTruncated(int start)**: Gibt einen LongStream der Collatz-Folge ab start zurück, abgebrochen bei der ersten Wiederholung.
- **collatzOrbit(int start)**: Prüft, ob die Collatz-Folge von start im Orbit 4, 2, 1 endet.
- **collatzTrueForLimit(int limit)**: Prüft die Collatz-Vermutung für alle Zahlen von 1 bis limit (parallelisiert).
- **fibonacciStream()**: Erstellt einen unbegrenzten LongStream mit der Fibonacci-Folge.

### Aufgabe 2: Videospiel-Sammlung
Modellieren Sie eine Spielesammlung in Java gemäß folgendem Klassendiagramm:

- **Platform**: name, company, equals, hashCode, compareTo
- **Genre**: Enumeration
- **Game**: name, genre, platform, releaseYear, metacriticScore, equals, hashCode, compareTo
- **GamesLibrary**: platforms (Set<Platform>), games (Set<Game>), Methoden zum Hinzufügen/Entfernen, und weitere Methoden

Implementieren Sie die Methoden in GamesLibrary ausschließlich mit Streams und testen Sie diese:
- `Game getBestGame()`
- `List<Game> sortGamesByMetacriticScore()`
- `List<Game> sortGamesByReleaseYear()`
- `double getAverageMetacriticScore()`
- `List<Game> getGamesForGenre(Genre genre)`
- `boolean gameReleasedBetween(int begin, int end)`
- `Map<Platform, List<Game>> getGamesForPlatform()`
- `Platform getBestPlatform()`
- `List<Genre> getGenresWithGames()`
- `List<Game> topGames(long n)`
- `String getTopTenListString()`
- `Map<Genre, Long> getGenreCount()`
- `Map<Platform, Double> getAverageScoreForPlatform()`