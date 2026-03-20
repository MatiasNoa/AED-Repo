package Lab1.PyPooEje1;

public class ContainerRect {

    private Rectangulo[] rectangulos;
    private double[] distancias;
    private double[] areas;
    private int n;                      // capacidad maxima
    public static int numRec = 0;       // cantidad de rectangulos guardados

    // Constructor
    public ContainerRect(int n) {
        this.n = n;
        rectangulos = new Rectangulo[n];
        distancias   = new double[n];
        areas        = new double[n];
    }

    // Agrega un rectangulo al contenedor
    public void addRectangulo(Rectangulo r) {
        if (numRec < n) {
            rectangulos[numRec] = r;
            distancias[numRec]  = Coordenada.distancia(r.getEsquina1(), r.getEsquina2());
            areas[numRec]       = r.calculoArea();
            numRec++;
        } else {
            System.out.println("No es posible guardar mas rectangulos. Contenedor lleno.");
        }
    }

    // Muestra todos los rectangulos almacenados
    public String toString() {
        String resultado = String.format("%-5s %-30s %-10s %-10s%n",
                "Rect", "Coordenadas", "Distancia", "Area");
        for (int i = 0; i < numRec; i++) {
            resultado += String.format("%-5d %-30s %-10.3f %-10.2f%n",
                    (i + 1),
                    rectangulos[i].toString(),
                    distancias[i],
                    areas[i]);
        }
        return resultado;
    }
}
