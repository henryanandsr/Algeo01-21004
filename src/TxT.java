import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TxT {
    /*=========================================================================READ AND WRITE MATRIX=========================================================================*/
    public static double[][] readMatrix(String path,int elementRow,int elementCol) throws IOException {
        double[][] m = new double[elementRow][elementCol];
        FileReader targetRead = null;
        try{
            targetRead = new FileReader(path);
            Scanner scan = new Scanner(targetRead);
            for(int i=0;i<elementRow;i++){
                for(int j=0;j<elementCol;j++){
                    m[i][j] = scan.nextDouble();
                }
            }
            scan.close();
        } catch (FileNotFoundException e) {
            System.out.println("path yang dimasukkan tidak benar");
            return null;
        }
        return m;
    }
    public static boolean writeMatrix(String path,double[][] m){
        boolean isTrue = false;
        try{
            FileWriter writeMatrix = new FileWriter(path);
            for(int i=0;i<m.length;i++){
                for(int j=0;j<m[0].length;j++){
                    if(j==0){
                        writeMatrix.write(Double.toString(m[i][j]));
                    }else if(j>0){
                        writeMatrix.write(" "+ m[i][j]);
                    }
                }
                writeMatrix.write("\n");
            }
            writeMatrix.write("\n");
            writeMatrix.close();
            isTrue =true;
        } catch (IOException e) {
            System.out.println("path tidak ditemukan");
        }
        return isTrue;
    }
    public static boolean writeInverseAdjoin(String path, double[][] m){
        boolean isTrue = false;
        try{
            FileWriter writeMatrix = new FileWriter(path);
            writeMatrix.write("Matrix :\n");
            Operator.writeMatrix(writeMatrix,m);
            System.out.println("Matrix:");
            Operator.printMatrix(m);
            if(Operator.isSquare(m)){
                if(DeterminanKofaktor.determinan(m)==0){
                    System.out.println("matrix tidak memiliki inverse karena determinan sama dengan 0");
                    writeMatrix.write("matrix tidak memiliki inverse karena determinan sama dengan 0\n\n");
                }else{
                    m = InverseAdjoin.inverseMatrixAdjoin(m);
                    System.out.println("memilki inverse:\n\n");
                    Operator.printMatrix(m);
                    writeMatrix.write("dengan metode Adjoin matrix ini memiliki inverse:\n\n");
                    Operator.writeMatrix(writeMatrix,m);
                    isTrue = true;
                }
            }else{
                System.out.println("matrix yang dimasukkan tidak nxn atau square");
                writeMatrix.write("matrix yang dimasukkan tidak nxn atau square\n\n");
            }
            writeMatrix.close();
        } catch (IOException e) {
            System.out.println("path tidak ditemukan");
        }
        return isTrue;
    }
    public static boolean writeInverseOBE(String path, double[][] m){
        boolean isTrue = false;
        try{
            FileWriter writeMatrix = new FileWriter(path);
            writeMatrix.write("Matrix :\n");
            Operator.writeMatrix(writeMatrix,m);
            System.out.println("Matrix:");
            Operator.printMatrix(m);
            if(Operator.isSquare(m)){
                if(DeterminanKofaktor.determinan(m)==0){
                    System.out.println("matrix tidak memiliki inverse karena determinan sama dengan 0");
                    writeMatrix.write("tidak memiliki inverse karena determinan sama dengan 0\n\n");
                }else {
                    m = InverseOBE.inverseMatrixOBE(m);
                    System.out.println("dengan metode OBE matrix ini memiliki inverse:\n\n");
                    Operator.printMatrix(m);
                    writeMatrix.write("dengan metode OBE matrix ini memiliki inverse:\n\n");
                    Operator.writeMatrix(writeMatrix,m);
                    isTrue = true;
                }
            }else{
                System.out.println("matrix yang dimasukkan tidak nxn atau square");
                writeMatrix.write("matrix yang dimasukkan tidak nxn atau square\n\n");
            }
            writeMatrix.close();
        } catch (IOException e) {
            System.out.println("path tidak ditemukan");
        }
        return isTrue;
    }
    public static boolean writeInverseSPL(String path,double[][] m){
        boolean isTrue = false;
        try {
            FileWriter writeMatrix = new FileWriter(path);
            if(m[0].length==m.length+1) {
                if (DeterminanKofaktor.determinan(Operator.getMatrix(m, 0, 0, m.length - 1, m.length - 1)) == 0) {
                    writeMatrix.write("Matrix :\n");
                    Operator.printMatrix(m);
                    System.out.println();
                    Operator.writeMatrix(writeMatrix,m);
                    writeMatrix.write("tidak bisa menggunakan metode balikan karena determinan sama dengan nol\n\n");
                    System.out.println("tidak bisa menggunakan metode balikan karena determinan sama dengan nol");
                } else {
                    writeMatrix.write("Matrix :\n");
                    System.out.println("Matrix:");
                    Operator.printMatrix(m);
                    System.out.println();
                    Operator.writeMatrix(writeMatrix,m);
                    writeMatrix.write("memiliki inverse:\n\n");
                    Operator.writeMatrix(writeMatrix,InverseOBE.inverseMatrixOBE(Operator.getMatrix(m, 0, 0, m.length - 1, m.length - 1)));
                    writeMatrix.write("\n\n");
                    writeMatrix.write("dengan metode balikan, matriks ini memiliki hasil:\n");
                    double[] result = InverseSPL.matrixInverseSPL(m);
                    System.out.println("Memiliki inverse:");
                    Operator.printMatrix(InverseOBE.inverseMatrixOBE(Operator.getMatrix(m, 0, 0, m.length - 1, m.length - 1)));
                    System.out.println();
                    System.out.println("dengan result");
                    Operator.printResultInverseSPL(result);
                    for (int i = 0; i < result.length; i++) {
                        writeMatrix.write("x" + (i + 1) + " = " + result[i] + "\n");
                    }
                    writeMatrix.write("\n\n");
                    isTrue = true;
                }
            }else{
                writeMatrix.write("Matrix :\n");
                Operator.writeMatrix(writeMatrix,m);
                System.out.println("matrix yang dimasukkan tidak nx(n+1)");
                writeMatrix.write("matrix yang dimasukkan tidak nx(n+1)\n\n");
            }
            writeMatrix.close();
        } catch (IOException e) {
            System.out.println("path tidak ditemukan");
        }
        return isTrue;
    }
    public static boolean writeGaussSPL(String path,double[][] m){
        boolean isTrue = false;
        try{
            FileWriter writeMatrix = new FileWriter(path);
            writeMatrix.write("Matrix :\n");
            Operator.writeMatrix(writeMatrix,m);
            writeMatrix.write("dengan gauss:\n");
            Operator.writeMatrix(writeMatrix,Gauss.matrixGauss(m));
            writeMatrix.write("memiliki hasil SPL:\n");
            double[][] result = GaussJordan.matrixGaussJordan(m);
            for(int i=0;i<m.length-1;i++){
                writeMatrix.write("x"+(i+1)+" = "+result[i][m.length]+"\n");
            }
            writeMatrix.write("\n\n");
            writeMatrix.close();
            isTrue = true;
        } catch (IOException e) {
            System.out.println("path tidak ditemukan");
        }
        return isTrue;
    }
    public static boolean writeGaussJordanSPL(String path,double[][] m){
        boolean isTrue = false;
        try{
            FileWriter writeMatrix = new FileWriter(path);
            writeMatrix.write("Matrix :\n");
            Operator.writeMatrix(writeMatrix,m);
            writeMatrix.write("dengan gauss jordan:\n");
            Operator.writeMatrix(writeMatrix,GaussJordan.matrixGaussJordan(m));
            writeMatrix.write("memiliki hasil SPL:\n");
            double[][] result = GaussJordan.matrixGaussJordan(m);
            for(int i=0;i<m.length-1;i++){
                writeMatrix.write("x"+(i+1)+" = "+result[i][m.length]+"\n");
            }
            writeMatrix.write("\n\n");
            writeMatrix.close();
            isTrue = true;
        } catch (IOException e) {
            System.out.println("path tidak ditemukan");
        }
        return isTrue;
    }
    public static boolean writeCramer(String path, double[][] m){
        boolean isTrue = false;
        try {
            FileWriter writeMatrix = new FileWriter(path);
            writeMatrix.write("Matrix :\n");
            System.out.println("Matrix :");
            Operator.printMatrix(m);
            Operator.writeMatrix(writeMatrix,m);
            writeMatrix.write("dengan metode cramer, persamaan ini memilki hasil:\n\n");
            System.out.println("dengan metode cramer, persamaan ini memilki hasil:");
            double[] result = Cramer.cramer(m);
            Operator.printResultInverseSPL(result);
            for(int i=0;i<m.length-1;i++){
                writeMatrix.write("x"+(i+1)+" = "+result[i]+"\n");
            }
            writeMatrix.write("\n\n");
            writeMatrix.close();
            isTrue = true;
        }catch (IOException e) {
            System.out.println("path tidak ditemukan");
        }
        return isTrue;
    }
    public static boolean writeDeterminanKofaktor(String path,double[][] m){
        boolean isTrue = false;
        try {
            FileWriter writeMatrix = new FileWriter(path);
            System.out.println("Matrix:");
            Operator.printMatrix(m);
            writeMatrix.write("Matrix :\n");
            Operator.writeMatrix(writeMatrix,m);
            writeMatrix.write("dengan metode kofaktor matriks ini memiliki determinan = "+DeterminanKofaktor.determinan(m)+"\n\n");
            System.out.println("dengan metode kofaktor matriks ini memiliki determinan = "+DeterminanKofaktor.determinan(m));
            isTrue = true;
            writeMatrix.close();
        } catch (IOException e) {
            System.out.println("path tidak ditemukan");
        }
        return isTrue;
    }
    public static boolean writeDeterminanOBE(String path,double[][] m){
        boolean isTrue = false;
        try {
            FileWriter writeMatrix = new FileWriter(path);
            System.out.println("Matrix:");
            Operator.printMatrix(m);
            writeMatrix.write("Matrix :\n");
            Operator.writeMatrix(writeMatrix,m);
            writeMatrix.write("dengan metode OBE matriks ini memiliki determinan = "+DeterminanOBE.determinan(m)+"\n\n");
            System.out.println("dengan metode OBE matriks ini memiliki determinan = "+DeterminanOBE.determinan(m));
            writeMatrix.close();
            isTrue = true;
        } catch (IOException e) {
            System.out.println("path tidak ditemukan");
        }
        return isTrue;
    }
    public static boolean writeInterpolasiBikubik(String path,double[][] m){
        boolean isTrue = false;
        try{
            FileWriter writeMatrix = new FileWriter(path);
            writeMatrix.write("Matrix :\n");
            System.out.println("Matrix:");
            Operator.printMatrix(m);
            Operator.writeMatrix(writeMatrix,m);
            Scanner scan = new Scanner(System.in);
            System.out.print("x = ");
            int x = scan.nextInt();
            System.out.println();
            System.out.print("y = ");
            int y = scan.nextInt();
            System.out.println();
            System.out.println("memiliki hasil interpolasi bikubik: "+InterpolasiBicubic.hitungFungsi(m,x,y));
            writeMatrix.write("dengan \nx = "+x+"\ny = "+y+"\nmemiliki hasil :"+InterpolasiBicubic.hitungFungsi(m,x,y)+"\n\n");
            writeMatrix.close();
            isTrue = true;
        } catch (IOException e) {
            System.out.println("path tidak ditemukan");
        }
        return isTrue;
    }
    public static boolean writeInterpolasiPolinom(String path, double[][] m){
        boolean isTrue = false;
        try{
            FileWriter writeMatrix = new FileWriter(path);
            writeMatrix.write("Matrix :\n");
            System.out.println("Matrix:");
            Operator.printMatrix(m);
            Operator.writeMatrix(writeMatrix,m);
            Scanner scan = new Scanner(System.in);
            System.out.print("x = ");
            double x = scan.nextDouble();
            System.out.println();
            System.out.println("memiliki hasil interpolasi polinom: "+InterpolasiPolinom.hitungFungsi(m,x));
            writeMatrix.write("dengan \nx = "+x+"\nmemiliki hasil :"+InterpolasiPolinom.hitungFungsi(m,x)+"\n\n");
            writeMatrix.close();
            isTrue = true;
        } catch (IOException e) {
            System.out.println("path tidak ditemukan");
        }
        return isTrue;
    }
    public static boolean writeRegresi(String path,double[][] m){
        boolean isTrue = false;
        try{
            FileWriter writeMatrix = new FileWriter(path);
            System.out.println("Matrix:");
            Operator.printMatrix(m);
            System.out.println("memiliki regresi:");
            Operator.printMatrix(Regresi.regresi(m));
            writeMatrix.write("Matrix:\n\n");
            Operator.writeMatrix(writeMatrix,m);
            writeMatrix.write("memilki regresi\n\n");
            Operator.writeMatrix(writeMatrix,Regresi.regresi(m));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return isTrue;
    }
}
