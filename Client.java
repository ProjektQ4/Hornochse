import java.net.Socket;
import java.net.InetAddress;

public class Client extends Thread{
    
    private static SocketHandler_Client sh;
    private static Socket s;
    
    public void run(){
        verbinden();
    }
    
    public static void verbinden(/*String ip, int port*/){
        String ip="10.16.112.4";
        int port=80;
        try{
            sh=new SocketHandler_Client(new Socket(InetAddress.getByName(ip), port));
        }catch(Exception e){System.out.println(e.getMessage());}
        //System.out.println("Verbunden!");
    }
    
    public static void verbindungSchließen(){
        try{
            s.close();
        }catch(Exception e){System.out.println(e.getMessage());}
    }
    
    public static void auswerten(String s){
        
    }
    
    public static void ausgewählt(Karte_Client k){
        
    }
}
