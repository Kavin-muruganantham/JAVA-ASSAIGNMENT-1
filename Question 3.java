import java.util.ArrayList;
import java.util.List;

public class TextJustification {
    
    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int index = 0;
        
        while (index < words.length) {
            int totalChars = words[index].length();
            int last = index + 1;
            
            // Accumulate words until the next word exceeds maxWidth
            while (last < words.length) {
                if (totalChars + words[last].length() + 1 > maxWidth) break;
                totalChars += words[last].length() + 1;
                last++;
            }
            
            StringBuilder sb = new StringBuilder();
            int gap = last - index - 1;
            
            // If it's the last line or the line has only one word, left-justify
            if (last == words.length || gap == 0) {
                for (int i = index; i < last; i++) {
                    sb.append(words[i]).append(" ");
                }
                sb.deleteCharAt(sb.length() - 1); // Remove last space
                
                // Fill the remaining space with spaces
                while (sb.length() < maxWidth) {
                    sb.append(" ");
                }
            } else {
                // Calculate spaces to evenly distribute
                int spaces = (maxWidth - totalChars) / gap;
                int extraSpaces = (maxWidth - totalChars) % gap;
                
                for (int i = index; i < last - 1; i++) {
                    sb.append(words[i]);
                    sb.append(" ");
                    
                    // Add the necessary spaces
                    for (int j = 0; j < spaces + (i - index < extraSpaces ? 1 : 0); j++) {
                        sb.append(" ");
                    }
                }
                sb.append(words[last - 1]); // Append the last word
            }
            
            result.add(sb.toString());
            index = last;
        }
        
        return result;
    }

    public static void main(String[] args) {
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth = 16;
        
        if (validateInput(words, maxWidth)) {
            List<String> justifiedText = fullJustify(words, maxWidth);
            for (String line : justifiedText) {
                System.out.println("\"" + line + "\"");
            }
        } else {
            System.out.println("Invalid input according to the constraints.");
        }
    }

    // Method to validate the input based on given constraints
    public static boolean validateInput(String[] words, int maxWidth) {
        if (words.length >= 300) return false;
        if (maxWidth < 1 || maxWidth > 100) return false;
        
        for (String word : words) {
            if (word.length() > 20 || word.length() > maxWidth) return false;
        }
        
        return true;
    }
}
