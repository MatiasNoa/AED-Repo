package Lab5;
// Representa una tarea con título y nivel de prioridad
public class Tarea{

    private String titulo;
    private int prioridad;  // 1=baja, 2=media, 3=alta

    public Tarea(String titulo, int prioridad) {
        this.titulo = titulo;
        this.prioridad = prioridad;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getPrioridad() {
        return prioridad;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Tarea)) return false;
        Tarea otra = (Tarea) obj;
        return this.titulo.equals(otra.titulo) && this.prioridad == otra.prioridad;
    }


    @Override
    public String toString() {
        String nivel = prioridad == 3 ? "ALTA" : prioridad == 2 ? "MEDIA" : "BAJA";
        return "Tarea['" + titulo + "', prioridad=" + nivel + "(" + prioridad + ")]";
    }
}
