import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;

public class Karte_Client{
    
    private int zahl;
    private int punkte;
    private Image img;

    public Karte_Client(int z){
        zahl=z;
        try{
            img = ImageIO.read(getClass().getResource("/Images/"+z+".png"));
        }catch(Exception e){ 
            int i=0;
        }
    }
    
    public int getZahl(){
        return zahl;
    }
    
    public int getPunkte(){
        return punkte;
    }
    
    public Image getImage(){
        return img;
    }
}
