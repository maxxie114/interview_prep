import java.util.*;

// solution for leetcode 744: Find Smallest Letter Greater Than Target
// leetcode submission: https://leetcode.com/problems/find-smallest-letter-greater-than-target/submissions/1448417195
public class SmallestGreaterThanT {
    public char nextGreatestLetter(char[] letters, char target) {
        // edge case
        if (letters == null || letters.length == 0) {
            return letters[0];
        }
        
        // initialize left right mid
        int left = 0;
        int right = letters.length - 1;

        // nothing larger than target
        if (letters[right] <= target) {
            return letters[0];
        }

        // left == right is the key
        while (left != right) {
            int mid = left + (right - left) / 2;
            // if mid is smaller or equal to target, move left to mid+1
            if (letters[mid] <= target) {
                left = mid + 1;
            } else {
                // if mid is greater than target, move right to mid
                right = mid;
            }
        }
        return letters[right];
    }

    public static void main(String[] args) {
        // create 3 test cases
        SmallestGreaterThanT solution = new SmallestGreaterThanT();
        char[] letters = {'c', 'f', 'j'};
        char target = 'a';
        System.out.println(solution.nextGreatestLetter(letters, target)); // c
        target = 'c';
        System.out.println(solution.nextGreatestLetter(letters, target)); // f
        target = 'd';
        System.out.println(solution.nextGreatestLetter(letters, target)); // f
    }
}
