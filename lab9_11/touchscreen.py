from monitor import Monitor

class TouchScreen(Monitor):
    """Похідний клас для представлення сенсорного екрану"""
    
    def __init__(self, brand: str, model: str, size: float, resolution: str, 
                 touch_points: int, has_stylus: bool):
        """
        Ініціалізація сенсорного екрану
        
        Args:
            brand (str): Бренд монітору
            model (str): Модель монітору
            size (float): Розмір екрану в дюймах
            resolution (str): Роздільна здатність
            touch_points (int): Кількість точок дотику
            has_stylus (bool): Підтримка стилусу
        """
        super().__init__(brand, model, size, resolution)
        self.touch_points = touch_points
        self.has_stylus = has_stylus
        self.touch_enabled = True
    
    def toggle_touch(self):
        """Вмикає/вимикає сенсорний ввід"""
        self.touch_enabled = not self.touch_enabled
        status = "увімкнено" if self.touch_enabled else "вимкнено"
        print(f"Сенсорний ввід {status}")
    
    def display_info(self):
        """Виводить розширену інформацію про сенсорний екран"""
        base_info = super().display_info()
        return f"""{base_info}
        Точок дотику: {self.touch_points}
        Підтримка стилусу: {'Так' if self.has_stylus else 'Ні'}
        Сенсорний ввід: {'Увімкнено' if self.touch_enabled else 'Вимкнено'}
        """