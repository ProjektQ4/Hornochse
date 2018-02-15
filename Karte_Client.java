import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class Karte_Client{
    
    private int zahl;
    private int punkte;
    private BufferedImage img;

    public Karte_Client(int z, int p){
        zahl=z;
        punkte=p;
        try{
            img=ImageIO.read(new File("Images\\"+zahl+".png"));
        }catch(Exception e){}
    }
    
    public int getZahl(){
        return zahl;
    }
    
    public int getPunkte(){
        return punkte;
    }
}