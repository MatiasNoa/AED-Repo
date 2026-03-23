// Clase Principal - Actividad 4 y 7
public class Principal {

    // Actividad 7 / Ejercicio 2: metodo generico para mostrar cualquier bolsa
    public static <T> void mostrarBolsa(Bolsa<T> bolsa) {
        for (T elemento : bolsa) {
            System.out.println(elemento.toString());
        }
    }

    public static void main(String[] args) {

        // --- Actividad 4: Bolsa de Chocolatinas ---
        System.out.println("=== Bolsa de Chocolatinas ===");
        Bolsa<Chocolatina> bolsaCho = new Bolsa<Chocolatina>();
        Chocolatina c  = new Chocolatina("milka");
        Chocolatina c1 = new Chocolatina("milka");
        Chocolatina c2 = new Chocolatina("ferrero");
        bolsaCho.add(c);
        bolsaCho.add(c1);
        bolsaCho.add(c2);

        // Recorrer con for-each
        for (Chocolatina chocolatina : bolsaCho) {
            System.out.println(chocolatina.getMarca());
        }

        // --- Actividad 7 / Ejercicio 2: Bolsa de Golosinas usando metodo generico ---
        System.out.println("\n=== Bolsa de Golosinas (metodo generico) ===");
        Bolsa<Golosina> bolsaGol = new Bolsa<Golosina>();
        bolsaGol.add(new Golosina("Chicle",   10.5));
        bolsaGol.add(new Golosina("Caramelo", 5.0));
        bolsaGol.add(new Golosina("Paleta",   20.0));

        mostrarBolsa(bolsaGol);

        // Tambien se puede mostrar la bolsa de chocolatinas con el mismo metodo
        System.out.println("\n=== Bolsa de Chocolatinas (metodo generico) ===");
        mostrarBolsa(bolsaCho);
    }
}
