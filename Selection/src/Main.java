public class Main {

    public static void main(String[] args) {
        // 生成一个大小为n, 包含0...n-1这n个元素的随机数组arr
        int N = 10000;
        Integer[] arr;


        arr = TestHelper.generateOrderedArray(N);
        TestHelper.shuffleArray(arr);

        // 验证Selection.solve2, 对arr数组求第i大元素, 应该为i-1
        // 因为在Selection.solve2中, 第k大元素的k是从1索引的
       /* for( int i = 1 ; i <= N ; i ++ ){
            assert Selection.solve2(arr, i).compareTo(i - 1) == 0;
            System.out.println("test " + i + " complete.");
        }
        System.out.println("Test Selection.solve2 completed.");*/
        int count = 0;
        for( int i = 0 ; i < N ; i ++ ){
            System.out.print( + arr[i] + " ");
            count ++;
            if(count % 10 == 0)
            System.out.println();
        }
        int k = 1000;
        System.out.print("第" + k + "大的元素是" + Selection.solve2(arr,k));


    }
}
