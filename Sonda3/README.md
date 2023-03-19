


# Cosa è Sonda?

Sonda rappresenta il software associato ad una sonda che rileva il fumo la dove è stata impiantata.

## Struttura

Nel package Sonda c'è una classe Sonda che ha un proxy PLC (Programmable Logic Controller, secondo la nomenclatura dei sistemi SCADA).

1. Il bean della sonda è configurato in configuration/SondaConfig secondo i parametri definiti in application.properties, quindi è iniettato nel @Component PLC 
2. Il PLC salva in una lista le varie misurazioni effettuate dalla sonda (in seconda battuta bisogna introdurre un DB).
3. 
