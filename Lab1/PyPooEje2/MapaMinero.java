package Lab1.PyPooEje2;
import java.io.*;
import java.util.*;

public class MapaMinero {
    private Zona[][] zonas;
    private int filas;
    private int columnas;

    // Constructor que lee desde archivo
    public MapaMinero(String archivo) throws Exception {
        Scanner sc = new Scanner(new File(archivo));

        // Lee primera linea
        filas = sc.nextInt();
        columnas = sc.nextInt();
        zonas = new Zona[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                // lee cada zona: mineral cantidad pureza
                String mineral = sc.next();
                double cantidad = sc.nextDouble();
                double pureza = sc.nextDouble();
                zonas[i][j] = new Zona(mineral, cantidad, pureza);
            }
        }
        sc.close();
    }

    public int getFilas()    { return filas; }
    public int getColumnas() { return columnas; }
    public Zona getZona(int i, int j) { return zonas[i][j]; }

    // Busca la subregion k x k con mayor valor economico total
    public void analizarRegion(int k) {
        double maxValor = -1;
        int mejorFila = 0, mejorCol = 0;

        for (int i = 0; i <= filas - k; i++) {
            for (int j = 0; j <= columnas - k; j++) {
                double total = calcularValorRegion(i, j, k);
                if (total > maxValor) {
                    // Solo captura la region con mayor valor
                    // guardamos el valor y la posicion inicial
                    maxValor = total;
                    mejorFila = i;
                    mejorCol = j;
                }
            }
        }

        // Mostrar resultados
        System.out.println("Region mas valiosa encontrada:");
        System.out.println();
        System.out.println("Posicion inicial: (" + mejorFila + "," + mejorCol + ")");
        System.out.println("Tamano de la region: " + k + " x " + k);
        System.out.println();
        System.out.println("Zonas analizadas:");

        // Contar minerales para encontrar el predominante
        String[] minerales = new String[k * k];
        int[] conteo = new int[k * k];
        int size = 0;

        // Recorremos subregion
        for (int i = mejorFila; i < mejorFila + k; i++) {
            for (int j = mejorCol; j < mejorCol + k; j++) {
                // Imprime cada zona (toString)
                System.out.println(zonas[i][j].toString());
                String m = zonas[i][j].getTipoMineral();

                int pos = -1;

                // Buscar si ya existe mineral en el arreglo
                for (int x = 0; x < size; x++) {
                    if (minerales[x].equals(m)) {
                        pos = x;
                        break;
                    }
                }

                // Si no existe, agregarlo
                if (pos == -1) {
                    minerales[size] = m;
                    conteo[size] = 1;
                    size++;
                } else {
                    conteo[pos]++;
                }
            }
        }

        // %.1f para mostrar un decimal y %n para salto de linea
        System.out.printf("Valor total estimado: %.1f%n", maxValor);

        // Mineral predominante
        String predominante = "";
        int maxConteo = 0;

        for (int i = 0; i < size; i++) {
            if (conteo[i] > maxConteo) {
                maxConteo = conteo[i];
                predominante = minerales[i];
            }
        }

        System.out.println("Mineral predominante en la region: " + predominante);
    }

    // Calcula el valor total de una region k x k comenzando en (fila, col)
    private double calcularValorRegion(int fila, int col, int k) {
        double total = 0;
        for (int i = fila; i < fila + k; i++) {
            for (int j = col; j < col + k; j++) {
                total += zonas[i][j].getValor();
            }
        }
        return total;
    }
}
