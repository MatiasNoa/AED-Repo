package Lab3;
import java.util.HashMap;
import java.util.Map;

public class ModaDemo {
    public static int moda(int[] v) {
    Map<Integer, Integer> frecuencia = new HashMap<>(); //O(1)
    int maxFrecuencia = 0; //O(1)
    int moda = v[0]; //O(1)
    for (int num : v) { //O(n)
        int f = frecuencia.getOrDefault(num, 0) + 1; //O(1)
        frecuencia.put(num, f); //O(1)
        if (f > maxFrecuencia) { //O(1)
            maxFrecuencia = f; //O(1)
            moda = num; //O(1)
        }
    }
    return moda; //O(1)
 }
 public static void main(String[] args) {
 int[] datos = {1, 3, 2, 3, 4, 3, 2, 1, 3}; //O(1)
 int resultado = moda(datos); //O(n)
 System.out.println("La moda es: " + resultado); //O(1)
 }
}

/*
Bloque 1: O(1)
Inicialización de variables (HashMap, maxFrecuencia, moda).
Bloque 2: O(n × 1) = O(n)
Se recorre el arreglo una sola vez.
En cada iteración se realizan operaciones de acceso e inserción en el diccionario (getOrDefault y put), que en promedio son O(1).
Además, las comparaciones y asignaciones también son O(1).
Por lo tanto, cada iteración cuesta O(1), y al repetirse n veces → O(n).
Bloque 3: O(1)
Retorno del resultado.
Resultado:
T(n) = O(1 + n + 1) → O(n)
Aplicando la regla de la suma, concluimos que el algoritmo es de complejidad lineal, ya que solo depende de un recorrido del arreglo.

*/
