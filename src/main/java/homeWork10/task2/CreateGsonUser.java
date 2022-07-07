package homeWork10.task2;

import com.google.gson.Gson;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CreateGsonUser {
    String filePath;
    String fileGson;

    public void createJson (String filePathRun, String filePathCreate) {
        this.filePath = filePathRun;
        this.fileGson = filePathCreate;
        createJsonFile(this.filePath, this.fileGson);
    }

    private void createJsonFile (String filePath, String fileGson) {
        List<User> userList = new ArrayList<>();

        try {List<String> userStringList = Files.readAllLines(Paths.get(filePath));
            userStringList.removeAll(Arrays.asList("", null));
            userStringList.remove(userStringList.get(0));
            for (String s : userStringList) {
                String[] nameAge = s.split(" ");
                userList.add(new User(nameAge[0], Integer.parseInt(nameAge[1])));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        String json = new Gson().toJson(userList);
        File file = new File(fileGson);
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(json);
            writer.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
