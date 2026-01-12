"""
Лабораторна робота №8.
Модуль для обчислення виразу y = ctg(x) / tg(x) з функціями введення-виведення.
"""

import math
import struct
import re

def calculate_expression(x_deg):
    """
    Обчислює вираз y = ctg(x) / tg(x).
    Математично це еквівалентно y = 1 / (tg(x))^2.
    """
    x_rad = math.radians(x_deg)
    
    # Перевірка ОДЗ: sin(x) не може бути 0 (тобто x != 0, 180, 360...)
    if abs(math.sin(x_rad)) < 1e-9:
        raise ValueError(f"Вираз не визначений для кута {x_deg}°. Ділення на нуль.")
        
    tan_val = math.tan(x_rad)
    return 1.0 / (tan_val ** 2)

# Функції роботи з файлами

def save_text(file_path, result):
    """Записує результат у текстовий файл."""
    with open(file_path, 'w', encoding='utf-8') as f:
        f.write(f"Результат обчислення: {result}")

def save_binary(file_path, result):
    """Записує результат у двійковий файл (формат double)."""
    with open(file_path, 'wb') as f:
        # 'd' - double precision float (8 байт)
        f.write(struct.pack('d', result))

def read_text(file_path):
    """Зчитує число з текстового файлу."""
    with open(file_path, 'r', encoding='utf-8') as f:
        content = f.read()
        # Шукаємо число (включно з дробовою частиною) у тексті
        match = re.search(r"[-+]?\d*\.\d+|\d+", content)
        if match:
            return float(match.group())
        raise ValueError("Число у файлі не знайдено.")

def read_binary(file_path):
    """Зчитує число з двійкового файлу."""
    with open(file_path, 'rb') as f:
        data = f.read(8) # Читаємо рівно 8 байт
        if len(data) < 8:
            raise ValueError("Файл пошкоджений.")
        return struct.unpack('d', data)[0]

#Головна частина програми

def main():

    try:
        # Введення х
        x_input = input("Введіть значення x (градуси): ")
        x = float(x_input)

        # Обчислення
        result = calculate_expression(x)
        print(f"Результат: {result}")

        # Запис у файли
        txt_file = "result.txt"
        bin_file = "result.bin"

        save_text(txt_file, result)
        print(f"Записано у текстовий файл: {txt_file}")

        save_binary(bin_file, result)
        print(f"Записано у двійковий файл: {bin_file}")

        # Перевірка (читання назад)
        val_txt = read_text(txt_file)
        print(f"Зчитано з тексту: {val_txt}")

        val_bin = read_binary(bin_file)
        print(f"Зчитано з бінарного: {val_bin}")

    except ValueError as e:
        print(f"Помилка даних: {e}")
    except IOError as e:
        print(f"Помилка доступу до файлу: {e}")
    except Exception as e:
        print(f"Непередбачувана помилка: {e}")

if __name__ == "__main__":
    main()