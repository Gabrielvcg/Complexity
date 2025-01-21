package algoritmos.ordenacion;

import java.util.ArrayList;
import java.util.List;

public class QuickSort {

	public static void quickSort(List<Integer> list) {
		if (list == null || list.size() <= 1)
			return;
		quickSort(list, 0, list.size() - 1);
	}

	private static void quickSort(List<Integer> list, int low, int high) {
		if (low < high) {
			// Seleccionar pivote y particionar
			int pivotIndex = partition(list, low, high);

			// Ordenar recursivamente las dos mitades
			quickSort(list, low, pivotIndex - 1);
			quickSort(list, pivotIndex + 1, high);
		}
	}

	private static int partition(List<Integer> list, int low, int high) {
		// Seleccionar pivote (usamos mediana de 3 para mejor rendimiento)
		int mid = low + (high - low) / 2;
		int pivotIndex = medianOfThree(list, low, mid, high);
		swap(list, pivotIndex, high);
		int pivot = list.get(high);

		// Índice del elemento más pequeño
		int i = low - 1;

		// Particionar alrededor del pivote
		for (int j = low; j < high; j++) {
			if (list.get(j) <= pivot) {
				i++;
				swap(list, i, j);
			}
		}

		// Colocar el pivote en su posición final
		swap(list, i + 1, high);
		return i + 1;
	}

	private static int medianOfThree(List<Integer> list, int low, int mid, int high) {
		int a = list.get(low);
		int b = list.get(mid);
		int c = list.get(high);

		if (a < b) {
			if (b < c)
				return mid; // a < b < c
			if (a < c)
				return high; // a < c < b
			return low; // c < a < b
		} else {
			if (a < c)
				return low; // b < a < c
			if (b < c)
				return high; // b < c < a
			return mid; // c < b < a
		}
	}

	private static void swap(List<Integer> list, int i, int j) {
		int temp = list.get(i);
		list.set(i, list.get(j));
		list.set(j, temp);
	}

	public static void main(String[] args) {
		// Ejemplo de uso
		List<Integer> lista = new ArrayList<>(List.of(64, 34, 25, 12, 22, 11, 90));
		System.out.println("Lista original: " + lista);
		quickSort(lista);
		System.out.println("Lista ordenada: " + lista);
	}
}