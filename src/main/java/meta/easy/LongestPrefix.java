package meta.easy;

public class LongestPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs==null || strs.length==0)
            return "";
        for(int index=0;index<strs[0].length();index++){
            char charFromFirst=strs[0].charAt(index);
            for(int wordIndex=1;wordIndex<strs.length;wordIndex++){
                if(index==strs[wordIndex].length() || charFromFirst!=strs[wordIndex].charAt(index)){
                    return strs[0].substring(0,index);
                }
            }
        }
        return strs[0];
    }
    // Time complexity :O(n*m)
    // Space Complexity :O(1)

}
