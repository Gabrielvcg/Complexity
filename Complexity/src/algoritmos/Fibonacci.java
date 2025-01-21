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
	
	
	public static Integer fibonacciPD(Integer n) {
		if (n <= 1) return n;

        // Crear un array para almacenar los valores de Fibonacci
        int[] fib = new int[n + 1];

        // Casos base
        fib[0] = 0;
        fib[1] = 1;

        // Llenar el array con la relación de recurrencia
        for (int i = 2; i <= n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }

        return fib[n];
	}

    public static void main(String[] args) {
        Integer n = 6;
        Map<Integer, Integer> dicc = new HashMap<>();

        // Tiempo para Fibonacci recursivo
        long startRecursive = System.nanoTime();
        Integer r = fibonacci(n);
        long endRecursive = System.nanoTime();
        System.out.println(String.format("Fibonacci recursivo: %d - Tiempo: %.6f s", r, (endRecursive - startRecursive) / 1_000_000_000.0));

        // Tiempo para Fibonacci con memoización
        long startMemoization = System.nanoTime();
        Integer rm = fibonacciMemoria(n, dicc);
        long endMemoization = System.nanoTime();
        System.out.println(String.format("Fibonacci con memoización: %d - Tiempo: %.6f s", rm, (endMemoization - startMemoization) / 1_000_000_000.0));

        // Tiempo para Fibonacci con programación dinámica
        long startDynamic = System.nanoTime();
        Integer dp = fibonacciPD(n);
        long endDynamic = System.nanoTime();
        System.out.println(String.format("Fibonacci con programación dinámica: %d - Tiempo: %.6f s", dp, (endDynamic - startDynamic) / 1_000_000_000.0));
    }
}
