public class InverseAdjoin {
    public static double[][] inverseMatrixAdjoin(double[][] arr){
        int i,j;
        double[][] adjoin = Operator.adjoin(arr);
        double hasil[][] = new double[arr.length][arr[0].length];
        double satuperdet = 1/Operator.determinan(arr);
        for(i=0;i<arr.length;i++){
            for(j=0;j<arr[0].length;j++){
                hasil[i][j] = adjoin[i][j] * satuperdet;
            }
        }
        return hasil;
    }
}
