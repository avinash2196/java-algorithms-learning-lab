package meta.medium;

public class ExponentialPow {
    public double myPow(double x, int n) {
        return binaryPow(x, (long) n);
    }

    private double binaryPow(double x, long n) {
        if (n == 0) return 1;
        if (n < 0) {
            n = -1 * n;
            return 1.0 / binaryPow(x, n);
        }
        if (n % 2 == 0) {
            return binaryPow(x * x, n / 2);
        } else {
            return x * binaryPow(x * x, (n - 1) / 2);
        }
    }
}
// Time complexity :O(log n)
// Space Complexity :O(log n)