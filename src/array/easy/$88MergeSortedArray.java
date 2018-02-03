package array.easy;

public class $88MergeSortedArray {

    public static void main(String[] args) {
        int nums1[] = {0};
        int nums2[] = {1};
        int m = 0;
        int n = 1;
        merge2(nums1, m, nums2, n);
        for (int i : nums1) {
            System.out.print(i);
        }
    }

    //LeetCode上别人的解法，从后往前比较，不用第三个数组
    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j])
                nums1[k--] = nums1[i--];
            else
                nums1[k--] = nums2[j--];
        }
        while (j >= 0)
            nums1[k--] = nums2[j--];

    }


    //首先想到的方法，用第三个数组来暂时存放，最后再复制回去
    public static void merge1(int[] nums1, int m, int[] nums2, int n) {
        int i = 0;
        int j = 0;
        int[] merge = new int[m + n];
        for (; ; ) {
            //某一数组先结束
            if (i == m) {
                for (; j < n; j++) {
                    merge[i + j] = nums2[j];
                }
                break;
            } else if (j == n) {
                for (; i < m; i++) {
                    merge[i + j] = nums1[i];
                }
                break;
            }
            //都没有到最后一个元素时
            if (nums1[i] < nums2[j]) {
                merge[i + j] = nums1[i];
                i++;
            } else {
                merge[i + j] = nums2[j];
                j++;
            }
        }
        //将结果复制回去
        for (int q = 0; q < m + n; q++) {
            nums1[q] = merge[q];
        }
    }


}
