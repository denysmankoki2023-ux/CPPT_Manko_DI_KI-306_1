import java.util.*;

/**
 * Узагальнений клас-контейнер, що представляє Торговий Центр.
 * Керує різними типами магазинів та надає операції для управління ними.
 *
 * @param <T> Тип магазинів у торговому центрі
 */
public class ShoppingMall<T extends Store> {
    private List<T> stores;
    private final int maxCapacity;

    /**
     * Створює новий Торговий Центр із вказаною місткістю.
     *
     * @param capacity Максимальна кількість магазинів, яку може вмістити торговий центр
     */
    public ShoppingMall(int capacity) {
        this.stores = new ArrayList<>();
        this.maxCapacity = capacity;
    }

    /**
     * Додає новий магазин до торгового центру.
     *
     * @param store Магазин для додавання
     * @return true якщо магазин успішно додано, false якщо ні
     */
    public boolean addStore(T store) {
        if (stores.size() < maxCapacity) {
            return stores.add(store);
        }
        return false;
    }

    /**
     * Видаляє магазин з торгового центру.
     *
     * @param store Магазин для видалення
     * @return true якщо магазин успішно видалено, false якщо ні
     */
    public boolean removeStore(T store) {
        return stores.remove(store);
    }

    /**
     * Знаходить магазин з максимальним доходом у торговому центрі.
     *
     * @return Магазин з максимальним доходом, або null якщо торговий центр порожній
     */
    public T findMaxRevenueStore() {
        if (stores.isEmpty()) {
            return null;
        }
        return Collections.max(stores, Comparator.comparing(Store::getRevenue));
    }

    /**
     * Отримує список всіх магазинів у торговому центрі.
     *
     * @return Список всіх магазинів
     */
    public List<T> getAllStores() {
        return new ArrayList<>(stores);
    }
}
