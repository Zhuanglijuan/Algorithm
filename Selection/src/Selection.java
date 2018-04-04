/**
 * Created by Zhuang on 2018/4/4.
 */
public class Selection {
    private Selection(){}

    private static int  partition(Comparable[] arr, int l,int r){
        swap(arr,l,(int )(Math.random() * (r - l + 1)) + l);

        Comparable v = arr[l];

        int lt = l;     // arr[l+1...lt] > v
        int gt = r + 1; // arr[gt...r] < v
        int i = l+1;    // arr[lt+1...i) == v
        while( i < gt ){
            if( arr[i].compareTo(v) > 0 ){
                swap( arr, i, lt+1);
                i ++;
                lt ++;
            }
            else if( arr[i].compareTo(v) < 0 ){
                swap( arr, i, gt-1);
                gt --;
            }
            else{ // arr[i] == v
                i ++;
            }
        }

        swap( arr, l, lt );

        return lt;
    }

    //求出nums[l ... r]范围里第k大的数
    private static Comparable solve(Comparable[] nums, int l ,int r, int k){
        if(l == r)
            return nums[l];

        int p = partition(nums,l,r);

        if(k == p){
            return nums[p];
        }

        else if(k < p)
            return solve(nums,l,p-1,k);

        else// 如果 k > p, 则需要在nums[p+1...r]中找第k-p-1小元素
            // 注意: 由于我们传入__selection的依然是nums, 而不是nums[p+1...r],
            //       所以传入的最后一个参数依然是k, 而不是k-p-1
            return solve(nums,p + 1,r,k);
    }

    //寻找nums数组第k大的元素
    //k是从0开始索引的，即最大的元素是第0大元素
    public static Comparable solve(Comparable nums[],int k){

        assert nums != null && k >= 0 && k < nums.length;
        return solve(nums,0,nums.length - 1, k);
    }

    //寻找nums数组第k大的元素,k从1开始索引,即最大元素是第1大元素,以此类推
    public static Comparable solve2(Comparable nums[], int k){
        return solve(nums, k - 1);
    }

    private static void  swap(Object[] arr,int i , int j){
        Object temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
