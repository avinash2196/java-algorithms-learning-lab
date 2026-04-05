package meta.hard;

import java.util.Arrays;

public class Candy {
    public int candy(int[] ratings) {
        int len = ratings.length;
        //create left to right array by comparing left element
        int[] left2RightArray = new int[len];
        Arrays.fill(left2RightArray, 1);
        for (int i = 1; i < len; i++) {
            if (ratings[i] > ratings[i - 1]) {
                left2RightArray[i] = left2RightArray[i - 1] + 1;
            }
        }
        int[] right2LeftArray = new int[len];
        Arrays.fill(right2LeftArray, 1);
        for (int i = len - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                left2RightArray[i] = left2RightArray[i + 1] + 1;
            }
        }
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += Math.max(left2RightArray[i], right2LeftArray[i]);
        }
        //create right to left array by comparing right element
        return sum;
    }
}
