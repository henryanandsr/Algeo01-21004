import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MatriksFromFile {
    public static String currentDir(){
        return System.getProperty("user.dir") + "" //diarahkan ke directory
    }
    public static int[] ukuranMatriks(String filename){
        int row = 0, col = 0;
        File fileMatriks = new File(currentDir() + "\\" + filename);
        int[] ukuran = new int[2];
        Scanner readRow = new Scanner(file);
        Scanner readCol = new Scanner(file);
        try {
            while (readCol.hasNextDouble()){
                col += 1;
                readCol.nextDouble();
            }
            while (readRow.hasNextDouble()){
                row += 1;
                readRow.nextDouble();
            } catch(FileNotFoundException e){
                ;
            }
        }
        ukuran[0] = row;
        ukuran[1] = col;
        return ukuran;
    }
}