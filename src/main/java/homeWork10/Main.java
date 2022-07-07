package homeWork10;

import homeWork10.task1.ValidTelephoneNumbers;
import homeWork10.task2.CreateGsonUser;
import homeWork10.task3.CountWords;

public class Main {
    public static final String FILE_NUMBERS_NAME_PATH = "fileNumbers.txt";
    public static final String FILE_NAME_AGE_NAME_PATH = "fileNameAge.txt";
    public static final String CREATE_JSON_FILE_PATH = "user.json";
    public static final String FILE_WORDS_NAME_PATH = "words.txt";

    public static void main(String[] args) {
        ValidTelephoneNumbers numbers = new ValidTelephoneNumbers();
        numbers.PrintTelephoneNumbers(FILE_NUMBERS_NAME_PATH);
        CreateGsonUser user = new CreateGsonUser();
        user.createJson(FILE_NAME_AGE_NAME_PATH, CREATE_JSON_FILE_PATH);
        CountWords words = new CountWords();
        words.run(FILE_WORDS_NAME_PATH);
    }
}
