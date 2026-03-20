package Lab1.PyPooAct1;


public class Verificador {

    // Caso 1: Los rectangulos se sobreponen (se cruzan con area > 0)
    public static boolean esSobrePos(Rectangulo r1, Rectangulo r2) {
        // Rectángulo ya normalizado por su constructor, creamos las variables para mas claridad
        double r1minX = r1.getEsquina1().getX();
        double r1maxX = r1.getEsquina2().getX();
        double r1minY = r1.getEsquina1().getY();
        double r1maxY = r1.getEsquina2().getY();

        double r2minX = r2.getEsquina1().getX();
        double r2maxX = r2.getEsquina2().getX();
        double r2minY = r2.getEsquina1().getY();
        double r2maxY = r2.getEsquina2().getY();

        // Si los tomamos como segmentos en este caso de sobreposición encontraremos intersecciones en ambos ejes
        // El overlap en cada eje se calcula como el mínimo del máximo menos el máximo del mínimo
        // Además estas intersecciones forman el rectangulo de intersección.
        double overlapX = Math.min(r1maxX, r2maxX) - Math.max(r1minX, r2minX);
        double overlapY = Math.min(r1maxY, r2maxY) - Math.max(r1minY, r2minY);

        return overlapX > 0 && overlapY > 0;
    }

    // Caso 2: Los rectangulos estan juntos (se tocan en un borde o esquina)
    public static boolean esJunto(Rectangulo r1, Rectangulo r2) {
        // Rectángulo ya normalizado por su constructor, creamos las variables para mas claridad
        double r1minX = r1.getEsquina1().getX();
        double r1maxX = r1.getEsquina2().getX();
        double r1minY = r1.getEsquina1().getY();
        double r1maxY = r1.getEsquina2().getY();

        double r2minX = r2.getEsquina1().getX();
        double r2maxX = r2.getEsquina2().getX();
        double r2minY = r2.getEsquina1().getY();
        double r2maxY = r2.getEsquina2().getY();

        // Utilizamos el mismo criterio de segmentos, pero ahora buscamos al menos un overlap 0.
        double overlapX = Math.min(r1maxX, r2maxX) - Math.max(r1minX, r2minX);
        double overlapY = Math.min(r1maxY, r2maxY) - Math.max(r1minY, r2minY);

        // Se tocan si exactamente uno de los overlaps es 0 y el otro es >= 0
        // O si ambos son 0 (se tocan en esquina)
        boolean xToca = overlapX == 0 && overlapY >= 0;
        boolean yToca = overlapY == 0 && overlapX >= 0;

        return (xToca || yToca) && !esSobrePos(r1, r2);
    }

    // Caso 3: Los rectangulos son disjuntos (no se tocan ni sobreponen)
    public static boolean esDisjunto(Rectangulo r1, Rectangulo r2) {
        // Usamos la lógica de que no se sobreponen ni se tocan
        return !esSobrePos(r1, r2) && !esJunto(r1, r2);
    }
}
