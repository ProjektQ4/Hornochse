import java.util.ArrayList;

public class Stapel_Server{

    private int id;
    private int punkte;
    private ArrayList<Karte_Server> karten=new ArrayList<Karte_Server>();
    private int nmax=6;
    
    public Stapel_Server(Karte_Server oberste, int id){
        this.id=id;
        karten.add(oberste);
        punkte=oberste.getPunkte();
    }
    
    public ArrayList<Karte_Server> anlegen(Karte_Server k){
        ArrayList<Karte_Server> s=null;
        if(karten.size()==nmax-1){
            s=karten;
            karten=new ArrayList<Karte_Server>();
            karten.add(k);
        }
        else{
            karten.add(k);
        }
        return s;
    }
}
