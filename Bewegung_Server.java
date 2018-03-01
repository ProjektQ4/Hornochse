
public class Bewegung_Server{
    
    private int spieler;
    private int karte;
    private int stapel;
    
    public Bewegung_Server(int s, Karte_Server k, Stapel_Server st){
        spieler=s;
        karte=k.getZahl();
        stapel=st.getID();
    }
    
    public int getSpieler(){
        return spieler;
    }
    
    public int getKarte(){
        return karte;
    }
    
    public int getStapel(){
        return stapel;
    }
}
