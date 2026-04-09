import java.util.Scanner;
import java.util.StringBuilder;

public class Hijacked {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            int testCases = Integer.parseInt(input.nextLine());
            for (int testcase = 0; testcase < testCases; testcase++) {
                long lineLength = Integer.parseInt(input.nextLine());
                String line = input.nextLine();

                int index = 0;
                while (index < line.length() - 5) {
                    String candidateStartToken = line.substring(index, index + 3);
                    String candidateEndToken = new StringBuilder(candidateStartToken).reverse().toString();
                    int endIndex = line.indexOf(candidateEndToken, index + 2);
                    if (endIndex > 0 && endIndex > index + 3) {
                        String message = line.substring(index + 3, endIndex);
                        for (int i = 0; i < candidateStartToken.length(); i++) {
                            String doubleCh = "" + candidateStartToken.charAt(i) + candidateStartToken.charAt(i);
                            message = message.replace(doubleCh, "" + candidateStartToken.charAt(i));
                        }
                        System.out.println(message);
                        line = line.substring(endIndex + 3);
                        index = 0;
                    } else {
                        index++;
                    }
                }
            }
        }
    }
}
