// ============================================================
// EJERCICIO 03: Viaje mas barato a traves del rio
// Tecnica: Programacion Dinamica
// C[i][j] = costo minimo de ir del embarcadero i al j
// C[i][j] = min( T[i][k] + C[k][j] ) para todo i < k <= j
// ============================================================
public class Ejercicio3 {

    // Resuelve el viaje mas barato usando programacion dinamica
    // T[i][j] = tarifa DIRECTA del embarcadero i al j (0 si no hay conexion directa)
    // n = numero de embarcaderos
    public static int[][] calcularCostos(int[][] T, int n) {
        // C[i][j] = costo minimo de ir de i a j
        int[] C = new int[n];
        // Usando arreglo 2D
        int[][] costo = new int[n][n];

        // Caso base: costo de ir al mismo embarcadero es 0
        // costo[i][i] = 0 (ya inicializado)

        // Llenar de diagonal en diagonal (por longitud del viaje)
        // len = diferencia entre destino y origen
        for (int len = 1; len < n; len++) {
            for (int i = 0; i < n - len; i++) {
                int j = i + len; // destino

                // Empezar con el costo directo de i a j
                costo[i][j] = T[i][j];

                // Probar hacer escala en cada embarcadero k intermedio
                for (int k = i + 1; k < j; k++) {
                    // Costo = ir de i a k (directo) + mejor costo de k a j
                    int conEscala = T[i][k] + costo[k][j];
                    if (conEscala < costo[i][j]) {
                        costo[i][j] = conEscala; // actualizar si es mejor
                    }
                }
            }
        }
        return costo;
    }

    public static void main(String[] args) {
        // Ejemplo: 4 embarcaderos (indices 0, 1, 2, 3)
        // T[i][j] = tarifa directa de i a j
        // 0 = no hay conexion directa (no se puede ir "hacia atras")
        int n = 4;
        int[][] T = {
            {0, 2, 8, 15},  // desde 0: puede ir a 1(2), 2(8), 3(15)
            {0, 0, 3, 9},   // desde 1: puede ir a 2(3), 3(9)
            {0, 0, 0, 4},   // desde 2: puede ir a 3(4)
            {0, 0, 0, 0}    // desde 3: sin destino
        };

        int[][] costo = calcularCostos(T, n);

        System.out.println("=== Viaje mas barato a traves del rio ===");
        System.out.println("Tarifas directas (T):");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                System.out.printf("%4d", T[i][j]);
            System.out.println();
        }

        System.out.println("\nCostos minimos (C):");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                System.out.printf("%4d", costo[i][j]);
            System.out.println();
        }

        System.out.println("\nConsultas:");
        System.out.println("Costo minimo de 0 a 3: " + costo[0][3]); // 0->1->2->3 = 2+3+4=9
        System.out.println("Costo minimo de 0 a 2: " + costo[0][2]); // 0->1->2 = 2+3=5
        System.out.println("Costo minimo de 1 a 3: " + costo[1][3]); // 1->2->3 = 3+4=7
    }
}
