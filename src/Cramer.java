 public class Cramer{
    public static void main(String[] args){
    double[][] m = {
        {0,0,2,-1},
        {2,0,-2,-2},
        {-1,2,-4,1},
    };
    // double[][] m = {
    //     {0,0,2,-1,4},
    //     {2,0,-2,-2,3},
    //     {-1,2,-4,1,2},
    //     {3,0,0,-3,1}
    // };
    double[] x= new double[m.length];
    for (int i=0;i<m.length;i++){
        x[i] = cramer(m)[i];
        System.out.print(x[i]+" ");
    }
    }
    public static double[] cramer(double[][] m) {
        double detA;
        double[][] A = Operator.getMatrix(m,0,0,m.length-1,m[0].length-2);
        double[][] b = Operator.getMatrix(m, 0, m[0].length-1, m.length-1, m[0].length-1);
        double[] result = new double[A[0].length];
        if (A.length>=1 && A.length<4){
            double detInsert;
            double[][] inserted = new double[A.length][A.length];
            detA = DeterminanKofaktor.determinan(A);
            for (int j=0;j<A[0].length;j++){
                inserted = insertBtoA(A, b, j);
                detInsert = DeterminanKofaktor.determinan(inserted);
                result[j] = detInsert/detA;
            }
        } else if (m.length>=4){
            detA = DeterminanOBE.determinan(A);
            double detInsert;
            double[][] inserted;
            int j = 0;
            while (j<A[0].length){
                inserted = insertBtoA(A, b, j);
                detInsert = DeterminanOBE.determinan(inserted);
                result[j] = detInsert/detA;
                j++;
            }
        }
        return result;
    }
    private static double[][] insertBtoA(double[][] A, double[][] b,int col) {
        double[][] copy = new double[A.length][A[0].length];
        copy = Operator.copyMatriks(A, copy);
        for (int i=0;i<A.length;i++) {
            copy[i][col] = b[i][0];
        }
        return copy;
    }
}