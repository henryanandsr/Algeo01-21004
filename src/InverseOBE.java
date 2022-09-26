public class InverseOBE {
    public static double[][] inverseMatrixOBE(double[][] m){
        double[][] identity = new double[m.length][m[0].length];
        Operator.createIdentity(identity);
        double[][] mergeMatrix = Operator.mergeMatrix(m,identity);
        GaussJordan.matrixGaussJordan(mergeMatrix);
        double[][] result = Operator.getMatrix(mergeMatrix,0,((mergeMatrix[0].length/2)),(mergeMatrix.length-1),(mergeMatrix[0].length-1));
        return result;
    }
}
