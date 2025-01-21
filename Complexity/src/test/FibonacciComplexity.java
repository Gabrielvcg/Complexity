package test;

import java.util.HashMap;
import java.util.List;
import java.util.function.Function;

import org.apache.commons.math3.fitting.WeightedObservedPoint;

import algoritmos.Fibonacci;
import us.lsi.common.Pair;
import us.lsi.curvefitting.DataFile;
import us.lsi.curvefitting.Exponential;
import us.lsi.curvefitting.Fit;
import us.lsi.curvefitting.GenData;
import us.lsi.curvefitting.PowerLog;
import us.lsi.graphics.MatPlotLib;

public class FibonacciComplexity {

	 
		private static Integer nMin = 1; // n mínimo para el cálculo 
		private static Integer nMax = 30; // n máximo para el cálculo 
		private static Integer nIncr = 1; // incremento en los valores de n del cálculo 
		private static Integer nIter = 50; // número de iteraciones para cada medición de tiempo
		private static Integer nIterWarmup = 1000; // número de iteraciones para warmup
		
	    
	    public static void genDataFib() {
	    	String file = "ficheros_generados/FIB.txt";
			Function<Integer,Long> f1 = GenData.time(n -> Fibonacci.fibonacci(n));
//			Integer tMin,Integer tMax,Integer tInc,Integer numIter,Integer numIterWarmup
			GenData.tiemposEjecucionAritmetica(f1,file,nMin,nMax,nIncr,nIter,nIterWarmup);
	    }

	    public static void genDataFibMem() {
	    	String file = "ficheros_generados/FIBMEM.txt";
			Function<Integer,Long> f1 = GenData.time(n -> Fibonacci.fibonacciMemoria(n,new HashMap<Integer,Integer>()));
//			Integer tMin,Integer tMax,Integer tInc,Integer numIter,Integer numIterWarmup
			GenData.tiemposEjecucionAritmetica(f1,file,nMin,nMax,nIncr,nIter,nIterWarmup);
	    }

	  

	    public static void showFib() {
	        String file = "ficheros_generados/FIB.txt";
	        List<WeightedObservedPoint> data = DataFile.points(file);
	        Fit pl = Exponential.of();
	        pl.fit(data);
	        System.out.println(pl.getExpression());
	        System.out.println(pl.getEvaluation().getRMS());
	        MatPlotLib.show(file, pl.getFunction(), pl.getExpression());
	    }

	    public static void showFibMem() {
	        String file = "ficheros_generados/FIBMEM.txt";
	        List<WeightedObservedPoint> data = DataFile.points(file);
			Fit pl = PowerLog.of(List.of(Pair.of(2, 0.),Pair.of(3, 0.)));
	        pl.fit(data);
	        System.out.println(pl.getExpression());
	        System.out.println(pl.getEvaluation().getRMS());
	        MatPlotLib.show(file, pl.getFunction(), pl.getExpression());
	    }


	    public static void showCombined() {
	        MatPlotLib.showCombined("Tiempos",
	                List.of("ficheros_generados/FIB.txt", "ficheros_generados/FIBMEM.txt"),
	                List.of("FIB", "FIBMEM"));

	    }

	    public static void main(String[] args) {
	    	//genDataFib();
	     	//genDataFibMem();
	    	showFib();
	    	showFibMem();
	        showCombined();
	    }
	}


