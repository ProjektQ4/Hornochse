import java.util.Random;

public class KI
{
    int schwierigkeit, id;
    String name;
    
    public KI()
    {
        
    }
    
    
    private Karte_Server neueRunde(Stapel_Server[] s, Karte_Server[] h){
        Karte_Server[] handkarten = h;
        Random rnd = new Random();
        Karte_Server ausgabe = handkarten[0];
           
        if (schwierigkeit == 0){
            ausgabe = handkarten[rnd.nextInt(4)+1];
        }
        
        return ausgabe;
    }
    
    
    
    
}
