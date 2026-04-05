package meta.easy;

public class SquareRoot {
    public int mySqrt(int x) {
        if (x < 2) return x;
        int left = 2;
        int right = x / 2;
        while (left <= right) {
            int pivot = left + (right - left) / 2;
            long num = (long) pivot * pivot;
            if (num == x) {
                return pivot;
            } else if (num < x) {
                left = pivot + 1;
            } else {
                right = pivot - 1;
            }
        }
        return right;
    }
    // Time complexity : O (log x)
    //Space complexity : O(1)

}
