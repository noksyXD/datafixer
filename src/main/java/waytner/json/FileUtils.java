package waytner.json;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public final class FileUtils {
    private FileUtils() {
    }

    public static List<String> read(File inputFile) {
        ArrayList readContent = new ArrayList();
        try {
            String str;
            BufferedReader in = new BufferedReader((Reader)new InputStreamReader((InputStream)new FileInputStream(inputFile), "UTF8"));
            while ((str = in.readLine()) != null) {
                readContent.add((Object)str);
            }
            in.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return readContent;
    }





    public static File getConfigFile(String name) {
        File file = new File(String.format((String)"%s.json", (Object[])new Object[]{name}));
        if (!file.exists()) {
            System.out.println("Do not find your data or data is free.");
            System.exit(0);
            try {
                file.createNewFile();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        return file;
    }
}

