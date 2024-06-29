package Questions;
import java.util.*;

public class SpiralMatrix {
    public static void main(String[] a) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of rows: ");
        int n = sc.nextInt();
        System.out.println("Enter number of columns: ");
        int m = sc.nextInt();

        int fibonacci[] = new int[n*m];
        int[][] matrix = new int[n][m];
        fibonacci[0] = 0;
        fibonacci[1] = 1;
        
        for(int i = 2; i < fibonacci.length; i++) {
            fibonacci[i] = fibonacci[i-1] + fibonacci[i-2];
        }

        for(int i = 0; i < fibonacci.length; i++) {
            System.out.print(fibonacci[i]+" ");
        }


        int rowStart = 0, rowEnd = n - 1, colStart = 0, colEnd = m - 1, index = 0;
        while(rowStart <= rowEnd && colStart <= colEnd) {
            for(int j = colStart; j <= colEnd && index < fibonacci.length; j++) {
                matrix[rowStart][j] = fibonacci[index++];
            }
            rowStart++;

            for(int j = rowStart; j <= rowEnd && index < fibonacci.length; j++) {
                matrix[j][colEnd] = fibonacci[index++];
            }
            colEnd--;
            
            for(int j = colEnd; j >= colStart && index < fibonacci.length; j--) {
                matrix[rowEnd][j] = fibonacci[index++];
            }
            rowEnd--;
            
            for(int j = rowEnd; j >= rowStart && index < fibonacci.length; j--) {
                matrix[j][colStart] = fibonacci[index++];
            }
            colStart++;
        }

        System.out.println("\nRESULT: ");
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                System.out.print(matrix[i][j]+"   ");
            }
            System.out.println();
        }
    }
}
