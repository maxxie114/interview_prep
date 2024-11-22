public class leetcode125 {
    isPalindrome(s) {
        for i from 0 to s.length, j from s.length - 1 to 0 {
            while (i < j and char i is not a digit or letter) {
                i++
            }
            while (i < j and char j is not a digit or letter) {
                j--
            }

            if (i < j and char i is not equal to char j) {
                return false
            }
        }
        return true
    }
}
