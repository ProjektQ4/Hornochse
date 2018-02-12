import java.net.Socket;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Output{

    private SocketHandler sh;
    private Socket s;

    private BufferedWriter bw;

    public Output(SocketHandler sh, Socket s){
        this.sh=sh;
        this.s=s;
        try{
            bw=new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
        }catch(Exception e){System.out.println(e.getMessage());}
    }

    public void senden(String s){
        try{
            bw.write(s);
            bw.flush();
        }catch(Exception e){System.out.println(e.getMessage());}
    }
}
