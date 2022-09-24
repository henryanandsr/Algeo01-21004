public class Inverse {
    public static void main(String[] args){
        double[][] m = {{2,1,5},{4,7,5},{8,1,3}};
        // System.out.println(m.length);
        // System.out.print(m[0].length + "\n");
        // System.out.println(determinan(m) + "\n");
        Operator.printMatrix(inverse_matriks(m));
    }
    public static double[][] inverse_matriks(double[][] arr){
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
