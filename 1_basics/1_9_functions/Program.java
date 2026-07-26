public class Program {
    public static void main(String[] args) {
        hello();

        String name = "Mikhail";
        greet(name);
        say("Hello", "from", "func");

        String word = "Programming";
        System.out.printf("%s is long word – %s\n", word, isLongWord(word));

        // Avg
        System.out.printf("Avg #1: %.1f\n", Arithmetic.avg(new int[]{1, 2, 3, 4, 5}));
        System.out.printf("Avg #2: %.1f\n", Arithmetic.avg(new float[]{1.1f, 2.2f, 3.3f, 4.4f, 5.5f}));

        // Inventory & items
        Inventory inventory = new Inventory();
        inventory.clearItems();
        inventory.showItems();

        Item item = new Item();
        item.name = "orange";
        inventory.addItem(item);
        inventory.showItems();
        
        Item item2 = new Item();
        item2.name = "banana";
        inventory.addItem(item2);
        inventory.showItems();    
        
        Item item3 = new Item();
        item3.name = "apple";
        inventory.addItemWithChangedName(item3);
        System.out.printf("Item3 (%s) - название поменялось? %s\n", "apple", item3.name); // +
        inventory.showItems();   
        
        Item item4 = new Item();
        item4.name = "grape";
        inventory.addItemFromNewObject(item4);
        System.out.printf("Item4 (%s) - название поменялось? %s\n", "grape", item4.name);
        inventory.showItems();
    }

    public static void hello() {
        System.out.println("Hello, world!");
    }
    
    // Функция с параметром
    public static void greet(String name) {
        System.out.printf("Hello, %s!\n", name);
    }

    // Параметры переменной длины
    public static void say(String ...words) {
        System.out.print("I`m saying: ");

        for (String word : words) {
            System.out.printf("%s ", word);
        }
        System.out.println();
    }
    
    // Функция с возвращаемым значением
    public static boolean isLongWord(String word) {
        if (word.length() > 15) return true;
        return false;
    }
}

// Перегрузка методов
class Arithmetic {
    public static float avg(int[] values) {
        int sum = 0;
        for (int value: values) { sum += value; }
        return sum / values.length;
    }    

    public static float avg(float[] values) {
        float sum = 0;
        for (float value: values) { sum += value; }
        return sum / values.length;
    }
}

// Объект как параметр метода
class Inventory {
    private final int MAX_ITEMS = 5;
    Item[] items = new Item[MAX_ITEMS];

    public void addItem(Item item) {
        if (countItems() >= MAX_ITEMS) return;

        System.out.printf("Добавляю новый предмет: %s\n", item.name);
        int index = countItems();
        this.items[index] = item;
    }
    
    public void addItemWithChangedName(Item item) {
        if (countItems() >= MAX_ITEMS) return;

        int index = countItems();
        item.name = String.format("%s#%s", item.name, index);

        System.out.printf("Добавляю новый предмет: %s\n", item.name);
        this.items[index] = item;
    }
    
    public void addItemFromNewObject(Item item) {
        if (countItems() >= MAX_ITEMS) return;

        String oldName = item.name;
        item = new Item();
        int index = countItems();
        // item.name = String.format("%s#%s", item.name, index); // Будет null#n, так как у нового объекта еще не задано имя (оно null)
        item.name = String.format("%s#%s", oldName, index); // Если пересоздается объект, то так будет установлено нужное имя

        System.out.printf("Добавляю новый предмет: %s\n", item.name);
        this.items[index] = item;
    }

    public void clearItems() {
        for (int i = 0; i < this.items.length; i++) {
            this.items[i] = null;
        }
    }

    public int countItems() {
        int counter = 0;

        for (Item item : items) {
            if (item == null) continue;
            counter++;
        }
        return counter;
    }

    public void showItems() {
        System.out.printf("Предметов в инвентаре - %d\n", countItems());
        if (countItems() == 0) return;

        System.out.printf("{");
        for (int i = 0; i < countItems(); i++) {
            System.out.printf("%s ", this.items[i].name);
        }
        System.out.printf("}\n\n");
    }
}

class Item {
    String name;
}