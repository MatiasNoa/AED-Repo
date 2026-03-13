import java.util.*;

public class Rectangulo{
    private Coordenada esquina1;
    private Coordenada esquina2;

    public Rectangulo(Coordenada esquina1, Coordenada esquina2){
        this.esquina1 = esquina1;
        this.esquina2 = esquina2;
    }

    public Coordenada getEsquina1(){
        return this.esquina1;
    }

    public Coordenada getEsquina2(){
        return this.esquina2;
    }

    public void setEsquina1(Coordenada esquina1){
        this.esquina1 = esquina1;
    }

    public void setEsquina2(Coordenada esquina2){
        this.esquina2 = esquina2;
    }

    public toString(){
        return "Rectangulo: " + this.esquina1.toString() + " - " + this.esquina2.toString();
    }
}