##Aufgaben

1. Wirf einen Blick in `src/test/java`.  
Führe die Tests aus und schaue, ob sie grün werden.  

2. Vergleiche die Tests mit ArchUnit-Annotationen (`ArchCompilanceTest.java`) mit den herkömlichen JUnit-Tests (`ArchCompilanceTestJUnitStyle.java`).
Warum braucht @AnalyzeClasses eine ImportOption?  

3. Wir arbeiten nun mit dem ArchUnit-Stil (`ArchCompilanceTest.java`)  weiter. 
Studiere, was der Test überprüft. Ändere den Code so, dass der Test fehlschlägt.
(Und wieder zurück, damit wir weiterarbeiten können.) 

4. Schreibe einen Test, der sicherstellt, dass unsere Service-Klassen mit der Spring-@Service-Annotation versehen sind.
Stelle auch sicher, dass ausserhalb der Service-Package keine @Service-Annotationen vorhanden sind.

5. Stelle mit einem Test sicher, dass im Business-Layer keine statischen Methoden vorhanden sind, 
es sei denn, sie befinden sich in einer Klasse, deren Name mit Utils endet.  

6. Utils-Klassen, bzw. -Methoden sollen nicht von ausserhalb der Package aufgerufen werden. Um das zu garantieren, 
können wir einfach testen, ob sie public sind oder nicht.   

5. Unser Code sollte nach einer Onion-Architektur aufgebaut sein. 
Zuinnerst haben wir den Business-Core (Package `business`), darum herum die Service-Schicht
(Package `service`) und zuäusserst die Infrastrukturschicht (Package `service`). 
Stelle sicher, dass keine innere Schicht eine Abhängigkeit auf eine äussere Schicht hat.  
Implementiere es zuerst mit `dependOnClassesThat()`. Das braucht aber für drei Schichten mindestens zwei Tests.  
Schreibe es so um, dass ein Test reicht  (Hint: In der Doku nach `layeredArchitecture()` suchen).  
Wenn dein Test richtig geschrieben ist, wird er einen Architekturfehler aufdecken. Korrigiere diesen Fehler. 
  
 
 
  

 