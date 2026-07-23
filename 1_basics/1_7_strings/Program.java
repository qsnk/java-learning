public class Program {
    public static void main(String[] args) {
        String empty = new String();
        String name = "Mikhail";
        String fromChars = new String(new char[]{'M', 'i', 'k', 'h', 'a', 'i', 'l'});
        String formatted = String.format("My name is %s", name);
        String concatted = "Hello".concat(" World!");
        
        System.out.println(formatted);
        System.out.printf("Length of name: %d\n", name.length());
        System.out.printf("Name to lower case: %s\n", name.toLowerCase());
        System.out.printf("Name to upper case: %s\n", name.toUpperCase());

        System.out.printf("Names are equal: %s\n", name.equals(fromChars));

        String floatToString = String.valueOf(24.555f);
        System.out.println(floatToString);

        for (char digit: floatToString.toCharArray()) {
            System.out.printf("%s\t", digit);
        }
    }
}