package homeWork10.task3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CountWords {
    private String filePath;

    public void run (String filePath) {
        this.filePath = filePath;
        countWords(this.filePath);
    }

    private void countWords(String filePath) {
        File file = new File(filePath);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            StringBuilder builder =new StringBuilder();
            String line = reader.readLine();

            while (line != null) {
                builder.append(line).append(" ");
                line = reader.readLine();
            }

            line = builder.toString();
            String[] text =line.split(" ");
            Set<String> hashset = new HashSet<>(List.of(text));

            String[] words = hashset.toArray(new String[hashset.size()]);
            int[] wordsCount = new int[words.length];
            for (int i = 0; i < words.length; i++) {
                for (String textItem : text) {
                    if (textItem.equals(words[i])) {
                        wordsCount[i]++;
                    }
                }
            }

            Boolean sorting = true;
            while (sorting) {
                sorting = false;
                int decVariable;
                String strVariable;
                for (int i = 0; i < wordsCount.length - 1; i++) {
                    if (wordsCount[i] < wordsCount[i + 1]) {
                        decVariable = wordsCount[i];
                        wordsCount[i] = wordsCount[i + 1];
                        wordsCount[i + 1] = decVariable;

                        strVariable = words[i];
                        words[i] = words[i + 1];
                        words[i + 1] = strVariable;

                        sorting = true;
                    }
                }
            }

            for (int i = 0; i < words.length; i++) {
                System.out.println(words[i] + " " + wordsCount[i]);
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
