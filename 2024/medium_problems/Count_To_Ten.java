import java.util.Scanner;

public class Count_To_Ten {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            int testCases = Integer.parseInt(input.nextLine());
            for(int testcase = 0; testcase < testCases; testcase++) {
                //get the number of bits
                int numBits = input.nextInt();
                int pouiy = (int) Math.pow(2, numBits);
                for (int e = 0; e < pouiy; e++) {
                    String binarySequence = Integer.toBinaryString(e);
                    while (binarySequence.length() < numBits) {
                        binarySequence = "0" + binarySequence;
                    }
                    System.out.println(binarySequence);
                }
            }
        }
    }
}

