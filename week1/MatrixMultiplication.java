// Multiply matrixes
import java.util.Scanner;
// import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.List;
// import java.util.stream.Collectors;

class MultiplyMatrix {
    public int[][] multiplyMatrix(int[][] m1, int[][] m2) {
        //check if m1 columns number == m1 lines number;
        // int[][] final_matrix = new int[0][0];
        if (m1[0].length == m2.length) {
            int[][] final_matrix = new int[m1.length][m2[0].length];
            for(int i = 0; i < m1.length; i++) {
                for(int j = 0; j < m2[0].length; j++) {
                    for(int k = 0; k < m1[0].length; k++) {
                        final_matrix[i][j] += m1[i][k] * m2[k][j];
                    } 
                }
            }
            return(final_matrix);
        }
        else {
            int[][] final_matrix = new int[0][0];
            System.out.println("Cannot multiply those two matrix, the columns number of m1 doesn't match the lines numbers of m2");
            return(final_matrix);
        }     
    }
}

public class MatrixMultiplication {
    public int[][] GetMatrix(String m) {
        // conver the string to int;       
        int a = m.split(";").length;
        int b = m.split(";")[0].split(" ").length;
        int[][] matrix = new int[a][b];
        for(int i=0; i < m.split(";").length; i++){
            for(int j=0; j < m.split(";")[i].split(" ").length; j++){
                // System.out.print(m.split(";")[i].split(" ")[j]);
                matrix[i][j] = Integer.parseInt(m.split(";")[i].split(" ")[j]);
            }
        }
        // System.out.println(matrix[1][1]);
        return matrix;
    }

    public static void main(String[] args) {
        // int[][] m1;
        System.out.println("Please input the first matrix in format: x x ...;x x ...;...  for example: 1 8 5;12 4 1;5 2 2");
        Scanner scanner = new Scanner(System.in);        
        String m = scanner.nextLine();

        MatrixMultiplication input = new MatrixMultiplication();        
        int[][] m1 = input.GetMatrix(m);
        // int[][] m2;
        System.out.println("Please input the second matrix in format: x x ...;x x ...;...  for example: 1 8 5;12 4 1;5 2 2");     
        String n = scanner.nextLine();
        int[][] m2 = input.GetMatrix(n);
        scanner.close();
        // multiply matrixes;
        MultiplyMatrix calculator = new MultiplyMatrix();
        int[][] result = calculator.multiplyMatrix(m1, m2);
        for(int i = 0; i < result.length; i++) {
            for(int j = 0; j < result[0].length; j++) {
                System.out.println(result[i][j]);
            }

        }

    }
}
