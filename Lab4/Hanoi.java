// ============================================================
// ACTIVIDAD 01: Torres de Hanoi
// Tecnica: Recursividad + Dividir y Conquistar
// Idea: mover n-1 discos al auxiliar, mover el grande al destino,
//       luego mover los n-1 del auxiliar al destino.
// ============================================================
public class Hanoi {

    // Metodo recursivo para resolver las Torres de Hanoi
    // discos: cantidad de discos a mover
    // origen: torre donde estan los discos
    // auxiliar: torre de apoyo
    // destino: torre a donde deben llegar los discos
    public static void torresHanoi(int discos, int origen, int auxiliar, int destino) {
        // CASO BASE: si solo hay 1 disco, moverlo directamente
        if (discos == 1) {
            System.out.println("Mover disco 1 de torre " + origen + " a torre " + destino);
        } else {
            // PASO 1: mover los n-1 discos superiores al auxiliar (usando destino como apoyo)
            torresHanoi(discos - 1, origen, destino, auxiliar);

            // PASO 2: mover el disco mas grande al destino
            System.out.println("Mover disco " + discos + " de torre " + origen + " a torre " + destino);

            // PASO 3: mover los n-1 discos del auxiliar al destino (usando origen como apoyo)
            torresHanoi(discos - 1, auxiliar, origen, destino);
        }
    }

    public static void main(String[] args) {
        // Probar con 3 discos (torres: 1=origen, 2=auxiliar, 3=destino)
        System.out.println("=== Torres de Hanoi con 3 discos ===");
        torresHanoi(3, 1, 2, 3);
        // Total de movimientos = 2^n - 1 = 7

        System.out.println("\n=== Torres de Hanoi con 4 discos ===");
        torresHanoi(4, 1, 2, 3);
        // Total de movimientos = 2^4 - 1 = 15

        System.out.println("\n=== Torres de Hanoi con 2 discos ===");
        torresHanoi(2, 1, 2, 3);
        // Total de movimientos = 3
    }
}
