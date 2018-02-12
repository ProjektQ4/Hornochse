import java.net.Socket;

public class SocketHandler_Client extends SocketHandler{
    
    public SocketHandler_Client(Socket s){
        out=new Output(this, s);
        in=new Input(this, s);
        in.start();
    }
    
    public void auswerten(String s){
        Client.auswerten(s);
    }
}
