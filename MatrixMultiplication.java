import java.io.*;

public class MatrixMultiplication {
    public static void main(String[] args) {
        int rowsA, colsA, rowsB, colsB;

        // Accept matrix A from user
        System.out.println("Enter the number of rows and columns for Matrix A:");
        rowsA = getUserInput("Enter the number of rows for Matrix A: ");
        colsA = getUserInput("Enter the number of columns for Matrix A: ");
        

        // Accept matrix B from user
        System.out.println("Enter the number of rows and columns for Matrix B:");
        rowsB = getUserInput("Enter the number of rows for Matrix B: ");
        colsB = getUserInput("Enter the number of columns for Matrix B: ");
        

        // Perform matrix multiplication
        if (colsA != rowsB) {
            System.out.println("Matrix multiplication is not possible. Number of columns in Matrix A must be equal to the number of rows in Matrix B.");
            return;
        }
        int[][] matrixA = getMatrix("Matrix A", rowsA, colsA);
        int[][] matrixB = getMatrix("Matrix B", rowsB, colsB);
        int[][] resultMatrix = multiplyMatrices(matrixA, matrixB);
        

        // Write matrices A, B, and resultMatrix to file
        writeMatricesToFile(matrixA, matrixB, resultMatrix);
    }

    // Method to get user input
    public static int getUserInput(String message) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int input = 0;
        try {
            System.out.print(message);
            input = Integer.parseInt(reader.readLine());
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        return input;
    }

    // Method to accept matrix from user
    public static int[][] getMatrix(String matrixName, int rows, int cols) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[][] matrix = new int[rows][cols];
        System.out.println("Enter elements for " + matrixName + ":");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                try {
                    System.out.print(matrixName + "[" + i + "][" + j + "]: ");
                    matrix[i][j] = Integer.parseInt(reader.readLine());
                } catch (IOException | NumberFormatException e) {
                    e.printStackTrace();
                }
            }
        }
        return matrix;
    }

    // Method to perform matrix multiplication
    public static int[][] multiplyMatrices(int[][] A, int[][] B) {
        int rowsA = A.length;
        int colsA = A[0].length;
        int colsB = B[0].length;

        int[][] C = new int[rowsA][colsB];

        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                for (int k = 0; k < colsA; k++) {
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }

        return C;
    }

    // Method to write matrices to file
    public static void writeMatricesToFile(int[][] A, int[][] B, int[][] result) {
        try (PrintWriter writer = new PrintWriter("matrix.txt")) {
            writer.println("Matrix A:");
            writeMatrixToFile(A, writer);
            writer.println("\nMatrix B:");
            writeMatrixToFile(B, writer);
            writer.println("\nResult Matrix:");
            writeMatrixToFile(result, writer);
            System.out.println("Matrices written to file successfully.");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Method to write a matrix to file
    public static void writeMatrixToFile(int[][] matrix, PrintWriter writer) {
        for (int[] row : matrix) {
            for (int value : row) {
                writer.print(value + "\t");
            }
            writer.println();
        }
    }
}
