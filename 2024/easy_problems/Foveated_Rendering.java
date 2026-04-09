import java.util.*;

public class Foveated_Rendering {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            int testCases = Integer.parseInt(input.nextLine());
            int size = 20;
            for(int testcase = 0; testcase < testCases; testcase++) {
                String[] line = input.nextLine().split(" ");
                int row = Integer.parseInt(line[0]);
                int col = Integer.parseInt(line[1]);
                for (int r = 0; r < size; r++) {
                    for (int c = 0; c < size; c++) {
                        int check = Math.max(Math.abs(r - row), Math.abs(c - col));
                        if (check == 0) {
                            System.out.print(100);
                        } else if (check == 1) {
                            System.out.print(50);
                        } else if (check == 2) {
                            System.out.print(25);
                        } else {
                            System.out.print(10);
                        }
                        if (c + 1 != size) {
                            System.out.print(" ");
                        }
                    }
                    System.out.println();
                }
            }
        }
    }
}
