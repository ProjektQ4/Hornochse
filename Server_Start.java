
public class Server_Start{
    int Spieleranzahl;
    int KIStufe;
    int KIAnzahl;
    int HandkartenProSpieler;
    int AnzahlStapel;
    
    public void spielstartparameter(int Sa, int KIS, int KIA){
        Spieleranzahl = Sa;
        KIStufe = KIS;
        KIAnzahl = KIA;
        if(Spieleranzahl+KIAnzahl == 2){
            HandkartenProSpieler = 14;
            AnzahlStapel = 7;
        }
        if(Spieleranzahl+KIAnzahl == 3){
            HandkartenProSpieler = 12;
            AnzahlStapel = 9;
        }
        if(Spieleranzahl+KIAnzahl == 4){
            HandkartenProSpieler = 12;
            AnzahlStapel = 12;
        }
        
        
        Server.starteServer(Spieleranzahl);
    }
    

    
}
