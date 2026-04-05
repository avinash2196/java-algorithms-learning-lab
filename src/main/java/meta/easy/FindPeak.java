package meta.easy;

import java.util.List;
import java.util.ArrayList;

public class FindPeak {
    public List<Integer> findPeaks(int[] mountain) {
        List<Integer> result = new ArrayList();
        for (int index = 1; index < mountain.length - 1; index++) {
            if (mountain[index] > mountain[index - 1] && mountain[index] > mountain[index + 1]) {
                result.add(index);
            }
        }
        return result;
    }
}
// Time complexity :O(n)
// Space Complexity :O(k)