import java.util.*;

// ============================================================
// EJERCICIO 01: Subconjunto con restricciones
// Tecnica: Backtracking
// Reglas:
//   - Todos los multiplos de 3 DEBEN incluirse obligatoriamente
//   - Si un numero es par y el siguiente tambien es par, NO se puede elegir
//   - No es necesario usar todos los elementos
// ============================================================
public class Ejercicio1 {

    // arr: arreglo de numeros
    // i: indice actual
    // sumaActual: suma del subconjunto que se esta construyendo
    // objetivo: suma que se quiere alcanzar
    // Retorna true si es posible alcanzar el objetivo
    public static boolean resolver(int[] arr, int i, int sumaActual, int objetivo) {
        // CASO BASE: llegamos al objetivo exacto
        if (sumaActual == objetivo) return true;

        // CASO BASE: pasamos del objetivo o recorrimos todo el arreglo
        if (i >= arr.length || sumaActual > objetivo) return false;

        int elemento = arr[i];

        // REGLA 1: multiplos de 3 son obligatorios
        if (elemento % 3 == 0) {
            // Forzar inclusion, no hay decision
            return resolver(arr, i + 1, sumaActual + elemento, objetivo);
        }

        // REGLA 2: si el elemento es par y el siguiente tambien es par, no puede elegirse
        boolean esPar = (elemento % 2 == 0);
        boolean siguienteEsPar = (i + 1 < arr.length) && (arr[i + 1] % 2 == 0);

        if (esPar && siguienteEsPar) {
            // No se puede elegir este elemento par (el siguiente tambien es par)
            return resolver(arr, i + 1, sumaActual, objetivo);
        }

        // DECISION: incluir o no incluir el elemento
        // Opcion 1: incluir
        if (resolver(arr, i + 1, sumaActual + elemento, objetivo)) return true;
        // Opcion 2: no incluir (backtracking)
        return resolver(arr, i + 1, sumaActual, objetivo);
    }

    // Calcula la suma obligatoria de multiplos de 3
    public static int sumaObligatoria(int[] arr) {
        int suma = 0;
        for (int x : arr) if (x % 3 == 0) suma += x;
        return suma;
    }

    public static void main(String[] args) {
        // --- Ejemplo 1 ---
        // Multiplos de 3: {3, 6} suma = 9
        // 3 + 6 + 7 + 4 = 20 -> true
        int[] arr1 = {3, 4, 6, 7, 2};
        int objetivo1 = 20;
        System.out.println("Entrada: " + Arrays.toString(arr1) + " objetivo=" + objetivo1);
        System.out.println("Salida: " + resolver(arr1, 0, 0, objetivo1)); // true

        // --- Ejemplo 2 ---
        // Multiplos de 3: {3, 6} -> suma = 9, no hay forma de llegar a 18
        int[] arr2 = {3, 4, 6, 7, 8};
        int objetivo2 = 18;
        System.out.println("\nEntrada: " + Arrays.toString(arr2) + " objetivo=" + objetivo2);
        System.out.println("Salida: " + resolver(arr2, 0, 0, objetivo2)); // false

        // --- Ejemplo 3 ---
        // Multiplos de 3: {3, 6, 9} -> suma obligatoria = 18
        // 8 no se puede (le sigue 4, ambos pares)
        int[] arr3 = {3, 9, 2, 5, 8, 4};
        int objetivo3 = 31;
        System.out.println("\nEntrada: " + Arrays.toString(arr3) + " objetivo=" + objetivo3);
        System.out.println("Salida: " + resolver(arr3, 0, 0, objetivo3)); // false
    }
}
