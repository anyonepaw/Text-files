import java.io.File;
import java.util.*;

public class FolderEntry {

    private ArrayList<File> txtFilesList = new ArrayList<>();


    public void pullFilesFromFolder(File folder) {

        File[] filesList = folder.listFiles();
        txtFilesList.addAll(Arrays.asList(folder.listFiles((dir, name) ->  name.endsWith(".txt"))));

        if (filesList.length != 0) {

            for (File entry : filesList) {
                if (entry.isDirectory()) {
                    pullFilesFromFolder(entry);
                }
//                if (entry.isFile() && entry.getName().endsWith(".txt")) {
//                    txtFilesList.add(entry);
//                }
            }
        }
    }

    public ArrayList<File> getTxtFilesList() {

        Comparator<File> fileNameComparator
                = Comparator.comparing(
                File::getName, String.CASE_INSENSITIVE_ORDER);

        Collections.sort(txtFilesList, fileNameComparator);

        return txtFilesList;
    }


}
