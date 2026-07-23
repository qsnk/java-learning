public class Program {
    public static void main(String[] args) {
        String name = "Mikhail";
        byte age = 24;
        float weight = 65.5f;
        boolean isLearningJava = true;
        System.out.printf("My name is %s\n", name);
        System.out.printf("Age: %d, weight: %f. Weight as int: %d\n", age, weight, (int)weight);
        System.out.printf("Learning java: %b, as string: %s", isLearningJava, isLearningJava);
    }
}
