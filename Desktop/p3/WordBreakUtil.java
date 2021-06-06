import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class WordBreakUtil {
    public static Set<String> getWordsFromText(String filePath) {
        Set<String> words = new HashSet<>();
        try {
            File file = new File(filePath);
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String temp = sc.nextLine().trim().toLowerCase();
                words.add(temp);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return words;
    }

    public static void breakStringUtil(String message, Set<String> words, List<String> sentences) {
        breakString(message, message.length(), "", words, sentences);
    }

    private static void breakString(String text, int size, String result, Set<String> words, List<String> sentences) {
        text = text.toLowerCase();

        for (int i = 1; i <= size; i++) {
            String prefix = text.substring(0, i);

            if (words.contains(prefix)) {
                if (i == size) {
                    result += prefix;
                    sentences.add(result);
                    return;
                } else
                    breakString(text.substring(i), size - i, result + prefix + " ", words, sentences);
            }
        }
    }
}
