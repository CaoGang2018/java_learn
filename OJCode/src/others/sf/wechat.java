package others.sf;

import java.util.*;

/**
 * @author admin_cg
 * @data 2020/9/29 10:34
 */

class User{
    String name;
    int score;
    int next;

    public User(String name) {
        this.name = name;
        this.score = 0;
        this.next = -1;
    }
}
public class wechat {
    Map<Integer, User> map = new HashMap<>();
    int index = 0; // 记录用户序号

    /**
     *
     * @param name 用户名
     * @param id 父id
     * @return true
     */
    public boolean insertNewUsr(String name, int id){
        if(!map.containsKey(id)){
            map.put(index++, new User(name)); // map中没有id记录，原始用户
        }
        else{
            if(map.containsKey(map.get(id).next)){
                map.get(map.get(id).next).score += 3;
            }
            map.get(id).score += 10;
        }
        return true;
    }

    /**
     *
     * @return 结果集list
     */
    public List<User> topTen(){
        PriorityQueue<User> ans = new PriorityQueue<>(Comparator.comparingInt(o -> o.score));
        for (User value : map.values()) {
            ans.add(value);
            if(ans.size() > 10)
                ans.poll();
        }
        return new ArrayList<>(ans);
    }

}
