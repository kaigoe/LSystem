
import sas.View;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

public class Main {
    //werte definieren
    private static int fensterbreite = 1600;
    private static int fensterhoehe = 1000;
    private static double strichBreite = 1;
    private static double strichlänge = 5;

    public static void main(String[] args) throws IOException {
        start();
    }

    public static void start() throws IOException {
        //zum ausleden der konsole
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //um gegebenfallst werte anzupassten
        String input;
        System.out.println("Alle werte in Pixeln angeben");
        System.out.print("Fensterbreite (fuer Standart[" + fensterbreite + "] einfach enter): ");
        input = reader.readLine();
        if(!input.equals("")) fensterbreite = Integer.parseInt(input);
        System.out.print("Fensterhoehe (fuer Standart[" + fensterhoehe + "] einfach enter): ");
        input = reader.readLine();
        if(!input.equals("")) fensterhoehe = Integer.parseInt(input);
        System.out.print("Strichbreite (fuer Standart[" + strichBreite + "] einfach Enter): ");
        input = reader.readLine();
        if(!input.equals("")) strichBreite = Integer.parseInt(input);
        System.out.print("Strichlaenge (fuer Standart[" + strichlänge + "] einfach Enter): ");
        input = reader.readLine();
        if(!input.equals("")) strichlänge = Integer.parseInt(input);
        //ein fenster erstellen
        new View(fensterbreite,fensterhoehe);
        //zähler erstellen für iterrationen
        int iterration = 0;
        //Die starteinstellungen festlegen (siehe Output.java fuer mehr infos)
        Output output = new Output(fensterbreite/2, fensterhoehe/2, 180, "FX");
        //in die konsole schreiben
        System.out.print("Wir starten mit 'FX' wollen sie Fortfaren? (Enter/Nein): ");
        //schleife starten, die solange läuft, bis man nicht mehr enter drückt
        while (reader.readLine().toLowerCase(Locale.ROOT).equals("")){
            //zur visuellen abtrennung in der konsole
            System.out.println("----------------");
            //iterrationszähler erhöhen
            iterration = iterration + 1;
            //neue Regeln festlegen, nachdem neue itteration durchgeführt wurde
            output = LSystem.run(output.getOutput(), output.getX(),output.getY(),output.getAngle(),strichBreite, strichlänge);
            //in konsole ergebnisse darstellen
            System.out.println("Die " + iterration + ". iterration ist: '" + output.getOutput() + "'");
            System.out.print("Noch eine iteration ausführen? (Enter/nein)");
        }
        System.out.println("Sie heben " + iterration + " ausgeführt!");
    }
}
