import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        System.out.print("Put some text: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.printf("Console input: %s\n", input);

        scanner.close();
    }
}
