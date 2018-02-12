import java.net.Socket;

public class SocketHandler_Server extends SocketHandler{
    
    private int id;
    
    public SocketHandler_Server(Socket s, int id){
        this.id=id;
        out=new Output(this, s);
        in=new Input(this, s);
        in.start();
    }
    
    public void auswerten(String s){
        Server.auswerten(s);
    }
}
