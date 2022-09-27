public class InterpolasiPolinom {
    public static void main(String[] args){
        double[][] m = {{8,2.0794},{9.0, 2.1972},{9.5, 2.2513}};
        Operator.printMatrix(makePolinom(m));
    }
    public static double[][] makePolinom(double[][] arr){
        double polinom[][] = new double[arr.length][arr.length + 1];
        int i,j;
        for (i=0;i<polinom.length;i++){
            for(j=0;j<polinom[0].length;j++){
                if (j==polinom[0].length-1){
                    polinom[i][j] = arr[i][1];
                } else{
                    polinom[i][j] = Math.pow(arr[i][0],j);
                }
            }
        }
        return polinom;
    }
    // public static double hitungFungsi(double[][] arr){
    //     double[][] matriksPolinom = makePolinom(arr);
    //     double[][] matriksPolinomGJ = GaussJordan.matrixGaussJordan(matriksPolinom);
    //     Operator.printMatrix(GaussJordan.matrixGaussJordan(matriksPolinomGJ));
    //     return 0;
    // }
}
