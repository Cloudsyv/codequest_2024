import java.util.HashMap;
import java.util.Scanner;

public class TheLastPlaceYouLook {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            int testCases = Integer.parseInt(input.nextLine());
            for(int testcase = 0; testcase < testCases; testcase++) {
                String[] line =  input.nextLine().split(" ");
                int[]  x_coordinate = new int[3];
                int[] y_coordinate = new int[3];
                int[] distance = new int[3];
                int index = 0;
                for (int i = 0; i < 3 * 3; i += 3) {
                    x_coordinate[index] = Integer.parseInt(line[i]);
                    y_coordinate[index] = Integer.parseInt(line[i + 1]);
                    distance[index] = Integer.parseInt(line[i + 2]);
                    index++;
                }

                HashMap<String, Integer> coords = new HashMap<String, Integer>();
                for (int i = 0; i < 3; i++) {
                    int x = x_coordinate[i];
                    int y = y_coordinate[i];
                    int d = distance[i];
                    for (int j = 0; j <= 2 * d; j++) {
                        int ix = x - d + j;
                        String a = ix + "," + (j < d ? y + j : y + 2 * d - j);
                        String b = ix + "," + (j < d ? y - j : y - 2 * d + j);
                        coords.put(a, (coords.containsKey(a) ? coords.get(a) : 0) + 1);
                        if (!a.equals(b))
                            coords.put(b, (coords.containsKey(b) ? coords.get(b) : 0) + 1);
                    }
                }
                for (String l:coords.keySet()) {
                    if (coords.get(l) == 3) {
                        System.out.println("(" + l + ")");
                    }
                }
            }
        }
    }
}
