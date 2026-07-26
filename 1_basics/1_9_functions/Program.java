public class Program {
    public static void main(String[] args) {
        hello();

        String name = "Mikhail";
        greet(name);
        say("Hello", "from", "func");

        String word = "Programming";
        System.out.printf("%s is long word – %s\n", word, isLongWord(word));

        // Avg
        Arithmetic arth = new Arithmetic();
        System.out.printf("Avg #1: %.1f\n", arth.avg(new int[]{1, 2, 3, 4, 5}));
        System.out.printf("Avg #2: %.1f\n", arth.avg(new float[]{1.1f, 2.2f, 3.3f, 4.4f, 5.5f}));
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

// Передача объекта в параметр метода 
// TODO:
