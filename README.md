## 1. Aufgabe
Gegeben sei folgendes UML Diagramm.

![image](https://user-images.githubusercontent.com/69506130/124186658-eecc3800-dabc-11eb-9264-8f93bbc6980a.png)

Ergänzend sind Ihnen folgende Hinweise für die Implementierung gegeben. Eine Uhrzeit soll wie
folgt angelegt werden können:

Uhrzeit u = new Uhrzeit(12, 54);

Mittels System.out.println(u) soll eine Uhrzeit wie folgt ausgegeben werden können:
- 12:54 Uhr
Ein Mitarbeiter soll wie folgt angelegt:
- Mitarbeiter m = new Mitarbeiter("Max", "Mustermann", "max@htwsaar.de");
und mittels System.out.println(m) wie folgt ausgegeben werden können:
- Max Mustermann (max@htwsaar.de)
Ein Raum soll wie folgt angelegt:
- Raum r = new Raum(18, 0, 1);
und mittels System.out.println(r) wie folgt ausgegeben werden können:
- Raum 18-0.1
Mitarbeiter können Räume wie folgt reservieren. Sind beispielsweise die folgenden Mitarbeiter und
Räume gegeben
- Mitarbeiter m1 = new Mitarbeiter("Max", "Mustermann", "max@htwsaar.de"));
- Mitarbeiter m2 = new Mitarbeiter("John", "Doe", "john@htwsaar.de"));
- Raum r1 = new Raum(18,0,1);
- Raum r2 = new Raum(2,1,9);
- Raum r3 = new Raum(2,1,10);
und werden zusätzlich die folgenden Anweisungen ausgeführt
- m1.reserviere(r1, new Uhrzeit(12, 30), new Uhrzeit(14, 30), "VOOP");
- m1.reserviere(r2, new Uhrzeit(14, 30), new Uhrzeit(16, 30), "WebTech");
- m2.reserviere(r2, new Uhrzeit(12, 30), new Uhrzeit(13, 30), "Prog II");
- m2.reserviere(r3, new Uhrzeit(9, 30), new Uhrzeit(11,30), "ITM");
dann soll die Raumausgabe von System.out.println(r1) nun zusätzliche Reservierungsinformationen beinhalten:
- Raum 18-0.1
- gebucht von Max Mustermann (max@htwsaar.de) von 12:30 Uhr bis 14:30 für VOOP
Auch die Ausgabe von System.out.println(r2) soll dann diese Ausgabe erzeugen:
- Raum 2-1.9
- gebucht von Max Mustermann (max@htwsaar.de) von 14:30 Uhr bis 16:30 für WebTech
- gebucht von John Doe (john@htwsaar.de) von 12:30 Uhr bis 13:30 Uhr für Prog II
Gleiches gilt für die Ausgabe von System.out.println(r3):
- Raum 2-1.10
- gebucht von John Doe (john@htwsaar.de) von 9:30 Uhr bis 11:30 Uhr für ITM
Setzen Sie das Klassendiagramm unter Berücksichtigung der Implementierungshinweise sowie
der folgenden ergänzenden Hinweise bitte in Java Code um.
- Beachten Sie bitte, dass Sie offenbar über Assoziationen von Räumen auf Mitarbeiter schließen
können müssen. Diese Beziehungen müssen also mittels geeigneter Methoden verwaltet
werden.
- Sie müssen keine Doppelbelegungen erkennen oder zeitlichen Sortierungen bei den Ausgaben vornehmen.
- Sie müssen ebenso keine Reservierungsrücknahmen, Umbuchungen oder ähnliches berücksichtigen.
- Der Index bei der Funktion getReservierung(int index) beginnt bei 0.
## 2. Aufgabe
Implementieren Sie ein Dialog-Programm zum Testen der in Aufgabe 1 implementierten Klassen.
