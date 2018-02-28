import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.*;
import javax.imageio.ImageIO;

public class Grafik{

    private static JFrame f=new JFrame();
    private static Panel p=new Panel();

    private static JFrame warten=new JFrame();
    private static JLabel l=new JLabel();

    private static int n;
    private static int stapelanzahl;
    private static int eigeneZahl;
    private static boolean bereit=false;
    private static Stapel_Client[] stapel;
    private static ArrayList<Karte_Client> hk=new ArrayList<Karte_Client>();
    private static boolean[] gelegt;
    private static boolean eigeneGelegt;
    private static Karte_Client ausgewählt;

    public static void start(){
        Client.verbinden();
    }

    public static void warten(int a, int b){
        warten.setVisible(true);
        warten.setSize(500, 200);
        warten.setResizable(false);
        warten.setDefaultCloseOperation(warten.DO_NOTHING_ON_CLOSE);
        warten.add(l);
        l.setText(a+" von "+b+" Spielern verbunden.");
    }

    public static void setup(int a, int b, int c){
        n=a;
        gelegt=new boolean[n-1];
        stapelanzahl=b;
        eigeneZahl=c;
        stapel=new Stapel_Client[b];

        warten.setVisible(false);

        f.setVisible(true);
        f.setSize(1050, 800);
        f.setResizable(false);
        f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);

        f.add(p);
    }

    public static void eigeneLegen(Karte_Client k){
        ausgewählt=k;
        eigeneGelegt=true;
        bereit=true;
        p.repaint();
    }

    public static void fremdeLegen(int a){
        if(a<eigeneZahl) gelegt[a]=true;
        if(a>eigeneZahl) gelegt[a-1]=true;
        bereit=true;
        p.repaint();
    }

    public static void sortieren(ArrayList<Bewegung_Client> bew){

    }

    public static void neueRunde(ArrayList<Stapel_Client> s, ArrayList<Karte_Client> h){
        gelegt=new boolean[n-1];
        eigeneGelegt=false;
        ausgewählt=null;

        for(int i=0; i<stapelanzahl; i++){
            stapel[i]=s.get(i);
        }
        hk=h;
        bereit=true;
        p.repaint();
    }

    private static class Panel extends JPanel{

        private int höhe=75, breite=55; //Abmaße der Bilder  142
        Image rückseite;

        private MouseAdapter ma=new MouseAdapter(){
                public void mouseClicked(MouseEvent e){
                    click(e);
                }
            };

        private void click(MouseEvent e){
            if(ausgewählt==null){
                int x=e.getX();
                int y=e.getY();

                if(y>=764-höhe-10&&y<=764-10){
                    for(int i=0; i<hk.size(); i++){
                        int a=hk.size();
                        if(x>=(525-(a*breite+(a-1)*10)/2)+i*(breite+10)&&x<=(525-(a*breite+(a-1)*10)/2)+i*(breite+10)+breite){
                            ausgewählt=hk.get(i);
                            Client.ausgewählt(ausgewählt);
                            break;
                        }
                    }
                    bereit=true;
                    repaint();
                }
            }
        }

        public Panel(){
            addMouseListener(ma);
            try{
                rückseite = ImageIO.read(getClass().getResource("/Images/bg.png"));
            }catch(Exception e){}
        }

        public void paint(Graphics g){
            g.clearRect(0, 0, 1050, 800);

            g.setColor(new Color(152,251,152));
            g.fillRect(0, 0, 1050, 764);
            g.setColor(Color.BLACK);

            if(bereit){

                //eigene Handkarten//
                for(int i=0; i<hk.size(); i++){
                    Karte_Client k=hk.get(i);
                    int a=hk.size();
                    int x=(525-(a*breite+(a-1)*10)/2)+i*(breite+10);//20+i*110;
                    int y=764-höhe-10;
                    if(k!=ausgewählt) g.drawImage(k.getImage(), x, y, null);
                    else g.drawImage(k.getImage(), x, y-20, null);
                }

                //andere Handkarten//

                if(n==2||n==4){
                    for(int i=0; i<hk.size(); i++){
                        int a=hk.size();
                        int x=(525-(a*breite+(a-1)*10)/2)+i*(breite+10);
                        int y=10;
                        g.drawImage(rückseite, x, y, null);
                    }
                }

                if(n==3||n==4){
                    for(int i=0; i<hk.size(); i++){
                        int a=hk.size();
                        int x=10;
                        int y;
                        if(a<=7) y=(382-(a*höhe+(a-1)*10)/2)+i*(höhe+10);
                        else y=20+höhe+i*(764-3*höhe)/a;
                        g.drawImage(rückseite, x, y, null);
                    }
                }

                if(n==3||n==4){
                    for(int i=0; i<hk.size(); i++){
                        int a=hk.size();
                        int x=1050-breite-10;
                        int y;
                        if(a<=7) y=(382-(a*höhe+(a-1)*10)/2)+i*(höhe+10);
                        else y=20+höhe+i*(764-3*höhe)/a;
                        g.drawImage(rückseite, x, y, null);
                    }
                }

                //Stapel zeichnen//

                double c, d;
                c=stapelanzahl/2.0;
                d=c;

                if(c%1!=0){
                    c+=0.5; 
                    d-=0.5;
                }

                int a=(int) c, b=(int) d;

                for(int i=0; i<a; i++){
                    int y=382-höhe-15;
                    int x=(525-(a*breite+(a-1)*10)/2)+i*(breite+10);
                    Karte_Client k=stapel[i].getOberste();
                    g.drawImage(k.getImage(), x, y, null);
                }
                for(int i=0; i<b; i++){
                    int y=382+15;
                    int x=(525-(b*breite+(b-1)*10)/2)+i*(breite+10);
                    Karte_Client k=stapel[i+a].getOberste();
                    g.drawImage(k.getImage(), x, y, null);
                }

                //gelegte Karten//

                if(n==2){
                    if(gelegt[0]) g.drawImage(rückseite, 525-breite/2, höhe+20, null);
                }
                if(n==3){
                    if(gelegt[0]) g.drawImage(rückseite, breite+20, 382-höhe/2, null);
                    if(gelegt[1]) g.drawImage(rückseite, 1050-breite-20, 382-höhe/2, null);
                }
                if(n==4){
                    if(gelegt[0]) g.drawImage(rückseite, breite+20, 382-höhe/2, null);
                    if(gelegt[1]) g.drawImage(rückseite, 525-breite/2, höhe+20, null);
                    if(gelegt[2]) g.drawImage(rückseite, 1050-2*breite-20, 382-höhe/2, null);
                }
            }
            bereit=false;
        }
    }
}
