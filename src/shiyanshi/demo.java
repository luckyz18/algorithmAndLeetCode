package shiyanshi;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

/**
 * 统计一个文件夹下的项目名  文件数  代码行数
 */
public class demo {

    static int fileCount = 0;
    static int lineCount = 0;

    public static void getFile(String filepath) {
        File file = new File(filepath);
        File[] listfile = file.listFiles();
        for (int i = 0; i < listfile.length; i++) {
            if (!listfile[i].isDirectory()) {
                if (!listfile[i].getName().endsWith(".c")) {
                    continue;
                }
                //String temp=listfile[i].toString().substring(0,listfile[i].toString().length()) ;
                //count++;
                //System.out.println("文件"+count+"---path=" + listfile[i]);
                fileCount++;
                lineCount += getFileNumbers(listfile[i].toString());
            } else {
                getFile(listfile[i].toString());
            }
        }
        //System.out.println(filepath.substring(15) + "\t" + fileCount + "\t" + lineCount);
    }

    public static int getFileNumbers(String filePath) {
        int linenumber = 0;
        try {
            File file = new File(filePath);
            if (file.exists()) {
                FileReader fr = new FileReader(file);
                LineNumberReader lnr = new LineNumberReader(fr);
                while (lnr.readLine() != null) {
                    linenumber++;
                }
                //System.out.println("Total number of lines : " + linenumber);
                //System.out.println("文件" + filePath + " 中的代码行有 " + linenumber);
                lnr.close();
                return linenumber;
            } else {
                System.out.println("File does not exists!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static void main(String[] args) {
        File file = new File("E:\\实验室\\kaiyuanPro");
        File[] listfile = file.listFiles();
        for (int i = 0; i < listfile.length; i++) {
            if (listfile[i].isDirectory()) {
                getFile(listfile[i].toString());
                System.out.println(listfile[i].toString().substring(18) + "\t" + fileCount + "\t" + lineCount);
                fileCount = 0;
                lineCount = 0;
            }
        }
    }

}
