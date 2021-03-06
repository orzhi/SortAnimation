package pri.weiqiang.sortanimation.algorithm;

import java.util.Arrays;

/**
 * 数组的排序，用于理解各个排序,java debug运行可以查看变量变化
 */
public class Sort {
    static int[] a8 = {40, 60, 30, 80, 50, 20, 90, 20, 10, 70};
    static int[] a7 = {3, 2, 1};
    static int[] a5 = {22, 3, 2, 1, 0, 5, 4};
    static int[] a4 = {22, 3, 2, 1, 0, 5, 4};
    static int[] a3 = {22, 3, 2, 1, 0, 5, 4};
    static int[] a = {2, 3, 6, 11};
    static int[] b = {1, 4, 8, 9};
    static int[] c = new int[a.length + b.length];
    static int[] a1 = {2, 3, 6, 11, 2, 3, 4};
    static int[] a6 = {5, 4, 3, 1, 0, 2, 6};

    // 直接在Debug下查看数组变化，特别容易理解
    public static void main(String[] args) {

//        quickSort(a6, 0, a6.length - 1);
//		memeryArray(a, a.length, b, b.length, c);
//		sort(a1, 0, a1.length-1);
//		selectSort(a3);
//		pubbleSort(a4);
//		InsertSort(a5);
        HeerSort(a7);
//        shellSort(a7);
//        sort(a7);
//		HeapSort.sortHeap();
        //查找
//		binarySearch(a8);
        System.out.println("Finished……");
    }


    private static void binarySearch(int[] a) {

        System.out.println("二分法查找");
        int target = 80;
        Arrays.sort(a);
        boolean result = false;
        int min = 0;
        int b = 0;
        int max = a.length - 1;
        while (min <= max) {
            b = (min + max) / 2;
            if (target > a[b]) {
                min = b + 1;
            }
            if (target < a[b]) {
                max = b - 1;
            }
            if (target == a[b]) {
                min++;
                result = true;

            }

        }
        System.out.println("result:" + result + ",b:" + b);
    }

    //正确 https://www.cnblogs.com/zengzhihua/p/4456734.html
    public static void shellSort(int[] a) {
        System.out.println("希尔排序");
        int n = a.length;
        int d = n / 2;
        while (d > 0) {
            for (int i = d; i < n; i++) {
                int j = i - d;
                while (j >= 0 && a[j] > a[j + d]) {
                    int tmp = a[j];
                    a[j] = a[j + d];
                    a[j + d] = tmp;
                    j = j - d;
                }
            }
            d = d / 2;
        }
        for (int o : a) {
            System.out.print(o + ",");
        }
    }

    //    static int[] a7 = {3, 2, 5, 4,1}; 错误 排序后的结果为2 1 3 4 5
    // 希尔排序 https://blog.csdn.net/csdn_aiyang/article/details/73108606
    @Deprecated
    private static void HeerSort(int[] a) {
        System.out.println("希尔排序");
        int d = a.length / 2;
        //判断是否为基数 a%2！=0
        if ((a.length & 1) == 1) {
            System.out.println("数组大小为奇数 间隔需要+1 否则循环将少一次 排序将错误");
            d++;
        }
        while (true) {
            for (int i = 0; i < d; i++) {
                for (int j = i; j + d < a.length; j += d) {
                    int temp;
                    if (a[j] > a[j + d]) {
                        temp = a[j];
                        a[j] = a[j + d];
                        a[j + d] = temp;
                    }
                }
            }

            if (d == 1) {
                break;
            }
            d--;
        }
        for (int o : a) {
            System.out.print(o + ",");
        }

    }


