import java.util.ArrayList;
import java.util.Random;

public class Server_Start{
    static int Spieleranzahl;
    static int KIStufe;
    static int KIAnzahl;
    static int HandkartenProSpieler;
    static int AnzahlStapel;

    public static ArrayList<Karte_Server> KartenGenerieren(){
        ArrayList<Karte_Server> Karten = new  ArrayList<Karte_Server>();
        for(int i = 1; i <= 98; i++){
            switch(i){
                case 1:
                case 2:
                case 3:
                case 4:
                case 6:
                case 7:
                case 8:
                case 9:
                case 12:
                case 13:
                case 14:
                case 16:
                case 17:
                case 18:
                case 19:
                case 21:
                case 23:
                case 24:
                case 26:
                case 27:
                case 28:
                case 29:
                case 31:
                case 32:
                case 34:
                case 36:
                case 37:
                case 38:
                case 39:
                case 41:
                case 42:
                case 43:
                case 46:
                case 47:
                case 48:
                case 49:
                case 51:
                case 52:
                case 53:
                case 54:
                case 56:
                case 57:
                case 58:
                case 59:
                case 61:
                case 62:
                case 63:
                case 64:
                case 67:
                case 68:
                case 69:
                case 71:
                case 72:
                case 73:
                case 74:
                case 76:
                case 78:
                case 79:
                case 81:
                case 82:
                case 83:
                case 84:
                case 86:
                case 87:
                case 89:
                case 91:
                case 92:
                case 93:
                case 94:
                case 96:
                case 97:
                case 98:
                Karten.add(new Karte_Server(i, 1));
                break;

                case 15:
                case 35:
                case 65:
                case 85:
                Karten.add(new Karte_Server(i, 2));
                break;

                case 5:
                case 25:
                case 45:
                case 75:
                case 95:
                Karten.add(new Karte_Server(i, -2));
                break;

                case 10:
                case 20:
                case 30:
                case 40:
                case 50:
                case 60:
                case 70:
                case 80:
                case 90:
                Karten.add(new Karte_Server(i, -3));
                break;

                case 11:
                case 22:
                case 33:
                case 44:
                case 66:
                case 77:
                case 88:
                case 99:
                Karten.add(new Karte_Server(i, -5));
                break;

                case 55:
                Karten.add(new Karte_Server(i, -7));
                break;

            }

        }
        return Karten;
    }

    public static void spielstartparameter(int Sa, ArrayList<Integer> kiStufe){
        Spieleranzahl = Sa;
        KIAnzahl = kiStufe.size();
        Random rnd = new Random();

        System.out.println(Sa+" Spieler mit "+ KIAnzahl+" KIs");
        
        ArrayList<Karte_Server> Karten=KartenGenerieren();

        if(Spieleranzahl+KIAnzahl == 2){
            HandkartenProSpieler = 14;
            AnzahlStapel = 7;
            ArrayList<Karte_Server> hk1 = new  ArrayList<Karte_Server>();
            ArrayList<Karte_Server> hk2 = new  ArrayList<Karte_Server>();
            for(int i = 1; i<=14; i++){
                int r = rnd.nextInt(Karten.size());
                hk1.add(Karten.get(r));
                Karten.remove(r);   
            }
            for(int i = 1; i<=14; i++){
                int r = rnd.nextInt(Karten.size());
                hk2.add(Karten.get(r));
                Karten.remove(r);   
            }
            Spieler Spieler1 = new Spieler("Spieler1", 1, hk1);
            Spieler Spieler2 = new Spieler("Spieler2", 2, hk2);
        }
        if(Spieleranzahl+KIAnzahl == 3){
            HandkartenProSpieler = 12;
            AnzahlStapel = 9;
            ArrayList<Karte_Server> hk1 = new  ArrayList<Karte_Server>();
            ArrayList<Karte_Server> hk2 = new  ArrayList<Karte_Server>();
            ArrayList<Karte_Server> hk3 = new  ArrayList<Karte_Server>();
            for(int i = 1; i<=12; i++){
                int r = rnd.nextInt(Karten.size());
                hk1.add(Karten.get(r));
                Karten.remove(r);   
            }
            for(int i = 1; i<=12; i++){
                int r = rnd.nextInt(Karten.size());
                hk2.add(Karten.get(r));
                Karten.remove(r);   
            }
            for(int i = 1; i<=12; i++){
                int r = rnd.nextInt(Karten.size());
                hk3.add(Karten.get(r));
                Karten.remove(r);   
            }
            
            
            Spieler[] spieler=new Spieler[Spieleranzahl];
            KI[] ki=new KI[KIAnzahl];
            for(int i=0; i<Spieleranzahl; i++){
                ArrayList<Karte_Server> hk = new  ArrayList<Karte_Server>();
                for(int t = 1; t<=12; t++){
                    int r = rnd.nextInt(Karten.size());
                    hk.add(Karten.get(r));
                    Karten.remove(r);   
                }
                spieler[i]=new Spieler("Spieler"+(i+1), i+1, hk);
            }
            for(int y=0; y<KIAnzahl; y++){
                ki[y]=new KI(1);//Platzhalter
                
                
                
                
                
                
                
                
                
                
                
                
            }

            Spieler Spieler1 = new Spieler("Spieler1", 1, hk1);
            Spieler Spieler2 = new Spieler("Spieler2", 2, hk2);
            Spieler Spieler3 = new Spieler("Spieler3", 3, hk3);
        }
        if(Spieleranzahl+KIAnzahl == 4){
            HandkartenProSpieler = 12;
            AnzahlStapel = 12;
            ArrayList<Karte_Server> hk1 = new  ArrayList<Karte_Server>();
            ArrayList<Karte_Server> hk2 = new  ArrayList<Karte_Server>();
            ArrayList<Karte_Server> hk3 = new  ArrayList<Karte_Server>();
            ArrayList<Karte_Server> hk4 = new  ArrayList<Karte_Server>();
            for(int i = 1; i<=12; i++){
                int r = rnd.nextInt(Karten.size());
                hk1.add(Karten.get(r));
                Karten.remove(r);   
            }
            for(int i = 1; i<=12; i++){
                int r = rnd.nextInt(Karten.size());
                hk2.add(Karten.get(r));
                Karten.remove(r);   
            }
            for(int i = 1; i<=12; i++){
                int r = rnd.nextInt(Karten.size());
                hk3.add(Karten.get(r));
                Karten.remove(r);   
            }
            for(int i = 1; i<=12; i++){
                int r = rnd.nextInt(Karten.size());
                hk4.add(Karten.get(r));
                Karten.remove(r);   
            }
            Spieler Spieler1 = new Spieler("Spieler1", 1, hk1);
            Spieler Spieler2 = new Spieler("Spieler2", 2, hk2);
            Spieler Spieler3 = new Spieler("Spieler3", 3, hk3);
            Spieler Spieler4 = new Spieler("Spieler4", 4, hk4);
        }
        Server.starteServer(Spieleranzahl);
    }

}
