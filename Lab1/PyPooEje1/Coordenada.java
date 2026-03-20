package Lab1.PyPooEje1;
public class Coordenada{
    private double x;
    private double y;

    public Coordenada(){
        this.x = 0;
        this.y = 0;
    }

    public Coordenada(double x, double y){
        this.x = x;
        this.y = y;
    }

    public Coordenada(Coordenada c){
        this.x = c.getX();
        this.y = c.getY();

    }

    public double getX(){
        return this.x;
    }

    public double getY(){
        return this.y;
    }

    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }

     // Distancia euclideana (metodo de instancia)
    public double distancia(Coordenada c) {
        double dx = this.x - c.x;
        double dy = this.y - c.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    // Distancia euclideana (metodo de clase)
    public static double distancia(Coordenada c1, Coordenada c2) {
        double dx = c1.x - c2.x;
        double dy = c1.y - c2.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    @Override
    public String toString(){
        return "[" + this.x + ", " + this.y + "]";
    }
}

