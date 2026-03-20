package Lab1.PyPooEje2;
public class Zona {
    private String tipoMineral;
    private double cantidad;
    private double pureza;

    public Zona(String tipoMineral, double cantidad, double pureza) {
        this.tipoMineral = tipoMineral;
        this.cantidad = cantidad;
        this.pureza = pureza;
    }

    public String getTipoMineral() {
        return tipoMineral;
    }

    public double getCantidad() {
        return cantidad;
    }

    public double getPureza() {
        return pureza;
    }

    // Valor economico = cantidad * pureza
    public double getValor() {
        return cantidad * pureza;
    }

    public String toString() {
        return "[ " + tipoMineral + ", cantidad: " + cantidad + ", pureza: " + pureza + " ]";
    }
}
