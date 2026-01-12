import java.io.IOException;

/**
 * Клас є точкою входу для виконання програми, яка демонструє роботу з класом Monitor.
 */
public class TouchScreenDriver {
    /**
     * Основний метод для запуску програми.
     *
     * @param args аргументи командного рядка (не використовуються)
     */
    public static void main(String[] args) {
        try {
            TouchScreen touchScreen = new TouchScreen(
                    new Screen(90, 95, true),
                    new Stand(85, 2),
                    new ControlPanel("USB-C")
            );

            touchScreen.turnOn();
            touchScreen.adjustBrightness(80);
            touchScreen.adjustContrast(75);
            touchScreen.handleTouch(100, 200);
            touchScreen.disableTouch();
            touchScreen.handleTouch(150, 250);
            touchScreen.enableTouch();
            touchScreen.handleTouch(300, 400);
            System.out.println(touchScreen.getInfo());
            touchScreen.turnOff();

            touchScreen.closeLogger();
        } catch (IOException e) {
            // Обробка помилок, що виникають під час запису в файл
            throw new RuntimeException("Сталася помилка при записі в файл: " + e.getMessage());
        }
    }
}