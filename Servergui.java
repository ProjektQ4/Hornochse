import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
  *
  * Beschreibung
  *
  * @version 1.0 vom 19.02.2018
  * @author
  */

public class Servergui extends Frame {
  // Anfang Attribute
  private Choice choice1 = new Choice();
  private Choice choice2 = new Choice();
  private Choice choice3 = new Choice();
  private Choice choice4 = new Choice();
  private Button button1 = new Button();
  private JLabel label1=new JLabel("Spieler:");
  private Label label1 = new Label();
  private Label label2 = new Label();
  private Label label3 = new Label();
  private Label label4 = new Label();
  private Label label5 = new Label();
  private int a();
  private int b();
  private int c();
  private int d();

  // Ende Attribute

  public Servergui(String title) {
    // Frame-Initialisierung
    super(title);
    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent evt) { dispose(); }
    });
    int frameWidth = 483; 
    int frameHeight = 415;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setResizable(false);
    Panel cp = new Panel(null);
    add(cp);
    // Anfang Komponenten

    choice1.setBounds(64, 72, 145, 25);
    choice1.add("Spieler");
    choice1.add("KI(Leicht)");
    choice1.add("KI(Mittel)");
    choice1.add("KI(Schwer)");
    choice1.addItemListener(new ItemListener() { 
      public void itemStateChanged(ItemEvent evt) { 
        choice1_ItemStateChanged(evt);
      }
    });
    cp.add(choice1);
    choice2.setBounds(64, 112, 145, 25);
    choice2.add("Spieler");
    choice2.add("KI(Leicht)");
    choice2.add("KI(Mittel)");
    choice2.add("KI(Schwer)");
    cp.add(choice2);
    choice3.setBounds(64, 152, 145, 25);
    choice3.add("");
    choice3.add("Spieler");
    choice3.add("KI(Leicht)");
    choice3.add("KI(Mittel)");
    choice3.add("KI(Schwer)");
    cp.add(choice3);
    choice4.setBounds(64, 192, 145, 25);
    choice4.add("");
    choice4.add("Spieler");
    choice4.add("KI(Leicht)");
    choice4.add("KI(Mittel)");
    choice4.add("KI(Schwer)");
    choice4.add("");
    cp.add(choice4);
    button1.setBounds(136, 296, 225, 41);
    button1.setLabel("Starten");
    button1.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        button1_ActionPerformed(evt);
      }
    });
    cp.add(button1);
    label1.setBounds(16, 24, 203, 33);
    label1.setText("Spieler");
    cp.add(label1);
    label2.setBounds(24, 72, 35, 19);
    label2.setText("1");
    cp.add(label2);
    label3.setBounds(24, 112, 35, 19);
    label3.setText("2");
    cp.add(label3);
    label4.setBounds(24, 152, 27, 19);
    label4.setText("3");
    cp.add(label4);
    label5.setBounds(24, 192, 35, 19);
    label5.setText("4");
    cp.add(label5);
    // Ende Komponenten

    setVisible(true);
  }

  // Anfang Methoden
  public void button1_ActionPerformed(ActionEvent evt) {
    int anzahlSpieler=0;

    int [] kiSchwierigkeit= new int[4];
    kiSchwierigkeit [0]= a;
    kiSchwierigkeit [1]= b;
    kiSchwierigkeit [2]= c;
    kiSchwierigkeit [3]= d;
     int anzahlKI = kiSchwierigkeit.length;
    if(choice1.getSelectedIndex()!=0){
       if
    }
    else anzahlSpieler++;
    Spielsteuerung.starten();
  }

  public void choice1_ItemStateChanged(ItemEvent evt) {
    // TODO hier Quelltext einfügen
  }

  // Ende Methoden

  public static void main(String[] args) {
    new Servergui("Servergui");
  }
}
