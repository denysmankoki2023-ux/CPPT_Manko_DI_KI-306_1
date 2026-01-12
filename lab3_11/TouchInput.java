import java.io.IOException;

/**
 * Інтерфейс для реалізації сенсорного вводу.
 */
public interface TouchInput {
    /**
     * Метод для обробки сенсорного вводу.
     *
     * @param x координата X дотику
     * @param y координата Y дотику
     * @throws IOException якщо виникає помилка під час логування
     */
    void handleTouch(int x, int y) throws IOException;
}