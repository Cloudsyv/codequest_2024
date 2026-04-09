import java.util.Scanner;

public class Rock_Paper_Scissors {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            int testCases = Integer.parseInt(input.nextLine());
            for (int testcase = 0; testcase < testCases; testcase++) {
                String str = input.nextLine();
                String[] arrayStr = str.split(" ");
                boolean rock = false;
                boolean paper = false;
                boolean scissors = false;
                int rockCount = 0;
                int paperCount = 0;
                int scissorCount = 0;
                for (String check : arrayStr) {
                    switch (check) {
                        case "R":
                            rock = true;
                            rockCount++;
                            break;
                        case "P":
                            paper = true;
                            paperCount++;
                            break;
                        case "S":
                            scissors = true;
                            scissorCount++;
                            break;
                    }
                }
                if (rock && !paper && scissors && rockCount == 1)
                    System.out.println("ROCK");
                else if (rock && paper && !scissors && paperCount == 1)
                    System.out.println("PAPER");
                else if (!rock && paper && scissors && scissorCount == 1)
                    System.out.println("SCISSORS");
                else
                    System.out.println("NO WINNER");
            }
        }
    }
}
