import java.net.ServerSocket;
import java.net.Socket;
import java.net.InetAddress;

public class Server{

    private static final int port=80;
    private static int n;

    private static ServerSocket server;
    private static SocketHandler_Server[] verbindungen;

    public static InetAddress getLocalIP(){
        InetAddress add=null;
        try{
            Socket s=new Socket(InetAddress.getByName("www.google.de"), 80);
            add=s.getLocalAddress();
            s.close();
        }catch(Exception e){System.out.println(e.getMessage());}
        return add;
    }

    public static void starten(int n1){
        n=n1;
        for(int i=0; i<n; i++){
            Client c=new Client();
            c.start();
        }
        verbindungen=new SocketHandler_Server[n];
        System.out.println("Server wird unter der IP "+getLocalIP().toString().substring(1)+" aufgebaut.");
        try{
            server=new ServerSocket(port);
            for(int i=0; i<n; i++){
                verbindungen[i]=new SocketHandler_Server(server.accept(), i);
                System.out.println("Client angenommen!");
                
                for(int t=0; t<=i; t++){
                    verbindungen[t].senden("warten"+i+","+n+"\n");
                }

                verbindungen[i].senden("warten3,4\n");
                verbindungen[i].senden("setup4,15,6\n");
                verbindungen[i].senden("lege eigene75\n");
                verbindungen[i].senden("lege fremde1\n");
                verbindungen[i].senden("sortieren1,11,1;2,7,3;3,99,8;4,65,2\n");
                verbindungen[i].senden("new2,7,3;4,2,1;98,10,5:1,6,19,87\n");
            }

            try{
                Thread.sleep(10000);
            }catch(Exception e){}
            System.exit(0);
        }catch(Exception e){System.out.println(e.getMessage());}
    }

    public static synchronized void auswerten(String s, int id){
        System.out.println("Synchronized beginnt");
        
        s=s.substring(10);
        int zahl=Integer.valueOf(s);
        Spielsteuerung.ausgewählt(zahl, id);
        
        System.out.println("Synchronized endet");
    }
    
    public static void setup(int nSpieler, int nStapel, int nHandkarten){
        for(int i=0; i<n; i++){
            verbindungen[i].senden("setup"+nSpieler+","+nStapel+","+nHandkarten+"\n");
        }
    }
    
    public static void legen(Karte_Server k, int spieler){
        for(int i=0; i<n; i++){
            if(i==spieler) verbindungen[i].senden("lege eigene"+k.getZahl()+"\n");
            else verbindungen[i].senden("lege fremde"+spieler+"\n");
        }
    }

    public static void schließen(){
        try{
            server.close();
        }catch(Exception e){System.out.println(e.getMessage());}
    }
}
