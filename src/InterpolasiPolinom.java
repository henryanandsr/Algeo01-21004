public class InterpolasiPolinom {
    // public static void main(String[] args){
    //     double[][] m = {{8,2.0794},{9.0, 2.1972},{9.5, 2.2513}};
    //     Operator.printMatrix(makePolinom(m));
    //     System.out.println(hitungFungsi(m,9.2));
    // }
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
    public static double[] makeFungsi(double[][] arr){
        int i;
        double[][] matriksPolinom = makePolinom(arr);
        // Operator.printMatrix(matriksPolinom);
        double[][] matriksPolinomGJ = GaussJordan.matrixGaussJordan(matriksPolinom);
        // Operator.printMatrix(GaussJordan.matrixGaussJordan(matriksPolinomGJ));
        double[] fungsi = new double[matriksPolinomGJ.length]; 
        for (i=0;i<matriksPolinomGJ.length;i++){
            fungsi[i] = matriksPolinomGJ[i][matriksPolinomGJ[0].length - 1];
        }
        return fungsi;
    }
    public static double hitungFungsi(double[][] arr, double x){
        int i;
        double[] fungsi = makeFungsi(arr);
        double result=0;
        for (i=0;i<fungsi.length;i++){
            result += fungsi[i] * Math.pow(x,i);
        }
        return result;
    }
    public static void tulisFungsi(double[] fungsi){
        int z;
        System.out.print("f(x) = " + fungsi[0]);
        for(z=1;z<fungsi.length;z++){
            if (fungsi[z]<0){
                System.out.print(fungsi[z]+"x^"+z);
            } else{
                System.out.print("+"+fungsi[z]+"x^"+z);
            }
        }
        System.out.println();
    }
}
