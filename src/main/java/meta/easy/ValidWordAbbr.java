package meta.easy;

public class ValidWordAbbr {
    public boolean validWordAbbreviation(String word, String abbr) {
        int wordIndex=0;
        int abbrIndex=0;
        while(wordIndex<word.length() && abbrIndex<abbr.length()){
            char currAbbr=abbr.charAt(abbrIndex);
            if(Character.isLetter(currAbbr)){
                if(currAbbr!=word.charAt(wordIndex)){
                    return false;
                }
                else{
                    abbrIndex++;
                    wordIndex++;
                }
            }else{
                if(currAbbr=='0'){
                    return false;
                }
                else{
                    int num=0;
                    while(abbrIndex<abbr.length() && Character.isDigit(abbr.charAt(abbrIndex))){
                        num=num*10+abbr.charAt(abbrIndex)-'0';
                        abbrIndex++;
                    }
                    wordIndex=wordIndex+num;
                }
            }
        }
        return word.length()==wordIndex && abbr.length()==abbrIndex;
    }
    // Time complexity :O(max(n,m))
    // Space Complexity :O(1)
}
