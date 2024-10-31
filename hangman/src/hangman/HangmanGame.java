package hangman;

import java.util.HashSet;
import java.util.Scanner;

public class HangmanGame {
    private String wordToGuess;
    private HashSet<Character> guessedLetters;
    private int lives;

    public HangmanGame() {
        this.wordToGuess = WordRepository.getRandomWord();
        this.guessedLetters = new HashSet<>();
        this.lives = 6;
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);

        while (lives > 0 && !isWordGuessed()) {
            System.out.print(displayWord() + "\n");
            System.out.println("У Вас осталось жизней: " + lives);
            System.out.print("Введите букву: ");
            char guess = scanner.nextLine().charAt(0);
            processGuess(guess);
        }

        if (isWordGuessed()) {
            System.out.println("Поздравляем! Вы угадали слово: " + wordToGuess);
        } else {
            System.out.println("Игра окончена! Слово было: " + wordToGuess);
        }

        scanner.close();
    }

    private void processGuess(char guess) {
        if (wordToGuess.indexOf(guess) >= 0) {
            guessedLetters.add(guess);
        } else {
            lives--;
            System.out.println("Не верно! Вы потеряли жизнь.");
        }
    }

    private String displayWord() {
        StringBuilder displayedWord = new StringBuilder();
        for (char letter : wordToGuess.toCharArray()) {
            if (guessedLetters.contains(letter)) {
                displayedWord.append(letter);
            } else {
                displayedWord.append("_");
            }
        }
        return displayedWord.toString();
    }

    private boolean isWordGuessed() {
        for (char letter : wordToGuess.toCharArray()) {
            if (!guessedLetters.contains(letter)) {
                return false;
            }
        }
        return true;
    }
}
