100 LWDD R0, #500 ; Akku = k
102 SWDD R0, #504 ; Summe s initialisieren und speichern
104 LWDD R0, #500 ; Akku = k
106 INC ; k = k + 1
108 SWDD R0, #500 ; Inkrementierten Wert speichern
110 LWDD R1, #504 ; R1 = s
112 ADD R0 ; s = s + k
114 SWDD R0, #504 ; Summe speichern
116 LWDD R0, #500 ; k (inkrementierter Wert) laden
118 NOT ; Akku = Akku invertieren
120 INC ; Akku = Akku + 1 (=> 2er-Komplement von k)
122 LWDD R1, #502 ; R1 = j
124 ADD R1 ; Akku := Akku + R1 (= j - k)
126 BNZD #104 ; Wenn j - k ≠ 0 springe zu 104 zurück