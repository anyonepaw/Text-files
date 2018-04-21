import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class TXTFileWriter {

    private File file;

    public void writeTXTFiles(String outPathName, ArrayList<File> files) {

        file = new File(outPathName + "solution.txt");

        try {

            for (File txtFile : files) {
                BufferedReader in = new BufferedReader(new FileReader(txtFile.getAbsolutePath()));
                PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file, true)));
                String s;
                while ((s = in.readLine()) != null)
                    out.println(s);
                out.close();
            }

        } catch (IOException e) {
            e.getMessage();
        }

    }

    public File getFile() {
        return file;
    }
}


