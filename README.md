MiniPowerPcEmu
==============
Schreiben Sie ein Programm in einer beliebigen Programmiersprache / Umgebung, das den in der Vorlesung spezifizierten „Mini-Power-PC“ emuliert – d. h. alle Befehle des Befehlssatzes (siehe Anlage Befehlssatz „Mini-Power-PC“) ausführt.

 1. Als Eingabe soll gelesen werden: (2 Punkte)
 1.1 Ein beliebiges mit dem Befehlssatz geschriebenes Programm, das ab Speicher 100 in den Speicher eingelesen wird
 1.2 Die Parameter des Programms (Eingabewerte) ab Speicher 500 (Der Op-Code und die Parameter des Programms können als Binär-,
 2. Als Ausgabe wird folgendes erwartet: (3 + 2 Punkte)
 2.2 Die aktuellen Zustände der Register:
 2.2.1 Befehlszähler, Befehlsregister
 2.2.2 Akkumulator, Carry-Bit
 2.2.3 Reg-1, Reg-2, Reg-3
 2.2.4 Optional: Alle Werte auch als Binär-Werte (16 Bit)
 3. Der aktuelle decodierte Befehl aus dem Befehlsregister (als Mnemonics)
 4. Der aktuelle Zustand des Speichers:
 4.1. 5 Befehle vor bis 10 Befehle nach dem aktuellen Befehl
 4.2 Der Inhalt der Speicherzellen 500 bis 529 (wortweise)
 4.3 Optional: alle Werte auch als Binär-Werte (16 Bit)
 5. Die Anzahl der durchgeführten Befehle (zum Programmstart 0)
 6. Implementieren Sie einen „schnellen“ und einen „slow“ Modus sowie optional einen „Step-Modus“: (2 + 2 Punkte)
 6.1 Schneller Modus: Während des Programmablaufs erfolgt keine Ausgabe
    (keine Aktualisierung der Ausgabedaten); diese werden erst am Programmende aktualisiert
 6.2 Slow-Modus: Während des Programmablaufs wird nach Bearbeitung eines jeden Befehls die Ausgabe aktualisiert
 6.3 Step-Modus: Wie der Slow-Modus, jedoch wird das Programm nach Bearbeitung eines jeden Befehls unterbrochen und wird erst nach einer Bestätigung durch den User (z. B. Drücken einer Taste) wieder fortgesetzt