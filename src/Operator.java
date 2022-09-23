public class Operator {
    public static void printMatrix(double[][] m){
        for(int i=0;i<m.length;i++){
            for(int j=0;j<m[0].length;j++){
                if(j==0){
                    System.out.print(m[i][j]);
                }
                if(j>0){
                    System.out.print(m[i][j]);
                }
            }
            System.out.println("");
        }
    }
}
