public class Main {

    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println(" GESTOR DE TAREAS - Objetos Tarea");
        System.out.println("========================================");

        GestorDeTareas<Tarea> gestor = new GestorDeTareas<>();
        System.out.println("\n--- Agregar tareas ---");
        gestor.agregarTarea(new Tarea("Disenar base de datos", 2));
        gestor.agregarTarea(new Tarea("Corregir bug critico",  3));
        gestor.agregarTarea(new Tarea("Escribir documentacion", 1));
        gestor.agregarTarea(new Tarea("Hacer pruebas unitarias", 2));
        gestor.agregarTarea(new Tarea("Deploy a produccion",   3));

        System.out.println("\n--- Tareas actuales (" + gestor.contarTareas() + " en total) ---");
        gestor.imprimirTareas();
        System.out.println("\n--- Eliminar tarea ---");
        gestor.eliminarTarea(new Tarea("Escribir documentacion", 1));
        gestor.eliminarTarea(new Tarea("Tarea inexistente", 1));
        System.out.println("\n--- Verificar existencia ---");
        Tarea buscar1 = new Tarea("Corregir bug critico", 3);
        Tarea buscar2 = new Tarea("Escribir documentacion", 1);
        System.out.println("  Existe '" + buscar1.getTitulo() + "': " + gestor.contieneTarea(buscar1));
        System.out.println("  Existe '" + buscar2.getTitulo() + "': " + gestor.contieneTarea(buscar2));
        System.out.println("\n--- Tarea mas prioritaria ---");
        System.out.println("  " + gestor.obtenerTareaMasPrioritaria());
        System.out.println("\n--- Invertir lista ---");
        gestor.invertirTareas();
        System.out.println("  Lista invertida:");
        gestor.imprimirTareas();
        System.out.println("\n--- Completar tarea ---");
        gestor.completarTarea(new Tarea("Deploy a produccion", 3));
        System.out.println("\n--- Tareas PENDIENTES ---");
        gestor.imprimirTareas();
        System.out.println("\n--- Tareas COMPLETADAS ---");
        gestor.imprimirCompletadas();

        System.out.println("\n========================================");
        System.out.println(" GESTOR DE TAREAS - Strings");
        System.out.println("========================================");

        GestorDeTareas<String> gestorStr = new GestorDeTareas<>();
        gestorStr.agregarTarea("Comprar insumos");
        gestorStr.agregarTarea("Revisar correos");
        gestorStr.agregarTarea("Reunion de equipo");
        gestorStr.agregarTarea("Actualizar reportes");
        gestorStr.imprimirTareas();

        gestorStr.eliminarTarea("Revisar correos");
        gestorStr.invertirTareas();
        gestorStr.imprimirTareas();

        gestorStr.completarTarea("Comprar insumos");
        gestorStr.imprimirTareas();
        System.out.println("\n--- Completadas ---");
        gestorStr.imprimirCompletadas();

        System.out.println("\n========================================");
        System.out.println(" DEMO ListLinked<Integer>");
        System.out.println("========================================");

        ListLinked<Integer> lista = new ListLinked<>();
        lista.insertLast(10);
        lista.insertLast(20);
        lista.insertLast(30);
        lista.insertFirst(5);
        System.out.println("Lista: " + lista);
        System.out.println("Longitud: " + lista.length());
        System.out.println("Buscar 20: posicion " + lista.search(20));
        System.out.println("Buscar 99: posicion " + lista.search(99));
        lista.removeNode(20);
        System.out.println("Despues de eliminar 20: " + lista);
        System.out.println("Esta vacia: " + lista.isEmptyList());
        lista.destroyList();
        System.out.println("Despues de destroyList: " + lista);
        System.out.println("Esta vacia: " + lista.isEmptyList());
    }
}