    //正确 https://www.cnblogs.com/LeslieXia/p/5814571.html
    public static void sort(int[] arr) {
        System.out.println("希尔排序 new");
        // i表示希尔排序中的第n/2+1个元素（或者n/4+1）
        // j表示希尔排序中从0到n/2的元素（n/4）
        // r表示希尔排序中n/2+1或者n/4+1的值
        int i, j, r, tmp;
        // 划组排序
        for (r = arr.length / 2; r >= 1; r = r / 2) {
            for (i = r; i < arr.length; i++) {
                tmp = arr[i];
                j = i - r;
                // 一轮排序
                while (j >= 0 && tmp < arr[j]) {
                    arr[j + r] = arr[j];
                    j -= r;
                }
                arr[j + r] = tmp;
            }
            System.out.println(i + ":" + Arrays.toString(arr));
        }
    }

    // 插入排序 https://blog.csdn.net/csdn_aiyang/article/details/73108606
    private static void InsertSort(int[] a) {
        System.out.println("插入排序");
        long t1 = System.nanoTime();
        // 直接插入排序
        for (int i = 1; i < a.length; i++) {
            // 待插入元素
            int temp = a[i];
            int j;
            for (j = i - 1; j >= 0; j--) {
                // 将大于temp的往后移动一位
                if (a[j] > temp) {
                    a[j + 1] = a[j];
                } else {
                    break;
                }
            }
            a[j + 1] = temp;// 插入进来
        }
        for (int q = 0; q < a.length; q++) {
            System.out.print(a[q] + ",");
        }
    }

