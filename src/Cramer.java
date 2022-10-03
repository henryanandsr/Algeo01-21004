 public class Cramer{
    public static double[] cramer(double[][] m) {
        double detA;
        double[][] A = Operator.getMatrix(m,0,0,m.length-1,m[0].length-2);
        double[][] b = Operator.getMatrix(m, 0, m[0].length-1, m.length-1, m[0].length-1);
        double[] result = new double[A[0].length];
        if (A.length>=1 && A.length<4){
            double detInsert;
            double[][] inserted = new double[A.length][A[0].length];
            detA = DeterminanKofaktor.determinan(A);
            if (detA==0){
                System.out.println("Tidak bisa ditemukan hasil karena determinan matriks awal sama dengan nol");
                return result;
            }
            for (int j=0;j<A[0].length;j++){
                inserted = insertBtoA(A, b, j);
                detInsert = DeterminanKofaktor.determinan(inserted);
                result[j] = detInsert/detA;
            }
        } else if (m.length>=4){
            detA = DeterminanOBE.determinan(A);
            double detInsert;
            double[][] inserted = new double[A.length][A[0].length];
            if (detA==0){
                System.out.println("Tidak bisa ditemukan hasil karena determinan matriks awal sama dengan nol");
                return result;
            }
            for (int j=0;j<A[0].length;j++){
                inserted = insertBtoA(A, b, j);
                detInsert = DeterminanKofaktor.determinan(inserted);
                result[j] = detInsert/detA;
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