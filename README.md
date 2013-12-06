Als Dienst soll hier die beliebig genaue Bestimmung von pi betrachtet werden. Der Dienst stellt folgendes Interface bereit:

// Calculator.java

public interface Calculator {	
	public BigDecimal pi (int anzahl_nachkommastellen);		
}


Ihre Aufgabe ist es nun, zun�chst mittels Java-RMI die direkte Kommunikation zwischen Klient und Dienst zu erm�glichen und in einem zweiten Schritt den Balancierer zu implementieren und zwischen Klient(en) und Dienst(e) zu schalten. Gehen Sie dazu folgendermassen vor:

    �ndern Sie Calculator und CalculatorImpl so, dass sie �ber Java-RMI von aussen zugreifbar sind. Entwicklen Sie ein Serverprogramm, das eine CalculatorImpl-Instanz erzeugt und beim RMI-Namensdienst registriert. Entwicklen Sie ein Klientenprogramm, das eine Referenz auf das Calculator-Objekt beim Namensdienst erfragt und damit pi bestimmt. Testen Sie die neu entwickelten Komponenten.
    Implementieren Sie nun den Balancierer, indem Sie eine Klasse CalculatorBalancer von Calculator ableiten und die Methode pi() entsprechend implementieren. Dadurch verh�lt sich der Balancierer aus Sicht der Klienten genauso wie der Server, d.h. das Klientenprogramm muss nicht ver�ndert werden. Entwickeln Sie ein Balanciererprogramm, das eine CalculatorBalancer-Instanz erzeugt und unter dem vom Klienten erwarteten Namen beim Namensdienst registriert. Hier ein paar Details und Hinweise:

        o Da mehrere Serverprogramme gleichzeitig gestartet werden, sollten Sie das Serverprogramm so erweitern, dass man beim Start auf der Kommandozeile den Namen angeben kann, unter dem das CalculatorImpl-Objekt beim Namensdienst registriert wird. dieses nun seine exportierte Instanz an den Balancierer �bergibt, ohne es in die Registry zu schreiben. Verwenden Sie dabei ein eigenes Interface des Balancers, welches in die Registry gebinded wird, um den Servern das Anmelden zu erm�glichen.	
		o Das Balancierer-Programm sollte nun den Namensdienst in festgelegten Abst�nden abfragen um herauszufinden, ob neue Server Implementierungen zur Verf�gung stehen.	
		o Java-RMI verwendet intern mehrere Threads, um gleichzeitig eintreffende Methodenaufrufe parallel abarbeiten zu k�nnen. Das ist einerseits von Vorteil, da der Balancierer dadurch mehrere eintreffende Aufrufe parallel bearbeiten kann, andererseits m�ssen dadurch im Balancierer �nderbare Objekte durch Verwendung von synchronized vor dem gleichzeitigen Zugriff in mehreren Threads gesch�tzt werden.	   
		o Beachten Sie, dass nach dem Starten eines Servers eine gewisse Zeit vergeht, bis der Server das CalculatorImpl-Objekt erzeugt und beim Namensdienst registriert hat sich beim Balancer meldet. D.h. Sie m�ssen im Balancierer zwischen Start eines Servers und Abfragen des Namensdienstes einige Sekunden warten.	

Testen Sie das entwickelte System, indem Sie den Balancierer mit verschiedenen Serverpoolgr�ssen starten und mehrere Klienten gleichzeitig Anfragen stellen lassen. W�hlen Sie die Anzahl der Iterationen bei der Berechung von pi entsprechend gross, sodass eine Anfrage lang genug dauert um feststellen zu k�nnen, dass der Balancierer tats�chlich mehrere Anfragen parallel bearbeitet.

Gruppenarbeit

Die Arbeit ist als 2er-Gruppe zu l�sen und �ber das Netzwerk zu testen! Nur localhost bzw. lokale Testzyklen sind unzul�ssig und werden mit 6 Minuspunkten benotet!
Benotungskriterien

o 12 Punkte: Java RMI Implementierung (siehe Punkt 1)	
o 12 Punkte: Implementierung des Balancers (siehe Punkt 2)	
o davon 6 Punkte: Balancer	
o davon 2 Punkte: Parameter - Name des Objekts	
o davon 2 Punkte: Listing der Server (dyn. Hinzuf�gen und Entfernen)	
o davon 2 Punkte: Testprotokoll mit sinnvollen Werten f�r Serverpoolgr��e und Iterationen
Quellen	

An Overview of RMI Applications, Oracle Online Resource, http://docs.oracle.com/javase/tutorial/rmi/overview.html (last viewed 21.11.2013)