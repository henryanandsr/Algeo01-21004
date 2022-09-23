public class GaussJordan {
    private static Gauss gauss = new Gauss();
    public static double[][] matrixGaussJordan(double[][] m){
        m = gauss.matrixGauss(m);
        for(int i=1;i<m.length;i++){
            int idxNotNoll = 0;
            for(int j=m[0].length-2;j>=0;j--){
                if(m[i][j]!=0){
                    idxNotNoll = j;
                }
            }
            if(m[i][idxNotNoll]!=0) {
                double firstCol = m[i][idxNotNoll];
                for (int k=idxNotNoll;k<m[0].length;k++) {
                    m[i][k]=m[i][k]/firstCol;
                }
                for (int k=i;k>=0;k--){
                    if(k!=0){
                        double upperObject = m[k-1][idxNotNoll];
                        if(upperObject!=0) {
                            for (int l = idxNotNoll; l < m.length; l++) {
                                m[k-1][l] = (m[k][idxNotNoll] * m[k - 1][l]) - (upperObject * m[k][l]);
                            }
                        }
                    }
                }
            }
        }
        return m;
    }
}
