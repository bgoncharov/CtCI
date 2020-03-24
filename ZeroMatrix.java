public class ZeroMatrix {

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] < 10 && matrix[i][j] > -10) {
                    System.out.print(" ");
                }
                if (matrix[i][j] < 100 && matrix[i][j] > -100) {
                    System.out.print(" ");
                }
                if (matrix[i][j] >= 0) {
                    System.out.print(" ");
                }
                System.out.print(" " + matrix[i][j]);
            }
            System.out.println();
        }
    }

    public static void zeros(int[][] matrix) {
        boolean row = false;
        boolean column = false;

        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                row = true;
                break ;
            }
        }

        for (int j = 0; j < matrix.length; j++) {
            if (matrix[j][0] == 0) {
                column = true;
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                nullifyRow(matrix, i);
            }
        }

        for (int j = 1; j < matrix.length; j++) {
            if (matrix[0][j] == 0) {
                nullifyColumn(matrix, j);
            }
        }

        if (row) {
            nullifyRow(matrix, 0);
        }

        if (column) {
            nullifyColumn(matrix, 0);
        }

    }

    public static void nullifyColumn(int[][] matrix, int column) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][column] = 0;
        }
    }

    public static void nullifyRow(int[][] matrix, int row) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[row][i] = 0;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},
                            {3,4,0},
                            {5,6,7}};
        printMatrix(matrix);
        System.out.println();
        zeros(matrix);
        printMatrix(matrix);
    }
}
