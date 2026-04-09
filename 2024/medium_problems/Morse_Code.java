import java.util.*;

public class MorseCode {
    public static final String SEPARATOR = "   ";
    
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            int testCases = Integer.parseInt(input.nextLine());
            for(int testcase = 0; testcase < testCases; testcase++) {
                // A map for each direction of coding
                Map<Character, String> letterToMorse = new HashMap<>();
                Map<String, Character> morseToLetter = new HashMap<>();
                
                // Get the definitions and store a map for each direction
                for (char letter = 'A'; letter <= 'Z'; letter++) {
                    String morse = input.nextLine().replace(letter + " ", "");
                    
                    letterToMorse.put(Character.valueOf(letter), morse);
                    morseToLetter.put(morse, Character.valueOf(letter));
                }
                
                // Store a space character
                letterToMorse.put(Character.valueOf(' '), " ");
                
                // Get the lines to encrypt and decrypt
                char[] toEncrypt = input.nextLine().toCharArray();
                String toDecrypt = input.nextLine();
                
                StringBuilder ciphertext = new StringBuilder();
                
                // Go through each character in the line and encrypt it
                for (int i = 0; i < toEncrypt.length; i++) {
                    ciphertext.append(letterToMorse.get(Character.valueOf(toEncrypt[i])));
                    ciphertext.append(SEPARATOR);
                }
                
                // Print the encrypted text
                System.out.println(ciphertext.toString().trim());
                
                // 7 spaces between words
                String[] wordsToDecrypt = toDecrypt.split("       ");
                StringBuilder plaintext = new StringBuilder();
                
                // Go through the morse code
                for (int i = 0; i < wordsToDecrypt.length; i++) {
                    // Get the next letters in the next word
                    String[] letters = wordsToDecrypt[i].split(SEPARATOR);
                    for (int j = 0; j < letters.length; j++) {
                        plaintext.append(morseToLetter.get(letters[j]));
                    }
                    plaintext.append(" ");
                }
                System.out.println(plaintext.toString().trim());
            }
        }
    }
}
