package others.leecode;

import java.util.Arrays;

/**
 * 设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。
 * @author admin_cg
 * @date 2020/8/13 16:51
 */
public class Solution17_14 {
    public int[] smallestK(int[] arr, int k) {
        if(arr == null || arr.length == 0 || k == 0) return new int[0];
        if(k >= arr.length) return arr;
        /*
        int idx = partition(arr, 0, arr.length-1);
        if(idx == k-1) return Arrays.copyOf(arr, k);
        while(idx != k-1){
            if(idx < k-1){
                idx = partition(arr, idx+1, arr.length-1);
            }
            else if(idx > k-1){
                idx = partition(arr, 0, idx-1);
            }
        }
         */
        int low = 0, high = arr.length-1;
        while(low < high){
            int p = partition(arr, low, high);
            if(p == k-1) break;;
            if(p < k-1){
                low = p +1;
            }
            else {
                high = p -1;
            }
        }
        return Arrays.copyOf(arr, k);
    }

    public int partition(int[] arr, int i, int j){
        int t = arr[i];
        while(i < j){
            while(j > i &&  arr[j] >= t) j--;
            arr[i] = arr[j];
            while(i < j &&  arr[i] <= t) i++;
            arr[j] = arr[i];
        }
        arr[j] = t;
        return j;

    }

}
