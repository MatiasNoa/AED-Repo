package Lab2;

public class Golosina {

    private String nombre;
    private double peso;

    public Golosina(String nombre, double peso) {
        this.nombre = nombre;
        this.peso = peso;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPeso() {
        return peso;
    }

    @Override
    public String toString() {
        return "Golosina{" + "nombre=" + nombre + ", peso=" + peso + '}';
    }
}