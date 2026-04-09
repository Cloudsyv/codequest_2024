import java.util.Scanner;

public class Is_There_An_Echo_In_Here {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            int testCases = Integer.parseInt(input.nextLine());
            for(int testcase = 0; testcase < testCases; testcase++) {
                String str = input.nextLine();
                System.out.println(str);
                System.out.println(str);
            }
        }
    }
}
