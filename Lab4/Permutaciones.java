import java.util.*;

// ============================================================
// ACTIVIDAD 02: Permutaciones
// Tecnica: Recursividad + Backtracking
// Genera todas las formas posibles de ordenar un conjunto
// ============================================================
public class Permutaciones {

    // arr: arreglo original
    // actual: permutacion que se esta construyendo
    // usado: marca si el elemento en posicion i ya fue usado
    public static void permutar(int[] arr, List<Integer> actual, boolean[] usado) {
        // CASO BASE: la permutacion esta completa (tiene todos los elementos)
        if (actual.size() == arr.length) {
            System.out.println(actual); // imprimir la permutacion
            return;
        }

        // Recorrer todos los elementos del arreglo
        for (int i = 0; i < arr.length; i++) {
            if (!usado[i]) { // solo si el elemento no fue usado aun
                // ELEGIR: marcar como usado y agregar a la permutacion actual
                usado[i] = true;           // completar codigo: true
                actual.add(arr[i]);        // completar codigo: arr[i]

                // AVANZAR: llamada recursiva
                permutar(arr, actual, usado);

                // BACKTRACKING: deshacer la eleccion
                actual.remove(actual.size() - 1);
                usado[i] = false;          // completar codigo: false
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        boolean[] usado = new boolean[arr.length]; // todos en false por defecto

        System.out.println("=== Permutaciones de {1,2,3} ===");
        // Total: 3! = 6 permutaciones
        permutar(arr, new ArrayList<>(), usado);
    }
}
