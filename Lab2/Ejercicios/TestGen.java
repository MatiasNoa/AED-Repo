// Clase TestGen - Ejercicios 1, 2, 5, 6 y 7
package Lab2.Ejercicios;

public class TestGen {

    // -------------------------------------------------------
    // Ejercicio 1: metodo generico exist
    // Busca un elemento en un arreglo usando equals
    // No usa casting
    // -------------------------------------------------------
    public static <T> boolean exist(T[] arreglo, T elemento) {
        for (T item : arreglo) {
            if (item.equals(elemento)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        // --- Ejercicio 1: probar exist con String e Integer ---
        System.out.println("=== Ejercicio 1: metodo exist ===");
        String[]  v = {"Perez", "Sanchez", "Rodriguez"};
        Integer[] w = {12, 34, 56};

        System.out.println(exist(v, "Sanchez"));  // true
        System.out.println(exist(w, 34));          // true
        // System.out.println(exist(w, "Salas")); // Error de compilacion: tipos incompatibles

        // Probar exist con Golosinas
        System.out.println("\n--- exist con Golosinas ---");
        Golosina[] golosinas = {
            new Golosina("Chicle",   10.5),
            new Golosina("Caramelo", 5.0),
            new Golosina("Paleta",   20.0)
        };
        System.out.println(exist(golosinas, new Golosina("Caramelo", 5.0)));  // true
        System.out.println(exist(golosinas, new Golosina("Goma",     3.0)));  // false

        // Probar exist con Chocolatinas
        System.out.println("\n--- exist con Chocolatinas ---");
        Chocolatina[] chocs = {
            new Chocolatina("milka"),
            new Chocolatina("ferrero"),
            new Chocolatina("snickers")
        };
        System.out.println(exist(chocs, new Chocolatina("ferrero")));  // true
        System.out.println(exist(chocs, new Chocolatina("twix")));     // false

        // -----------------------------------------------------------
        // Ejercicio 5: Cajoneria de Golosinas - search y delete
        // -----------------------------------------------------------
        System.out.println("\n=== Ejercicio 5: Cajoneria de Golosinas ===");
        Cajoneria<Golosina> cajoneriaGol = new Cajoneria<Golosina>();

        cajoneriaGol.add(new Golosina("Chicle",    10.5), "Rojo");
        cajoneriaGol.add(new Golosina("Caramelo",   5.0), "Amarillo");
        cajoneriaGol.add(new Golosina("Paleta",    20.0), "Verde");
        cajoneriaGol.add(new Golosina("Gomita",     8.0), "Azul");
        cajoneriaGol.add(new Golosina("Chicle",    10.5), "Naranja"); // duplicado intencional

        System.out.println("Contenido de la cajoneria:");
        System.out.print(cajoneriaGol.toString());

        // Buscar golosinas
        System.out.println("\n--- search ---");
        String resultado = cajoneriaGol.search(new Golosina("Paleta", 20.0));
        System.out.println("Buscar Paleta 20.0: " + resultado);

        resultado = cajoneriaGol.search(new Golosina("Piruleta", 1.0));
        System.out.println("Buscar Piruleta 1.0: " + resultado);

        // Eliminar una golosina
        System.out.println("\n--- delete ---");
        Golosina eliminada = cajoneriaGol.delete(new Golosina("Caramelo", 5.0));
        System.out.println("Eliminado: " + eliminada);

        Golosina noExiste = cajoneriaGol.delete(new Golosina("Chicle", 99.0));
        System.out.println("Intentar eliminar Chicle 99.0: " + noExiste);

        System.out.println("\nCajoneria despues de eliminar:");
        System.out.print(cajoneriaGol.toString());

        // -----------------------------------------------------------
        // Ejercicio 6: contar ocurrencias - Golosinas
        // -----------------------------------------------------------
        System.out.println("=== Ejercicio 6: contar ocurrencias (Golosinas) ===");
        int ocurrencias = cajoneriaGol.contar(new Golosina("Chicle", 10.5));
        System.out.println("Veces que aparece Chicle 10.5: " + ocurrencias); // 2 (hay duplicado)

        ocurrencias = cajoneriaGol.contar(new Golosina("Paleta", 20.0));
        System.out.println("Veces que aparece Paleta 20.0: " + ocurrencias); // 1

        // -----------------------------------------------------------
        // Ejercicio 7: Cajoneria de Chocolatinas (mismo codigo, distinto tipo)
        // -----------------------------------------------------------
        System.out.println("\n=== Ejercicio 7: Cajoneria de Chocolatinas ===");
        Cajoneria<Chocolatina> cajoneriaChoc = new Cajoneria<Chocolatina>();

        cajoneriaChoc.add(new Chocolatina("milka"),    "Rojo");
        cajoneriaChoc.add(new Chocolatina("ferrero"),  "Amarillo");
        cajoneriaChoc.add(new Chocolatina("snickers"), "Verde");
        cajoneriaChoc.add(new Chocolatina("milka"),    "Azul");   // duplicado
        cajoneriaChoc.add(new Chocolatina("twix"),     "Naranja");

        System.out.println("Contenido de la cajoneria de chocolatinas:");
        System.out.print(cajoneriaChoc.toString());

        System.out.println("--- search ---");
        System.out.println("Buscar ferrero: " + cajoneriaChoc.search(new Chocolatina("ferrero")));
        System.out.println("Buscar kitkat:  " + cajoneriaChoc.search(new Chocolatina("kitkat")));

        System.out.println("--- delete ---");
        Chocolatina chocEliminada = cajoneriaChoc.delete(new Chocolatina("snickers"));
        System.out.println("Eliminado: " + chocEliminada);

        System.out.println("--- contar ---");
        System.out.println("Veces milka: " + cajoneriaChoc.contar(new Chocolatina("milka"))); // 2
        System.out.println("Veces twix:  " + cajoneriaChoc.contar(new Chocolatina("twix")));  // 1

        System.out.println("\nCajoneria final de chocolatinas:");
        System.out.print(cajoneriaChoc.toString());
    }
}
