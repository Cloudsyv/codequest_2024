import java.util.*;

public class Monogram {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            int testCases = Integer.parseInt(input.nextLine());
            for(int testcase = 0; testcase < testCases; testcase++) {
                int num = input.nextInt();
                for (int i = 0; i < num; i++) {
                  String a = input.next().substring(0, 1);
                  String b = input.next().substring(0, 1);
                  String c = input.next().substring(0, 1);
                  System.out.println((a + c + b).toUpperCase());
                }
            }
        }
    }
}
