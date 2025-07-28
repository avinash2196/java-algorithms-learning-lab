package meta.easy.OnePass;

public class ElementAppearingMoreThan25PerInSortedArray {
    public int findSpecialInteger(int[] arr) {
        int lastVal = arr[0];
        if (arr.length == 1) {
            return lastVal;
        }
        int len = arr.length;
        int requiredCount = len / 4;
        int currentCount = 1;
        for (int index = 1; index < arr.length; index++) {

            if (arr[index] == lastVal) {
                currentCount++;
                if (currentCount > requiredCount) {
                    return lastVal;
                }
            } else {
                lastVal = arr[index];
                currentCount = 1;
            }
        }
        return 0;
    }
    /*
    Time Complexity =O(n)
    Space Complexity =O(1)
     */
}
