import java.util.ArrayList;
import java.util.Random;

public class Server_Start{
    private static int Spieleranzahl;
    private static int KIStufe;
    private static int KIAnzahl;
    private static int AnzahlGesamt;
    private static int HandkartenProSpieler;
    private static int AnzahlStapel;
    private static ArrayList<ArrayList<Karte_Server>> KIHandkarten=new ArrayList<ArrayList<Karte_Server>>();
    private static ArrayList<Stapel_Server> stapel=new ArrayList<Stapel_Server>();
    private static Spieler[] spieler;
    private static KI[] ki;
    private static int[] KIPunkte;

    private static int zähler=0;
    private static int[] ausgewählt;

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

    public static void starten(int Sa, ArrayList<Integer> kiStufe){
        Spieleranzahl = Sa;
        KIAnzahl = kiStufe.size();
        AnzahlGesamt=Spieleranzahl+KIAnzahl;
        Random rnd = new Random();

        ausgewählt=new int[AnzahlGesamt];

        System.out.println(Sa+" Spieler mit "+ KIAnzahl+" KIs");

        ArrayList<Karte_Server> Karten=KartenGenerieren();

        if(Spieleranzahl+KIAnzahl == 2){
            HandkartenProSpieler = 14;
            AnzahlStapel = 7;
        }
        if(Spieleranzahl+KIAnzahl == 3){
            HandkartenProSpieler = 12;
            AnzahlStapel = 9;
        }
        if(Spieleranzahl+KIAnzahl == 4){
            HandkartenProSpieler = 12;
            AnzahlStapel = 12;
        }

        spieler=new Spieler[Spieleranzahl];
        ki=new KI[KIAnzahl];
        KIPunkte=new int[KIAnzahl];

        for(int i=0; i<AnzahlStapel; i++){
            int r=rnd.nextInt(Karten.size());
            stapel.add(new Stapel_Server(Karten.get(r), i));
            Karten.remove(r);
        }
        for(int i=0; i<Spieleranzahl; i++){
            ArrayList<Karte_Server> hk = new  ArrayList<Karte_Server>();
            for(int t = 0; t<HandkartenProSpieler; t++){
                int r = rnd.nextInt(Karten.size());
                hk.add(Karten.get(r));
                Karten.remove(r);   
            }
            spieler[i]=new Spieler("Spieler"+i, i, hk);
        }
        for(int i=0; i<KIAnzahl; i++){
            ki[i]=new KI(kiStufe.get(i));
            ArrayList<Karte_Server> hk=new ArrayList<Karte_Server>();
            for(int t=0; t<HandkartenProSpieler; t++){
                int r = rnd.nextInt(Karten.size());
                hk.add(Karten.get(r));
                Karten.remove(r);
            }
            KIHandkarten.add(hk);
        }
        Server.starteServer(Spieleranzahl);
        Server.setup(Spieleranzahl+KIAnzahl, AnzahlStapel);

        ArrayList<ArrayList<Karte_Server>> hk=new ArrayList<ArrayList<Karte_Server>>();
        for(int i=0; i<Spieleranzahl; i++){
            hk.add(spieler[i].getHandkarten());
        }

        Server.neueRunde(stapel, hk);
    }

    public static void ausgewählt(int a, int b){
        zähler++;
        ausgewählt[b]=a;
        Karte_Server k=spieler[b].getKarte(a);
        Server.legen(k, b);
        if(zähler==Spieleranzahl){
            zähler=0;
            for(int i=0; i<KIAnzahl; i++){
                ausgewählt[Spieleranzahl+i]=ki[i].neueRunde(stapel, KIHandkarten.get(i)).getZahl();

                Karte_Server KIkarte=null;
                for(int t=0; t<KIHandkarten.get(i).size(); t++){
                    if(KIHandkarten.get(i).get(t).getZahl()==ausgewählt[Spieleranzahl+i]){
                        KIkarte=KIHandkarten.get(i).get(t);
                        break;
                    }
                }
                Server.legen(KIkarte, Spieleranzahl+i);
            }

            int[] karten=new int[AnzahlGesamt];
            ArrayList<Integer> f=new ArrayList<Integer>();
            for(int i=0; i<AnzahlGesamt; i++){
                f.add(ausgewählt[i]);
            }
            int z=0;
            while(f.size()>0){
                int min=f.get(0);
                for(int t=0; t<f.size(); t++){
                    min=Math.min(min, f.get(t));
                }
                karten[z]=min;
                f.remove(new Integer(min));
                z++;
            }

            ArrayList<Stapel_Server> sp=new ArrayList<Stapel_Server>();
            ArrayList<Stapel_Server> stap=new ArrayList<Stapel_Server>();
            for(int i=0; i<stapel.size(); i++){
                stap.add(stapel.get(i));
            }

            while(stap.size()>0){
                Stapel_Server s=stap.get(0);
                for(int t=0; t<stap.size(); t++){
                    int c=s.getOberste().getZahl();
                    int d=stap.get(t).getOberste().getZahl();
                    if(c>d){
                        s=stap.get(t);
                    }
                }
                sp.add(s);
                stap.remove(s);
            }

            for(int i=0; i<AnzahlGesamt; i++){
                int e=karten[i];
                k=null;
                int g=0;
                for(int t=0; t<Spieleranzahl; t++){
                    if(e==ausgewählt[t]){
                        k=spieler[t].getKarte(e);
                        g=i;
                    }
                }
                for(int t=Spieleranzahl; t<AnzahlGesamt; t++){
                    if(e==ausgewählt[t]){
                        for(int o=0; o<KIHandkarten.get(t-Spieleranzahl).size(); o++){
                            if(e==KIHandkarten.get(t-Spieleranzahl).get(o).getZahl()){
                                k=KIHandkarten.get(t-Spieleranzahl).get(o);
                                g=t;
                                break;
                            }
                        }
                    }
                }
                if(e<sp.get(0).getOberste().getZahl()){
                    ArrayList<Karte_Server> h=sp.get(0).anlegen(k);
                    if(h!=null){
                        for(int t=0; t<h.size(); t++){
                            if(g<Spieleranzahl){
                                spieler[g].addPunkte(h.get(t).getPunkte());
                            }
                            else{
                                KIPunkte[g-Spieleranzahl]+=h.get(t).getPunkte();
                            }
                        }
                    }
                }
                else{
                    boolean bool=true;
                    z=0;
                    while(bool){
                        if(sp.get(z).getOberste().getZahl()<e&&z<sp.size()) z++;
                        else bool=false;
                    }
                    if(sp.get(z).getOberste().getZahl()>e) z--;
                    ArrayList<Karte_Server> h=sp.get(z).anlegen(k);
                    if(h!=null){
                        for(int t=0; t<h.size(); t++){
                            if(g<Spieleranzahl){
                                spieler[g].addPunkte(h.get(t).getPunkte());
                            }
                            else{
                                KIPunkte[g-Spieleranzahl]+=h.get(t).getPunkte();
                            }
                        }
                    }
                }

                if(g<Spieleranzahl){
                    spieler[g].entferneKarte(k);
                }
                else{
                    KIHandkarten.get(g-Spieleranzahl).remove(k);
                }
            }

            ArrayList<ArrayList<Karte_Server>> hk=new ArrayList<ArrayList<Karte_Server>>();
            for(int i=0; i<Spieleranzahl; i++){
                hk.add(spieler[i].getHandkarten());
            }

            Server.neueRunde(stapel, hk);
        }
    }
}
