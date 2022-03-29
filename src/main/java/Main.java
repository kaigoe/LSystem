import sas.Sprite;
import sas.Text;
import sas.View;

public class Main {
    //werte definieren
    private static int fensterbreite = 1600;
    private static int fensterhoehe = 1000;
    private static double strichBreite = 1;
    private static double strichlänge = 5;
    private static View view;

    public static void main(String[] args){
        start();
    }

    public static void start(){
        boolean run = true;
        //ein fenster erstellen
        view = new View(fensterbreite,fensterhoehe);
        //Informationen
        new Text(20,0,"n für den nächsten und q zum stoppen      Dises Programm wirde geschriben von Kai und zuletzt am 29.03.2022 geändert");
        //zähler erstellen für iterrationen
        int iterration = 0;
        //Die starteinstellungen festlegen (siehe Output.java fuer mehr infos)
        Output output = new Output(fensterbreite/4, fensterhoehe/2, 180, "FX", new Sprite());
        //in die konsole schreiben
        System.out.print("Wir starten mit 'FX' wollen sie Fortfaren? (Enter/Nein): ");
        //ein textfeld um in dem fenster etwas zu visualisieren
        Text text = new Text(20, 50,"");
        //schleife starten, die solange läuft, bis man nicht mehr enter drückt
        while (run){
            //zur visuellen abtrennung in der konsole
            System.out.println("----------------");
            //iterrationszähler erhöhen
            iterration = iterration + 1;
            //neue Regeln festlegen, nachdem neue itteration durchgeführt wurde
            output = LSystem.run(output.getOutput(), fensterbreite/2, fensterhoehe/2,90+(90*iterration),strichBreite, 700*(Math.pow(2.0/3.0,iterration)), output.getPart());

            while(!view.keyPressed('n') && run){
                if(view.keyPressed('q')) run = false;
                view.wait(10);
            }
            view.keyBufferDelete();
        }
        text.setText("Sie heben " + iterration + " iterrationen ausgeführt!");
    }
}
