package pl.coderslab.readAndWriteAndCreate.Create;

import java.io.File;
import java.io.IOException;

public class createTaskFile {
    public static boolean createTaskFile() throws IOException {
        File file = new File("task.csv");

        if (!file.exists()) {
            file.createNewFile();
            return false;
        }
        return true;
    }
}
