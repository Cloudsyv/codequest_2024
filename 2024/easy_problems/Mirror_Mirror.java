import java.util.Scanner;

public class Mirror_Mirror {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            int testCases = Integer.parseInt(input.nextLine());
            for(int testcase = 0; testcase < testCases; testcase++) {
                String str = input.nextLine();
                StringBuilder stringBuilder = new StringBuilder(str);
                System.out.println(stringBuilder.reverse().toString());
            }
        }
    }
}
