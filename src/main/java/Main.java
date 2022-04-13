import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        StringBuilder log = new StringBuilder();

        createDir( "./Games/src", log);
        createDir( "./Games/res", log);
        createDir( "./Games/savegames", log);
        createDir( "./Games/temp", log);

        createDir("./Games/src/main", log);
        createDir("./Games/src/main", log);

        createFile("./Games/src/main/Main.java", log);
        createFile("./Games/src/main/Utils.java", log);

        createDir("./Games/res/drawables", log);
        createDir( "./Games/res/victors", log);
        createDir( "./Games/res/icons", log);

        createFile("./Games/temp/temp.txt", log);

        try (FileWriter fw = new FileWriter("./Games/temp/temp.txt")) {
            fw.write("");
            fw.append(log.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void createDir(String path, StringBuilder log) {
        File dir = new File(path);

        if (dir.mkdir()) {
            log.append("Directory " + dir.getName() + " was created");
        } else {
            log.append("Directory " + dir.getName() + " was not created");
        }
        log.append("\n");

    }

    public static void createFile(String nameFile, StringBuilder log) {
        File file = new File(nameFile);

        try {
            if (file.createNewFile()) {
                log.append("File " + file.getName() + " was created");
            } else {
                log.append("File " + file.getName() + " was not created");
            }
            log.append("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
