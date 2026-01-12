/**
 * Клас представляє підставку монітора з можливістю налаштування кута нахилу та висоти.
 */
public class Stand {
    private int tiltAngle;
    private int height;

    /**
     * Конструктор класу Stand, який ініціалізує кут нахилу та висоту підставки.
     *
     * @param tiltAngle кут нахилу підставки в градусах
     * @param height висота підставки
     */
    public Stand(int tiltAngle, int height) {
        this.tiltAngle = tiltAngle;
        this.height = height;
    }

    /**
     * Встановлює новий кут нахилу підставки.
     *
     * @param tiltAngle новий кут нахилу в градусах
     */
    public void setTiltAngle(int tiltAngle) {
        this.tiltAngle = tiltAngle;
    }

    /**
     * Встановлює нову висоту підставки.
     *
     * @param height нова висота
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * Повертає інформацію про підставку.
     *
     * @return рядок з інформацією про поточний кут нахилу та висоту підставки.
     */
    public String getInfo() {
        return "Підставка (кут нахилу: " + tiltAngle + ", висота: " + height + ")";
    }
}
