import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        StringBuilder log = new StringBuilder();

        createDir("src", "./Games", log);
        createDir("res", "./Games", log);
        createDir("save", "./Games", log);
        createDir("temp", "./Games", log);

        createDir("main", "./Games/src", log);
        createDir("test", "./Games/src", log);

        createFile("Main.java", "./Games/src/main", log);
        createFile("Utils.java", "./Games/src/main", log);

        createDir("drawables", "./Games/res", log);
        createDir("victors", "./Games/res", log);
        createDir("icons", "./Games/res", log);

        createFile("temp.txt", "./Games/temp", log);

        try (FileWriter fw = new FileWriter("./Games/temp/temp.txt")) {
            fw.write("");
            fw.append(log.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void createDir(String nameDir, String parentPath, StringBuilder log) {
        File dir = new File(parentPath + "/" + nameDir);

        if (dir.mkdir()) {
            log.append("Directory " + nameDir + " was created");
        } else {
            log.append("Directory " + nameDir + " was not created");
        }
        log.append("\n");

    }

    public static void createFile(String nameFile, String path, StringBuilder log) {
        File file = new File(path + "/" + nameFile);

        try {
            if (file.createNewFile()) {
                log.append("File " + path + " was created");
            } else {
                log.append("File " + path + " was not created");
            }
            log.append("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
