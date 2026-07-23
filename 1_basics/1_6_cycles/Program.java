public class Program {
    public static void main(String[] args) {
        // for (;;) {
        //     System.out.println("Endless loop");
        // }

        System.out.println("Numbers from 1 to 10:");
        
        for (int i = 1; i <= 10; i++) {
            System.out.printf("%d\t", i);
        }
        
        String name = "Mikhail";
        System.out.printf("\nChars of name: %s\n", name);
        
        for (char letter : name.toCharArray()) {
            System.out.printf("%s\t", letter);
        }

        int number = 24;
        String buf = "";
        
        System.out.printf("\nDecimal `%d` to binary with `while`:\n", number);

        while (number > 1) {
            int remainder = number % 2;
            buf = buf.concat(String.valueOf(remainder));
            number = (int)(number / 2);
        }

        buf = buf.concat(String.valueOf(number));
        System.out.println(new StringBuilder(buf).reverse().toString());

        do {
            System.out.println("Executed even if value is false");
        } while (false);
    }
}