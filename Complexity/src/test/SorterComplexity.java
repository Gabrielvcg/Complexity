package test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import org.apache.commons.math3.fitting.WeightedObservedPoint;

import algoritmos.ordenacion.BinarySort;
import algoritmos.ordenacion.Listas;
import algoritmos.ordenacion.MergeSort;
import algoritmos.ordenacion.QuickSort;
import us.lsi.curvefitting.DataFile;
import us.lsi.curvefitting.Fit;
import us.lsi.curvefitting.GenData;
import us.lsi.curvefitting.PowerLog;
import us.lsi.graphics.MatPlotLib;

public class SorterComplexity {

	private static Integer nMin = 1000; // n mínimo para el cálculo
	private static Integer nMax = 10000; // n máximo para el cálculo
	private static Integer nIncr = 1000; // incremento en los valores de n del cálculo
	private static Integer nIter = 50; // número de iteraciones para cada medición de tiempo
	private static Integer nIterWarmup = 1000; // número de iteraciones para warmup

	// Método para generar datos de QuickSort
	public static void genDataQS(List<Integer> ls) {
		String file = "ficheros_generados/QS.txt";
		Function<Integer, Long> f1 = GenData.time(n -> QuickSort.quickSort(ls.subList(0, n)));
		GenData.tiemposEjecucionAritmetica(f1, file, nMin, nMax, nIncr, nIter, nIterWarmup);
	}

	// Método para generar datos de MergeSort
	public static void genDataMS(List<Integer> ls) {
		String file = "ficheros_generados/MS.txt";
		Function<Integer, Long> f1 = GenData.time(n -> {
			List<Integer> mutableList = new ArrayList<>(ls.subList(0, n));
			MergeSort.mergeSort(mutableList);
		});
		GenData.tiemposEjecucionAritmetica(f1, file, nMin, nMax, nIncr, nIter, nIterWarmup);
	}

	// Método para generar datos de BinarySort
	public static void genDataBS(List<Integer> ls) {
		String file = "ficheros_generados/BS.txt";
		Function<Integer, Long> f1 = GenData.time(n -> {
			List<Integer> mutableList = new ArrayList<>(ls.subList(0, n));
			BinarySort.binarySort(mutableList);
		});
		GenData.tiemposEjecucionAritmetica(f1, file, nMin, nMax, nIncr, nIter, nIterWarmup);
	}

	// Método para mostrar los resultados de QuickSort
	public static void showQS() {
		String file = "ficheros_generados/QS.txt";
		List<WeightedObservedPoint> data = DataFile.points(file);
		Fit pl = PowerLog.of();
		pl.fit(data);
		System.out.println("QuickSort Expression: " + pl.getExpression());
		System.out.println("QuickSort RMS: " + pl.getEvaluation().getRMS());
		MatPlotLib.show(file, pl.getFunction(), pl.getExpression());
	}

	// Método para mostrar los resultados de MergeSort
	public static void showMS() {
		String file = "ficheros_generados/MS.txt";
		List<WeightedObservedPoint> data = DataFile.points(file);
		Fit pl = PowerLog.of();
		pl.fit(data);
		System.out.println("MergeSort Expression: " + pl.getExpression());
		System.out.println("MergeSort RMS: " + pl.getEvaluation().getRMS());
		MatPlotLib.show(file, pl.getFunction(), pl.getExpression());
	}

	// Método para mostrar los resultados de BinarySort
	public static void showBS() {
		String file = "ficheros_generados/BS.txt";
		List<WeightedObservedPoint> data = DataFile.points(file);
		Fit pl = PowerLog.of();
		pl.fit(data);
		System.out.println("BinarySort Expression: " + pl.getExpression());
		System.out.println("BinarySort RMS: " + pl.getEvaluation().getRMS());
		MatPlotLib.show(file, pl.getFunction(), pl.getExpression());
	}

	// Método para mostrar los resultados combinados de todos los algoritmos
	public static void showCombined() {
		MatPlotLib.showCombined("Tiempos",
				List.of("ficheros_generados/QS.txt", "ficheros_generados/MS.txt", "ficheros_generados/BS.txt"),
				List.of("QuickSort", "MergeSort", "BinarySort"));
	}

	// Método principal
	public static void main(String[] args) {
		List<Integer> ls = Listas.generarLista(nMax, nMax);

		// Generación de datos de los tres algoritmos
		genDataQS(ls);
		genDataMS(ls);
		genDataBS(ls);

		// Mostrar resultados de cada algoritmo
		showQS();
		showMS();
		showBS();

		// Mostrar los resultados combinados
		showCombined();
	}
}
