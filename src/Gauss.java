import java.util.*;

public class Gauss {
    private static Operator tools = new Operator();

    public static void main (String[] args){
        double[][] m = {{1,2,3,4,6},{2,2,7,5,99},{3,4,5,89,32},{4,5,6,7,99,90}};
        tools.printMatrix(matrixGauss(m));
    }
    public static double[][] matrixGauss(double[][] m){
        int baris = m.length;
        int kolom = m[0].length;
        for(int i=0;i<baris;i++){
            int jumNol = 0;
            for(int j=0;j<kolom;j++){
                if(m[i][j]==0&&j<=i+1){
                    jumNol++;
                }
                if(m[i][i]!=0){
                    jumNol--;
                }
            }
            if((jumNol>i)&&(tools.isNotAllNol(m,i,i))){
                tools.changeRow(m,i);
            }
        }
        for(int i=0;i<baris;i++){
            for(int j=i+1;j<baris;j++){
                if(m[j][i]!=0){
                    double firstRow = m[j][i];
                    for(int k=0;k<m[0].length;k++){
                        m[j][k] = (m[i][i]*m[j][k])-(firstRow*m[i][k]);
                    }
                }
            }
        }
        return m;
    }
}
