package Lab3;
public class MergeSort {

    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {                                  //O(1)
            int mid = (left + right) / 2;                    //O(1)

            mergeSort(arr, left, mid);                       //O(T(n/2))
            mergeSort(arr, mid + 1, right);                  //O(T(n/2))
            
            if (arr[mid] <= arr[mid + 1]) return;            //O(1)
            merge(arr, left, mid, right);                    //O(n)
        }
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;                             //O(1)
        int n2 = right - mid;                                //O(1)

        int[] L = new int[n1];                               //O(n)
        int[] R = new int[n2];                               //O(n)

        for (int i = 0; i < n1; i++)                         //O(n)
            L[i] = arr[left + i];

        for (int j = 0; j < n2; j++)                         //O(n)
            R[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;                          //O(1)

        while (i < n1 && j < n2) {                           //O(n)
            if (L[i] <= R[j]) {                              //O(1)
                arr[k] = L[i];                               //O(1)
                i++;
            } else {
                arr[k] = R[j];                               //O(1)
                j++;
            }
            k++;
        }

        while (i < n1) {                                     //O(n)
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {                                     //O(n)
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}

/*
Análisis de complejidad
Bloque 1: O(1)
Verificación adicional antes del merge.
Bloque 2: O(T(n/2) + T(n/2))
Las llamadas recursivas siguen siendo iguales.
Bloque 3: O(n)
El merge solo se ejecuta si es necesario.

Función de recurrencia
En el peor caso:
T(n) = 2T(n/2) + n
En el mejor caso (arreglo ya ordenado):
T(n) = 2T(n/2) + 1

Expansión (mejor caso)
T(n) = 2T(n/2) + 1
T(n) = 2[2T(n/4) + 1] + 1
T(n) = 4T(n/4) + 3
⋮
T(n) = 2^k T(n/2^k) + (2^k - 1)
Caso base:
k = log n
T(n) = n·T(1) + (n - 1)
T(n) = O(n)

Resultados
•	Peor caso: O(n log n) 
•	Mejor caso: O(n) 

Diferencias con la versión original
•	Se evita realizar el merge si los subarreglos ya están ordenados 
•	Se reduce el número de operaciones innecesarias 
•	Mejora el rendimiento en casos prácticos

Aunque el orden de complejidad en el peor caso sigue siendo O(n log n), la versión mejorada optimiza el rendimiento en casos favorables, reduciendo el costo a O(n) cuando el arreglo ya está ordenado.

*/