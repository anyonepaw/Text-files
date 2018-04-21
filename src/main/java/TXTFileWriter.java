import java.io.*;
import java.util.ArrayList;

public class TXTFileWriter {


    private File file;

    public TXTFileWriter(String pathname) {
        this.file = new File(pathname + "/solution.txt");
    }

    public void writeTXTFiles(ArrayList<File> files) {


        try {

            for (File txtFile : files) {
                BufferedReader in = new BufferedReader(new FileReader(txtFile.getAbsolutePath()));
                PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file,true)));
                String s;
                while ((s = in.readLine()) != null)
                    out.println(s);
                out.close();
                in.close();
            }

        } catch (IOException e) {
            e.getMessage();
        }

    }

    public File getFile() {
        return file;
    }
}


