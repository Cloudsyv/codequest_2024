import java.util.Scanner;

public class The_Bottom_Line {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            int testCases = Integer.parseInt(input.nextLine());
            for(int testcase = 0; testcase < testCases; testcase++) {
                String[] line = input.nextLine().split(" ");
                int firstCompany = Integer.parseInt(line[0]);
                int secondCompany = Integer.parseInt(line[1]);
                int difference = 0;
                if (firstCompany > secondCompany) {
                    difference = firstCompany - secondCompany;
                    System.out.println("Cassowary Craft sold " + difference + " more aircraft");
                } else if (secondCompany > firstCompany) {
                    difference = secondCompany - firstCompany;
                    System.out.println("Lead Balloons Ltd sold " + difference + " more aircraft");
                } else {
                    System.out.println("Cassowary Craft and Lead Balloons Ltd sold the same number of aircraft");
                }
            }
        }
    }
}
