public class Program {
    public static void main(String[] args) {
        System.out.println("Арифметика");
        System.out.println(1+1);
        System.out.println(10-1);
        System.out.println(10*2);
        System.out.println(10 / 3);
        System.out.println(10 % 3);

        System.out.println("Логические");
        // XOR
        System.out.println(10 ^ 2);

        // Logic sum
        System.out.println(10 | 2);

        // Inversion
        System.out.println(~10);

        //bitwise shifts
        System.out.println(10 >> 2); // 1010 >> 2 = 10 (2)
        System.out.println(10 << 2);

        System.out.println("Сравнение");
        System.out.println(10 > 2);
        System.out.println(10 < 2);
        System.out.println(10 == 2);
        System.out.println(10 != 2);
    }
}
