package others.leecode;

import java.util.Arrays;

/**
 * @author admin_cg
 * @date 2020/8/18 13:02
 */
public class Solution_LCP03 {
    public boolean robot(String command, int[][] obstacles, int x, int y) {
        /*
        if(Arrays.stream(obstacles).anyMatch(q -> Arrays.equals(q, new int[]{0,0}))) return false;
        int[] pos = new int[2];
        if(pos[0] == x && pos[1] == y) return true;
        while(pos[0] != x && pos[1] != y){
            for (int i = 0; i < command.length(); i++) {
                if(command.charAt(i) == 'U'){
                    pos[1] ++;
                    if(pos[1] > y) return false;
                    if(Arrays.stream(obstacles).anyMatch(q -> Arrays.equals(q, pos)))
                        return false;
                    else if(pos[0] == x && pos[1] == y) return true;
                }
                if(command.charAt(i) == 'R'){
                    pos[0] ++;
                    if(pos[0] > x) return false;
                    if(Arrays.stream(obstacles).anyMatch(q -> Arrays.equals(q, pos)))
                        return false;
                    else if(pos[0] == x && pos[1] == y) return true;
                }
            }
        }
        return false;
        */

        int[][] path = new int[command.length()][2];
        int xStep = 0, yStep = 0;
        for (int i = 0; i < command.length(); i++) {
            char ch = command.charAt(i);
            switch (ch){
                case 'U':
                    yStep++;
                    break;
                case 'R':
                    xStep++;
                    break;
                default:
                    break;
            }
            path[i][0] = xStep;
            path[i][1] = yStep;
        }

        for(int[] obs : obstacles){
            if(obs[0] >= x && obs[1] >= y)
                continue;
            if(pass(path, obs[0], obs[1], xStep, yStep))
                return false;

        }
        return pass(path, x, y, xStep, yStep);
    }

    public boolean pass(int[][] paths, int x, int y, int xStep, int yStep){
        for(int[] path:paths){
            if((x - path[0]) % xStep == 0 && (y - path[1]) % yStep == 0 && (x - path[0]) / xStep == (y - path[1]) / yStep)
                return true;
        }
        return false;
    }
}
