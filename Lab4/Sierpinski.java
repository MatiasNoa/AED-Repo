import javax.swing.*;
import java.awt.*;

// ============================================================
// ACTIVIDAD 03: Triangulo de Sierpinski
// Tecnica: Recursividad
// Idea: dividir un triangulo en 3 subtriangulos y repetir
//       el proceso hasta llegar al nivel 0 (caso base).
// ============================================================
public class Sierpinski extends JPanel {

    private int nivel; // nivel de recursion a dibujar

    public Sierpinski(int nivel) {
        this.nivel = nivel;
    }

    // Dibuja el triangulo de Sierpinski de forma recursiva
    // (x1,y1), (x2,y2), (x3,y3): vertices del triangulo actual
    // nivel: profundidad de recursion
    public void drawTriangle(Graphics g, int x1, int y1,
                              int x2, int y2, int x3, int y3, int nivel) {
        // CASO BASE: nivel 0, dibujar el triangulo solido
        if (nivel == 0) {
            int[] xPoints = {x1, x2, x3};
            int[] yPoints = {y1, y2, y3};
            g.fillPolygon(xPoints, yPoints, 3);
        } else {
            // Calcular los puntos medios de cada lado del triangulo
            int mx12 = (x1 + x2) / 2;  // medio entre vertice 1 y 2
            int my12 = (y1 + y2) / 2;
            int mx23 = (x2 + x3) / 2;  // medio entre vertice 2 y 3
            int my23 = (y2 + y3) / 2;
            int mx31 = (x3 + x1) / 2;  // medio entre vertice 3 y 1
            int my31 = (y3 + y1) / 2;

            // CASO RECURSIVO: dibujar los 3 sub-triangulos
            // Triangulo superior
            drawTriangle(g, x1, y1, mx12, my12, mx31, my31, nivel - 1);
            // Triangulo inferior izquierdo
            drawTriangle(g, mx12, my12, x2, y2, mx23, my23, nivel - 1);
            // Triangulo inferior derecho
            drawTriangle(g, mx31, my31, mx23, my23, x3, y3, nivel - 1);
            // El triangulo central queda vacio (no se dibuja)
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        // Dibujar el triangulo con el nivel configurado
        // Vertices: base en y=500, punta en y=100
        drawTriangle(g, 100, 500, 500, 500, 300, 100, nivel);
    }

    // Metodo para abrir una ventana con un nivel especifico
    public static void mostrarNivel(int nivel) {
        JFrame frame = new JFrame("Triangulo de Sierpinski - Nivel " + nivel);
        Sierpinski panel = new Sierpinski(nivel);
        frame.add(panel);
        frame.setSize(620, 580);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        // Actividad: mostrar los triangulos de nivel 4, 6 y 8
        mostrarNivel(4);
        mostrarNivel(6);
        mostrarNivel(8);
    }
}
