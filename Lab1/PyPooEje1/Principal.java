package Lab1.PyPooEje1;
import java.util.*;

public class Principal {

    public static void mostrarRectangulo(String nombre, Rectangulo r) {
        System.out.println("Rectangulo " + nombre + " = " + r.toString());
    }

    public static Rectangulo rectanguloSobre(Rectangulo r1, Rectangulo r2) {
        double minX1 = Math.min(r1.getEsquina1().getX(), r1.getEsquina2().getX());
        double maxX1 = Math.max(r1.getEsquina1().getX(), r1.getEsquina2().getX());
        double minY1 = Math.min(r1.getEsquina1().getY(), r1.getEsquina2().getY());
        double maxY1 = Math.max(r1.getEsquina1().getY(), r1.getEsquina2().getY());

        double minX2 = Math.min(r2.getEsquina1().getX(), r2.getEsquina2().getX());
        double maxX2 = Math.max(r2.getEsquina1().getX(), r2.getEsquina2().getX());
        double minY2 = Math.min(r2.getEsquina1().getY(), r2.getEsquina2().getY());
        double maxY2 = Math.max(r2.getEsquina1().getY(), r2.getEsquina2().getY());

        double x1 = Math.max(minX1, minX2);
        double y1 = Math.max(minY1, minY2);
        double x2 = Math.min(maxX1, maxX2);
        double y2 = Math.min(maxY1, maxY2);

        return new Rectangulo(new Coordenada(x1, y1), new Coordenada(x2, y2));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Contenedor para maximo 10 rectangulos
        ContainerRect contenedor = new ContainerRect(10);

        // Leer rectangulo A
        System.out.print("Ingrese una esquina del 1er rectangulo: ");
        double x1 = sc.nextDouble();
        double y1 = sc.nextDouble();
        System.out.print("Ingrese la esquina opuesta del 1er rectangulo: ");
        double x2 = sc.nextDouble();
        double y2 = sc.nextDouble();

        Rectangulo A = new Rectangulo(new Coordenada(x1, y1), new Coordenada(x2, y2));
        A.normalizar();
        contenedor.addRectangulo(A);

        // Leer rectangulo B
        System.out.print("Ingrese una esquina del 2do rectangulo: ");
        double x3 = sc.nextDouble();
        double y3 = sc.nextDouble();
        System.out.print("Ingrese la esquina opuesta del 2do rectangulo: ");
        double x4 = sc.nextDouble();
        double y4 = sc.nextDouble();

        Rectangulo B = new Rectangulo(new Coordenada(x3, y3), new Coordenada(x4, y4));
        B.normalizar();
        contenedor.addRectangulo(B);

        // Mostrar rectangulos
        mostrarRectangulo("A", A);
        mostrarRectangulo("B", B);

        // Determinar caso
        if (Verificador.esSobrePos(A, B)) {
            System.out.println("Rectangulos A y B se sobreponen.");
            Rectangulo sobre = rectanguloSobre(A, B);
            System.out.printf("Area de sobreposicion = %.2f%n", sobre.calculoArea());
        } else if (Verificador.esJunto(A, B)) {
            System.out.println("Rectangulos A y B se juntan");
        } else {
            System.out.println("Rectangulos A y B son disjuntos");
        }

        // Mostrar contenedor al final
        System.out.println("\n--- Contenedor de Rectangulos ---");
        System.out.print(contenedor.toString());

        sc.close();
    }
}