    // 冒泡 https://blog.csdn.net/csdn_aiyang/article/details/73108606
    private static void pubbleSort(int[] numbers) {
        System.out.println("冒泡排序");
        int temp;// 记录临时变量
        int size = numbers.length;// 数组大小
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {// 索引不同的两层for循环
                if (numbers[i] < numbers[j]) {// 交互数据从大到小排列顺序 大的放前面
                    temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }
        for (int q = 0; q < numbers.length; q++) {
            System.out.print(numbers[q] + ",");
        }
    }

    // 堆排序代码实现 https://www.cnblogs.com/Java3y/p/8639937.html

    // 选择排序 https://blog.csdn.net/csdn_aiyang/article/details/73108606
    public static void selectSort(int[] array) {
        System.out.println("选择排序");
        int min;
        int tmp = 0;
        for (int i = 0; i < array.length; i++) {
            min = array[i];
            for (int j = i; j < array.length; j++) {
                if (array[j] < min) {
                    min = array[j];// 最小值
                    tmp = array[i];
                    array[i] = min;
                    array[j] = tmp;
                }
            }
        }
        for (int q = 0; q < array.length; q++) {
            System.out.print(array[q] + ",");
        }

    }

    // 将有序数组a[]和b[]合并到c[]中
    public static void memeryArray(int a[], int n, int b[], int m, int c[]) {
        int i, j, k;

        i = j = k = 0;
        while (i < n && j < m) {
            if (a[i] < b[j])
                c[k++] = a[i++];
            else
                c[k++] = b[j++];
        }
        for (int q = 0; q < c.length; q++) {
            System.out.print(c[q] + ",");
        }
        System.out.println();
        // 可能会有一组数列没有完全遍历到，因为上边循环是&&
        while (i < n)
            c[k++] = a[i++];

        for (int q = 0; q < c.length; q++) {
            System.out.print(c[q] + ",");
        }
        System.out.println();

        while (j < m)
            c[k++] = b[j++];

        for (int q = 0; q < c.length; q++) {
            System.out.print(c[q] + ",");
        }
    }

    // 归并算法 https://www.cnblogs.com/of-fanruice/p/7678801.html
    public static int[] sort(int[] a, int low, int high) {
        System.out.println("归并排序!");
        int mid = (low + high) / 2;
        if (low < high) {
            sort(a, low, mid);
            sort(a, mid + 1, high);
            // 左右归并
            merge(a, low, mid, high);
        }
        return a;
    }

    public static void merge(int[] a, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low;
        int j = mid + 1;
        int k = 0;
        // 把较小的数先移到新数组中
        while (i <= mid && j <= high) {
            if (a[i] < a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
            }
        }
        // 把左边剩余的数移入数组
        while (i <= mid) {
            temp[k++] = a[i++];
        }
        // 把右边边剩余的数移入数组
        while (j <= high) {
            temp[k++] = a[j++];
        }
        // 把新数组中的数覆盖nums数组
        for (int x = 0; x < temp.length; x++) {
            a[x + low] = temp[x];
        }
        for (int q = 0; q < a.length; q++) {
            System.out.print(a[q] + ",");
        }
        System.out.println();
    }

    // 快速排序
    public static void quickSort(int[] a, int low, int high) {
        int start = low;
        int end = high;
        int key = a[low];

        while (end > start) {

            // 从后往前比较// 如果没有比关键值小的，比较下一个，直到有比关键值小的交换位置，然后又从前往后比较
            while (end > start && a[end] >= key)
                end--;
            if (a[end] <= key) {
                int temp = a[end];
                a[end] = a[start];
                a[start] = temp;
                System.out.println("key:" + key + ",从后往前比较 end:" + end + ",a[end]:" + a[end] + ",start:" + start + ",a[start]:" + a[start]);
                System.out.println("---start:" + start);
            }
            // 从前往后比较// 如果没有比关键值大的，比较下一个，直到有比关键值大的交换位置
            while (end > start && a[start] <= key)
                start++;
            if (a[start] >= key) {
                int temp = a[start];
                a[start] = a[end];
                a[end] = temp;
                System.out.println("key:" + key + ",从前往后比较 end:" + end + ",a[end]:" + a[end] + ",start:" + start + ",a[start]:" + a[start]);
                System.out.println("---end:" + end);
            }
            // 此时第一次循环比较结束，关键值的位置已经确定了。左边的值都比关键值小，右边的值都比关键值大，但是两边的顺序还有可能是不一样的，进行下面的递归调用
        }
        StringBuilder sb = new StringBuilder("a6 =");
        for (int i = 0; i < a6.length; i++) {
            sb.append(a6[i] + ",");

        }
        System.out.println("sb:" + sb.toString());
        // 递归
        if (start > low) {
            System.out.println("**************************************************");
            System.out.println("迭代******start > low!" + ",start:" + start + ",low:" + low);
            quickSort(a, low, start - 1);// 左边序列。第一个索引位置到关键值索引-1
        }
        if (end < high) {
            System.out.println("**************************************************");
            System.out.println("迭代*******end < high!" + ",end:" + end + ",high:" + high);
            quickSort(a, end + 1, high);// 右边序列。从关键值索引+1到最后一个
        }
    }

    /**
     * 堆排序：Java
     *
     * @author skywang
     * @date 2014/03/11
     */

    public static class HeapSort {

        /*
         * (最大)堆的向下调整算法
         *
         * 注：数组实现的堆中，第N个节点的左孩子的索引值是(2N+1)，右孩子的索引是(2N+2)。
         *     其中，N为数组下标索引值，如数组中第1个数对应的N为0。
         *
         * 参数说明：
         *     a -- 待排序的数组
         *     start -- 被下调节点的起始位置(一般为0，表示从第1个开始)
         *     end   -- 截至范围(一般为数组中最后一个元素的索引)
         */
        public static void maxHeapDown(int[] a, int start, int end) {
            int c = start; // 当前(current)节点的位置
            int l = 2 * c + 1; // 左(left)孩子的位置
            int tmp = a[c]; // 当前(current)节点的大小

            for (; l <= end; c = l, l = 2 * l + 1) {
                // "l"是左孩子，"l+1"是右孩子
                if (l < end && a[l] < a[l + 1])
                    l++; // 左右两孩子中选择较大者，即m_heap[l+1]
                if (tmp >= a[l])
                    break; // 调整结束
                else { // 交换值
                    a[c] = a[l];
                    a[l] = tmp;
                }
            }

            System.out.printf("(最大)二叉堆\n");
            for (int i = 0; i < a.length; i++)
                System.out.printf("%d ", a[i]);
            System.out.printf("\n");
        }

        /*
         * 堆排序(从小到大)
         *
         * 参数说明：
         *     a -- 待排序的数组
         *     n -- 数组的长度
         */
        public static void heapSortAsc(int[] a, int n) {
            int i, tmp;

            // 从(n/2-1) --> 0逐次遍历。遍历之后，得到的数组实际上是一个(最大)二叉堆。
            for (i = n / 2 - 1; i >= 0; i--)
                maxHeapDown(a, i, n - 1);


            // 从最后一个元素开始对序列进行调整，不断的缩小调整的范围直到第一个元素
            for (i = n - 1; i > 0; i--) {
                // 交换a[0]和a[i]。交换后，a[i]是a[0...i]中最大的。
                tmp = a[0];
                a[0] = a[i];
                a[i] = tmp;
                // 调整a[0...i-1]，使得a[0...i-1]仍然是一个最大堆。
                // 即，保证a[i-1]是a[0...i-1]中的最大值。
                maxHeapDown(a, 0, i - 1);
            }
        }

        /*
         * (最小)堆的向下调整算法
         *
         * 注：数组实现的堆中，第N个节点的左孩子的索引值是(2N+1)，右孩子的索引是(2N+2)。
         *     其中，N为数组下标索引值，如数组中第1个数对应的N为0。
         *
         * 参数说明：
         *     a -- 待排序的数组
         *     start -- 被下调节点的起始位置(一般为0，表示从第1个开始)
         *     end   -- 截至范围(一般为数组中最后一个元素的索引)
         */
        public static void minHeapDown(int[] a, int start, int end) {
            int c = start; // 当前(current)节点的位置
            int l = 2 * c + 1; // 左(left)孩子的位置
            int tmp = a[c]; // 当前(current)节点的大小

            for (; l <= end; c = l, l = 2 * l + 1) {
                // "l"是左孩子，"l+1"是右孩子
                if (l < end && a[l] > a[l + 1])
                    l++; // 左右两孩子中选择较小者
                if (tmp <= a[l])
                    break; // 调整结束
                else { // 交换值
                    a[c] = a[l];
                    a[l] = tmp;
                }
            }
        }

        /*
         * 堆排序(从大到小)
         *
         * 参数说明：
         *     a -- 待排序的数组
         *     n -- 数组的长度
         */
        public static void heapSortDesc(int[] a, int n) {
            int i, tmp;

            // 从(n/2-1) --> 0逐次遍历每。遍历之后，得到的数组实际上是一个最小堆。
            for (i = n / 2 - 1; i >= 0; i--)
                minHeapDown(a, i, n - 1);

            // 从最后一个元素开始对序列进行调整，不断的缩小调整的范围直到第一个元素
            for (i = n - 1; i > 0; i--) {
                // 交换a[0]和a[i]。交换后，a[i]是a[0...i]中最小的。
                tmp = a[0];
                a[0] = a[i];
                a[i] = tmp;
                // 调整a[0...i-1]，使得a[0...i-1]仍然是一个最小堆。
                // 即，保证a[i-1]是a[0...i-1]中的最小值。
                minHeapDown(a, 0, i - 1);
            }
        }

        public static void sortHeap() {
            System.out.println("堆排序");
            int i;
            int a[] = {1, 2, 4, 3, 0};

            System.out.printf("before sort:");
            for (i = 0; i < a.length; i++)
                System.out.printf("%d ", a[i]);
            System.out.printf("\n");

            heapSortAsc(a, a.length); // 升序排列
            // heapSortDesc(a, a.length); // 降序排列

            System.out.printf("after  sort:");
            for (i = 0; i < a.length; i++)
                System.out.printf("%d ", a[i]);
            System.out.printf("\n");
        }
    }

}
