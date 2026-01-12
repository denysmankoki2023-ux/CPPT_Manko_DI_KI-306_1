import java.io.*;
import java.util.*;

/**
 * Лабораторна робота №1.
 * Програма генерує зубчастий масив, який містить
 * лише заштриховану, задану варіантом, область квадратної матриці (варіант 11).
 *
 * Програма:
 *  • запитує розмір квадратної матриці;
 *  • запитує символ-заповнювач;
 *  • будує зубчастий масив потрібної форми;
 *  • виводить масив на екран та у файл MyFile.txt;
 *  • містить повноцінні Javadoc-коментарі.
 *
 * @author Manko Denys
 * @version 1.0
 */
public class Lab1MankoKI306 {

    /**
     * Статичний метод main є точкою входу в програму.
     * Метод читає з клавіатури розмір квадратної матриці та один символ-заповнювач.
     * Будує зубчастий масив, що містить лише заштриховану, задану варіантом, область квадратної матриці.
     * Виводить результат на екран та записує його у файл "MyFile.txt".
     *
     * @param args аргументи командного рядка
     * @throws FileNotFoundException якщо не вдалося створити файл
     */
      public static void main(String[] args) throws FileNotFoundException {

        Scanner in = new Scanner(System.in);
        File dataFile = new File("MyFile.txt");
        PrintWriter fout = new PrintWriter(dataFile);

        System.out.print("Enter the size of the matrix: ");
        int n = in.nextInt();
        in.nextLine();

        System.out.print("Enter a placeholder character: ");
        String filler = in.nextLine();

        if (filler.length() != 1) {
            System.out.println("Error: You must enter exactly one character!");
            fout.close();
            in.close();
            return;
        }

        char symbol = filler.charAt(0);

        int half = n / 2;
        char[][] arr = new char[n][];
        for (int i = 0; i < n; i++) {
            if (i < half) {
                // Верхня половина: заповнюємо праву частину Довжина масиву = загальна ширина мінус половина
                arr[i] = new char[n - half];
            } else {
                // Нижня половина: заповнюємо ліву частину Довжина масиву = половина ширини
                arr[i] = new char[half];
            }
            // Заповнюємо створений рядок символами
            Arrays.fill(arr[i], symbol);
        }

        for (int i = 0; i < n; i++) {
            // Логіка для виведення відступів (пробілів) // Якщо ми у верхній половині (i < half), спочатку треба вивести пробіли, щоб зсунути символи праворуч.
            if (i < half) {
                for (int j = 0; j < half; j++) {
                    System.out.print("  "); // Два пробіли для вирівнювання з "символ + пробіл"
                    fout.print("  ");
                }
            }
            // Виведення самого зубчастого масиву
            for (char c : arr[i]) {
                System.out.print(c + " ");
                fout.print(c + " ");
            }
            // Перехід на новий рядок
            System.out.println();
            fout.println();
        }

        fout.flush();
        fout.close();
        
        System.out.println("\nThe result is also written to a file: MyFile.txt");
    }
}