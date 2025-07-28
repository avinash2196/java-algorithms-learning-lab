package meta.hard.TwoPointer;

public class RegexMatcher {
    class Solution {
        public boolean isMatch(String s, String p) {
            int sLen = s.length();
            int pLen = p.length();
            int starLastPos = -1;
            int sLastIndex = 0;
            int sIndex = 0;
            int pIndex = 0;
            while (sIndex < sLen) {
                if (pIndex < pLen && (p.charAt(pIndex) == '?' || p.charAt(pIndex) == s.charAt(sIndex))) {
                    pIndex++;
                    sIndex++;
                } else if (pIndex < pLen && p.charAt(pIndex) == '*') {
                    starLastPos = pIndex;
                    sLastIndex = sIndex;
                    pIndex++;
                } else if (starLastPos != -1) {
                    //reset both
                    pIndex = starLastPos;
                    sIndex = sLastIndex;
                    //move both ahead
                    sIndex++;
                    pIndex++;
                    //take backup of sIndex
                    sLastIndex = sIndex;
                }
            }
            while (pIndex < pLen && p.charAt(pIndex) == '*') {
                pIndex++;
            }
            return pIndex == pLen;
        }
    }
		/*
			if both are same or ? , move both ahead

			if * , save this * position of p, and move ahead p without moving sIndex ,save sIndex also

			now if mismatch and we have previous star found
				reset pIndex to old star Index (backtrack)
				reset Sindex to old Index
				move Sindex ahead
				save Sindex again for next iteration
		*/
    /* Time Complexity: O(m + n)
    Space Complexity : O(1)
     */
}
