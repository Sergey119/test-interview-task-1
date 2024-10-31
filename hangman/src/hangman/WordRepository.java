package hangman;

import java.util.Random;

public class WordRepository {
    private static final String[] words = {
            "программирование", "разработка", "виселица", "java"
    };

    public static String getRandomWord() {
        Random random = new Random();
        return words[random.nextInt(words.length)];
    }
}
