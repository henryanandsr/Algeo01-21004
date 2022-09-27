public class DeterminanKofaktor {
    public static double determinanKofaktor(double[][] arr){
        int kali = 1;
        double det = 0;
        int i;
        if (arr.length==1){
            return arr[0][0];
        }
        for (i=0;i<arr[0].length;i++){
            det += (arr[0][i] * kali * determinanKofaktor(Operator.sub_matriks(arr,0,i)));
            kali *=-1;
        }
        return det;
    }
}
