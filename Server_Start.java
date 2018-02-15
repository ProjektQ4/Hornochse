
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
            //Spieler Spieler1 = new Spieler("Spieler1", 1, ArrayList<Karte_Server> hk1 = new ArrayList<Karte_Server>());
            //Spieler Spieler2 = new Spieler("Spieler2", 2);
        }
        if(Spieleranzahl+KIAnzahl == 3){
            HandkartenProSpieler = 12;
            AnzahlStapel = 9;
            //Spieler1 = new Spieler("Spieler1", 1, ArrayList<Karte_Server> hk1 = new ArrayList<Karte_Server>());
            //Spieler Spieler2 = new Spieler("Spieler2", 2);
            //Spieler Spieler3 = new Spieler("Spieler3", 3);
        }
        if(Spieleranzahl+KIAnzahl == 4){
            HandkartenProSpieler = 12;
            AnzahlStapel = 12;
            //Spieler1 = new Spieler("Spieler1", 1, ArrayList<Karte_Server> hk1 = new ArrayList<Karte_Server>());
            //Spieler Spieler2 = new Spieler("Spieler2", 2);
            //Spieler Spieler3 = new Spieler("Spieler3", 3);
            //Spieler Spieler4 = new Spieler("Spieler4", 4);
        }
        Server.starteServer(Spieleranzahl);
    }
    

    
}
