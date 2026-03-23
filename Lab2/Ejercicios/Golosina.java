// Clase Golosina - Actividad 3
public class Golosina {

    private String nombre;
    private double peso;

    public Golosina(String nombre, double peso) {
        this.nombre = nombre;
        this.peso = peso;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPeso() {
        return this.peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    // Ejercicio 5: equals para buscar por nombre y peso
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || !(obj instanceof Golosina)) return false;
        Golosina otra = (Golosina) obj;
        return this.nombre.equals(otra.nombre) && this.peso == otra.peso;
    }

    @Override
    public String toString() {
        return "Golosina[nombre=" + nombre + ", peso=" + peso + "]";
    }
}
