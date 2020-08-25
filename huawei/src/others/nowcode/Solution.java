package others.nowcode;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

/**
 * @author admin_cg
 * @date 2020/8/9 19:18
 */
public class Solution {
    public static void main(String[] args) {
        String s = "1000";
        Solution recoveryIP = new Solution();
        List<String> ls =  recoveryIP.restoreIpAddresses(s);
        for (String i: ls ) {
            System.out.println(i);
        }
    }
    List<String> list = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        int[] iptmp = new int[4];
//        backtrack(s, 0, 0, iptmp);
        dfs(s, 0, 0, iptmp);
        return list;
    }

    public void backtrack(String s, int start, int segmentNum, int[] segments) {
        // 到达结束条件
        if (segmentNum == 4) {
            if (start == s.length()) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < 3; i++) {
                    sb.append(segments[i]).append(".");
                }
                sb.append(segments[3]);
                list.add(sb.toString());
            }
            return;
        }

        // 提前回溯
        if (start == s.length()) {
            return;
        }

        // 约束条件，0开头，特别处理
        if (s.charAt(start) == '0') {
            segments[segmentNum] = 0;
            backtrack(s, start + 1, segmentNum + 1, segments);
        }

        int temp = 0;
        for (int end = start; end < s.length(); end++) {
            // 做选择
            temp = temp * 10 + (s.charAt(end) - '0');
            if (temp > 0 && temp <= 255) {
                segments[segmentNum] = temp;
                backtrack(s, end + 1, segmentNum + 1, segments);
            } else {    // 这个break极为重要，没有的话会产生错误答案
                break;
            }
        }
    }

    public void dfs(String s, int ip, int start, int[] ipTmp) {
        if(ip == 4){
            if(start == s.length()){
                StringJoiner sj = new StringJoiner(".");
                for(int in : ipTmp){
                    sj.add(String.valueOf(in));
                }
                list.add(sj.toString());
            }
            return;
        }

        if(start == s.length())
            return;

        if(s.charAt(start) == '0'){
            ipTmp[ip] = 0;
            dfs(s, ip+1, start + 1, ipTmp);
        }

        int tmp = 0;
        for(int cur = start; cur < s.length(); cur++){
            tmp = tmp*10 + (s.charAt(cur) - '0');
            if(tmp > 0 && tmp <= 255){
                ipTmp[ip] = tmp;
                dfs(s, ip+1, cur+1, ipTmp);
            }
            else{
                break;
            }
        }
    }
}
