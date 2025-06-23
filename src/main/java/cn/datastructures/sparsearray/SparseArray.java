package cn.datastructures.sparsearray;

import java.io.*;
import java.util.*;

/**
 * ClassName: SparseArray
 * Package: cn.datastructures.sparsearray
 * Description:
 *
 * @Author wanghao
 * @Create 2022/12/5 11:14
 * @Version v1.0
 */
public class SparseArray {

    public static void main(String[] args) throws IOException {
        // 创建一个原始的二维数组 11*11
        // 0表示没有棋子。1表示黑子，2表示蓝子
        int chessArr1[][] = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        // 输出原始二维数组
        System.out.println("原始二维数组：");
        for (int[] row : chessArr1) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
        System.out.println();

        // 将二维数组转为稀疏数组
        // 1.遍历原始二维数组，得到有效数据的个数sum
        int sum = 0;
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1[i].length; j++) {
                if (chessArr1[i][j] != 0) {
                    sum++;
                }
            }
        }
        // 2.根据sum创建稀疏数组 sparseArr1
        int sparseArr1[][] = new int[sum + 1][3];
        sparseArr1[0][0] = chessArr1.length;
        sparseArr1[0][1] = chessArr1[0].length;
        sparseArr1[0][2] = sum;
        // 3。将二维数组的数据存入稀疏数组
        int count = 0;
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1[i].length; j++) {
                if (chessArr1[i][j] != 0) {
                    count++;
                    sparseArr1[count][0] = i;
                    sparseArr1[count][1] = j;
                    sparseArr1[count][2] = chessArr1[i][j];
                }
            }
        }

        // 4.输出稀疏数组
        for (int i = 0; i < sparseArr1.length; i++) {
            System.out.printf("%d\t%d\t%d\n", sparseArr1[i][0], sparseArr1[i][1], sparseArr1[i][2]);
        }
        System.out.println();

        // 文件操作
        File file = new File("f.txt");
        // 将稀疏数组写入磁盘
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        for (int i = 0; i < sparseArr1.length; i++) {
            String str = sparseArr1[i][0] + "\t" + sparseArr1[i][1] + "\t" + sparseArr1[i][2];
            bw.write(str);
            bw.newLine();
        }
        bw.close();
        // 将磁盘文件读取
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line = null;
        // 循环读取
        List<String> list = new ArrayList<>();
        while ((line = br.readLine()) != null) {
            list.add(line);
        }
        br.close();
        int sparseArr2[][] = new int[list.size()][3];
        for (int i = 0; i < list.size(); i++) {
            String[] split = list.get(i).split("\t");
            sparseArr2[i][0] = Integer.parseInt(split[0]);
            sparseArr2[i][1] = Integer.parseInt(split[1]);
            sparseArr2[i][2] = Integer.parseInt(split[2]);
        }
        // 输出稀疏数组
        System.out.println("-----------");
        for (int i = 0; i < sparseArr2.length; i++) {
            System.out.printf("%d\t%d\t%d\n", sparseArr2[i][0], sparseArr2[i][1], sparseArr2[i][2]);
        }
        System.out.println("-----------");

        System.out.println();
        // 稀疏数组转为二维数组
        // 1.先读取稀疏数组的第一行，创建原始的二维数组
        int chessArr2[][] = new int[sparseArr1[0][0]][sparseArr1[0][1]];
        // 2.读取稀疏数组后几行数据，赋值给原始二维数组
        for (int i = 1; i < sparseArr1.length; i++) {
            chessArr2[sparseArr1[i][0]][sparseArr1[i][1]] = sparseArr1[i][2];
        }
        // 3.输出二维数组
        for (int i = 0; i < chessArr2.length; i++) {
            for (int j = 0; j < chessArr2[i].length; j++) {
                System.out.printf("%d\t", chessArr2[i][j]);
            }
            System.out.println();
        }
    }
}

