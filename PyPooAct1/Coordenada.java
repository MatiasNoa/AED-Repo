import java.util.*;

public Class Coordenada{
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

    public double distancia(Coordenada c){
        return Math.sqrt(Math.pow(this.x - c.getX(), 2) + Math.pow(this.y - c.getY(), 2));
    }

    public static double distancia(Coordenada c1, Coordenada c2){
        return Math.sqrt(Math.pow(c1.getX() - c2.getX(), 2) + Math.pow(c1.getY() - c2.getY(), 2));
    }

    public toString(){
        return "(" + this.x + ", " + this.y + ")";
    }
}