// Solution for leetcode 125: Valid Palindrome
// Leetcode submission: https://leetcode.com/problems/valid-palindrome/submissions/1460155506
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        // corner case
        if (s == null || s.length() == 0) {
            return true;
        }

        // two pointers
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            while (i < j && !Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            }
            while (i < j && !Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            }

            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                return false;
            }

            // move pointers
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        // test case
        ValidPalindrome solution = new ValidPalindrome();
        String testString = "A man, a plan, a canal: Panama";
        System.out.println(solution.isPalindrome(testString)); // true
    }
}
