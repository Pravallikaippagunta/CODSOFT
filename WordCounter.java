import java.util.Scanner;

public class WordCounter {
    public static void main(String[] args) {
        System.out.println("Enter text: ");
        String input = getInput();
        String[] words = input.split("[\\s\\p{Punct}]+");
        int wordCount = 0;
        for (String word : words) {
            if (!word.isEmpty()) {
                wordCount++;
            }
        }
        System.out.println("Total number of words: " + wordCount);
    }
    private static String getInput() {
        Scanner sc = new Scanner(System.in);
        StringBuilder input = new StringBuilder();
            if (sc.hasNextLine()) {
                input.append(sc.nextLine());
            }
        return input.toString();
    }
}
