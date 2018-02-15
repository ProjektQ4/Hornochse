import java.net.ServerSocket;
import java.net.Socket;
import java.net.InetAddress;

public class Server{
    
    private static final int port=80;
    
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

    public static void starten(int n){
        //Client c=new Client();
        //c.start();
        verbindungen=new SocketHandler_Server[n];
        System.out.println("Server wird unter der IP "+getLocalIP().toString().substring(1)+" aufgebaut.");
        try{
            server=new ServerSocket(port);
            for(int i=0; i<n; i++){
                verbindungen[i]=new SocketHandler_Server(server.accept(), i);
                System.out.println("Client angenommen!");
            }
        }catch(Exception e){System.out.println(e.getMessage());}
    }
    
    public static synchronized void auswerten(String s){
        
    }
    
    public static void schließen(){
        try{
            server.close();
        }catch(Exception e){System.out.println(e.getMessage());}
    }
}
