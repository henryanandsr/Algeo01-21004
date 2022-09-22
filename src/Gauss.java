import java.util.*;

public class Gauss {
    public static double[][] matrixGauss(double[][] m){
        int baris = m.length;
        int kolom = m[0].length;
        for(int i=0;i<baris;i++){
            int jumNol = 0;
            for(int j=0;j<kolom;j++){
                if(m[i][j]==0){
                    jumNol++;
                }
            }
            if((jumNol>i)&&(isNotAllNol(m,i,i))){
                changeRow(m,i);
            }
        }
        for(int i=0;i<baris;i++){
            for(int j=i+1;j<baris;j++){
                if(m[j][i]!=0){
                    for(int k=0;k<m[0].length;k++){
                        m[j][k] = (m[i][i]*m[j][k])-(m[j][i]*m[i][k]);
                    }
                }
            }
        }
        return m;
    }
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
}
