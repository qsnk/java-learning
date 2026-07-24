public class Program {
    public static void main(String[] args) {
        char[] arrayOfChars = new char[]{'h', 'e', 'l', 'l', 'o'};

        for(int i = 0; i < arrayOfChars.length; i++) { System.out.printf("%s", arrayOfChars[i]); }
        System.out.println();

        String[] arrayOf3Strings = new String[3];
        arrayOf3Strings[0] = "Hello";
        arrayOf3Strings[1] = "from";
        arrayOf3Strings[2] = "world";
        // Error
        // arrayOf3Strings[3] = "not enough space";

       for (String word : arrayOf3Strings) {
           System.out.println(word);
       }

       // 2D arrays
       int[][] table = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

       for(int row = 0; row < table.length; row++) {
           for(int col = 0; col < table[row].length; col++) {
               System.out.printf("%d ", table[row][col]);
           }
           System.out.println();
       }
    }
}
