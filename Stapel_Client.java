
public class Stapel_Client{
    
    private Karte_Client oberste;
    private int punkte;
    private int n;

    public Stapel_Client(Karte_Client k){
        n=1;
        oberste=k;
        punkte=oberste.getPunkte();
    }
    
    public Stapel_Client(int n, Karte_Client k, int p){
        this.n=n;
        oberste=k;
        punkte=p;
    }
    
    public void aktualisieren(int n, Karte_Client k, int p){
        this.n=n;
        oberste=k;
        punkte=p;
    }
}
