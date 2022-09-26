public class InverseSPL {
    public static double[] matrixInverseSPL(double[][] m){
        double[][] inverseMatrix = Operator.getMatrix(m,0,0,(m.length-1),(m.length-1));
        inverseMatrix = InverseOBE.inverseMatrixOBE(inverseMatrix);
        double[] result = new double[m.length];
        double[] resultSPL = new double[m.length];

        for(int i=0;i<m.length;i++){
            result[i] = m[i][m[0].length-1];
        }
        for(int i=0;i<inverseMatrix.length;i++){
            double all=0;
            for(int j=0;j<inverseMatrix[0].length;j++){
                all+=(inverseMatrix[i][j]*result[j]);
            }
            resultSPL[i]=all;
        }
        return resultSPL;
    }
}
