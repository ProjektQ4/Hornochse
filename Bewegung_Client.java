
public class Bewegung_Client{
    
    private int spieler;
    private Karte_Client karte;
    private int stapel;
    
    public Bewegung_Client(int s, Karte_Client k, int st){
        spieler=s;
        karte=k;
        stapel=st;
    }
    
    public int getSpieler(){
        return spieler;
    }
    
    public int getKarte(){
        return karte.getZahl();
    }
    
    public int getStapel(){
        return stapel;
    }
}
