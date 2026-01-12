import java.io.FileWriter;
import java.io.IOException;

/**
 * Клас для обчислення виразу y = ctan(x) / tan(x).
 * Використовується для демонстрації механізму виключень і запису результатів у файл.
 */
public class ExpressionCalculator {

    /**
     * Обчислює вираз y = ctan(x) / tan(x).
     *
     * @param x значення змінної x
     * @return результат обчислення виразу
     * @throws IllegalArgumentException якщо x = 0, 180..., оскільки вираз не визначений
     */
    public double calculate(double x) throws IllegalArgumentException {
        double xRad = Math.toRadians(x);
    if (Math.abs(Math.sin(xRad)) < 1e-9) {
        throw new IllegalArgumentException("Вираз не визначений (x = PI*k), значення x не може дорівнювати 0°, 180°, 360°...");
    }
    double tan = Math.tan(xRad);
    return 1.0 / (tan * tan);
    }

    /**
     * Записує результат обчислення у файл.
     *
     * @param result результат обчислення
     * @param filePath шлях до файлу
     * @throws IOException якщо виникає помилка при записі у файл
     */
    public void writeResultToFile(double result, String filePath) throws IOException {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write("Результат обчислення: " + result);
        }
    }
}