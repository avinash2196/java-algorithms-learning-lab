package meta.easy;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascalTriangle=new ArrayList();
        for(int row=0;row<numRows;row++){
            List<Integer> currRow=new ArrayList();
            for(int col=0;col<=row;col++){
                if(col==0 || col==row)
                    currRow.add(1);
                else
                    currRow.add(pascalTriangle.get(row-1).get(col-1)+pascalTriangle.get(row-1).get(col));
            }
            pascalTriangle.add(currRow);
        }
        return pascalTriangle;
    }
    // Time complexity : O (numRow^2)
    //Space complexity : O(numRow^2)
}
