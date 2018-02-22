import java.net.Socket;
import java.net.InetAddress;
import java.util.ArrayList;

public class Client extends Thread{

    private static SocketHandler_Client sh;
    private static Socket s;
    private static int nSpieler;

    public void run(){
        verbinden();
    }

    public static void verbinden(/*String ip, int port*/){
        //String ip="192.168.43.72";
        String ip="192.168.178.39";
        //String ip="10.16.112.4";
        int port=80;
        try{
            sh=new SocketHandler_Client(new Socket(InetAddress.getByName(ip), port));
        }catch(Exception e){System.out.println(e.getMessage());}
        System.out.println("Client verbunden!");

        //ausgewählt(new Karte_Client(45));
    }

    public static void verbindungSchließen(){
        try{
            sh.schließen();
            s.close();
        }catch(Exception e){System.out.println(e.getMessage());}
    }

    public static void auswerten(String s){
        if(s.indexOf("warten")==0){
            int n1=Integer.valueOf(s.substring(s.indexOf(",")-1, s.indexOf(",")));
            int n2=Integer.valueOf(s.substring(s.indexOf(",")+1, s.indexOf(",")+2));
            Grafik.warten(n1, n2);
        }
        else if(s.indexOf("setup")==0){
            int n1=Integer.valueOf(s.substring(s.indexOf(",")-1, s.indexOf(",")));
            nSpieler=n1;
            s=s.substring(s.indexOf(",")+1);
            int n2=Integer.valueOf(s.substring(0, s.indexOf(",")));
            int n3;
            if(s.indexOf("\n")!=-1) n3=Integer.valueOf(s.substring(s.indexOf(",")+1, s.indexOf("\n")));
            else n3=Integer.valueOf(s.substring(s.indexOf(",")+1));
            Grafik.setup(n1, n2, n3);
        }
        else if(s.indexOf("lege eigene")==0){
            int n;
            if(s.indexOf("\n")!=-1) n=Integer.valueOf(s.substring(11, s.indexOf("\n")));
            else n=Integer.valueOf(s.substring(11));
            Grafik.eigeneLegen(new Karte_Client(n));
        }
        else if(s.indexOf("lege fremde")==0){
            int n;
            if(s.indexOf("\n")!=-1) n=Integer.valueOf(s.substring(11, s.indexOf("\n")));
            else n=Integer.valueOf(s.substring(11));
            Grafik.fremdeLegen(n);
        }
        else if(s.indexOf("sortieren")==0){
            ArrayList<Bewegung_Client> bew=new ArrayList<Bewegung_Client>();
            s=s.substring(9);
            while(s.indexOf(";")!=-1){
                String str=s.substring(0, s.indexOf(";"));
                s=s.substring(s.indexOf(";")+1);
                int n1=Integer.valueOf(str.substring(str.indexOf(",")-1, str.indexOf(",")));
                str=str.substring(str.indexOf(",")+1);
                int n2=Integer.valueOf(str.substring(0, str.indexOf(",")));
                int n3=Integer.valueOf(str.substring(str.indexOf(",")+1));
                bew.add(new Bewegung_Client(n1, new Karte_Client(n2), n3));
            }
            int n1=Integer.valueOf(s.substring(s.indexOf(",")-1, s.indexOf(",")));
            s=s.substring(s.indexOf(",")+1);
            int n2=Integer.valueOf(s.substring(0, s.indexOf(",")));
            int n3=Integer.valueOf(s.substring(s.indexOf(",")+1));
            bew.add(new Bewegung_Client(n1, new Karte_Client(n2), n3));
            Grafik.sortieren(bew);
        }
        else if(s.indexOf("new")==0){
            ArrayList<Stapel_Client> stapel=new ArrayList<Stapel_Client>();
            ArrayList<Karte_Client> hk=new ArrayList<Karte_Client>();
            s=s.substring(3);
            String s1=s.substring(0, s.indexOf(":"));
            String s2=s.substring(s.indexOf(":")+1);
            while(s1.indexOf(";")!=-1){
                int n1=Integer.valueOf(s1.substring(0, s1.indexOf(",")));
                s1=s1.substring(s.indexOf(",")+1);
                int n2=Integer.valueOf(s1.substring(0, s1.indexOf(",")));
                int n3=Integer.valueOf(s1.substring(s1.indexOf(",")+1, s1.indexOf(";")));
                s1=s1.substring(s1.indexOf(";")+1);
                stapel.add(new Stapel_Client(n1, new Karte_Client(n2), n3));
            }
            int n1=Integer.valueOf(s1.substring(0, s1.indexOf(",")));
            s1=s1.substring(s.indexOf(",")+2);
            int n2=Integer.valueOf(s1.substring(0, s1.indexOf(",")));
            int n3=Integer.valueOf(s1.substring(s1.indexOf(",")+1));
            stapel.add(new Stapel_Client(n1, new Karte_Client(n2), n3));

            while(s2.indexOf(",")!=-1){
                n1=Integer.valueOf(s2.substring(0, s2.indexOf(",")));
                hk.add(new Karte_Client(n1));
                s2=s2.substring(s2.indexOf(",")+1);
            }
            n1=Integer.valueOf(s2);
            hk.add(new Karte_Client(n1));

            Grafik.neueRunde(stapel, hk);
        }
    }

    public static void ausgewählt(Karte_Client k){
        sh.senden("ausgewählt"+k.getZahl()+"\n");
    }
}
