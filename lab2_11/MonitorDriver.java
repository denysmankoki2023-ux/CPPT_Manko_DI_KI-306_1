import java.io.IOException;

/**
 * Клас MonitorDriver є точкою входу для виконання програми, яка демонструє роботу з класом Monitor.
 */
public class MonitorDriver {
    /**
     * Основний метод для запуску програми.
     *
     * @param args аргументи командного рядка (не використовуються)
     */
    public static void main(String[] args) {
        try {
            Monitor monitor = new Monitor(
                    new Screen(50, 90, false),
                    new Stand(10, 1),
                    new ControlPanel("DisplayPort")
            );
            monitor.turnOn();
            monitor.getInfo();
            monitor.adjustBrightness(55);
            monitor.adjustContrast(100);
            monitor.adjustTilt(30);
            monitor.adjustHeight(2);
            monitor.activatePowerSavingMode();
            monitor.deactivatePowerSavingMode();
            monitor.changeInputSource("HDMI");
            monitor.getInfo();
            monitor.turnOff();

            monitor.closeLogger();
        } 
        catch (IOException e) {throw new RuntimeException("Сталася помилка при записі в файл: " + e.getMessage());} 
    }
}