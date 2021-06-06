import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Please enter a sentence:");
        Scanner input=new Scanner(System.in);
        Set<String> words = WordBreakUtil.getWordsFromText("C:\\Users\\ASUS\\Desktop\\words_alpha.txt");
        List<String> result = new ArrayList<>();
        WordBreakUtil.breakStringUtil(input.next().toLowerCase(),words,result);
        System.out.println(result.get(result.size() - 1));
    }
}
