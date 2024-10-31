import java.util.Scanner;   // Для работы с вводом пользователя

public class PasswordGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PasswordService passwordService = new PasswordService();

        System.out.print("Выберите длину пароля (от 8 до 12 символов): ");
        int length = scanner.nextInt();

        if (length < 8 || length > 12) {
            System.out.println("Длина пароля должна быть от 8 до 12 символов.");
        } else {
            String password = passwordService.generatePassword(length);
            System.out.println("Сгенерированный пароль: " + password);
        }

        scanner.close();
    }
}
