import java.io.IOException;

/**
 * Клас, що представляє сенсорний екран, розширює базовий клас Monitor та реалізує інтерфейс TouchInput.
 */
public class TouchScreen extends Monitor implements TouchInput {
    private boolean touchEnabled;

    /**
     * Конструктор для створення сенсорного екрану.
     *
     * @param screen екран монітора
     * @param stand підставка для монітора
     * @param controlPanel панель управління монітором
     * @throws IOException якщо виникає помилка під час створення логера
     */
    public TouchScreen(Screen screen, Stand stand, ControlPanel controlPanel) throws IOException {
        super(screen, stand, controlPanel);
        this.touchEnabled = true;
    }

    /**
     * Увімкнення сенсорного екрану.
     *
     * @throws IOException якщо виникає помилка під час логування
     */
    @Override
    public void turnOn() throws IOException {
        isOn = true;
        logger.log("Сенсорний екран увімкнено");
        System.out.println("Сенсорний екран увімкнено");
    }

    /**
     * Вимкнення сенсорного екрану.
     *
     * @throws IOException якщо виникає помилка під час логування
     */
    @Override
    public void turnOff() throws IOException {
        isOn = false;
        logger.log("Сенсорний екран вимкнено");
        System.out.println("Сенсорний екран вимкнено");
    }

    /**
     * Обробка дотику до сенсорного екрану за координатами.
     *
     * @param x координата X дотику
     * @param y координата Y дотику
     * @throws IOException якщо виникає помилка під час логування
     */
    @Override
    public void handleTouch(int x, int y) throws IOException {
        if (isOn && touchEnabled) {
            logger.log(String.format("Оброблено дотик за координатами (%d, %d)", x, y));
            System.out.printf("Оброблено дотик за координатами (%d, %d)\n", x, y);
        } else {
            logger.log("Дотик проігноровано: екран вимкнено або сенсорний ввід вимкнено");
            System.out.println("Дотик проігноровано: екран вимкнено або сенсорний ввід вимкнено");
        }
    }

    /**
     * Метод для вмикання сенсорного вводу.
     *
     * @throws IOException якщо виникає помилка під час логування
     */
    public void enableTouch() throws IOException {
        touchEnabled = true;
        logger.log("Сенсорний ввід увімкнено");
        System.out.println("Сенсорний ввід увімкнено");
    }

    /**
     * Метод для вимикання сенсорного вводу.
     *
     * @throws IOException якщо виникає помилка під час логування
     */
    public void disableTouch() throws IOException {
        touchEnabled = false;
        logger.log("Сенсорний ввід вимкнено");
        System.out.println("Сенсорний ввід вимкнено");
    }

    /**
     * Метод для отримання інформації про сенсорний екран.
     *
     * @return рядок з інформацією про сенсорний екран
     * @throws IOException якщо виникає помилка під час логування
     */
    @Override
    public String getInfo() throws IOException {
        String info = "Інформація про сенсорний екран: " + screen.getInfo() + 
                      ", Сенсорний ввід: " + (touchEnabled ? "увімкнено" : "вимкнено");

        logger.log("Інформація про сенсорний екран: " + info);
        return info;
    }
}