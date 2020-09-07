package others.leecode;

import java.util.Collections;
import java.util.LinkedList;

/**
 * @author admin_cg
 * @date 2020/8/29 15:23
 */
public class Solution_71 {
    public String simplifyPath(String path) {
        if(path == null || path.length() == 0) return path;
        LinkedList<String> temp = new LinkedList<>();
        String[] pathTemp = path.split("/+");
        for (String s : pathTemp) {
            if (s.equals("..")){
                if(!temp.isEmpty())
                    temp.pop();
            }
            else if (!s.equals("."))
                temp.push(s);
        }
        Collections.reverse(temp);
        return "/" + String.join("/", temp);
    }
}
