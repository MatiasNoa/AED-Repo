import java.util.Arrays;

// ============================================================
// ACTIVIDAD 04: Merge Sort - Ordenamiento por Mezcla
// Tecnica: Dividir y Conquistar
// Complejidad: O(n log n)
// ============================================================
public class MergeSort {

    // Mezcla dos mitades ordenadas en una sola
    // arr: arreglo completo
    // izq: inicio de la primera mitad
    // mid: fin de la primera mitad
    // der: fin de la segunda mitad
    public static void merge(int[] arr, int izq, int mid, int der) {
        // Calcular tamanos de los sub-arreglos
        int n1 = mid - izq + 1; // tamano mitad izquierda
        int n2 = der - mid;     // tamano mitad derecha

        // Copias temporales de cada mitad
        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) L[i] = arr[izq + i];
        for (int j = 0; j < n2; j++) R[j] = arr[mid + 1 + j];

        // Mezclar L y R de vuelta al arreglo original en orden
        int i = 0, j = 0, k = izq;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Copiar elementos restantes de L (si quedan)
        while (i < n1) { arr[k] = L[i]; i++; k++; }
        // Copiar elementos restantes de R (si quedan)
        while (j < n2) { arr[k] = R[j]; j++; k++; }
    }

    // Divide el arreglo y lo ordena recursivamente
    public static void mergeSort(int[] arr, int izq, int der) {
        // CASO BASE: si solo hay 1 elemento, ya esta ordenado
        if (izq >= der) return;

        int mid = (izq + der) / 2; // punto medio

        // DIVIDIR: ordenar la mitad izquierda
        mergeSort(arr, izq, mid);
        // DIVIDIR: ordenar la mitad derecha
        mergeSort(arr, mid + 1, der);
        // CONQUISTAR: mezclar las dos mitades ordenadas
        merge(arr, izq, mid, der);
    }

    // Metodo de ayuda para mostrar el arreglo
    public static void mostrar(int[] arr, String etiqueta) {
        System.out.print(etiqueta + ": ");
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {

        // --- Arreglo de 5 elementos ---
        int[] a5 = {64, 25, 12, 22, 11};
        mostrar(a5, "Antes (5 elementos)");
        mergeSort(a5, 0, a5.length - 1);
        mostrar(a5, "Despues (5 elementos)");

        System.out.println();

        // --- Arreglo de 8 elementos ---
        int[] a8 = {38, 27, 43, 3, 9, 82, 10, 1};
        mostrar(a8, "Antes (8 elementos)");
        mergeSort(a8, 0, a8.length - 1);
        mostrar(a8, "Despues (8 elementos)");

        System.out.println();

        // --- Arreglo de 10 elementos ---
        int[] a10 = {15, 8, 3, 23, 42, 7, 19, 55, 1, 36};
        mostrar(a10, "Antes (10 elementos)");
        mergeSort(a10, 0, a10.length - 1);
        mostrar(a10, "Despues (10 elementos)");
    }
}
