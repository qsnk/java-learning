import java.lang.Math;

public class Program {
    public static void main(String[] args) {
        int randNumber = (int)(Math.random() * 100);
        System.out.println("Generating random number between 0 and 100");
        System.out.printf("Random number is %d\n", randNumber);

        if (randNumber > 50) {
            System.out.printf("%d is greater than 50\n", randNumber);
        }
        else if (randNumber < 50) {
            System.out.printf("%d is lower than 50\n", randNumber);  
        }
        else {
            System.out.printf("%d on half\n", randNumber);  
        }

        if (randNumber % 2 == 0) {
            System.out.printf("%d is even\n", randNumber);
        } else {
            System.out.printf("%d is odd\n", randNumber);
        }
    }
}