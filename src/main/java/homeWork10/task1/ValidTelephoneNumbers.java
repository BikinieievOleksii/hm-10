package homeWork10.task1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ValidTelephoneNumbers {
    public void PrintTelephoneNumbers(String filePath) {
        File file = new File(filePath);

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = reader.readLine();
            while (line != null) {
                if (checkValid(line)) {
                    System.out.println(line);
                }
                line = reader.readLine();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private boolean checkValid (String telNumber) {
        return telNumber.matches("[(](\\d{3})[)][ ](\\d{3})-(\\d{4})")
                || telNumber.matches("(\\d{3})-(\\d{3})-(\\d{4})");
    }
}
