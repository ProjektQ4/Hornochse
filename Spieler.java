import java.util.ArrayList;

public class Spieler{
    String name;
    int id;
    private int punkte=0;
    private ArrayList<Karte_Server> Handkarten=new ArrayList<Karte_Server>();
    
    public Spieler(String n, int i, ArrayList<Karte_Server> hk){
        name = n;
        id = i;
        Handkarten = hk;
    }
    
    public ArrayList<Karte_Server> getHandkarten(){
        return Handkarten;
    }
    
    public Karte_Server getKarte(int a){
        Karte_Server k=null;
        for(int i=0; i<Handkarten.size(); i++){
            if(Handkarten.get(i).getZahl()==a){
                k=Handkarten.get(i);
                break;
            }
        }
        return k;
    }
    
    public void entferneKarte(Karte_Server k){
        Handkarten.remove(k);
    }
    
    public void addPunkte(int a){
        punkte+=a;
    }
}
