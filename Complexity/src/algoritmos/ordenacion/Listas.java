package algoritmos.ordenacion;

import java.util.ArrayList;
import java.util.List;

public class Listas {

	public static List<Integer> generarLista(Integer n, Integer range) {
		List<Integer> ls = new ArrayList<>();
		for(int i=0;i<n;i++) {
			ls.add((int)(Math.random()*range));
		}
		return ls;
	}
	
}
