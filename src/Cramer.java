 public class Cramer{
    public static double[] cramer(double[][] A) {
        double mainA[][] = Operator.getMatrix(A,0,0,A.length-1,A[0].length-2);
        double[] result = new double[mainA[0].length];
        double detA = DeterminanKofaktor.determinanKofaktor(mainA);
        double[][] b = Operator.getMatrix(A, 0, A[0].length-1, A.length-1, A[0].length-1);
        for (int j=0;j<mainA[0].length;j++){
            result[j] = DeterminanKofaktor.determinanKofaktor(cramerInsert(mainA,b,j))/detA;
        }
        return result;
    }
    private static double[][] cramerInsert(double[][] arr, double[][] b,int col) {
        double[][] copy = new double[arr.length][arr[0].length];
        Operator.copyMatriks(arr, copy);
        for (int i=0;i<arr.length;i++) {
            copy[i][col] = b[i][0];
        }
        return copy;
    }
}