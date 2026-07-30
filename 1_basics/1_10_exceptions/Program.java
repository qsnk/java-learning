public class Program {
    public static void main(String[] args) {
        // Throwable - базовый класс для всех исключений
        // Исключения можно разделить на 2 вида:
        // 1. Проверяемые (англ. checked)
        // 2. Непроверяемые (англ. unchecked)

        int[] numbers = new int[] {1, 2, 3, 4, 5};        
        System.out.printf("Первый элемент массива: %d\n", numbers[0]);

        // Попытка достать 999 элемент
        try {
            int index = 999;
            System.out.printf("%d элемент массива: %d\n", index, numbers[index]);        
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.printf("Ошибка при попытке получить элемент массива: %s\n", e.getMessage());
        }
        
        // Попытка достать 999 элемент или последний
        try {
            int index = -1;
            System.out.printf("%d элемент массива: %d\n", index, numbers[index]);        
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.printf("Ошибка при попытке получить элемент массива: %s\n", e.getMessage());
        } finally {
            System.out.println("Дошли до блока finally, пробуем получить последний элемент массива");
            System.out.printf("Последний элемент массива: %d\n", numbers[numbers.length - 1]);        
        }

        // Бросаем исключение
        int index = 100;
        try {
            int value = getArrayItem(numbers, index);
            System.out.printf("%d элемент массива = %d\n", index, value);
        } catch (Exception e) {
            System.err.printf("Не удалось получить %d элемент массива: %s\n", index, e.getMessage());
        }

        // Использование своего исключения
        try {
            String value = "Java";
            scanString(value);
        } catch (Exception e) { // Ловим все исключения
            System.err.printf("Ошибка при сканировании строки: %s\n", e.getMessage());
        }

        double avgValue = avg(numbers);
        System.out.printf("Среднее арифметическое переданного массива = %f\n", avgValue);
    }

    // Функция, которая возвращает элемент массива и выбрасывает исключение ArrayIndexOutOfBoundsException в случае ошибки 
    public static int getArrayItem(int[] array, int index) throws ArrayIndexOutOfBoundsException {
        if (index >= array.length || index < 0) throw new ArrayIndexOutOfBoundsException(String.format("Index %d out of bounds for array with length %d", index, array.length));
        return array[index];
    }

    // Функция, которая проверяет длину строки и выбрасывает исключение TooShortStringException в случае если строка короче 5 символов
    public static void scanString (String value) throws TooShortStringException {
        if (value.length() < 5) throw new TooShortStringException(String.format("String \"%s\" has too short length = %d", value, value.length()));
        System.out.printf("%s has suitable length %d\n", value, value.length());
    }

    // Функция с оператором assert
    public static double avg(int[] array) {
        assert array.length > 0;

        int sum = 0;

        for (int i : array) {
            sum += i;
        }
        return sum / array.length;
    }
}

class TooShortStringException extends Exception {
    public TooShortStringException(String message) {
        super(message);
    }
}