package utils;

import java.io.FileWriter;
import java.io.IOException;

public class CustomLogger {
    public void log(String filePath, Double x, Double y) {
        try {
            FileWriter fw = new FileWriter(filePath, true);
            String text = "x=" + x + "; y=" + y + "\n";
            fw.write(text);
            fw.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
