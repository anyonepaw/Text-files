import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {


    String pathName = "/Users/Angelika/Desktop/Java/";
    File path = new File(pathName);


    @Test
    public void folderEntryWorks() throws IOException {

        FolderEntry folderEntry = new FolderEntry();
        folderEntry.pullFilesFromFolder(path);
        ArrayList<File> txtFiles = folderEntry.getTxtFilesList();
        for (File file: txtFiles) {
            System.out.println(file.getName());
        }

        assertTrue(!txtFiles.isEmpty());
    }

    @Test
    public void fileIsNotEmpty() throws IOException {

        FolderEntry folderEntry = new FolderEntry();
        folderEntry.pullFilesFromFolder(path);
        ArrayList<File> txtFiles = folderEntry.getTxtFilesList();
        TXTFileWriter txtFileWriter = new TXTFileWriter();
        txtFileWriter.writeTXTFiles(pathName, txtFiles);

        assertTrue(txtFileWriter.getFile().length() > 0);
    }




}