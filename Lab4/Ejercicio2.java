import java.util.Arrays;

// ============================================================
// EJERCICIO 02: K-esimo elemento mas grande
// Tecnica: Dividir y Conquistar (QuickSelect)
// Similar a QuickSort pero solo procesamos el lado relevante
// No se ordena el arreglo completo
// ============================================================
public class Ejercicio2 {

    // Particiona el arreglo alrededor de un pivote
    // Los elementos mayores al pivote van a la izquierda
    // Los menores van a la derecha
    // Retorna la posicion final del pivote
    public static int particionar(int[] arr, int izq, int der) {
        int pivote = arr[der]; // usamos el ultimo elemento como pivote
        int i = izq - 1;       // i apunta al ultimo elemento mayor al pivote

        for (int j = izq; j < der; j++) {
            if (arr[j] >= pivote) { // mayor o igual va a la izquierda
                i++;
                // intercambiar arr[i] y arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Poner el pivote en su posicion correcta
        int temp = arr[i + 1];
        arr[i + 1] = arr[der];
        arr[der] = temp;

        return i + 1; // posicion del pivote
    }

    // Encuentra el k-esimo elemento mas grande usando QuickSelect
    // arr: arreglo (se puede modificar)
    // izq, der: limites de busqueda
    // k: posicion buscada (1-based, 1 = el mas grande)
    public static int quickSelect(int[] arr, int izq, int der, int k) {
        // CASO BASE: solo hay un elemento
        if (izq == der) return arr[izq];

        // Particionar y obtener posicion del pivote
        int posicion = particionar(arr, izq, der);

        // Cuantos elementos hay a la izquierda del pivote (incluyendo el pivote)
        int rango = posicion - izq + 1;

        if (k == rango) {
            // El pivote ES el k-esimo elemento mas grande
            return arr[posicion];
        } else if (k < rango) {
            // El k-esimo esta en la mitad izquierda (mas grandes)
            return quickSelect(arr, izq, posicion - 1, k);
        } else {
            // El k-esimo esta en la mitad derecha (mas pequenos)
            return quickSelect(arr, posicion + 1, der, k - rango);
        }
    }

    public static int kEsimoMasGrande(int[] arr, int k) {
        // Copiar para no modificar el original
        int[] copia = Arrays.copyOf(arr, arr.length);
        return quickSelect(copia, 0, copia.length - 1, k);
    }

    public static void main(String[] args) {

        // [4, 2, 7, 10, 4, 17], k=3 -> esperado: 7 (17,10,7)
        int[] a1 = {4, 2, 7, 10, 4, 17};
        System.out.println("Array: " + Arrays.toString(a1) + ", k=3 -> " + kEsimoMasGrande(a1, 3));

        // [4, 2, 7, 10, 4, 1, 6], k=5 -> esperado: 4 (10,7,6,4,4)
        int[] a2 = {4, 2, 7, 10, 4, 1, 6};
        System.out.println("Array: " + Arrays.toString(a2) + ", k=5 -> " + kEsimoMasGrande(a2, 5));

        // [4, 2, 7, 1, 4, 6], k=1 -> esperado: 7
        int[] a3 = {4, 2, 7, 1, 4, 6};
        System.out.println("Array: " + Arrays.toString(a3) + ", k=1 -> " + kEsimoMasGrande(a3, 1));

        // [9, 2, 7, 1, 7], k=4 -> esperado: 2 (9,7,7,2)
        int[] a4 = {9, 2, 7, 1, 7};
        System.out.println("Array: " + Arrays.toString(a4) + ", k=4 -> " + kEsimoMasGrande(a4, 4));
    }
}
