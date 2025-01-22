package algoritmos;

public class NReinas {
	

	    // Imprimir el tablero
	    private static void printBoard(int[][] board, int n) {
	        for (int i = 0; i < n; i++) {
	            for (int j = 0; j < n; j++) {
	                System.out.print((board[i][j] == 1 ? "Q " : "_ "));
	            }
	            System.out.println();
	        }
	        System.out.println();
	    }

	    // Verificar si se puede colocar una reina en la posición (row, col)
	    private static boolean isSafe(int[][] board, int row, int col, int n) {
	        // Verificar la columna
	        for (int i = 0; i < row; i++) {
	            if (board[i][col] == 1) {
	                return false;
	            }
	        }

	        // Verificar la diagonal superior izquierda
	        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
	            if (board[i][j] == 1) {
	                return false;
	            }
	        }

	        // Verificar la diagonal superior derecha
	        for (int i = row, j = col; i >= 0 && j < n; i--, j++) {
	            if (board[i][j] == 1) {
	                return false;
	            }
	        }

	        return true;
	    }

	    // Resolver el problema de las N reinas usando backtracking
	    private static boolean solveNQueens(int[][] board, int row, int n) {
	        // Si todas las reinas están colocadas, terminar
	        if (row >= n) {
	            printBoard(board, n);
	            return true;
	        }

	        boolean success = false;
	        for (int col = 0; col < n; col++) {
	            if (isSafe(board, row, col, n)) {
	                // Colocar la reina
	                board[row][col] = 1;

	                // Recursivamente intentar colocar el resto de las reinas
	                success = solveNQueens(board, row + 1, n) || success;

	                // Si no es posible, quitar la reina (backtrack)
	                board[row][col] = 0;
	            }
	        }

	        return success;
	    }

	    public static void main(String[] args) {
	        int n = 4; // Número de reinas
	        int[][] board = new int[n][n];

	        if (!solveNQueens(board, 0, n)) {
	            System.out.println("No hay solución.");
	        }
	    }
	}


