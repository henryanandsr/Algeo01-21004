import static java.lang.Math.abs;

public class DeterminanOBE {
    private static int sign=1;
    private static double constant=1;
    private static double det = 1;
    //fungsi yang memeriksa jika ada baris/kolom berisi 0 semua (determinan=0)
    public static boolean All0rowcolCek(double[][] m){
        for (int i=0;i<m.length;i++){
            if (All0rowcol(m,true,i)){
                det = 0;
                break;
            }
            if (All0rowcol(m,false,i)){
                det = 0;
                break;
            }
        }
        return true;
    }
    //Fungsi mengecek jika baris/kolom bernilai 0 semua
    private static boolean All0rowcol(double[][] m, boolean isRow, int idx){
        double[] temp = new double[m.length];
        if (isRow){
            for (int i=0;i<temp.length;i++){
                temp[i] = m[idx][i];
            }
        } else {
            for (int i=0;i<temp.length;i++){
                temp[i] = m[i][idx];
            }
        }
        for (int i=0;i<temp.length;i++){
            if (temp[i]!=0){
                return false;
            }
        }
        return true;
    }
    //Fungsi mengurangi baris ke brs1 dengan brs2
    private static void kurangBasis(double[][] m, int row, double[] basis){
        int i;
        for(i=0;i<m[0].length;i++){
            m[row][i] = m[row][i] - basis[i];
        }
    }
    private static void tambahBasis(double[][] m, int row, double[] basis){
        int i;
        for(i=0;i<m[0].length;i++){
            m[row][i] = m[row][i] + basis[i];
        }
    }
    // {for debugging}
    // private static void printBasis(double[] basis){
    //     for(int j=0;j<basis.length;j++){
    //         if(j==0){
    //             if(basis[j]==0){
    //                 System.out.print(abs(basis[j]));
    //             }else{
    //                 System.out.print(basis[j]);
    //             }
    //         }
    //         if(j>0){
    //             if(basis[j]==0) {
    //                 System.out.print(" " + abs(basis[j]));
    //             }else{
    //                 System.out.print(" " + basis[j]);
    //             }
    //         }
    //     }
    // }
    //Fungsi mengalikan suatu baris dengan n
    private static void kali(double[][] arr, int brs, double n){
        int i;
        for(i=0;i<arr[0].length;i++){
            arr[brs][i] = arr[brs][i] * n;
        }
    }
    //Fungsi mengubah semua bilangan di depan tidak nol
    private static void swapRow(double[][] arr, int brs1, int brs2){
        double copy[][] = new double[arr.length][arr[0].length];
        copy = Operator.copyMatriks(arr, copy);
        int i;
        for (i=0;i<arr[0].length;i++){
            arr[brs1][i] = copy[brs2][i];
            arr[brs2][i] = copy[brs1][i];
        }
    }

    private static void obe(double[][] m){
    double basis[] = new double[m[0].length];
    // int idxBasis = 0;
    for (int idxBasis=0;idxBasis<m.length;idxBasis++){   //idxBasis = row basis sekarang
        //swap basis ke baris non 0 kalau 0 (kalau ngga, lanjut)
        if (m[idxBasis][idxBasis]==0) {
            int scanNot0 = idxBasis+1;
            while (scanNot0<m.length && m[scanNot0][idxBasis]==0){
                scanNot0++;
            }
            swapRow(m,idxBasis,scanNot0);
            sign*=-1;
// System.out.println("terjadi swap");
        }
// Operator.printMatrix(m);
// System.out.println();
        //mengisi list basis dengan elemen baris dan disederhanakan
        //penyederhanaan digunakan untuk eliminasi elmt di bawah basis
        for (int i=0;i<m[0].length;i++){
            basis[i]=m[idxBasis][i]/m[idxBasis][idxBasis];
        }
// System.out.println();

        // {unused} bikin sebaris jadi baris eselon (1 utama, sisanya dibagi element 1 utama)
        // kali(m,idxBasis,1/basis[0]);
        // constant *= basis[0];
        
// System.out.println("Basis:");
// printBasis(basis);
// System.out.println();
        //eliminasi 1 column di bawah elemen basis
        //dengan pengurangan baris tsb dengan basis
        int elimRow = idxBasis+1;
        while (elimRow<m.length) {
// System.out.println("\niterasi eliminasi "+elimRow);
            while(m[elimRow][idxBasis]!=0){
                if (m[elimRow][idxBasis]>0) {
                    kurangBasis(m, elimRow, basis);
                } else {
                    tambahBasis(m, elimRow, basis);
                }
// Operator.printMatrix(m);
// System.out.println("'terkurangi' 1");
            }
            elimRow++;
        }
    }
    }
    public static double determinan(double[][] m){
        All0rowcolCek(m);
        if (det==1){
            obe(m);
            for (int i=0;i<m.length;i++){
                det *= m[i][i];
            }
        }
        return det*sign/constant;
    }
}
