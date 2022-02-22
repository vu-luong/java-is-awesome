import java.util.ArrayList;
import java.util.List;

class Solution {
    
    public static String spaceString(int nSpaces) {
        return new String(new char[nSpaces]).replace('\0', ' ');
    }
    
    public List<String> fullJustify(String[] words, int maxWidth) {
        
        int lengthCount = 0;
        int wordCount = 0;
        List<String> wordBuffer = new ArrayList<>();
        List<String> result = new ArrayList<>();
        for (String word : words) {
            int currentLength = lengthCount + wordCount - 1 + word.length();
            if (wordCount > 0) {
                currentLength += 1;
            }
            if (currentLength > maxWidth) {
                int nSpaces = maxWidth - lengthCount;
                int position;
                int nAppend;
                
                StringBuilder line = new StringBuilder();
                
                if (wordCount == 1) {
                    line.append(wordBuffer.get(0));
                    line.append(spaceString(nSpaces));
                } else {
                    position = nSpaces % (wordCount - 1) - 1;
                    nAppend  = nSpaces / (wordCount - 1);
                    
                    for (int j = 0; j <= position; j++) {
                        line.append(wordBuffer.get(j));
                        line.append(spaceString(nAppend + 1));
                    }
                    for (int j = position + 1; j < (wordCount - 1); j++) {
                        line.append(wordBuffer.get(j));
                        line.append(spaceString(nAppend));
                    }
                    line.append(wordBuffer.get(wordCount - 1));
                }
                
                System.out.println(line);
                result.add(line.toString());
                
                wordCount   = 0;
                lengthCount = 0;
                wordBuffer  = new ArrayList<>();
            }
            lengthCount += word.length();
            wordCount += 1;
            wordBuffer.add(word);
        }
        
        if (lengthCount > 0) {
            StringBuilder line = new StringBuilder();
            int nSpaces = maxWidth - lengthCount;
            for (int j = 0; j < wordBuffer.size() - 1; j++) {
                line.append(wordBuffer.get(j));
                line.append(" ");
                nSpaces -= 1;
            }
            line.append(wordBuffer.get(wordBuffer.size() - 1));
            line.append(spaceString(nSpaces));
            System.out.println(line);
            result.add(line.toString());
        }
        
        return result;
    }
}

public class TextJustification {
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.fullJustify(
            new String[]{
                "Science", "is", "what", "we", "understand", "well", "enough", "to", "explain",
                "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"
            },
            20
        ));
    }
    
}
