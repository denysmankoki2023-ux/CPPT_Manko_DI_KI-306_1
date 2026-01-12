from monitor import Monitor
from touchscreen import TouchScreen

def main():
    # Створення звичайного монітору
    monitor = Monitor("Dell", "P2419H", 24.0, "1920x1080")
    
    # Створення сенсорного екрану
    touch_screen = TouchScreen("Wacom", "Cintiq 16", 15.6, "1920x1080", touch_points=10, has_stylus=True)
    
    # Демонстрація роботи з моніторами
    print("\n=== Звичайний монітор ===")
    monitor.turn_on()
    print(monitor.display_info())
    monitor.turn_off()
    
    print("\n=== Сенсорний екран ===")
    touch_screen.turn_on()
    touch_screen.toggle_touch()
    print(touch_screen.display_info())
    touch_screen.toggle_touch()
    touch_screen.turn_off()

if __name__ == "__main__":
    main()