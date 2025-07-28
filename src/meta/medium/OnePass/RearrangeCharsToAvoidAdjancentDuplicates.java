package meta.medium.OnePass;

public class RearrangeCharsToAvoidAdjancentDuplicates {
    public String reorganizeString(String s) {
        //get frequencey of each element in count array
        int[] freqMap = new int[26];
        int maxCount = 0;
        int maxCharIndex = 0;
        for (char ch : s.toCharArray()) {
            freqMap[ch - 'a']++;
            if (freqMap[ch - 'a'] > maxCount) {
                maxCount = freqMap[ch - 'a'];
                maxCharIndex = ch - 'a';
            }
        }
        //validate if its possible to arrange by chekcing the count ( need to be less than /2+1)
        if (maxCount > (s.length() + 1) / 2) {
            return "";
        }
        //place elements at even index
        char[] ans = new char[s.length()];
        int index = 0;
        while (freqMap[maxCharIndex] != 0) {
            ans[index] = (char) (maxCharIndex + 'a');
            index += 2;
            freqMap[maxCharIndex]--;
        }
        //place all other elements
        for (int i = 0; i < 26; i++) {
            while (freqMap[i] > 0) {
                if (index >= s.length()) {
                    index = 1;
                }
                ans[index] = (char) (i + 'a');
                index += 2;
                freqMap[i]--;
            }
        }
        return String.valueOf(ans);
    }
}

//Time complexity : O(n)
