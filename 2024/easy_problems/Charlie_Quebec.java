
import java.util.Scanner;

public class Charlie_Quebec {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            int testCases = Integer.parseInt(input.nextLine());
            for(int testcase = 0; testcase < testCases; testcase++) {
                //initialize the ICAO alphabets using an array
                String[] ICAO_alphabets = {"Alpha", "Bravo", "Charlie", "Delta" , "Echo", "Foxtrot",
                                           "Golf", "Hotel", "India", "Juliet", "Kilo", "Lima", "Mike",
                                           "November", "Oscar", "Papa", "Quebec", "Romeo", "Sierra",
                                           "Tango", "Uniform", "Victor", "Whiskey", "Xray", "Yankee",
                                           "Zulu"};
                int num_times = Integer.parseInt(input.nextLine());
                for (int line = 0; line < num_times ; line++) {
                    //ask the user for their input and split the words
                    String[] characters = input.nextLine().toUpperCase().split("");

                    //declare the string that will store the converted ICAO alphabets
                    String message_in_icao = ""; 

                    //make a nested for loop that loop through the characters
                    for (int i = 0; i < characters.length; i++) {
                        if (characters[i].equals(" ")) {
                            message_in_icao += " ";
                        }
                        for (String alphabet:ICAO_alphabets) {
                            if (alphabet.substring(0, 1).equals(characters[i])) {
                                message_in_icao += alphabet;
                                if ((i + 1) < characters.length) {
                                    message_in_icao += "-";
                                }
                                break;
                            }
                        }
                    }
                    message_in_icao = message_in_icao.replace("- ", " ");
                    System.out.println(message_in_icao);
                        //check for a space, if there is, add one
                        //concatenate the ICAO alphabets string to form a full messag1e
                }
            }
        }
    }
}
