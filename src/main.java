import java.io.IOException;
import java.util.Scanner;
public class main{
    private static double[][] m;
    private static int row,col,pilDet,pilInv;
    private static String targetFile;
    private static boolean isCompleted = false;
    private static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        System.out.println("===============================================================SELAMAT DATANG KE DALAM PROGRAM KELOMPOK KAMI :)))===============================================================");
        while(!isCompleted){
            menu.menu();
            int pilMenu = scan.nextInt();
            while (pilMenu<1&&pilMenu>7){
                System.out.println("input tidak valid, masukkan kembali input:");
                pilMenu = scan.nextInt();
            }
            switch (pilMenu){
                case 1:
                    menu.SplDetInverse();
                    int pilSpl = scan.nextInt();
                    while (pilSpl<1&&pilSpl>4){
                        System.out.println("input tidak valid");
                        pilSpl = scan.nextInt();
                    }
                    switch (pilSpl){
                        case 1:
                            m = null;
                            menu.bacaInputMatrix();
                            int pilMat = scan.nextInt();
                            if(pilMat==1) {
                                System.out.print("masukkan jumlah baris matrix:");
                                row = scan.nextInt();
                                System.out.print("masukkan jumlah kolom matrix:");
                                col = scan.nextInt();
                                m = Operator.bacaMatriks(row, col);
                            }else if(pilMat==2){
                                System.out.print("masukkan jumlah baris matrix:");
                                row = scan.nextInt();
                                System.out.print("masukkan jumlah kolom matrix:");
                                col = scan.nextInt();
                                System.out.println("masukkan nama file txt:");
                                String file = scan.next();
                                m = TxT.readMatrix(file,row,col);
                            }
                            System.out.print("masukkan nama lokasi penyimpanan beserta nama txt: ");
                            targetFile = scan.next();
                            if(TxT.writeGaussSPL(targetFile,m)){
                                System.out.println("matrix berhasil diproses");
                            }else{
                                System.out.println("matrix gagal diproses");
                            }
                            break;
                        case 2:
                            menu.bacaInputMatrix();
                            m=null;
                            pilMat = scan.nextInt();
                            if(pilMat==1) {
                                System.out.print("masukkan jumlah baris matrix:");
                                row = scan.nextInt();
                                System.out.print("masukkan jumlah kolom matrix:");
                                col = scan.nextInt();
                                m = Operator.bacaMatriks(row, col);
                            }else if(pilMat==2){
                                System.out.print("masukkan jumlah baris matrix:");
                                row = scan.nextInt();
                                System.out.print("masukkan jumlah kolom matrix:");
                                col = scan.nextInt();
                                System.out.println("masukkan nama file txt:");
                                String file = scan.next();
                                m = TxT.readMatrix(file,row,col);
                            }
                            System.out.print("masukkan nama lokasi penyimpanan beserta nama txt: ");
                            targetFile = scan.next();
                            if(TxT.writeGaussJordanSPL(targetFile,m)){
                                System.out.println("matrix berhasil diproses");
                            }else{
                                System.out.println("matrix gagal diproses");
                            }
                            break;
                        case 3:
                            m=null;
                            menu.bacaInputMatrix();
                            pilMat = scan.nextInt();
                            if(pilMat==1) {
                                System.out.print("masukkan jumlah baris matrix:");
                                row = scan.nextInt();
                                System.out.print("masukkan jumlah kolom matrix:");
                                col = scan.nextInt();
                                m = Operator.bacaMatriks(row, col);
                            }else if(pilMat==2){
                                System.out.print("masukkan jumlah baris matrix:");
                                row = scan.nextInt();
                                System.out.print("masukkan jumlah kolom matrix:");
                                col = scan.nextInt();
                                System.out.println("masukkan nama file txt:");
                                String file = scan.next();
                                m = TxT.readMatrix(file,row,col);
                            }
                            System.out.print("masukkan nama lokasi penyimpanan beserta nama txt: ");
                            targetFile = scan.next();
                            if(TxT.writeInverseSPL(targetFile,m)){
                                System.out.println("matrix berhasil diproses");
                            }else{
                                System.out.println("matrix gagal diproses");
                            }
                            break;
                        case 4:
                            m=null;
                            menu.bacaInputMatrix();
                            pilMat = scan.nextInt();
                            if(pilMat==1) {
                                System.out.print("masukkan jumlah baris matrix:");
                                row = scan.nextInt();
                                System.out.print("masukkan jumlah kolom matrix:");
                                col = scan.nextInt();
                                m = Operator.bacaMatriks(row, col);
                            }else if(pilMat==2){
                                System.out.print("masukkan jumlah baris matrix:");
                                row = scan.nextInt();
                                System.out.print("masukkan jumlah kolom matrix:");
                                col = scan.nextInt();
                                System.out.println("masukkan nama file txt:");
                                String file = scan.next();
                                m = TxT.readMatrix(file,row,col);
                            }
                            System.out.print("masukkan nama lokasi penyimpanan beserta nama txt: ");
                            targetFile = scan.next();
                            if(TxT.writeCramer(targetFile,m)){
                                System.out.println("matrix berhasil diproses");
                            }else{
                                System.out.println("matrix gagal diproses");
                            }
                            break;
                    }
                    break;
                case 2:
                    System.out.println("1.Determinan Kofaktor\n2.Determinan OBE");
                    System.out.print("masukkan pilihan: ");
                    pilDet = scan.nextInt();
                    while(pilDet<1&&pilDet>2){
                        System.out.println("input tidak valid, masukkan input kembali");
                        pilDet = scan.nextInt();
                    }
                    switch (pilDet) {
                        case 1:
                            m=null;
                            menu.bacaInputMatrix();
                            int pilMat = scan.nextInt();
                            if(pilMat==1) {
                                System.out.print("masukkan jumlah baris matrix:");
                                row = scan.nextInt();
                                System.out.print("masukkan jumlah kolom matrix:");
                                col = scan.nextInt();
                                m = Operator.bacaMatriks(row, col);
                            }else if(pilMat==2){
                                System.out.print("masukkan jumlah baris matrix:");
                                row = scan.nextInt();
                                System.out.print("masukkan jumlah kolom matrix:");
                                col = scan.nextInt();
                                System.out.println("masukkan nama file txt:");
                                String file = scan.next();
                                m = TxT.readMatrix(file,row,col);
                            }
                            System.out.print("masukkan nama lokasi penyimpanan beserta nama txt: ");
                            targetFile = scan.next();
                            if (TxT.writeDeterminanKofaktor(targetFile, m)) {
                                System.out.println("matrix berhasil diproses");
                            } else {
                                System.out.println("matrix gagal diproses");
                            }
                            break;
                        case 2:
                            m=null;
                            menu.bacaInputMatrix();
                            pilMat = scan.nextInt();
                            if(pilMat==1) {
                                System.out.print("masukkan jumlah baris matrix:");
                                row = scan.nextInt();
                                System.out.print("masukkan jumlah kolom matrix:");
                                col = scan.nextInt();
                                m = Operator.bacaMatriks(row, col);
                            }else if(pilMat==2){
                                System.out.print("masukkan jumlah baris matrix:");
                                row = scan.nextInt();
                                System.out.print("masukkan jumlah kolom matrix:");
                                col = scan.nextInt();
                                System.out.println("masukkan nama file txt:");
                                String file = scan.next();
                                m = TxT.readMatrix(file,row,col);
                            }
                            System.out.print("masukkan nama lokasi penyimpanan beserta nama txt: ");
                            targetFile = scan.next();
                            if (TxT.writeDeterminanOBE(targetFile, m)) {
                                System.out.println("matrix berhasil diproses");
                            } else {
                                System.out.println("matrix gagal diproses");
                            }
                            break;
                    }
                    break;
                case 3:
                    System.out.println("1.Inverse Adjoin\n2.Inverse OBE");
                    System.out.print("masukkan pilihan: ");
                    pilInv = scan.nextInt();
                    while(pilInv<1&&pilInv>2){
                        System.out.println("input tidak valid, masukkan input kembali");
                        pilInv = scan.nextInt();
                    }
                    switch (pilInv) {
                        case 1:
                            m=null;
                            menu.bacaInputMatrix();
                            int pilMat = scan.nextInt();
                            if(pilMat==1) {
                                System.out.print("masukkan jumlah baris matrix:");
                                row = scan.nextInt();
                                System.out.print("masukkan jumlah kolom matrix:");
                                col = scan.nextInt();
                                m = Operator.bacaMatriks(row, col);
                            }else if(pilMat==2){
                                System.out.print("masukkan jumlah baris matrix:");
                                row = scan.nextInt();
                                System.out.print("masukkan jumlah kolom matrix:");
                                col = scan.nextInt();
                                System.out.println("masukkan nama file txt:");
                                String file = scan.next();
                                m = TxT.readMatrix(file,row,col);
                            }
                            System.out.print("masukkan nama lokasi penyimpanan beserta nama txt: ");
                            targetFile = scan.next();
                            if (TxT.writeInverseAdjoin(targetFile, m)) {
                                System.out.println("matrix berhasil diproses");
                            } else {
                                System.out.println("matrix gagal diproses");
                            }
                            break;
                        case 2:
                            m=null;
                            menu.bacaInputMatrix();
                            pilMat = scan.nextInt();
                            if(pilMat==1) {
                                System.out.print("masukkan jumlah baris matrix:");
                                row = scan.nextInt();
                                System.out.print("masukkan jumlah kolom matrix:");
                                col = scan.nextInt();
                                m = Operator.bacaMatriks(row, col);
                            }else if(pilMat==2){
                                System.out.print("masukkan jumlah baris matrix:");
                                row = scan.nextInt();
                                System.out.print("masukkan jumlah kolom matrix:");
                                col = scan.nextInt();
                                System.out.println("masukkan nama file txt:");
                                String file = scan.next();
                                m = TxT.readMatrix(file,row,col);
                            }
                            System.out.print("masukkan nama lokasi penyimpanan beserta nama txt: ");
                            targetFile = scan.next();
                            if (TxT.writeInverseOBE(targetFile, m)) {
                                System.out.println("matrix berhasil diproses");
                            } else {
                                System.out.println("matrix gagal diproses");
                            }
                            break;
                    }
                    break;
                case 4:
                    m=null;
                    menu.bacaInputMatrix();
                    int pilMat = scan.nextInt();
                    if(pilMat==1) {
                        System.out.print("masukkan jumlah baris matrix:");
                        row = scan.nextInt();
                        m = Operator.bacaMatriks(row, 2);
                    }else if(pilMat==2){
                        System.out.print("masukkan jumlah baris matrix:");
                        row = scan.nextInt();
                        System.out.println("masukkan nama file txt:");
                        String file = scan.next();
                        m = TxT.readMatrix(file,row,2);
                    }
                    System.out.print("masukkan nama lokasi penyimpanan beserta nama txt: ");
                    targetFile = scan.next();
                    if(TxT.writeInterpolasiPolinom(targetFile,m)){
                        System.out.println("matrix berhasil diproses");
                    }else{
                        System.out.println("matrix gagal diproses");
                    }
                    break;
                case 5:
                m=null;
                double xfile,yfile;
                menu.bacaInputMatrix();
                pilMat = scan.nextInt();
                if(pilMat==1) {
                    m = Operator.bacaMatriks(4, 4);
                    System.out.print("masukkan nama lokasi penyimpanan beserta nama txt: ");
                    targetFile = scan.next();
                    if(TxT.writeInterpolasiBikubikKeyboard(targetFile,m)){
                        System.out.println("matrix berhasil diproses");
                    }else{
                        System.out.println("matrix gagal diproses");
                    }
                }else if(pilMat==2){
                    System.out.println("masukkan nama file txt:");
                    String file = scan.next();
                    m = TxT.readMatrix(file,4,4);
                    xfile = TxT.readBicubic(file)[4][0];
                    yfile = TxT.readBicubic(file)[4][1];
                    System.out.print("masukkan nama lokasi penyimpanan beserta nama txt: ");
                    targetFile = scan.next();
                    if(TxT.writeInterpolasiBikubikFile(targetFile,m,xfile,yfile)){
                        System.out.println("matrix berhasil diproses");
                    }else{
                        System.out.println("matrix gagal diproses");
                    }
                }
                    break;
                case 6:
                    m=null;
                    menu.bacaInputMatrix();
                    pilMat = scan.nextInt();
                    if(pilMat==1) {
                        System.out.print("masukkan jumlah baris matrix:");
                        row = scan.nextInt();
                        System.out.print("masukkan jumlah kolom matrix:");
                        col = scan.nextInt();
                        m = Operator.bacaMatriks(row, col);
                    }else if(pilMat==2){
                        System.out.print("masukkan jumlah baris matrix:");
                        row = scan.nextInt();
                        System.out.print("masukkan jumlah kolom matrix:");
                        col = scan.nextInt();
                        System.out.println("masukkan nama file txt:");
                        String file = scan.next();
                        m = TxT.readMatrix(file,row,col);
                    }
                    System.out.print("masukkan nama lokasi penyimpanan beserta nama txt: ");
                    targetFile = scan.next();
                    if(TxT.writeRegresi(targetFile,m)){
                        System.out.println("matrix berhasil diproses");
                    }else{
                        System.out.println("matrix gagal diproses");
                    }
                    break;
                case 7:
                    isCompleted = true;
                    break;
            }
        }
    }
}