import java.net.Socket;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Input extends Thread{
    
    private SocketHandler sh;
    private Socket s;
    
    private BufferedReader br;
    
    public Input(SocketHandler sh, Socket s){
        this.sh=sh;
        this.s=s;
        try{
            br=new BufferedReader(new InputStreamReader(s.getInputStream()));
        }catch(Exception e){System.out.println(e.getMessage());}
    }
    
    public void run(){
    
    }
}
