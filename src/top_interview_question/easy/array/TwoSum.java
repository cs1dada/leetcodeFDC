package top_interview_question.easy.array;

import java.lang.reflect.Array;
import java.util.Arrays;

public class TwoSum {

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

    public static void main(String[] args) {

        int[] numsArray = { 1, 3, 7, 9, 2 };
        int target = 11;

        TwoSum aa = new TwoSum();
        System.out.println("return array: " + Arrays.toString(aa.twoSumBruteForce(numsArray, target)));

    }
}
