import java.util.Scanner;

/**
 * @author admin_cg
 * @date 2020/8/6 16:04
 */
public class Topscore {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String[] nm = sc.nextLine().split(" ");
            int n = Integer.parseInt(nm[0]), m = Integer.parseInt(nm[1]);
            int[] scores = new int[n];
            String[] sco = sc.nextLine().split(" ");
            for(int i = 0; i < n; i++)
                scores[i] = Integer.parseInt(sco[i]);

            for(int i = 0; i < m; i++){
                String[] in = sc.nextLine().split(" ");
                if(in[0].equals("Q")){
                    System.out.println(maxScore(scores, Integer.parseInt(in[1]), Integer.parseInt(in[2])));
                }
                else{
                    scores[Integer.parseInt(in[1])-1] = Integer.parseInt(in[2]);
                }
            }
        }

    }

    public static int maxScore(int[] nums, int s, int e){
        int st = Math.min(s, e);
        int se = Math.max(s, e);
        int max = nums[st-1];
        for(int i = st; i < se; i++){
            if(nums[i] > max)
                max = nums[i];
        }
        return max;
    }
}
