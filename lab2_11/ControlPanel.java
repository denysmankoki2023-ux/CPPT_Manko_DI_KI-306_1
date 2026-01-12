/**
 * Клас представляє панель керування монітора, яка відповідає за джерело вхідного сигналу.
 */
public class ControlPanel {
    private String inputSource;

    /**
     * Конструктор класу ControlPanel, який ініціалізує джерело вхідного сигналу.
     *
     * @param inputSource початкове джерело сигналу
     */
    public ControlPanel(String inputSource) {
        this.inputSource = inputSource;
    }

    /**
     * Встановлює нове джерело вхідного сигналу.
     *
     * @param inputSource нове джерело сигналу
     */
    public void setInputSource(String inputSource) {
        this.inputSource = inputSource;
    }

    /**
     * Повертає інформацію про панель керування.
     *
     * @return рядок з інформацією про поточне джерело сигналу.
     */
    public String getInfo() {
        return "Панель керування (джерело сигналу: " + inputSource + ")";
    }
}