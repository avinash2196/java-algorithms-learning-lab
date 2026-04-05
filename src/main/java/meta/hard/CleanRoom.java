package meta.hard;

import java.util.HashSet;
import java.util.Set;

interface Robot {
    void clean();

    boolean move();

    void turnRight();

    void turnLeft();
}

public class CleanRoom {
    //simply do dfs ..keep on moving to next room and return
    public void cleanRoom(Robot robot) {
        dfs(robot, 0, 0, 0, new HashSet<>());
    }
    int[][] directions = {{0, 1}, {1, 0}, {0, -1,}, {-1, 0}};
    private void dfs(Robot robot, int index, int row, int col, Set<String> visited) {
        String key=row+","+col;
        visited.add(key);
        robot.clean();
        for(int i=0;i<4;i++){
            int newD=(index+i)%4;
            int newRow=row+directions[newD][0];
            int newCol=col+directions[newD][1];
            String newKey=newRow+","+newCol;
            if(!visited.contains(newKey) && robot.move()){
                dfs(robot,newD,row,col,visited);
                goback(robot);
            }
            robot.turnRight();
        }
    }

    private void goback(Robot robot) {
        robot.turnLeft();
        robot.turnLeft();
        robot.move();
        robot.turnLeft();
        robot.turnLeft();
    }
}
