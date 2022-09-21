import java.util.scanner;

public class Matriks {
    public static double[][] bacaMatriks(int brs, int kol){
        double arr[][] = new double[brs][kol];
        Scanner s = new Scanner(System.in);
        for (int i = 0; i < brs; ++i){
            for (int j = 0; j < kol; ++j){
                arr[i][j] = s.nextDouble();
            }
        }
        return arr;
    }
}