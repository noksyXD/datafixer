package waytner.json;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.net.ssl.HttpsURLConnection;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    private static File FRIEND_DIR = FileUtils.getConfigFile("data2");
    public static int list = 0;
    public static final String WHITE = "\033[0;37m";   // WHITE



    public static void main(String[] args) throws Exception {


        Scanner scanner = new Scanner(System.in);

        System.out.println("________          __         ___________.__                     \n" +
                "\\______ \\ _____ _/  |______  \\_   _____/|__|__  ___ ___________ \n" +
                " |    |  \\\\__  \\\\   __\\__  \\  |    __)  |  \\  \\/  // __ \\_  __ \\\n" +
                " |    `   \\/ __ \\|  |  / __ \\_|     \\   |  |>    <\\  ___/|  | \\/\n" +
                "/_______  (____  /__| (____  /\\___  /   |__/__/\\_ \\\\___  >__|   \n" +
                "        \\/     \\/          \\/     \\/             \\/    \\/       ");

        System.out.println("welcome to datafixer");
        System.out.println("enter mode");
        while ((scanner.hasNextLine())) {
            String mode = scanner.nextLine();
            if (mode.equals("datafix")) {
                System.out.println("Enter json file path:");
                while (scanner.hasNextLine()) {
                    scanner.reset();
                    String scannerstring = scanner.nextLine();
                    if (!scannerstring.contains(".json")) {
                        FRIEND_DIR = FileUtils.getConfigFile(scannerstring);
                        List<String> fileContent = FileUtils.read(FRIEND_DIR);
                        for (String line : fileContent) {
                            // e.g. if json file name is "jsonfile.json", enter command line it "jsonfile".
                            Stream<String> file = Files.lines(Paths.get(scannerstring + ".json"));
                            int ilimit = 50000; // 50000 = 20,25 mb data, 100000 recommened
                            for (int i=0; i<ilimit; i++) {
                                list++;
                                try {
                                    ArrayList<String> arlist = new ArrayList<>();
                                    arlist.add(line.split("\"content\":\"")[list].split("\",")[0]);
                                    if (arlist.contains("cvv")|| arlist.contains("saniye ünal cep ini istiyor geçmiyor sistem") || arlist.toString().toLowerCase().contains("cvv")) {
                                        if (!arlist.toString().toLowerCase().equals(line.split("\"content\":\"")[list-1].split("\",")[0])) {
                                            System.out.println(arlist);
                                        }
                                    }
                                    if (i == ilimit-1) {
                                        System.out.println("scan limit is end.");
                                        System.exit(0);
                                    }
                                } catch (Throwable e) {
                                    e.printStackTrace();
                                } finally {
                                    if (file != null) {
                                        file.close();
                                    }
                                }
                            }
                        }
                    }
                }
            }else if (!mode.equals("datafix")) {
                System.out.println("please select mode");
                System.exit(0);
            }

        }

        }

}
