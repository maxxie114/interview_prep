import java.util.*;

// solution for leetcode 69: Sqrt(x)
public class SqrtOfX {
    // sqrt(x) is basically looking for a number where its square is largest smaller than or equals to x
    // leetcode submission: https://leetcode.com/problems/sqrtx/submissions/1448486665
    public int mySqrt(int x) {
        // edge case
        if (x == 0) {
            return 0;
        }

        // initialize left right
        int left = 1; // 0 is already handled
        int right = x;

        // left <= right is the key, because we want to find the largest smaller than or equals to x
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // use long to avoid overflow
            long squareMid = (long) mid * mid;
            // if mid square is bigger than x, move right to mid - 1
            if (squareMid > x) {
                right = mid - 1;
            // if mid square is smaller than x, instead of moving left to mid, we move left to mid + 1
            // because we can be sure that mid is not the answer
            // even if mid is the answer, we can find it in the next iteration
            } else if (squareMid < x) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        // return right because right is the largest smaller than or equals to x
        return right;
    }

    public static void main(String[] args) {
        // test case
        SqrtOfX sol = new SqrtOfX();
        int x = 9;
        System.out.println(sol.mySqrt(x)); // expect 3
        x = 8;
        System.out.println(sol.mySqrt(x)); // expect 2
        x = 2147395599;
        System.out.println(sol.mySqrt(x)); // expect 46339
        x = 5;
        System.out.println(sol.mySqrt(x)); // expect 2
    }
}
