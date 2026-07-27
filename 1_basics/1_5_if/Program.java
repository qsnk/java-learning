import java.lang.Math;
import java.time.DayOfWeek;
import java.time.LocalDate;


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

        // Switch stmnt
        switch (randNumber % 2) {
            case 0: System.out.printf("%d is even\n", randNumber); break;
            case 1: System.out.printf("%d is odd\n", randNumber); break;
           	default:
                System.err.println("Unreachable!");
                assert false;
      		break;
        }

        LocalDate date = LocalDate.now();
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        int idayOfWeek = switch (dayOfWeek) {
            case MONDAY -> 1;
            case TUESDAY -> 2;
            case WEDNESDAY -> 3;
            case THURSDAY -> 4;
            case FRIDAY -> 5;
            case SATURDAY -> 6;
            case SUNDAY -> 7;
        };

        System.out.printf("%s is %d integer value\n", dayOfWeek.toString(), idayOfWeek);

        // Тернарный оператор
        boolean isEven = randNumber % 2 == 0 ? true : false;
        System.out.printf("%d is even – %s\n", randNumber, isEven);
    }
}
