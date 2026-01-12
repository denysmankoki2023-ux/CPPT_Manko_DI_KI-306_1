public class Main {
    public static void main(String[] args) {
        ShoppingMall<Store> mall = new ShoppingMall<>(9);

        mall.addStore(new ClothingStore("Bershka", 52400.50, 1, "Молодіжний одяг"));
        mall.addStore(new ClothingStore("Reserved", 48900.00, 1, "Повсякденний стиль"));
        
        mall.addStore(new ClothingStore("Tommy Hilfiger", 125000.00, 2, "Преміум одяг"));
        mall.addStore(new ClothingStore("INTERTOP", 67350.75, 2, "Взуття та аксесуари"));

        mall.addStore(new FoodCourtStore("Lviv Croissants", 28400.00, 1, "Пекарня"));
        mall.addStore(new FoodCourtStore("Aroma Kava", 15200.00, 1, "Кав'ярня"));

        mall.addStore(new FoodCourtStore("KFC", 89000.00, 3, "Страви з курки"));
        mall.addStore(new FoodCourtStore("Пузата Хата", 95500.00, 3, "Українська кухня"));
        mall.addStore(new FoodCourtStore("Salateira", 41800.50, 3, "Здорове харчування"));
        
        System.out.println("Всі магазини в торговому центрі:");
        mall.getAllStores().forEach(System.out::println);

        Store maxRevenueStore = mall.findMaxRevenueStore();
        System.out.println("\nМагазин з максимальним доходом:");
        System.out.println(maxRevenueStore);

        mall.removeStore(maxRevenueStore);
        System.out.println("\nМагазини після видалення магазину з максимальним доходом:");
        mall.getAllStores().forEach(System.out::println);
    }
}
