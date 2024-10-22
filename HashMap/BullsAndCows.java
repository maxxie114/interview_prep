// Solution for leetcode 299

import java.util.*;
public class BullsAndCows {
    public String getHint(String secret, String guess) {
        int bulls = 0, cows = 0;
        Map<Character, Integer> secretCount = new HashMap<>();

        // First pass: count bulls and populate hashmap for secret
        for (int i = 0; i < secret.length(); i++) {
            char s = secret.charAt(i);
            char g = guess.charAt(i);
            if (s == g) {
                bulls++;
            } else {
                secretCount.put(s, secretCount.getOrDefault(s, 0) + 1);
            }
        }

        // Second pass: count cows
        for (int i = 0; i < guess.length(); i++) {
            char s = secret.charAt(i);
            char g = guess.charAt(i);
            if (s != g && secretCount.containsKey(g) && secretCount.get(g) > 0) {
                cows++;
                secretCount.put(g, secretCount.get(g) - 1);
            }
        }

        return bulls + "A" + cows + "B";
    }

    public static void main(String[] args) {
        BullsAndCows solution = new BullsAndCows();
        String secret = "1807";
        String guess = "7810";
        System.out.println(solution.getHint(secret, guess)); // Output: 1A3B
    }
}