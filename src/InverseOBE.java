public class InverseOBE {
    public static void main(String[] args) {
        double[][] m={
        {0,0,2,-1},
        {2,0,-2,-2},
        {-1,2,-4,1},
        {3,0,0,-3}
    };
        Operator.printMatrix(inverseMatrixOBE(m));
    }
    public static double[][] inverseMatrixOBE(double[][] m){
        double[][] identity = new double[m.length][m[0].length];
        Operator.createIdentity(identity);
        double[][] mergeMatrix = Operator.mergeMatrix(m,identity);
        GaussJordan.matrixGaussJordan(mergeMatrix);
        double[][] result = Operator.getMatrix(mergeMatrix,0,((mergeMatrix[0].length/2)),(mergeMatrix.length-1),(mergeMatrix[0].length-1));
        return result;
    }
}
