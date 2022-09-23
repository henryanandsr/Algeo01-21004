import java.util.Scanner;

public class Matriks {
    public static double[][] bacaMatriks(int row, int col){
        double arr[][] = new double[row][col];
        Scanner s = new Scanner(System.in);
        for (int i = 0; i < row; ++i){
            for (int j = 0; j < col; ++j){
                arr[i][j] = s.nextDouble();
            }
        }
        return arr;
    }
}