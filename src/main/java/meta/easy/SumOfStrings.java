package meta.easy;

public class SumOfStrings {
    public String addStrings(String num1, String num2) {
        int index1 = num1.length() - 1;
        int index2 = num2.length() - 1;

        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (index1 >= 0 || index2 >= 0) {
            int p1 = index1 >= 0 ? num1.charAt(index1) - '0' : 0;
            int p2 = index2 >= 0 ? num2.charAt(index2) - '0' : 0;
            int sum = p1 + p2 + carry;
            sb.append(sum % 10);
            carry = sum / 10;
            index1--;
            index2--;
        }
        if (carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }
    // Time complexity :O(max(m,n))
    // Space Complexity :O(max(m,n))
}
