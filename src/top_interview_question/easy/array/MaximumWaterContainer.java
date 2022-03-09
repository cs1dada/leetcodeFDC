package top_interview_question.easy.array;

public class MaximumWaterContainer {

    /**
     * 
     * time O(n^2)
     * space O(1)
     * time >>> space => 利用space來改善time
     */
    public int maxAreaBruteForce(int[] height) {
        if (height.length <= 1)
            return 0;

        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int temp = Math.min(height[i], height[j]) * (j - i);
                if (temp > maxArea) {
                    maxArea = temp;
                }
            }

        }

        return maxArea;

    }

    public static void main(String[] args) {

        int[] numsArray = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        int target = 49;

        MaximumWaterContainer aa = new MaximumWaterContainer();
        System.out.println("maxArea: " + aa.maxAreaBruteForce(numsArray));

    }
}
