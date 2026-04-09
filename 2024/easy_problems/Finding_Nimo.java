import java.util.Scanner;

public class Finding_Nimo {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            int testCases = Integer.parseInt(input.nextLine());
            for(int testcase = 0; testcase < testCases; testcase++) {
                String[] line = input.nextLine().split(" ");
                for (int i = 0; i < line.length; i++) {
                    if (line[i].equals("Nimo")) {
                        System.out.println(i + 1);
                    }
                }
            }
        }
    }
}
