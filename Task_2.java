import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Task_2 {

    public static void main(String[] args) {
        System.out.println("\n******************* WORD COUNT *********************\n");
        try {
            String text = getInputText(); 
            int totalWordCount = countWords(text);
            int uniqueWordCount = countUniqueWords(text);
            
            System.out.println("Total number of words: " + totalWordCount);
            System.out.println("Total number of unique words: " + uniqueWordCount);
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }

    
    private static String getInputText() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter 'file' to read from a file or 'text' to enter text:");
        String choice = reader.readLine().trim();

        if (choice.equalsIgnoreCase("file")) {
            System.out.print("Enter the file path: ");
            String filePath = reader.readLine().trim();
            return readTextFromFile(filePath);
        } else if (choice.equalsIgnoreCase("text")) {
            System.out.println("Enter the text (press Enter and leave an empty line to finish):");
            StringBuilder text = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null && !line.isEmpty()) {
                text.append(line).append(" ");
            }
            return text.toString();
        } else {
            throw new IllegalArgumentException("Invalid choice");
        }
    }

    
    private static String readTextFromFile(String filePath) throws IOException {
        StringBuilder text = new StringBuilder();
        try (BufferedReader fileReader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = fileReader.readLine()) != null) {
                text.append(line).append(" ");
            }
        }
        return text.toString();
    }

    
    private static int countWords(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }

        String[] words = text.split("\\s+"); 
        return words.length;
    }

    
    private static int countUniqueWords(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }

        String[] words = text.split("\\s+"); 
        Set<String> uniqueWords = new HashSet<>();
        for (String word : words) {
            uniqueWords.add(word.toLowerCase()); 
        }
        return uniqueWords.size();
    }
}