import java.util.Scanner;

import static java.lang.Math.abs;


public class Operator {
    /*
    prosedur ini berfungsi untuk print matrix
    dengan cara memasukkan matrix mxn berbentuk double pada prosedur

    print ini akan menampilakan matrix sesuai dengan baris dan kolomnya
    */
    public static void main(String[] args) {
        double[][] m = {{1,2,3},{4,5,6},{7,8,9}};
        Operator.printMatrix(sub_matriks(m,0,0));
        // System.out.println(m.length);
        // System.out.print(m[0].length + "\n");
        // System.out.println(determinan(m) + "\n");
        Operator.printMatrix(adjoin(m));
    }
    public static void printMatrix(double[][] m){
        for(int i=0;i<m.length;i++){
            for(int j=0;j<m[0].length;j++){
                if(j==0){
                    if(m[i][j]==0){
                        System.out.print(abs(m[i][j]));
                    }else{
                        System.out.print(m[i][j]);
                    }
                }
                if(j>0){
                    if(m[i][j]==0) {
                        System.out.print(" " + abs(m[i][j]));
                    }else{
                        System.out.print(" " + m[i][j]);
                    }
                }
            }
            System.out.println("");
        }
    }
    /*
    fungsi changeRow adalah fungsi yang digunakan untuk menukar baris
    yang dimana akan menukar jika kolom awal baris di bawah baris idxRow1 tidak sama dengan nol
    */
    public static void changeRow(double[][] m,int idxRow1){
        double[] copyRow1 = new double[m[0].length];
        double[] copyRow2 = new double[m[0].length];
        int idxR=0;
        for(int x=0;x<2;x++){
            if(x==0){
                for(int i=idxRow1;i<m.length;i++){
                    if(i==idxRow1){
                        for(int k=0;k<m[0].length;k++){
                            copyRow1[k] = m[i][k];
                        }
                    }
                    if(m[i][idxRow1]!=0){
                        for(int k=0;k<m[0].length;k++){
                            copyRow2[k] = m[i][k];
                            idxR=i;
                        }
                    }
                }
            }
            if(x==1){
                for(int i=idxRow1;i<m.length;i++){
                    if(i==idxRow1){
                        for(int k=0;k<m[0].length;k++){
                            m[i][k]=copyRow2[k];
                        }
                    }
                    if(i==idxR){
                        for(int k=0;k<m[0].length;k++){
                            m[i][k]=copyRow1[k];
                        }
                    }
                }
            }
        }
    }

    /*
    fungsi boolean isNotAllNol adalah fungsi yang digunakan untuk mencari
    apakah dibaris ini bernilai nol setelah diagonalnya atau tidak
    */
    public static boolean isNotAllNol(double[][] m,int idxRow,int idxCol){
        boolean isNotNol = false;
        int isNol=0;
        for(int i=idxRow;i<m.length;i++){
            if(m[i][idxCol]==0){
                isNol++;
            }
        }
        if(isNol!=0){
            isNotNol = true;
        }
        return isNotNol;
    }
    public static double[][] bacaMatriks(int row, int col){
        double arr[][] = new double[row][col];
        Scanner s = new Scanner(System.in);
        for (int i = 0; i < row; ++i){
            for (int j = 0; j < col; ++j){
                arr[i][j] = s.nextDouble();
            }
        }
        return arr;
    }
    public static double[][] sub_matriks(double[][] arr, int brs, int kol){
        double sub[][] = new double[(arr.length)-1][(arr[0].length)-1];
        int i,j;
        int idbrs = 0;
        int idkol = 0;
        for(i=0;i<arr.length;i++){
            for(j=0;j<arr[0].length;j++){
                if (i!=brs && j!=kol){
                    sub[idbrs][idkol] = arr[i][j];
                    if (idkol==(sub[0].length-1)){
                        idbrs+=1;
                        idkol=0;
                    } else{
                        idkol +=1;
                    }
                } 
            }
        }
        return sub;
    }
    public static double determinan(double[][] arr){
        int kali = 1;
        double det = 0;
        int i;
        if (arr.length==1){
            return arr[0][0];
        }
        for (i=0;i<arr[0].length;i++){
            det += (arr[0][i] * kali * determinan(sub_matriks(arr,0,i)));
            kali *=-1;
        }
        return det;
    }
    public static double[][] copyMatriks(double[][] arr, double[][] copy){
        int i,j;
        for (i=0;i<arr.length;i++){
            for(j=0;j<arr[0].length;j++){
                copy[i][j] = arr[i][j];
            }
        }
        return copy;
    }
    public static void transpose(double[][] arr){
        int i,j;
        double copy[][] = new double[arr.length][arr[0].length];
        copyMatriks(arr, copy);
        for(i=0;i<arr.length;i++){
            for(j=0;j<arr[0].length;j++){
                arr[i][j] = copy[j][i];
            }
        }
    }
    public static double[][] adjoin(double[][] arr){
        int i,j;
        int kali = 1;
        double copy[][] = new double[arr.length][arr[0].length];
        for (i=0;i<arr.length;i++){
            for(j=0;j<arr[0].length;j++){
                copy[i][j] = kali*determinan(sub_matriks(arr, i, j));
                kali *= -1;
            }
        }
        transpose(copy);
        return copy;
    }
}
