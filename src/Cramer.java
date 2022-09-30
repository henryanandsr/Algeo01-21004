 public class Cramer{
    public static double[] cramer(double[][] A) {
        double detA;
        double mainA[][] = Operator.getMatrix(A,0,0,A.length-1,A[0].length-2);
        double[][] b = Operator.getMatrix(A, 0, A[0].length-1, A.length-1, A[0].length-1);
        double[] result = new double[mainA[0].length];
        if (mainA.length>=1 && mainA.length<4){
            detA = DeterminanKofaktor.determinanKofaktor(mainA);
            for (int j=0;j<mainA[0].length;j++){
                result[j] = DeterminanKofaktor.determinanKofaktor(cramerInsert(mainA,b,j))/detA;
            }
        } else {
            detA = DeterminanOBE.determinan(mainA);
            for (int j=0;j<mainA[0].length;j++){
                result[j] = DeterminanKofaktor.determinanKofaktor(cramerInsert(mainA,b,j))/detA;
            }
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