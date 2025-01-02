package algoritmos.ordenacion;

import java.util.ArrayList;
import java.util.List;

public class BinarySort {

    // Método principal para ordenar la lista
    public static void binarySort(List<Integer> list) {
        for (int i = 1; i < list.size(); i++) {
            Integer key = list.get(i);
            // Encuentra la posición correcta para 'key' usando búsqueda binaria
            int position = binarySearch(list, key, 0, i - 1);
            
            // Inserta el elemento en la posición correcta
            list.remove(i);  // Elimina el elemento temporalmente de la posición actual
            list.add(position, key);  // Inserta el elemento en la nueva posición
        }
    }

    // Método de búsqueda binaria para encontrar la posición de inserción
    private static int binarySearch(List<Integer> list, Integer key, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (list.get(mid) < key) {
                low = mid + 1; // Buscar en la mitad derecha
            } else {
                high = mid - 1; // Buscar en la mitad izquierda
            }
        }
        return low; // Devuelve la posición correcta para insertar
    }

    public static void main(String[] args) {
        // Ejemplo de uso con una lista de enteros
        List<Integer> list = new ArrayList<>(List.of(29, 10, 14, 37, 13));
        System.out.println("Antes de ordenar: " + list);
        binarySort(list);
        System.out.println("Después de ordenar: " + list);
    }
}
