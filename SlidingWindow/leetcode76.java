public class leetcode76 {
    minWindow(s, t) {
        Map tmap;
        for (each characters in the string t) {
            put the character in the map
        }

        matches = 0
        slows = 0
        resultStart = 0
        resultLength = max value of int

        for fast from 0 to s.legnth {
            curchar = s.charAt(fast)
            curcount = tmap.get(curchar)

            if curcount is not null {
                curcount--
                if curcount is 0 {
                    matches++
                }
                update the count of the curChar in the map
            }

            while matches == tmap.size {
                curlength = fast - slows + 1
                if curlength < resultLength {
                    resultLength = curlength
                    resultStart = slows
                }
                curchar = s.charAt(slows)
                curcount = tmap.get(curchar)
                if curcount is not null {
                    curcount++
                    if curcount > 0 {
                        matches--
                    }
                    update the count of the curChar in the map
                }
                slows++
            }
        }
    }
}
