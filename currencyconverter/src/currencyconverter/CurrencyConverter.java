package currencyconverter;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CurrencyConverter {

    // Константы для курсов валют
    private static final Map<String, Double> exchangeRates = new HashMap<>();

    static {
        exchangeRates.put("USD", 1.0);      // Базовая валюта: Доллар США
        exchangeRates.put("EUR", 0.9);      // Евро
        exchangeRates.put("GBP", 0.75);     // Фунты стерлингов
        exchangeRates.put("JPY", 150.0);    // Японская иена
        exchangeRates.put("AUD", 1.5);      // Австралийский доллар
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите сумму в USD для конвертации:");
        double amount = scanner.nextDouble();

        System.out.println("Выберите валюту для конвертации: EUR, GBP, JPY, AUD");
        String targetCurrency = scanner.next().toUpperCase();

        convertCurrency(amount, targetCurrency);
    }

    private static void convertCurrency(double amount, String targetCurrency) {
        if (!exchangeRates.containsKey(targetCurrency)) {
            System.out.println("Неизвестная валюта: " + targetCurrency);
            return;
        }

        double convertedAmount = amount * exchangeRates.get(targetCurrency);
        System.out.print(amount + " USD = " + convertedAmount + " " + targetCurrency);
    }
}
