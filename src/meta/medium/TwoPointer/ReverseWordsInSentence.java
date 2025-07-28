package meta.medium.TwoPointer;

public class ReverseWordsInSentence {

    static char[] reverseWords(char[] arr) {
        reverseWord(arr, 0, arr.length - 1);
        int start = 0;
        for (int end = 0; end < arr.length; end++) {
            if (arr[end] == ' ') {
                reverseWord(arr, start, end - 1);
                start = end + 1;
            }
            if (end == arr.length - 1) {
                reverseWord(arr, start, end);
                start = end + 1;
            }
        }
        return arr;
    }

    private static void reverseWord(char[] arr, int start, int end) {
        while (start < end) {
            char temp = arr[start];
            arr[start++] = arr[end];
            arr[end--] = temp;
        }
    }
}
   /* Time and Space Complexity
    	Time Complexity	    Space Complexity
       	O(n)	            O(1) */