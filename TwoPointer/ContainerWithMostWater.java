import java.lang.Math;
// Solution for leetcode 11. Container With Most Water
// leetcode submission: https://leetcode.com/problems/container-with-most-water/submissions/1460149678
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        // initialize result as the first possible result
        // use height[left] and height[right] instead of left and right because the height of the container is determined by the shorter side
        int result = (right - left) * Math.min(height[left], height[right]);
        // loop until left and right meet
        while (left < right) {
            // move the shorter side to the center
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
            int curHeight = (right - left) * Math.min(height[left], height[right]);
            result = Math.max(result, curHeight);
        }
        return result;
    }

    public static void main(String[] Args) {
        // test case
        int[] height = {1,8,6,2,5,4,8,3,7};
        ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();
        System.out.println(containerWithMostWater.maxArea(height)); // 49
    }
}
