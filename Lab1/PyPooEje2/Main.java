package Lab1.PyPooEje2;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese el nombre del archivo: ");
        String archivo = sc.next();

        System.out.print("Ingrese el tamano k de la subregion: ");
        int k = sc.nextInt();

        try {
            MapaMinero mapa = new MapaMinero(archivo);
            mapa.analizarRegion(k);
        } catch (Exception e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }

        sc.close();
    }
}
