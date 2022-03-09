package top_interview_question.easy.array;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    /**
     * 
     * time O(n^2)
     * space O(1)
     * time >>> space => 利用space來改善time
     * 第一個for,計算matchNumber
     * 第二個for,loop nums找有沒有對應的matchNumber
     */
    public int[] twoSumBruteForce(int[] nums, int target) {
        if (nums.length <= 1)
            return null;

        for (int i = 0; i < nums.length; i++) {
            int matchNumber = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == matchNumber) {
                    int[] arr = { i, j };
                    return arr;
                }
            }
        }

        return null;
    }

    /**
     * 
     * time O(n)
     * space O(n)
     * 
     * 第一個for,計算matchNumber, 並從hashmap找有沒有對應的matchNumber
     * 沒有的話把自己放到hashmap, 當作別人的matchNumber候選人
     * hashmap找資料只要time O(1) => 用空間換取時間
     * 
     */
    public int[] twoSumOptimal(int[] nums, int target) {
        if (nums.length <= 1)
            return null;

        HashMap match = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            int matchNumber = target - nums[i];

            if (match.get(matchNumber) != null) {
                int[] arr = { (int) match.get(matchNumber), i };
                return arr;
            } else {
                // nums[i], index
                match.put(nums[i], i);
            }
        }

        return null;
    }

    public static void main(String[] args) {

        int[] numsArray = { 1, 3, 7, 9, 2 };
        int target = 11;

        TwoSum aa = new TwoSum();
        System.out.println("return array: " + Arrays.toString(aa.twoSumOptimal(numsArray, target)));

    }
}
