import java.util.Scanner;

public class Operator {
    /*
    prosedur ini berfungsi untuk print matrix
    dengan cara memasukkan matrix mxn berbentuk double pada prosedur

    print ini akan menampilakan matrix sesuai dengan baris dan kolomnya
    */
    public static void printMatrix(double[][] m){
        for(int i=0;i<m.length;i++){
            for(int j=0;j<m[0].length;j++){
                if(j==0){
                    System.out.print(m[i][j]);
                }
                if(j>0){
                    System.out.print(" "+m[i][j]);
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
}
