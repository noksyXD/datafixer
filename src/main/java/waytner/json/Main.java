package waytner.json;




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


    public static <Int> void main(String[] args) throws Exception {


        Scanner scanner = new Scanner(System.in);

        System.out.println("________          __         ___________.__                     \n" +
                "\\______ \\ _____ _/  |______  \\_   _____/|__|__  ___ ___________ \n" +
                " |    |  \\\\__  \\\\   __\\__  \\  |    __)  |  \\  \\/  // __ \\_  __ \\\n" +
                " |    `   \\/ __ \\|  |  / __ \\_|     \\   |  |>    <\\  ___/|  | \\/\n" +
                "/_______  (____  /__| (____  /\\___  /   |__/__/\\_ \\\\___  >__|   \n" +
                "        \\/     \\/          \\/     \\/             \\/    \\/          version 2.0 by waytner");

        System.out.println("welcome to datafixer");
        System.out.println("enter mode (now just one mode is active. It: 'datafix'):");
        while ((scanner.hasNextLine())) {
            String mode = scanner.nextLine();
            if (mode.equals("datafix")) {
                System.out.println("WARNING: E.g if your json file name is: 'data.json' please enter this on command line: 'data' so delete dot json extension");
                System.out.println("Enter json file path:");
                while (scanner.hasNextLine()) {
                    scanner.reset();
                    String scannerstring = scanner.nextLine();
                    if (!scannerstring.contains(".json")) {
                        FRIEND_DIR = FileUtils.getConfigFile(scannerstring);
                        List<String> fileContent = FileUtils.read(FRIEND_DIR);
                        for (String line : fileContent) {
                            Stream<String> file = Files.lines(Paths.get(scannerstring + ".json"));
                            System.out.println("enter your wanted limit (50000 = 20,25 mb data, 100000 recommened)");
                            int ilimit = 0;

                            while (scanner.hasNextLine()) {
                                scanner.reset();
                                int scannerss = scanner.nextInt();
                                ilimit = scannerss;
                                break;
                            }
                            System.out.println("Scan and write is started. If scanner do not writing any cc on command line with in 5 minutes, Please check your data or want help.");
                            System.out.println("Check cclist.txt file. It on this path. (New feature)");
                            for (int i=0; i<ilimit; i++) {
                                list++;
                                try {
                                    ArrayList<String> arlist = new ArrayList<>();
                                    arlist.add(line.split("\"content\":\"")[list].split("\",")[0]);
                                    if (arlist.toString().toLowerCase().contains("/22") || arlist.toString().toLowerCase().contains("saniye ünal") || arlist.toString().toLowerCase().contains("/28") || arlist.toString().toLowerCase().contains("/27") || arlist.toString().toLowerCase().contains("/26") || arlist.toString().toLowerCase().contains("/25") || arlist.toString().toLowerCase().contains("/24")|| arlist.toString().toLowerCase().contains("/23") || arlist.toString().toLowerCase().contains("cvv")) {
                                        if (!(arlist.toString().toLowerCase().contains("/21") || arlist.toString().toLowerCase().contains("model") || arlist.toString().toLowerCase().contains("kasko"))) {
                                            System.out.println(arlist);
                                            File filelist = new File("cclist.txt");
                                            if (!filelist.exists()) {
                                                filelist.createNewFile();
                                            }
                                            try {
                                                BufferedWriter out = new BufferedWriter(
                                                        new FileWriter(filelist, true));
                                                out.write(arlist.toString() + "\n");
                                                out.close();
                                            }
                                            catch (IOException e) {
                                                System.out.println("exception occurred pls send this error code to current developer" + e);
                                                System.exit(0);
                                            }
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
                    } else {
                        System.out.println("Please read warning. Closing...");
                        Thread.sleep(5000);
                        System.exit(0);
                    }
                }
            }else if (!mode.equals("datafix")) {
                System.out.println("please select mode");
                System.exit(0);
            }
        }
        }
}
