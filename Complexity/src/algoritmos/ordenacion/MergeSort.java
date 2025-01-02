package algoritmos.ordenacion;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {

    // Método principal para Merge Sort
    public static void mergeSort(List<Integer> ls) {
        if (ls.size() > 1) {
            // Dividir la lista en dos mitades
            int mid = ls.size() / 2;

            List<Integer> left = new ArrayList<>(ls.subList(0, mid));
            List<Integer> right = new ArrayList<>(ls.subList(mid, ls.size()));

            // Ordenar recursivamente cada mitad
            mergeSort(left);
            mergeSort(right);

            // Combinar las dos mitades ordenadas
            merge(ls, left, right);
        }
    }

    // Método para combinar dos sublistas ordenadas
    private static void merge(List<Integer> ls, List<Integer> left, List<Integer> right) {
        int i = 0; // Índice para la sublista izquierda
        int j = 0; // Índice para la sublista derecha
        int k = 0; // Índice para la lista combinada

        // Comparar elementos de ambas sublistas y colocarlos en orden
        while (i < left.size() && j < right.size()) {
            if (left.get(i) <= right.get(j)) {
                ls.set(k++, left.get(i++));
            } else {
                ls.set(k++, right.get(j++));
            }
        }

        // Copiar los elementos restantes de la sublista izquierda
        while (i < left.size()) {
            ls.set(k++, left.get(i++));
        }

        // Copiar los elementos restantes de la sublista derecha
        while (j < right.size()) {
            ls.set(k++, right.get(j++));
        }
    }

    // Método principal para probar Merge Sort
    public static void main(String[] args) {
        List<Integer> lista = List.of(38, 27, 43, 3, 9, 82, 10);
        System.out.println("Lista original: " + lista);

        List<Integer> mutableList = new ArrayList<>(lista); // Crear una lista mutable
        mergeSort(mutableList); // Ordenar la lista
        System.out.println("Lista ordenada: " + mutableList);
    }
}
