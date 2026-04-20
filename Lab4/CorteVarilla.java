// ============================================================
// ACTIVIDAD 06: Corte de Varilla
// Tecnica: Programacion Dinamica vs Solucion Recursiva Naive
// Problema: dada una varilla de longitud n y precios por pieza,
//           encontrar el maximo valor al cortar la varilla.
// ============================================================
public class CorteVarilla {

    // ----------------------------------------------------------
    // SOLUCION NAIVE (Recursiva sin memorizacion) - O(2^n)
    // Muy ineficiente: recalcula los mismos subproblemas muchas veces
    // ----------------------------------------------------------
    static int getValueNaive(int[] values, int length) {
        // CASO BASE: longitud 0 no tiene valor
        if (length <= 0) return 0;

        int tmpMax = -1;
        // Probar todos los posibles primeros cortes
        for (int i = 0; i < length; i++) {
            // Valor del primer trozo + mejor valor del resto
            tmpMax = Math.max(tmpMax, values[i] + getValueNaive(values, length - i - 1));
        }
        return tmpMax;
    }

    // ----------------------------------------------------------
    // SOLUCION CON PROGRAMACION DINAMICA - O(n^2)
    // Guarda los resultados de subproblemas para no recalcularlos
    // ----------------------------------------------------------
    static int getValueDP(int[] values, int rodLength) {
        // subSolutions[i] = mejor valor para una varilla de longitud i
        int[] subSolutions = new int[rodLength + 1];
        // subSolutions[0] = 0 (varilla de longitud 0 vale 0)

        // Calcular el mejor valor para cada longitud de 1 a rodLength
        for (int i = 1; i <= rodLength; i++) {
            int tmpMax = -1;
            // Probar todos los primeros cortes posibles para esta longitud
            for (int j = 0; j < i; j++) {
                // values[j] = precio del trozo de longitud j+1
                // subSolutions[i-j-1] = mejor valor del resto (ya calculado)
                tmpMax = Math.max(tmpMax, values[j] + subSolutions[i - j - 1]);
            }
            subSolutions[i] = tmpMax; // guardar resultado
        }

        return subSolutions[rodLength]; // resultado para la varilla completa
    }

    public static void main(String[] args) {
        // values[i] = precio de una pieza de longitud (i+1)
        int[] values = new int[]{3, 7, 1, 3, 9};
        int rodLength = values.length;

        System.out.println("=== Corte de Varilla ===");
        System.out.println("Precios por longitud: ");
        for (int i = 0; i < values.length; i++)
            System.out.println("  Longitud " + (i+1) + " -> Precio: " + values[i]);

        System.out.println("\nSolucion NAIVE (recursiva): " + getValueNaive(values, rodLength));
        System.out.println("Solucion DP (programacion dinamica): " + getValueDP(values, rodLength));
        // Ambas deben dar 17

        // Segundo ejemplo
        int[] values2 = {1, 5, 8, 9, 10, 17, 17, 20};
        System.out.println("\n--- Segundo ejemplo ---");
        System.out.println("Solucion NAIVE: " + getValueNaive(values2, values2.length));
        System.out.println("Solucion DP: " + getValueDP(values2, values2.length));
    }
}
