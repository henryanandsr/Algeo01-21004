public class InterpolasiBicubic {
    public static void main(String[] args){
        double[][] m = {{153,59,210,96},{125,161,72,81},{98,101,42,12},{21,51,0,16}};
        System.out.println(hitungFungsi(m, 0, 0));
        System.out.println(hitungFungsi(m, 0.5, 0.5));
        System.out.println(hitungFungsi(m, 0.25, 0.75));
        System.out.println(hitungFungsi(m, 1, 1));
//        }

    }
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
    public static double[][] makeMatriksY(double[][] arr){
        int i,j;
        double temp[][] = new double[16][1];
        int idx = 0;
        for(i=0;i<4;i++){
            for(j=0;j<4;j++){
                temp[idx][0] = arr[j][i];
                idx++;
            }
        }
        return temp;
    }
    //tentukan nilai dari a
    public static double[][] makematriksA(double[][] arr){
        double[][] inversX = InverseOBE.inverseMatrixOBE(makeMatriksX());
        double[][] mY = makeMatriksY(arr);
        double result[][] = new double[16][1];
        result = Operator.multiplyMatrix(inversX,mY);
        return result;
    }
    public static double[][] makeMatrixAFix(double[][] arr){
        int i,j;
        int x=0;
        double res[][] = new double[4][4];
        for(i=0;i<=3;i++){
            for(j=0;j<=3;j++){
                res[j][i] = arr[x][0];
                x++;
            }
        }
        return res;
    }
    public static double hitungFungsi(double[][] arr, double x, double y){
        int i,j;
        double result = 0;
        double[][] matriksA = makeMatrixAFix(makematriksA(arr));
        for (i=0;i<=3;i++){
            for(j=0;j<=3;j++){
                result += matriksA[j][i] * Math.pow(x, j) * Math.pow(y,i);
            }
        }
        return result;
    }
}
