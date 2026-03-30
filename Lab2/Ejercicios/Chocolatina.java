// Clase Chocolatina - Actividad 3
package Lab2.Ejercicios;

public class Chocolatina {

    private String marca;

    public Chocolatina(String marca) {
        this.marca = marca;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    // equals para comparar por marca (necesario para exist y contar)
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || !(obj instanceof Chocolatina)) return false;
        Chocolatina otra = (Chocolatina) obj;
        return this.marca.equals(otra.marca);
    }

    @Override
    public String toString() {
        return "Chocolatina[marca=" + marca + "]";
    }
}
