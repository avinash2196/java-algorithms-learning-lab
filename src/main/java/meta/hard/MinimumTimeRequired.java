package meta.hard;

import java.util.Arrays;

public class MinimumTimeRequired {
    private int result = Integer.MAX_VALUE;

    //backtrack and keep checking max against result
    public int minimumTimeRequired(int[] jobs, int k) {
        //sort jobs so that we can start from max
        Arrays.sort(jobs);
        reverse(jobs);
        int[] workers = new int[k];
        dfs(jobs, 0, workers, 0);
        return result;
    }

    private void dfs(int[] jobs, int jobIndex, int[] workers, int maxSoFar) {
        if (jobIndex == jobs.length) {
            result = Math.min(result, maxSoFar);
            return;
        }
        int job = jobs[jobIndex];
        for (int i = 0; i < workers.length; i++) {
            if (workers[i] + job >= result) continue;
            if (i > 0 && workers[i - 1] == workers[i]) {
                continue;
            }
            workers[i] += job;
            dfs(jobs, jobIndex + 1, workers, Math.max(maxSoFar, workers[i]));
            workers[i] -= job;
            if (workers[i] == 0) break;

        }

    }

    private void reverse(int[] jobs) {

    }
}
