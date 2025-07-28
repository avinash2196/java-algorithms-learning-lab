package meta.easy.OnePass;

public class FindDifferences {
    public  static void main(String[] args){
        deletionDistance("hit","heat");
    }
    static int deletionDistance(String str1, String str2) {
        if(str1.equals(str2))
            return 0;
        int[] str1Chars=new int[26];
        int[] str2Chars=new int[26];
        for(char ch:str1.toCharArray()){
            int index=ch-'a';
            str1Chars[index]++;
        }
        for(char ch:str2.toCharArray()){
            int index=ch-'a';
            str2Chars[index]++;
        }
        for(int i=0;i<=25;i++){
            while(str1Chars[i]>0 && str2Chars[i]>0){
                str1Chars[i]--;
                str2Chars[i]--;
            }
        }
        int result=0;
        for(int i=0;i<=25;i++){
            result+=Math.abs(str1Chars[i]-str2Chars[i]);
        }
        return result;
    }
}
