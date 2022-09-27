public class GaussJordan {
    public static double[][] matrixGaussJordan(double[][] m){
        m = Gauss.matrixGauss(m);
        int idx=0;
        for(int i=m[0].length-2;i>=0;i--){
            if(m[0][i]!=0){
                idx=i;
            }
        }
        double anu = m[0][idx];
        for(int i=idx;i<m[0].length;i++){
            m[0][i]/=anu;
        }
        for(int i=1;i<m.length;i++){
            int idxNotNoll = 0;
            for(int j=m[0].length-2;j>=0;j--){
                if(m[i][j]!=0){
                    idxNotNoll = j;
                }
            }
            if(m[i][idxNotNoll]!=0) {
//                double firstCol = m[i][idxNotNoll];
//                for (int k=idxNotNoll;k<m[0].length;k++) {
//                    m[i][k]=m[i][k]/firstCol;
//                }
                for (int k=i;k>0;k--){
                    double upperObject = m[k-1][idxNotNoll];
                    if(upperObject!=0) {
                        for (int l = idxNotNoll; l < m[0].length; l++) {
                            m[k-1][l] = (m[i][idxNotNoll] * m[k - 1][l]) - (upperObject * m[i][l]);
                        }
                    }
                }
            }
        }
        return m;
    }
}
