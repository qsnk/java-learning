package objects; // Определение пакета по названию папки

public class Inventory {
    private final int MAX_ITEMS = 20;
    String[] items;
    private int itemIndex = 0; 

    public Inventory() {
        this.items = new String[MAX_ITEMS];

        for (int i = 0; i < items.length; i++) items[i] = null;
    }

    public void addItem(String item) {
        if (this.itemIndex >= MAX_ITEMS) {
            System.out.println("Достигнут максимальный объем предметов ");
            return;
        }
        
        this.items[this.itemIndex] = item;
        this.itemIndex++;
    }

    public void showItems() {
        int index = 0;
        System.out.print("Invetory{");
        while (index < this.itemIndex) {
            System.out.printf("%s, ", items[index]);
            index++;
        }
        System.out.print("}\n");
    }
}