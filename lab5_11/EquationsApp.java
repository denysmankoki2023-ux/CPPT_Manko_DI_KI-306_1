import java.io.IOException;
import java.util.Scanner;

/**
 * Драйвер для запуску програми обчислення виразу та тестування методів читання і запису.
 */
public class EquationsApp {
    public static void main(String[] args) {
        ExpressionCalculator calculator = new ExpressionCalculator();
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Введіть значення x: ");
            double x = scanner.nextDouble();

            double result = calculator.calculate(x);
            System.out.println("Результат: " + result);

            String textFilePath = "result.txt";
            calculator.writeResultToFile(result, textFilePath);
            System.out.println("Результат записано у текстовий файл: " + textFilePath);

            String binaryFilePath = "result.bin";
            calculator.writeResultToBinaryFile(result, binaryFilePath);
            System.out.println("Результат записано у двійковий файл: " + binaryFilePath);

            double textResult = calculator.readResultFromFile(textFilePath);
            System.out.println("Результат, зчитаний з текстового файлу: " + textResult);

            double binaryResult = calculator.readResultFromBinaryFile(binaryFilePath);
            System.out.println("Результат, зчитаний з двійкового файлу: " + binaryResult);

        } catch (IllegalArgumentException e) {
            System.out.println("Помилка: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Помилка запису або читання файлу: " + e.getMessage());
        } finally {
            // Закриття сканера для уникнення витоку ресурсів
            scanner.close();
        }
    }
}