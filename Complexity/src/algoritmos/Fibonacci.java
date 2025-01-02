package algoritmos;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

	public static Integer fibonacci(Integer n) {
		return(n==0) ? 0: (n==1) ? 1 : fibonacci(n-1) + fibonacci (n-2);
	}
	
	public static Integer fibonacciMemoria(Integer n, Map<Integer, Integer> dicc) {
	    if (n == 0) return 0; 
	    if (n == 1) return 1; 

	    if (dicc.containsKey(n)) {
	        return dicc.get(n);
	    }

	    int fibNMinus1 = fibonacciMemoria(n - 1, dicc);
	    int fibNMinus2 = fibonacciMemoria(n - 2, dicc);
	    dicc.put(n, fibNMinus1 + fibNMinus2);

	    return dicc.get(n);
	}
	
	public static void main(String[]args) {
		Integer n= 6;
		Map<Integer,Integer> dicc=new HashMap<>();
		Integer r =fibonacci(n);
		Integer rm= fibonacciMemoria(n,dicc);
		System.out.println(r);
		System.out.println(rm);
	}
}
