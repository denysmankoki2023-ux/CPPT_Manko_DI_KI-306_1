class Monitor:
    """Базовий клас для представлення монітору"""
    
    def __init__(self, brand: str, model: str, size: float, resolution: str):
        """
        Ініціалізація монітору
        
        Args:
            brand (str): Бренд монітору
            model (str): Модель монітору
            size (float): Розмір екрану в дюймах
            resolution (str): Роздільна здатність (напр. "1920x1080")
        """
        self.brand = brand
        self.model = model
        self.size = size
        self.resolution = resolution
        self.is_on = False
    
    def turn_on(self):
        """Вмикає монітор"""
        self.is_on = True
        print(f"Монітор {self.brand} {self.model} увімкнено")
    
    def turn_off(self):
        """Вимикає монітор"""
        self.is_on = False
        print(f"Монітор {self.brand} {self.model} вимкнено")
    
    def display_info(self):
        """Виводить інформацію про монітор"""
        return f"""
        Бренд: {self.brand}
        Модель: {self.model}
        Розмір: {self.size}"
        Роздільна здатність: {self.resolution}
        Статус: {'Увімкнено' if self.is_on else 'Вимкнено'}
        """