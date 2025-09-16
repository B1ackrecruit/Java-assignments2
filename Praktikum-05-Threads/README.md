# Programmieren III (Java)
## 5. Praktikum: Threads
Wintersemester 2023  
Christopher Auer

### Lernziele
- Nebenläufigkeit mit Threads
- Parallelisieren einer for-Schleife
- Parallelisieren einer Verarbeitungs-Pipeline
- Synchronisieren von Threads

### Hinweise
- Die Praktika sind eine ausgezeichnete Prüfungsvorbereitung; aber nur, wenn Sie sie eigenständig bearbeiten oder es zumindest versuchen. Nachvollziehen der Lösungsvorschläge reicht nicht aus.
- Bearbeiten Sie die Aufgaben vor dem Praktikumstermin.
- Im Praktikum können Sie Ihre Lösung zeigen und Fragen stellen.
- Je nach zeitlichem Verlauf, wird während des Praktikumstermins der Lösungsvorschlag besprochen.
- Der Lösungsvorschlag wird online gestellt, nachdem alle Gruppen das Praktikum durchlaufen haben.

---

## Aufgaben

### Aufgabe 1: Das Thread-Rennen
Deklarieren Sie eine Klasse **ThreadRace** mit einer main-Methode und einem privaten statischen Attribut int raceCounter. Die main-Methode setzt raceCounter auf 0, startet zwei Threads (threadA und threadB), wartet 10 Sekunden, unterbricht beide Threads und gibt den Wert von raceCounter aus. Beide Threads führen eine Schleife aus, die eine aufwändige Rechnung (fib(35)) ausführt und raceCounter inkrementiert bzw. dekrementiert. Synchronisieren Sie den Zugriff auf raceCounter mit einem synchronized-Block. Probieren Sie verschiedene Varianten des kritischen Abschnitts aus und interpretieren Sie die Werte von raceCounter.

### Aufgabe 2: Bildverarbeitung
Verarbeiten Sie Bilddateien mit Hilfe der Klasse ImageUtils.java. Implementieren Sie die statische Methode **filterImage** in der Klasse ImageFilter, die ein Bild mit einer Filteroperation bearbeitet. Implementieren Sie außerdem die Methode **filterImageParallel**, die die Filteroperation auf mehrere Threads aufteilt. Erweitern Sie die main-Methode in ImageFilter, sodass Bilder geladen, gefiltert und gespeichert werden können. Probieren Sie verschiedene Filteroperationen aus (Inversion, Binarisierung, Posterize).

### Aufgabe 3: Pipeline
Implementieren Sie eine Verarbeitungs-Pipeline für mehrere Bilddateien mit den Klassen ImageFilterPipeline und ImageFilter. Die Pipeline besteht aus den Schritten loadImages, filterImages und saveImages, die jeweils in eigenen Threads laufen und über ReentrantLocks und Conditions synchronisiert werden. Die Pipeline soll erst beenden, wenn alle Dateien bearbeitet wurden.

---

**Hinweis:** Für dieses Praktikum wurde keine Lösung erstellt.
