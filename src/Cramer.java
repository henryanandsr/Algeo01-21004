 public class Cramer{
    public static void main(String[] args){
        double[][] m = {{2,1,5},{4,7,5}};
        double[] result = cramer(m);
        for (int i=0;i<result.length;i++) {
            System.out.println(result[i]);
        }
    }
    public static double[] cramer(double[][] A) {
        double[] result = new double[A[0].length-1];
        double copyA[][] = Operator.getMatrix(A,0,0,A.length-1,A[0].length-2);
        double detA = DeterminanKofaktor.determinanKofaktor(copyA);
        System.out.println(copyA);
        Operator.printMatrix((copyA));
        for (int j=0;j<copyA[0].length;j++){
            result[j] = DeterminanKofaktor.determinanKofaktor(cramerInsert(A,j))/detA;
        }
        return result;
    }
    private static double[][] cramerInsert(double[][] arr, int col) {
        for (int i=0;i<arr.length;i++) {
            arr[i][col] = arr[i][arr[0].length-1];
        }
        return arr;
    }
}