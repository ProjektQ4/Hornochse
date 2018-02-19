
public abstract class SocketHandler{
    
    protected Input in;
    protected Output out;
    protected int id;
    protected boolean alive=true;
    
    public void senden(String s){
        out.senden(s);
    }
    
    public void schließen(){
        alive=false;
        out.schließen();
    }
    
    public abstract void auswerten(String s);
}
