package meta.easy;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public int romanToInt(String s) {
        Map<Character,Integer> romanToInt=new HashMap<>();
        romanToInt.put('M', 1000);
        romanToInt.put('D', 500);
        romanToInt.put('C', 100);
        romanToInt.put('L', 50);
        romanToInt.put('X', 10);
        romanToInt.put('V', 5);
        romanToInt.put('I', 1);
        char[] arr=s.toCharArray();
        int index=0;
        int len=arr.length;
        int result=0;
        while(index<len){
            char currSymbol=arr[index];
            int currNum=romanToInt.get(currSymbol);
            int nextNum=0;
            if(index+1<len){
                nextNum=romanToInt.get(arr[index+1]);
            }
            if(currNum<nextNum){
                result=result+(nextNum-currNum);
                index=index+2;
            }else{
                result+=currNum;
                index++;
            }
        }
        return result;
    }
        // Time complexity : O (n)
        //Space complexity : O(1)


}
