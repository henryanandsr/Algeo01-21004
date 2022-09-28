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
            System.out.println("matrix berhasil diprosess");
            writeMatrix.close();
            return true;
        } catch (IOException e) {
            System.out.println("path tidak ditemukan");
        }
        return isTrue;
    }
    public static boolean writeInverseSPL(String path,double[][] m){
        boolean isTrue = false;
        try {
            FileWriter writeMatrix = new FileWriter(path);
            if(DeterminanKofaktor.determinanKofaktor(Operator.getMatrix(m,0,0,m.length-1,m.length-1))==0){
                writeMatrix.write("Matrix :\n");
                isTrue = writeMatrix(path,m);
                writeMatrix.write("tidak ada SPL karena determinan sama dengan 0\n\n");
                isTrue = false;
                System.out.println("tidak ada SPL karena determinan sama dengan 0");
                writeMatrix.close();
            }else {
                writeMatrix.write("Matrix :\n");
                isTrue = writeMatrix(path,m);
                writeMatrix.write("dengan metode balikan, matriks ini memiliki hasil:\n");
                double[] result = InverseSPL.matrixInverseSPL(m);
                for(int i=0;i<result.length;i++){
                    writeMatrix.write("x"+(i+1)+" = "+result[i]+"\n");
                }
                writeMatrix.write("\n\n");
                System.out.println("matrix berhasil diprosess");
                writeMatrix.close();
            }
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
            isTrue = writeMatrix(path,m);
            writeMatrix.write("dengan gauss:\n");
            isTrue = writeMatrix(path, Gauss.matrixGauss(m));
            writeMatrix.write("memiliki hasil SPL:\n");
            double[][] result = GaussJordan.matrixGaussJordan(m);
            for(int i=0;i<m.length-1;i++){
                writeMatrix.write("x"+(i+1)+" = "+result[i][m.length]+"\n");
            }
            writeMatrix.write("\n\n");
            System.out.println("matrix berhasil diprosess");
            writeMatrix.close();
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
            isTrue = writeMatrix(path,m);
            writeMatrix.write("dengan gauss jordan:\n");
            isTrue = writeMatrix(path, GaussJordan.matrixGaussJordan(m));
            writeMatrix.write("memiliki hasil SPL:\n");
            double[][] result = GaussJordan.matrixGaussJordan(m);
            for(int i=0;i<m.length-1;i++){
                writeMatrix.write("x"+(i+1)+" = "+result[i][m.length]+"\n");
            }
            writeMatrix.write("\n\n");
            System.out.println("matrix berhasil diprosess");
            writeMatrix.close();
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
            isTrue = writeMatrix(path,m);
            writeMatrix.write("dengan metode cramer persamaan ini memilki hasil:\n\n");
            double[] result = Cramer.cramer(m);
            for(int i=0;i<m.length-1;i++){
                writeMatrix.write("x"+(i+1)+" = "+result[i]+"\n");
            }
            writeMatrix.write("\n\n");
            System.out.println("matrix berhasil diprosess");
            writeMatrix.close();
        }catch (IOException e) {
            System.out.println("path tidak ditemukan");
        }
        return isTrue;
    }
    public static boolean writeDeterminanKofaktor(String path,double[][] m){
        boolean isTrue = false;
        try {
            FileWriter writeMatrix = new FileWriter(path);
            writeMatrix.write("Matrix :\n");
            isTrue = writeMatrix(path,m);
            writeMatrix.write("dengan metode kofaktor matriks ini memiliki determinan = "+DeterminanKofaktor.determinanKofaktor(m)+"\n\n");
            System.out.println("determinan berhasil diproses");
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
            writeMatrix.write("Matrix :\n");
            isTrue = writeMatrix(path,m);
            writeMatrix.write("dengan metode OBE matriks ini memiliki determinan = "+DeterminanOBE.determinan(m)+"\n\n");
            System.out.println("determinan berhasil diproses");
            writeMatrix.close();
        } catch (IOException e) {
            System.out.println("path tidak ditemukan");
        }
        return isTrue;
    }
}
