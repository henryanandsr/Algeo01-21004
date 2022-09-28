public class InterpolasiBicubic {
    public static double[][] makeMatriksX(){
        int i,j,k,l,x;
        double m16[][] = new double[16][16];
        double a;
        double temp[] = new double[16];
        int brs = 0;
        for (i=-1;i<=2;i++){
            for (j=-1;j<=2;j++){
                // untuk isi matriks per baris
                int idx = 0;
                for (k=0;k<=3;k++){
                    for(l=0;l<=3;l++){
                        a = Math.pow(j,l) * Math.pow(i,k);
                        temp[idx] = a;
                        idx++;
                    }
                }
                for (x=0;x<=15;x++){
                    m16[brs][x] = temp[x];
                }
                brs++;
            }
        }
        return m16;
    }
    //X = A^-1 * Y
    public static double[] makeMatriksY(double[][] arr){
        int i,j;
        double temp[] = new double[16];
        int idx = 0;
        for(i=0;i<4;i++){
            for(j=0;j<4;j++){
                temp[idx] = arr[j][i];
                idx++;
            }
        }
        return temp;
    }
    //tentukan nilai dari a
    public static double[] makematriksA(double[][] arr){
        System.out.println("================X");
        Operator.printMatrix(makeMatriksX());
        System.out.println("================X");
        double[][] inversX = InverseOBE.inverseMatrixOBE(makeMatriksX());
        Operator.printMatrix(inversX);
        double[] mY = makeMatriksY(arr);
        double result[] = new double[16];
        int i,j;
        for (i=0;i<=15;i++){
            for(j=0;j<=15;j++){
                result[j] = inversX[i][j] * mY[j];
            }
        }
        return result;
    }
    public static double hitungFungsi(double[][] arr, double x, double y){
        int idx = 0;
        int i,j;
        double result = 0;
        double[] matriksA = makematriksA(arr);
        for (i=0;i<=3;i++){
            for(j=0;j<=3;j++){
                result += matriksA[idx] * Math.pow(x, j) * Math.pow(y,i);
            }
        }
        return result;
    }
}
