// Clase DemoMetodoGenerico - Actividades 5 y 6
package Lab2.Ejercicios;

class DemoMetodoGenerico {

    // Metodo generico: determina si dos arreglos son iguales (mismo orden y contenido)
    static <T extends Comparable<T>> boolean igualArrays(T[] x, T[] y) {
        // Si las longitudes son diferentes, los arrays son diferentes
        if (x.length != y.length)
            return false;
        for (int i = 0; i < x.length; i++)
            if (!x[i].equals(y[i]))
                return false; // arrays diferentes
        return true; // contenido de arrays son equivalentes
    }

    public static void main(String[] args) {
        Integer nums[]  = {1, 2, 3, 4, 5};
        Integer nums2[] = {1, 2, 3, 4, 5};
        Integer nums3[] = {1, 2, 7, 4, 5};
        Integer nums4[] = {1, 2, 7, 4, 5, 6};

        if (igualArrays(nums, nums))
            System.out.println("nums es igual a nums");
        if (igualArrays(nums, nums2))
            System.out.println("nums es igual a nums2");
        if (igualArrays(nums, nums3))
            System.out.println("nums es igual a num3");
        if (igualArrays(nums, nums4))
            System.out.println("nums es igual a nums4");

        // Actividad 6: descomentar las lineas A, B, C, D
        // Resultado: ERROR de compilacion porque Integer[] y Double[] son tipos incompatibles
        // El compilador detecta el error ANTES de ejecutar (seguridad de tipos genericos)
        // A: Crea un array de double
        Double dvals[] = {1.1, 2.2, 3.3, 4.4, 5.5};                       // B
        // igualArrays(nums, dvals) da ERROR de compilacion:                // C
        //   Integer[] y Double[] no son del mismo tipo T
        // System.out.println("nums es igual a dvals");                     // D

        // Esto demuestra la VENTAJA de genericos vs Object:
        // con Object no habria error de compilacion pero si en tiempo de ejecucion.
        System.out.println("dvals creado con " + dvals.length + " elementos.");
        System.out.println("(La linea igualArrays(nums,dvals) genera error de compilacion)");
    }
}
