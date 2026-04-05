package meta.hard;

import java.util.ArrayList;
import java.util.List;

public class ValidParanthesisAfterRemovingExtra {

    private List<String> result=new ArrayList<>();
    public List<String> removeInvalidParentheses(String s) {
        int openCount=0;
        int closedCount=0;
        //count each start and extra end paranthese
        for(char ch:s.toCharArray()){
            if(ch=='('){
                openCount++;
            }else if(ch==')'){
                if(openCount>0){
                    openCount--;
                }else{
                    closedCount++;
                }
            }
        }
        dfs(s,0,0,0,openCount,closedCount,new StringBuilder());
        return result;
    }

    private void dfs(String s,int index, int openCount, int closedCount, int openRemaining, int closedRemaining,StringBuilder current) {
        if(openRemaining<0 || closedRemaining<0 || closedCount>openCount){
            return;
        }
        //base cases
        if(s.length()==index){
            if(openRemaining==0 && closedRemaining==0)
                result.add(current.toString());
        }
        char ch=s.charAt(index);
        int len=current.length();
        //discard
        if(ch=='(' && openRemaining>0){
            dfs(s,index+1,openCount,closedCount,openRemaining-1,closedRemaining,current);
        }else if(ch==')' && closedRemaining>0){
            dfs(s,index+1,openCount,closedCount,openRemaining,closedRemaining-1,current);
        }
        current.append(ch);
        if(ch!='(' && ch!=')')
            dfs(s,index+1,openCount,closedCount,openRemaining,closedRemaining,current);
        else if (ch=='(')
            dfs(s,index+1,openCount+1,closedCount,openRemaining,closedRemaining,current);
        else if (ch==')')
            dfs(s,index+1,openCount,closedCount+1,openRemaining,closedRemaining,current);
        current.setLength(len);
    }

    //perform DFS and work for all scenarios by including current or excluding current
}
