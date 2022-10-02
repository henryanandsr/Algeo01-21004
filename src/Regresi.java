public class Regresi {
    public static void main(String[] args) {  
        double[][] m={
        { 0, 0, 0, 0, 3 }, 
        { 3, 2, 1, 10, 2 }, 
        { 5, 10, 0, 0, 0 },
        };
        regresi(m);
    }
    public static void regresi(double[][] m){
        double[][] X = Operator.getMatrix(m,0,0,m.length-1,m[0].length-2);
        double[][] Y = Operator.getMatrix(m, 0, m[0].length-1, m.length-1, m[0].length-1);
        //misalkan matrix x adalah matrix yang berisi koefisien variabel independen, dan matrix y berisi nilai dependen
        //dari 2 jenis matriks ini, dibentuk matriks lain untuk metode penghitungan regresi linier
        //A*<beta> = B dengan A = X'X, B = X'Y. (X' = transpose dari matrix X)
        //Penghitungan dilakukan untuk mendapat nilai-nilai <beta>
        //Deklarasi matrix A dan b
        //Mengisi matriks A
        double[][] Xtr = new double[X[0].length][X.length];         //sizenya ngga kebalik ky transpose semestinya karena cara kerja fungsi transposenya
        double[][] XtrX = new double[Xtr.length][X[0].length];
        double[][] A = new double[XtrX.length][XtrX[0].length];
        Operator.transposeNotSq(X);
        Operator.printMatrix(Xtr);
        XtrX = Operator.multiplyMatrix(Xtr, X);
        Operator.copyMatriks(XtrX, A);
        //Mengisi matriks b
        double[][] XtrY = new double[Xtr.length][Y[0].length];
        double[][] B = new double[XtrY.length][XtrY[0].length];
        XtrY = Operator.multiplyMatrix(Xtr, Y);
        Operator.copyMatriks(XtrY, B);
        //Menemukan beta
        double[][] inSPL;
        double[][] merged;
        merged = Operator.mergeMatrix(A,B);
        System.out.println("Matrix di bawah akan dihitung dengan eliminasi gauss");
        Operator.printMatrix(merged);
        inSPL = Gauss.matrixGauss(Operator.mergeMatrix(A, B));
        System.out.println("Hasil eliminasi gauss:");
        Operator.printMatrix(inSPL);
    }
}