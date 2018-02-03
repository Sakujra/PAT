package array.easy;

public class $747LargestNumber {

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4};
        System.out.println(myDominantIndex(a));
    }

    public static int myDominantIndex(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > nums[max]) max = i;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[max] < 2 * nums[i] && max != i) return -1;
        }
        return max;
    }
}
