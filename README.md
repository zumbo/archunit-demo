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

5. Stelle mit einem Test sicher, dass im Business-Layer keine statischen Methoden vorhanden sind, mit Ausnahme von Klassen, die mit Utils enden.  

6. Utils-Klassen, bzw. -Methoden sollen nicht von ausserhalb der Package aufgerufen werden. Um das zu garantieren, 
können wir einfach testen, ob sie public sind oder nicht.   

7. Unser Code sollte nach einer Onion-Architektur aufgebaut sein. 
Zuinnerst haben wir den Business-Core (Package `business`), darum herum die Service-Schicht
(Package `service`) und zuäusserst die Infrastrukturschicht (Package `infrastructure`). 
Stelle sicher, dass keine innere Schicht eine Abhängigkeit auf eine äussere Schicht hat.
Wenn dein Test richtig geschrieben ist, wird er einen Architekturfehler aufdecken. Korrigiere diesen Fehler.   
Implementiere es zuerst mit `dependOnClassesThat()`. Das braucht aber für drei Schichten mindestens zwei Tests.  
Schreibe es so um, dass ein Test reicht. Es gibt dazu die High-Level-Funktionen `layeredArchitecture()`  und `onionArchitecture()`.
Letztere sollte besser an unsere Architektur angepasst sein, aber es gilt zu berücksichtigen, dass wir nur eine Service-Schicht haben 
(`onionArchitecture()` erwartet sowohl Domain Services als auch Application Services) und dass die Main-Applikation noch irgendwie
 in die Zwiebelarchitektur rein muss (oder aus den Tests ausgeschlossen werden muss).
 
 8. Schaue dir die vordefinierten Regeln in com.tngtech.archunit.library.GeneralCodingRules an und probiere sie aus. Versuche sie
  zu verletzen (eine sollte schon verletzt sein).
  
9. Teile die Applikation in Slices (entsprechend den drei Packages) auf und stelle sicher, dass keine zyklischen Abhängigkeiten existieren.
