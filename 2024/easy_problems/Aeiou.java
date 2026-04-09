// package finished;
// import java.util.Scanner;

// /*
//  * For each test case, this program should print out the number of vowels contained in the input
//  */

public class Aeiou {
     public static void main(String[] args) {
         try (Scanner input = new Scanner(System.in)) {
             int testCases = Integer.parseInt(input.nextLine());
            
             for (int testcase = 0; testcase < testCases; testcase++) {
                 int count = 0;
                 String line = input.nextLine();
                 for(int i = 0; i < line.length(); i++) {
                     if (line.substring(i, i + 1).equals("a")
                     || line.substring(i, i + 1).equals("e")
                     || line.substring(i, i + 1).equals("i")
                     || line.substring(i, i + 1).equals("o")
                     || line.substring(i, i + 1).equals("u")) {

                         count++;
                     }
                 }
                 System.out.println(count);
             }
         }
    }
 }
