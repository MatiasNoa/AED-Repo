import java.util.*;

// ============================================================
// ACTIVIDAD 02: Subconjuntos y Permutaciones
// Tecnica: Recursividad + Backtracking
// ============================================================
public class Subconjuntos {

    // Genera todos los subconjuntos posibles de un arreglo
    // arr: el arreglo original
    // actual: subconjunto que se esta construyendo
    // i: indice actual en el arreglo
    public static void generarSubconjuntos(int[] arr, List<Integer> actual, int i) {
        // CASO BASE: llegamos al final del arreglo, imprimir el subconjunto
        if (i == arr.length) {
            System.out.println(actual);
            return;
        }

        // DECISION 1: incluir el elemento actual
        actual.add(arr[i]);
        generarSubconjuntos(arr, actual, i + 1);

        // BACKTRACKING: deshacer la inclusion para probar la otra opcion
        actual.remove(actual.size() - 1);

        // DECISION 2: NO incluir el elemento actual
        generarSubconjuntos(arr, actual, i + 1);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.println("=== Subconjuntos de {1,2,3} ===");
        // Total: 2^3 = 8 subconjuntos
        generarSubconjuntos(arr, new ArrayList<>(), 0);
    }
}
