public class DeterminanOBE {
    private static int sign=1;
    //Determinan matriks dengan OBE
    public static void main(String[] args){
        double[][] m = {{0,0,2},{2,5,6},{1,2,8}};
        obe(m);
        Operator.printMatrix(m);
        System.out.println(determinan(m));
    }
    //Fungsi mengurangi baris ke brs1 dengan brs2
    public static void kurang(double[][] arr, int brs1, int brs2){
        int i;
        for(i=0;i<arr[0].length;i++){
            arr[brs1][i] = arr[brs1][i] - arr[brs2][i];
        }
    }

    //Fungsi mengalikan suatu baris dengan n
    public static void kali(double[][] arr, int brs, double n){
        int i;
        for(i=0;i<arr[0].length;i++){
            arr[brs][i] = arr[brs][i] * n;
        }
    }
    //Fungsi mengubah semua bilangan di depan tidak nol
    public static void swabRow(double[][] arr, int brs1, int brs2){
        double copy[][] = new double[arr.length][arr[0].length];
        copy = Operator.copyMatriks(arr, copy);
        int i;
        for (i=0;i<arr[0].length;i++){
            arr[brs1][i] = copy[brs2][i];
            arr[brs2][i] = copy[brs1][i];
        }
    }
    public static void urut(double[][] arr, int kol){
        for (int i=0;i<arr.length - 1;i++){
            for (int j=0;j<arr.length - 1;j++){
                if (arr[j][kol]==0){
                    swabRow(arr,j,j+1);
                    sign*=-1;
                }
            }
        }
    }
    public static void obe(double[][] arr){
        int kol,brs,x,z,k;
        int i=0;
        double kopi[] = new double[arr[0].length];
        urut(arr,0);
        for (kol=0; kol < arr[0].length - 1 ; kol++){
            double basis = arr[i][kol];
            for (brs=kol + 1;brs<arr.length;brs++){
                //masukkan baris basis ke array kopi
                for (k=0;k<arr[0].length;k++){
                    kopi[k] = arr[i][k];
                }
                //Mengurangi baris dengan baris basis untuk membuat nol
                if (arr[brs][kol] != 0){
                    double buatNol = arr[brs][kol] / basis;
                    for (z=0;z<kopi.length;z++){
                        kopi[z] *= buatNol;
                    }
                    for (x=0;x<arr[0].length;x++){
                        arr[brs][x] = arr[brs][x] - kopi[x];
                    }
                }
            }
            urut(arr,kol);
            i++;
        }
    }
    public static double determinan(double[][] arr){
        int i;
        double det = 1;
        for (i=0;i<arr.length;i++){
            det *= arr[i][i];
        }
        return det/sign;
    }
}
