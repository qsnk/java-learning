import objects.Inventory;
import objects.components.Item; // Импорт класса из дочерней папки от папки objects

// Текущий файл находится в безымянном пакете

public class Program {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        inventory.showItems();

        inventory.addItem("orange");
        inventory.addItem("banana");
        inventory.showItems();

        Item item = new Item("Sword");
        System.out.println(item.toString());
    }
}