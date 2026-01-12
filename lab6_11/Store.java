abstract class Store {
    private String name;
    private double revenue;
    private int floor;

    /**
     * Створює новий магазин.
     *
     * @param name Назва магазину
     * @param revenue Дохід магазину
     * @param floor Поверх, на якому розташований магазин
     */
    public Store(String name, double revenue, int floor) {
        this.name = name;
        this.revenue = revenue;
        this.floor = floor;
    }

    public String getName() {
        return name;
    }

    public double getRevenue() {
        return revenue;
    }

    public int getFloor() {
        return floor;
    }

    @Override
    public String toString() {
        return String.format("Магазин{назва='%s', дохід=%.2f грн, поверх=%d}", name, revenue, floor);
    }
}
