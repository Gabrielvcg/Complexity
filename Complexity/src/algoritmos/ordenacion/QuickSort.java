package algoritmos.ordenacion;
import java.util.ArrayList;
import java.util.List;

public class QuickSort {

	static Integer seleccionPivote(List<Integer> ls) {
	    int randomIndex = (int) (Math.random() * ls.size());
	    return ls.get(randomIndex);
	}
	
    // Método principal para implementar QuickSort (in-place)
    public static void quickSort(List<Integer> ls) {
        quickSortHelper(ls, 0, ls.size() - 1);
    }

    // Método auxiliar para realizar QuickSort recursivamente
    private static void quickSortHelper(List<Integer> ls, int low, int high) {
        if (low < high) {
            // Particionar la lista y obtener el índice del pivote
            int pivotIndex = partition(ls, low, high);

            // Ordenar recursivamente las dos mitades
            quickSortHelper(ls, low, pivotIndex - 1);
            quickSortHelper(ls, pivotIndex + 1, high);
        }
    }

    // Método para particionar la lista y ubicar el pivote en su posición correcta
    private static int partition(List<Integer> ls, int low, int high) {
        Integer pivot = seleccionPivote(ls); // Usamos el último elemento como pivote
        int i = low - 1; // Índice para elementos menores al pivote

        for (int j = low; j < high; j++) {
            if (ls.get(j) <= pivot) {
                i++;
                // Intercambiar ls[i] y ls[j]
                swap(ls, i, j);
            }
        }

        // Colocar el pivote en su posición correcta
        swap(ls, i + 1, high);

        return i + 1; // Retorna el índice del pivote
    }

    // Método para intercambiar dos elementos en la lista
    private static void swap(List<Integer> ls, int i, int j) {
        Integer temp = ls.get(i);
        ls.set(i, ls.get(j));
        ls.set(j, temp);
    }

    // Método principal para probar QuickSort
    public static void main(String[] args) {
        List<Integer> lista = List.of(29, 10, 14, 37, 13);
        System.out.println("Lista original: " + lista);
        List<Integer> mutableList = new ArrayList<>(lista); // Crear una lista mutable
        quickSort(mutableList); // Ordenar in-place
        System.out.println("Lista ordenada: " + mutableList);
    }
}
