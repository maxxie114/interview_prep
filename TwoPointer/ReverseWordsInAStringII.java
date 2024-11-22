// Solution for leetcode 186: Reverse Words in a String II
// leetcode submission: https://leetcode.com/problems/reverse-words-in-a-string-ii/submissions/1460159498
public class ReverseWordsInAStringII {
    public void reverseWords(char[] s) {
        // reverse the whole thing
        int left = 0;
        int right = s.length - 1;
        reverseWords(s, left, right);

        // reverse each words
        right = 0;
        while(left < s.length) {
            // find the end of the word
            while (right < s.length && s[right] != ' ') {
                right++;
            }
            // reverse the word from left to right-1
            reverseWords(s, left, right-1);
            // move left and right to the next word
            left = right + 1;
            right++;
        }
    }

    private void reverseWords(char[] s, int begin, int end){
        while(begin < end){
            char c = s[begin];
            s[begin++] = s[end];
            s[end--] = c;
        }
    }

    public static void main(String[] args) {
        // test case
        ReverseWordsInAStringII solution = new ReverseWordsInAStringII();
        char[] testString = "the sky is blue".toCharArray();
        solution.reverseWords(testString);
        System.out.println(testString); // "blue is sky the"
    }
}
