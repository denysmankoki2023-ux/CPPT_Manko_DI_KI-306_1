import java.io.IOException;

/**
 * Клас представляє монітор з можливістю налаштування параметрів, таких як яскравість, контрастність, нахил і висота.
 * Підтримує режим економії енергії та зміну джерела вхідного сигналу.
 */
public abstract class Monitor {
    protected Screen screen;
    protected Stand stand;
    protected ControlPanel controlPanel;
    protected Logger logger;
    protected boolean isOn;

    /**
     * Конструктор за замовчуванням, який створює монітор з екраном, підставкою та панеллю управління.
     *
     * @throws IOException якщо виникає помилка під час створення логера.
     */
    public Monitor() throws IOException {
        this(new Screen(100, 100, true), new Stand(80, 1), new ControlPanel("HDMI"));
        this.logger = new Logger("monitor_log.txt");

        logger.log(String.format("Монітор створено.", this.toString()));
    }

    /**
     * Конструктор, який дозволяє налаштовувати екран, підставку і панель управління.
     *
     * @param screen екран монітора
     * @param stand підставка для монітора
     * @param controlPanel панель управління монітором
     * @throws IOException якщо виникає помилка під час створення логера.
     */
    public Monitor(Screen screen, Stand stand, ControlPanel controlPanel) throws IOException {
        this.screen = screen;
        this.stand = stand;
        this.controlPanel = controlPanel;
        this.logger = new Logger("monitor_log.txt");

        logger.log(String.format("Монітор створено.", this.toString()));
    }

    /**
     * Абстрактний метод для вмикання монітора.
     *
     * @throws IOException якщо виникає помилка під час логування
     */
    public abstract void turnOn() throws IOException;

    /**
     * Абстрактний метод для вимикання монітора.
     *
     * @throws IOException якщо виникає помилка під час логування
     */
    public abstract void turnOff() throws IOException;


    /**
     * Змінює яскравість екрану.
     *
     * @param level рівень яскравості
     * @throws IOException якщо виникає помилка під час логування.
     */
    public void adjustBrightness(int level) throws IOException {
        screen.setBrightness(level);

        logger.log(String.format("Яскравість змінено на %s", level));
        System.out.printf("Яскравість змінено на %s\n", level);
    }

    /**
     * Змінює контрастність екрану.
     *
     * @param level рівень контрастності
     * @throws IOException якщо виникає помилка під час логування.
     */
    public void adjustContrast(int level) throws IOException {
        screen.setContrast(level);

        logger.log(String.format("Контрастність змінено на %s", level));
        System.out.printf("Контрастність змінено на %s\n", level);
    }

    /**
     * Змінює кут нахилу монітора.
     *
     * @param angle кут нахилу
     * @throws IOException якщо виникає помилка під час логування.
     */
    public void adjustTilt(int angle) throws IOException {
        stand.setTiltAngle(angle);

        logger.log(String.format("Кут нахилу змінено на %s", angle));
        System.out.printf("Кут нахилу змінено на %s\n", angle);
    }

    /**
     * Змінює висоту монітора.
     *
     * @param height висота
     * @throws IOException якщо виникає помилка під час логування.
     */
    public void adjustHeight(int height) throws IOException {
        stand.setHeight(height);

        logger.log(String.format("Висоту змінено на %s", height));
        System.out.printf("Висоту змінено на %s\n", height);
    }

    /**
     * Активує режим економії енергії.
     *
     * @throws IOException якщо виникає помилка під час логування.
     */
    public void activatePowerSavingMode() throws IOException {
        screen.setPowerSavingMode(true);

        logger.log("Активовано режим економії енергії");
        System.out.println("Активовано режим економії енергії");
    }

    /**
     * Деактивує режим економії енергії.
     *
     * @throws IOException якщо виникає помилка під час логування.
     */
    public void deactivatePowerSavingMode() throws IOException {
        screen.setPowerSavingMode(false);

        logger.log("Деактивовано режим економії енергії");
        System.out.println("Деактивовано режим економії енергії");
    }

    /**
     * Змінює джерело вхідного сигналу.
     *
     * @param source джерело сигналу
     * @throws IOException якщо виникає помилка під час логування.
     */
    public void changeInputSource(String source) throws IOException {
        controlPanel.setInputSource(source);

        logger.log(String.format("Змінено джерело вхідного сигналу на %s", source));
        System.out.printf("Змінено джерело вхідного сигналу на %s\n", source);
    }

    /**
     * Повертає інформацію про монітор.
     *
     * @return рядок з інформацією про монітор
     * @throws IOException якщо виникає помилка під час логування.
     */
    public String getInfo() throws IOException {
        String info = "Монітор: " + screen.getInfo() + ", " + stand.getInfo() + ", " + controlPanel.getInfo();

        logger.log(String.format("Інформація про: %s", info));
        System.out.printf("Інформація про: %s\n", info);
        return info;
    }

    /**
     * Метод для закриття логера.
     *
     * @throws IOException якщо виникає помилка під час закриття логера.
     */
    public void closeLogger() throws IOException {
        logger.close();
    }
}