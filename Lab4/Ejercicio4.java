// ============================================================
// EJERCICIO 04: Laberinto con Backtracking
// Tecnica: Recursividad + Backtracking
// 0 = camino libre, 1 = pared
// Busca camino de (0,0) a (n-1,m-1)
// ============================================================
public class Ejercicio4 {

    // Imprime el laberinto o la solucion
    public static void imprimir(int[][] matriz, String titulo) {
        System.out.println(titulo);
        for (int[] fila : matriz) {
            for (int val : fila)
                System.out.print(val + " ");
            System.out.println();
        }
    }

    // Intenta resolver el laberinto de forma recursiva con backtracking
    // laberinto: matriz original (0=libre, 1=pared)
    // solucion: matriz donde marcamos el camino con 1
    // fila, col: posicion actual
    // Retorna true si encontro camino, false si no hay salida
    public static boolean resolver(int[][] laberinto, int[][] solucion, int fila, int col) {
        int n = laberinto.length;
        int m = laberinto[0].length;

        // CASO BASE: llegamos a la esquina inferior derecha (destino)
        if (fila == n - 1 && col == m - 1) {
            solucion[fila][col] = 1; // marcar celda final
            return true;
        }

        // Verificar que la posicion actual es valida:
        // - dentro del laberinto
        // - es camino libre (0)
        // - no fue visitada ya (solucion[fila][col] == 0)
        if (fila < 0 || fila >= n || col < 0 || col >= m) return false;
        if (laberinto[fila][col] == 1) return false; // pared
        if (solucion[fila][col] == 1) return false;  // ya visitado

        // Marcar la celda actual como parte del camino
        solucion[fila][col] = 1;

        // Intentar moverse en las 4 direcciones: abajo, derecha, arriba, izquierda
        if (resolver(laberinto, solucion, fila + 1, col)) return true; // abajo
        if (resolver(laberinto, solucion, fila, col + 1)) return true; // derecha
        if (resolver(laberinto, solucion, fila - 1, col)) return true; // arriba
        if (resolver(laberinto, solucion, fila, col - 1)) return true; // izquierda

        // BACKTRACKING: ninguna direccion funcionó, desmarcar esta celda
        solucion[fila][col] = 0;
        return false;
    }

    public static void main(String[] args) {

        // --- Ejemplo 1: tiene solucion ---
        // Camino: (0,0)->(0,1)->(1,1)->(2,1)->(2,2)
        int[][] lab1 = {
            {0, 0, 1},
            {1, 0, 1},
            {1, 0, 0}
        };
        int[][] sol1 = new int[lab1.length][lab1[0].length];
        imprimir(lab1, "Laberinto 1:");
        boolean resultado1 = resolver(lab1, sol1, 0, 0);
        System.out.println("Tiene solucion: " + resultado1);
        if (resultado1) imprimir(sol1, "Camino encontrado (1=camino):");

        System.out.println();

        // --- Ejemplo 2: NO tiene solucion ---
        int[][] lab2 = {
            {0, 1},
            {1, 0}
        };
        int[][] sol2 = new int[lab2.length][lab2[0].length];
        imprimir(lab2, "Laberinto 2:");
        boolean resultado2 = resolver(lab2, sol2, 0, 0);
        System.out.println("Tiene solucion: " + resultado2);

        System.out.println();

        // --- Ejemplo 3: laberinto mas grande ---
        int[][] lab3 = {
            {0, 0, 0, 0},
            {1, 1, 0, 1},
            {0, 0, 0, 0},
            {0, 1, 1, 0}
        };
        int[][] sol3 = new int[lab3.length][lab3[0].length];
        imprimir(lab3, "Laberinto 3 (4x4):");
        boolean resultado3 = resolver(lab3, sol3, 0, 0);
        System.out.println("Tiene solucion: " + resultado3);
        if (resultado3) imprimir(sol3, "Camino encontrado:");
    }
}
