import java.security.SecureRandom;  // Для генерации случайных чисел

public class PasswordService {
    private static final String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String lowerCase = "abcdefghijklmnopqrstuvwxyz";
    private static final String digits = "0123456789";
    private static final String specialCharacters = "!@#$%^&*()-_=+<>?";
    private static final String allCharacters = upperCase + lowerCase + digits + specialCharacters;

    public String generatePassword(int length) {
        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder(length);

        // Добавление в пароль по одному символу из каждой категории
        password.append(upperCase.charAt(random.nextInt(upperCase.length())));
        password.append(lowerCase.charAt(random.nextInt(lowerCase.length())));
        password.append(digits.charAt(random.nextInt(digits.length())));
        password.append(specialCharacters.charAt(random.nextInt(specialCharacters.length())));

        // Заполнение оставшейся части пароля случайными символами из всех категорий
        for (int i = 4; i < length; i++) {
            password.append(allCharacters.charAt(random.nextInt(allCharacters.length())));
        }

        // Перемешивание символов пароля для обеспечения их хаотичности
        return PasswordShuffler.shuffleString(password.toString());
    }
}
