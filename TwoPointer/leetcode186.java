public class leetcode186 {
    public void reverseWords(char[] s) {
        // reverse the whole thing
        int left = 0;
        int right = s.length - 1;
        reverseWords(s, left, right);

        // reverse each words
        right = 0;
        while(left < s.length) {
            while (right < s.length && s[right] != ' ') {
                right++;
            }
            reverseWords(s, left, right-1);
            left = right + 1;
            right++;
        }
    }

    private void reverseWords(char[] s, int begin, int end){
        while(begin < end){
            char c = s[begin];
            s[begin] = s[end];
            s[end] = c;
            begin++;
            end--;
        }
    }
}
