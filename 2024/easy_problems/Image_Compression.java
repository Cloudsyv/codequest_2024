import java.util.*;

public class Image_Compression {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            int testCases = Integer.parseInt(input.nextLine());
            for(int testcase = 0; testcase < testCases; testcase++) {
                int num = input.nextInt();
                double max = Integer.MIN_VALUE;
                double min = Integer.MAX_VALUE;
                double[] array = new double[num];
                for (int i = 0; i < num; i++) {
                  array[i] = input.nextDouble();
                  min = Math.min(min, array[i]);
                  max = Math.max(max, array[i]);
                }
                for (int j = 0; j < num; j++) {
                  long output = Math.round((array[j] - min) / (max - min) * 255);
                  System.out.println(output);
                }
            }
        }
    }
}
