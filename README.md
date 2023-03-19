# Controllo Incendi

## 1. Cosa è Controllo Incendi
    Controllo Incendi è un'applicazione con tre gruppi di microservizi: 
1. Le sonde
2. Il CentroDiControllo
3. I CentriPersonale


    Una Sonda manda al CentroDiControllo le sue misurazioni, mentre il CentroDiControllo di occupa di mandare ai
    centri personale l'allarme nel caso qualche sonda abbia rilevato un valore di fumo pari a 5, o mandare 
    l'elenco delle misurazioni di una sonda quando questo viene richiesto dal centro personale.
    Si sono usati i pattern del proxy nella relazione tra Sonda e PLC, dell'observer nella relazione tra il 
    CentroDiControllo e i vari CentroPersonale. Si è usato il pattern della factory nella creazione dei centri personale
    nel CentroDiControllo, per quanto a mio avviso sia una forzatura. Il centroDiControllo è collegato ad un DB
    con due tabelle: una per la registrazione delle sonde attive, e una per la registrazione dei centroPersonale abbonati
    al CentroDiControllo.
    Non si è implementata per motivi di tempo la parte della Autenticazione ai microservizi.
    
Yours faithfully,
A.I. aka JSMaster
    

