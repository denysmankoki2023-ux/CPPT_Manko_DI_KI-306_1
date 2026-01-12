class ClothingStore extends Store {
    private String brandType;

    /**
     * Створює новий магазин одягу.
     *
     * @param name Назва магазину
     * @param revenue Дохід магазину
     * @param floor Номер поверху
     * @param brandType Тип брендів, що продаються
     */
    public ClothingStore(String name, double revenue, int floor, String brandType) {
        super(name, revenue, floor);
        this.brandType = brandType;
    }
}

