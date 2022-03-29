import sas.Sprite;

public class Output {
    //hier weden alle regeln gespeichet
    private double x;
    private double y;
    private String output;
    private double angle;
    private Sprite part;

    //hier werden für neue daten, die alten daten überschrieben
    public Output(double x, double y, double angle, String output, Sprite part){
        this.angle = angle;
        this.x = x;
        this.y = y;
        this.output = output;
        this.part = part;
    }

//hier werden die gespeicherten Daten aufrufbar gemacht

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public String getOutput() {
        return output;
    }

    public double getAngle() {
        return angle;
    }

    public Sprite getPart(){return part;}
}
