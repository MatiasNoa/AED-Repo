package Lab1.PyPooEje1;


public class Rectangulo{
    private Coordenada esquina1;
    private Coordenada esquina2;

    public Rectangulo(Coordenada esquina1, Coordenada esquina2){
        this.esquina1 = esquina1;
        this.esquina2 = esquina2;
        normalizar();
    }

    public Coordenada getEsquina1(){
        return this.esquina1;
    }

    public Coordenada getEsquina2(){
        return this.esquina2;
    }

    public void setEsquina1(Coordenada esquina1){
        this.esquina1 = esquina1;
        normalizar();
    }

    public void setEsquina2(Coordenada esquina2){
        this.esquina2 = esquina2;
        normalizar();
    }

    // Normalizar para que esquina1 sea inferior izquierda y esquina2 sea superior derecha siempre
    public void normalizar() {
        double minX = Math.min(esquina1.getX(), esquina2.getX());
        double minY = Math.min(esquina1.getY(), esquina2.getY());
        double maxX = Math.max(esquina1.getX(), esquina2.getX());
        double maxY = Math.max(esquina1.getY(), esquina2.getY());
        esquina1 = new Coordenada(minX, minY);
        esquina2 = new Coordenada(maxX, maxY);
    }

    // Calcula el area del rectangulo
    public double calculoArea() {
        double ancho = Math.abs(esquina2.getX() - esquina1.getX());
        double alto  = Math.abs(esquina2.getY() - esquina1.getY());
        return ancho * alto;
    }

    public String toString() {
        return "(" + esquina1.toString() + ", " + esquina2.toString() + ")";
    }
}