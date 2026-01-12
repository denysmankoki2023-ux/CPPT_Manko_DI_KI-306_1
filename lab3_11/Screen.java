/**
 * Клас представляє екран монітора з можливістю налаштування параметрів,
 * таких як яскравість, контрастність, а також режим економії енергії.
 */
public class Screen {
    private int brightness;
    private int contrast;
    private boolean powerSavingMode;

    /**
     * Конструктор класу Screen, який ініціалізує яскравість, контрастність та режим економії енергії.
     *
     * @param brightness рівень яскравості екрану
     * @param contrast рівень контрастності екрану
     * @param powerSavingMode режим економії енергії (увімкнено чи вимкнено)
     */
    public Screen(int brightness, int contrast, boolean powerSavingMode) {
        this.brightness = brightness;
        this.contrast = contrast;
        this.powerSavingMode = powerSavingMode;
    }

    /**
     * Встановлює новий рівень яскравості.
     *
     * @param brightness новий рівень яскравості
     */
    public void setBrightness(int brightness) {
        this.brightness = brightness;
    }

    /**
     * Встановлює новий рівень контрастності.
     *
     * @param contrast новий рівень контрастності
     */
    public void setContrast(int contrast) {
        this.contrast = contrast;
    }

    /**
     * Вмикає або вимикає режим економії енергії.
     *
     * @param powerSavingMode true для ввімкнення режиму економії енергії, false для вимкнення
     */
    public void setPowerSavingMode(boolean powerSavingMode) {
        this.powerSavingMode = powerSavingMode;
    }

    /**
     * Повертає інформацію про екран.
     *
     * @return рядок з інформацією про яскравість та контрастність екрану.
     */
    public String getInfo() {
        return "Екран (яскравість: " + brightness + ", контрастність: " + contrast + ")";
    }
}