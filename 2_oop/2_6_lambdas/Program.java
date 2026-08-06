public class Program {
    public static void main(String[] args) {
        var message = "Hello, World!";

        //               Ссылка на метод
        ISender sender = Program::echo;
        sender.send(message);

        // Лямбда выражение
        ISender lambdaSender = (msg) -> System.out.println(msg);
        lambdaSender.send(message);
    }

    public static void echo(String message) {
        System.out.println(message);
    }
}

// Функциональный интерфейс
interface ISender {
    void send(String message);
}