import java.util.ArrayList;

public class Spieler{
    String name;
    int id;
    private ArrayList<Karte_Server> Handkarten=new ArrayList<Karte_Server>();
    
    public Spieler(String n, int i, ArrayList<Karte_Server> hk){
        name = n;
        id = i;
        Handkarten = hk;
    }
    
    public void neueRunde(Stapel_Server stapel, ArrayList<Karte_Server> Handkarten){
        //Server.neueRunde();    
    }
}
