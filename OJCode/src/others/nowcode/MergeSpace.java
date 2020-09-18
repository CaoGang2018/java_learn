package others.nowcode;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author admin_cg
 * @date 2020/9/12 15:00
 */

class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e;
    }
}
public class MergeSpace {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        intervals.sort((o1, o2) -> o1.start == o2.start ? o1.end - o2.end : o1.start - o2.start);
        ArrayList<Interval> ans = new ArrayList<>();
        if( intervals.size() == 0) return  ans;
        ans.add(intervals.get(0));
        for (int i = 1; i < intervals.size(); i++) {
            if(intervals.get(i).start <= ans.get(ans.size() - 1).end){
                Interval s = ans.get(ans.size() - 1);
                ans.remove(ans.size() - 1);
                ans.add(new Interval(s.start, Math.max(s.end, intervals.get(i).end)));
            }
            else ans.add(intervals.get(i));
        }
        return ans;
    }
}
