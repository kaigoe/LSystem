import sas.Rectangle;
import sas.Tools;

import java.awt.*;

public class LSystem {

    //Regel "ersetze alle x mit X+YF+" definieren
    private static String RuleX = "X+YF+";
    //Regel "ersetze alle Y mit -FX-Y" definieren
    private static String RuleY = "-FX-Y";

    public static Output run(String input, double x, double y, double angle, double width, double lenght){
        //farbe für diese iterration festlegen
        Color color = new Color(Tools.randomNumber(0,255),Tools.randomNumber(0,255),Tools.randomNumber(0,255));
        //die anzahl der Zeichen, die von der zeichenkette schon gemalt wurden
        int leave = input.length();
        //bei dem erstem mal den zähler für die bereits erstellten striche zurück auf null setzen
        if(leave == 2) leave = 0;
        //output zeichenkette
        String output = "";
        //Die Regeln auf jeden buchstaben der zeichenkette anwenden und das Ergebniss der output zeichenkette hinzufügen
        for (int i = 0; i < input.length(); i++) {
            if(input.charAt(i) == 'X'){
                output = output + RuleX;
            } else if(input.charAt(i) == 'Y'){
                output = output + RuleY;
            } else{
                output = output + input.charAt(i);
            }
        }
        //Die output zeichenkette durchgehen und malen ABER erst ab dem zeichen, welches noch nicht gemalt wurde
        for (int i = leave; i < output.length(); i++) {
            leave--;
            if(output.charAt(i) == '+') {
                angle = angle + 270;
            }else if(output.charAt(i) == '-') {
                angle = angle + 90;
            }else if(output.charAt(i) == 'F'){
                while(angle / 360 >= 1){
                    angle = angle - 360;
                }
                //den strich malen
                Rectangle linie = new Rectangle(x,y,width,lenght, color);
                linie.turn(x,y,angle);
                // den endpunkt der linie anhand des Winkels festlegen
                if(angle == 0){
                    y = y + lenght;
                } else if(angle == 90){
                    x = x - lenght;
                } else if(angle == 180){
                    y = y - lenght;
                } else if(angle == 270){
                    x = x + lenght;
                    // den winkel in der Konsole ausgeben, wenn etwas nicht geklappt hat
                } else System.out.println(angle);
            }
        }
        //die neuen regeln an Main.java rueckgeben
        return new Output(x,y,angle,output);
    }
}