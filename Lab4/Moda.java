import java.util.Arrays;

// ============================================================
// ACTIVIDAD 05: Encontrar la Moda de un arreglo
// Se presentan 3 soluciones con diferente complejidad
// ============================================================
public class Moda {

    // ----------------------------------------------------------
    // SOLUCION 1: Fuerza bruta - O(n^2)
    // Para cada elemento, calcula su frecuencia y guarda la mayor
    // ----------------------------------------------------------

    // Calcula cuantas veces aparece 'ele' en array[first..end]
    private static int frecuencia(int[] array, int first, int end, int ele) {
        if (first > end) return 0;
        int suma = 0;
        for (int i = first; i <= end; i++)
            if (array[i] == ele) suma++;
        return suma;
    }

    // Complejidad de frecuencia: O(n)
    // Complejidad de moda1: O(n^2) porque llama a frecuencia n veces
    public static int moda1(int[] array) {
        int first = 0;
        int end = array.length - 1;

        if (first == end) return array[first];

        int moda = array[first];
        int maxfrec = frecuencia(array, first, end, moda);

        for (int i = first + 1; i < end; i++) {
            int frec = frecuencia(array, i, end, array[i]);
            if (frec > maxfrec) {
                maxfrec = frec;
                moda = array[i];
            }
        }
        return moda;
    }

    // ----------------------------------------------------------
    // SOLUCION 2: Arreglo ordenado - O(n log n)
    // Requiere ordenar primero, luego recorre una sola vez O(n)
    // ----------------------------------------------------------
    public static int moda2(int[] arrayOriginal) {
        // Copiar para no modificar el original
        int[] array = Arrays.copyOf(arrayOriginal, arrayOriginal.length);
        Arrays.sort(array); // ordenar: O(n log n)

        int first = 1;
        int p = 0;
        int end = array.length - 1;
        int moda = array[0];
        int frec = 1;
        int maxfrec = 0;

        // Recorrer el arreglo ordenado una sola vez: O(n)
        while (first <= end) {
            if (array[p] == array[first]) {
                // El elemento actual es igual al anterior, incrementar frecuencia
                frec++;
                first++;
            } else {
                // Cambio de elemento, comparar frecuencia acumulada
                if (frec > maxfrec) {
                    maxfrec = frec;
                    moda = array[p];
                }
                p = first;
                first = p + 1;
                frec = 1;
            }
        }
        // Verificar el ultimo grupo
        if (frec > maxfrec) moda = array[p];

        return moda;
    }

    // ----------------------------------------------------------
    // SOLUCION 3: Divide y Venceras - mejor que O(n log n)
    // Divide el arreglo en 3 partes por la mediana y usa conjuntos
    // homogeneos (todos iguales) y heterogeneos (distintos)
    // Implementacion simplificada con quickselect-style partition
    // ----------------------------------------------------------
    public static int moda3(int[] arrayOriginal) {
        int[] arr = Arrays.copyOf(arrayOriginal, arrayOriginal.length);
        return moda3Helper(arr, 0, arr.length - 1);
    }

    // Calcula la mediana de tres posiciones para mejor pivote
    private static int mediana(int[] arr, int izq, int der) {
        int mid = (izq + der) / 2;
        return arr[mid];
    }

    // Cuenta ocurrencias de val en arr[izq..der]
    private static int contarOcurrencias(int[] arr, int izq, int der, int val) {
        int count = 0;
        for (int i = izq; i <= der; i++)
            if (arr[i] == val) count++;
        return count;
    }

    // Divide el arreglo en tres partes: menores, iguales y mayores a la mediana
    // Retorna {inicio_iguales, fin_iguales}
    private static int[] particionar(int[] arr, int izq, int der, int mediana) {
        int[] temp = new int[der - izq + 1];
        int idx = 0;
        // Menores
        for (int i = izq; i <= der; i++) if (arr[i] < mediana) temp[idx++] = arr[i];
        int inicioIguales = izq + idx;
        // Iguales
        for (int i = izq; i <= der; i++) if (arr[i] == mediana) temp[idx++] = arr[i];
        int finIguales = izq + idx - 1;
        // Mayores
        for (int i = izq; i <= der; i++) if (arr[i] > mediana) temp[idx++] = arr[i];
        System.arraycopy(temp, 0, arr, izq, temp.length);
        return new int[]{inicioIguales, finIguales};
    }

    private static int moda3Helper(int[] arr, int izq, int der) {
        // Caso base: solo un elemento
        if (izq == der) return arr[izq];
        // Caso base: todos iguales
        if (arr[izq] == arr[der]) return arr[izq];

        int med = mediana(arr, izq, der);
        int[] limites = particionar(arr, izq, der, med);

        int izqMod  = moda3Helper(arr, izq, limites[0] - 1 > izq ? limites[0] - 1 : izq);
        int medMod  = med; // los iguales son todos 'med'
        int derMod  = moda3Helper(arr, limites[1] + 1 < der ? limites[1] + 1 : der, der);

        int freqIzq = contarOcurrencias(arr, izq, der, izqMod);
        int freqMed = limites[1] - limites[0] + 1; // cantidad de iguales a mediana
        int freqDer = contarOcurrencias(arr, izq, der, derMod);

        if (freqMed >= freqIzq && freqMed >= freqDer) return medMod;
        if (freqIzq >= freqDer) return izqMod;
        return derMod;
    }

    public static void main(String[] args) {
        int[] array1 = {4, 1, 2, 2, 3, 1, 2, 4, 2}; // moda = 2
        int[] array2 = {5, 5, 1, 3, 3, 3, 9};        // moda = 3
        int[] array3 = {7, 7, 7, 2, 2, 1};           // moda = 7

        System.out.println("=== Solucion 1: Fuerza bruta O(n^2) ===");
        System.out.println("Moda de " + Arrays.toString(array1) + ": " + moda1(array1));
        System.out.println("Moda de " + Arrays.toString(array2) + ": " + moda1(array2));

        System.out.println("\n=== Solucion 2: Arreglo ordenado O(n log n) ===");
        System.out.println("Moda de " + Arrays.toString(array1) + ": " + moda2(array1));
        System.out.println("Moda de " + Arrays.toString(array2) + ": " + moda2(array2));

        System.out.println("\n=== Solucion 3: Divide y Venceras ===");
        System.out.println("Moda de " + Arrays.toString(array1) + ": " + moda3(array1));
        System.out.println("Moda de " + Arrays.toString(array2) + ": " + moda3(array2));
        System.out.println("Moda de " + Arrays.toString(array3) + ": " + moda3(array3));
    }
}
