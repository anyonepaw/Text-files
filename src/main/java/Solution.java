import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {

    public static void main(String[] args) throws Exception {


        // /Users/Angelika/Desktop/Java
        System.out.println("Type the full name of required root folder:");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String pathName = reader.readLine();
        File path = new File(pathName);
        ifPathExists(path);

        System.out.println("Type the full name of folder where a file will be written:");
        String outPathName = reader.readLine();
        File path1 = new File(outPathName);
        ifPathExists(path1);


            FolderEntry folderEntry = new FolderEntry();
            folderEntry.pullFilesFromFolder(path);
            ArrayList<File> txtFiles = folderEntry.getTxtFilesList();
            TXTFileWriter txtFileWriter = new TXTFileWriter(outPathName);
            txtFileWriter.writeTXTFiles(txtFiles);


    }


    public static void ifPathExists(File path){

        if (!path.exists()){
            System.out.println("This path does not exist! Please, new it up.");
            System.exit(1);
        }
    }
}
