package array.easy;

import java.util.HashMap;
import java.util.Map;

public class $1TwoSum {

    public static void main(String[] args) {
        int[] nums = {2, 4, 6, 7};
        int target = 9;
        int[] re1 = approach3(nums, target);
        for (int num : re1
                ) {
            System.out.println(num);
        }
    }

    //#1 Brute Force
    public static int[] approach1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    //#2 Two-pass Hash Table
    public static int[] approach2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int implement = target - nums[i];
            if (map.containsKey(implement) && map.get(implement) != i) {
                //注意两个值的顺序
                return new int[]{i, map.get(implement)};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    //#3 One-pass Hash Table
    public static int[] approach3(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            //我写的
//            map.put(nums[i], i);
//            int implement = target - nums[i];
//            if(map.containsKey(implement)&&map.get(implement) != i)
//                    return new int[]{map.get(implement),i};
            //答案写的
            int comlement = target - nums[i];
            if (map.containsKey(comlement)) {
                //注意两个值的顺序
                return new int[]{map.get(comlement), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

}
