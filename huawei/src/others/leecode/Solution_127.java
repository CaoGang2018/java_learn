package others.leecode;

import java.util.*;

/**
 * @author admin_cg
 * @date 2020/8/28 20:23
 */
public class Solution_127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord))
            return 0;
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        visited.add(beginWord);
        int ans = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            ++ans;
            for (int i = 0; i < size; i++) {
                String start = queue.poll();
                for(String word : wordList){
                    if(visited.contains(word))
                        continue;
                    if(!isConnected(start, word))
                        continue;
                    if(word.equals(endWord))
                        return ++ans;
                    visited.add(word);
                    queue.offer(word);
                }
            }
        }
        return 0;
    }
    private boolean isConnected(String str1, String str2){
        if(str1.length() != str2.length())
            return false;
        int count = 0;
        for (int i = 0; i < str1.length(); i++) {
            if(str1.charAt(i) != str2.charAt(i))
                ++count;
            if(count > 1)
                return false;
        }
        return count == 1;
    }
}
