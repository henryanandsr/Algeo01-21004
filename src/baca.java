import java.util.*;
;

public class baca {
    public static double[][] bacaMatriks(int row, int col){
        double a[][] = new double[row][col];
        Scanner s = new Scanner(System.in);
        for (int i = 0; i < row; ++i){
            for (int j = 0; j < col; ++j){
                a[i][j] = s.nextDouble();
            }
        }
        return a;
    }
}