public class Regresi {
    public static double[][] regresi(double[][] m){
        double[][] X = Operator.getMatrix(m,0,0,m.length-1,m[0].length-2);
        double[][] Y = Operator.getMatrix(m, 0, m[0].length-1, m.length-1, m[0].length-1);
        //misalkan matrix x adalah matrix yang berisi koefisien variabel independen, dan matrix y berisi nilai dependen
        //dari 2 jenis matriks ini, dibentuk matriks lain untuk metode penghitungan regresi linier
        //A*<beta> = B dengan A = X'X, B = X'Y. (X' = transpose dari matrix X)
        //Penghitungan dilakukan untuk mendapat nilai-nilai <beta>
        //Deklarasi matrix A dan b
        //Mengisi matriks A
        double[][] All1Col = new double[X.length][1];
        for (int i=0;i<All1Col.length;i++){
            All1Col[i][0] = 1;
        }
        double[][] XAll1Added = new double[X.length+1][X[0].length];
        XAll1Added = Operator.mergeMatrix(All1Col, X);
        double[][] Xtr = new double[XAll1Added[0].length][XAll1Added.length];         //sizenya ngga kebalik ky transpose semestinya karena cara kerja fungsi transposenya
        double[][] XtrX = new double[Xtr.length][XAll1Added[0].length];
        double[][] A = new double[XtrX.length][XtrX[0].length];
        Xtr = Operator.transposeNotSq(XAll1Added);
        XtrX = Operator.multiplyMatrix(Xtr, XAll1Added);
        Operator.copyMatriks(XtrX, A);
        //Mengisi matriks b
        double[][] XtrY = new double[Xtr.length][Y[0].length];
        double[][] B = new double[XtrY.length][XtrY[0].length];
        XtrY = Operator.multiplyMatrix(Xtr, Y);
        Operator.copyMatriks(XtrY, B);
        //Menemukan beta
        double[][] merged;
        merged = Operator.mergeMatrix(A,B);
        return GaussJordan.matrixGaussJordan(merged);
    }
}