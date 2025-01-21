package algoritmos.ordenacion;

import java.util.List;

public class BubbleSort {

	public static void swap(List<Integer> ls, int i, int j) {
		int temp = ls.get(i);
		ls.set(i, ls.get(j));
		ls.set(j, temp);

	}
	
	public static void bubbleSort(List<Integer> ls){
		if (ls == null || ls.size()<=1) return;
		boolean valid = true;
		while(valid) {
			valid = false;
		for (int i = 0; i<ls.size()-1; i++) {
			int key = ls.get(i);
			int nextKey = ls.get(i+1);
			if (key > nextKey) {
				swap(ls,i,i+1);
				valid = true;
			}
		}
		
		}return;
	}
	
	public static void main(String[] args) {
		
		List<Integer> ls = Listas.generarLista(5, 10);
		System.out.println("Lista antes de ordenacion: "+ ls);
		bubbleSort(ls);
		System.out.println("Lista tras ordenacion: "+ ls);
		
	}
	
	
}
