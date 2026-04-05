package meta.medium;

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGain = 0;
        int currGain = 0;
        int answer = 0;
        int gain = 0;
        for (int i = 0; i < gas.length; i++) {
            gain = gas[i] - cost[i];
            currGain += gain;
            totalGain += gain;
            if (currGain < 0) {
                currGain = 0;
                answer = i + 1;
            }
        }
        return totalGain >= 0 ? answer : -1;
    }
}
// Time complexity :O(N)
// Space Complexity :O(1)