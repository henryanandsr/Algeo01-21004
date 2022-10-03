public class Gauss {

    private static Operator tools = new Operator();

    public static void main(String[] args) {
        double[][] m = {
            {0, 0, 2, -1},
            {2, 0, -2, -2},
            {-1, 2, -4, 1},
            {3, 0, 0, -3}
        };
        tools.printMatrix(matrixGauss(m));
    }
    public static double[][] matrixGauss(double[][] m){
        int baris = m.length;
        for(int i=0;i<baris;i++){
            int jumNol = 0;
            for(int j=0;j<=i;j++){
                if(m[i][j]==0){
                    jumNol++;
                }
            }
            if((jumNol>i)&&(tools.isNotAllNol(m,i,i))){
                tools.changeRow(m,i);
            }
        }
        for(int i=0;i<baris;i++){
            for(int j=i+1;j<baris;j++){
                int anu=0;
                for(int k=i;k>=0;k--){
                    if(m[j][k]!=0){
                        anu=k;
                    }
                }
                if(m[i][i]==0){
                    for(int k = i+1;k<m.length;k++){
                        if(m[k][i]!=0){
                            Operator.changeRow(m, i);
                        }
                    }
                }
                if(anu!=0||anu==0&&i==0){
                    double firstRow = m[j][anu];
                    for(int k=anu;k<m[0].length;k++){
                        m[j][k] = (m[i][i]*m[j][k])-(firstRow*m[i][k]);
                    }
                }
            }
        }
        for(int i=0;i<m.length;i++){
            double firstNotNol=0;
            for(int k=m.length-1;k>=0;k--){
                if(m[i][k]!=0){
                    firstNotNol=m[i][k];
                }
            }
            if(firstNotNol!=0){
                for(int j=0;j<m[0].length;j++){
                    m[i][j]/=firstNotNol;
                }
            }
        }
        return m;
    }
}