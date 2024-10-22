import java.util.*;

// Solution for Leetcode 49
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        // The result list
        List<List<String>> result = new ArrayList<>();
        // A list to store hashmaps representing each group of anagrams
        List<Map<Character, Integer>> hashMapList = new ArrayList<>();

        for (String str : strs) {
            Map<Character, Integer> currentMap = new HashMap<>();

            // Populate the character frequency map for the current word
            for (char c : str.toCharArray()) {
                currentMap.put(c, currentMap.getOrDefault(c, 0) + 1);
            }

            // Try to find the currentMap in the hashMapList
            boolean found = false;
            for (int i = 0; i < hashMapList.size(); i++) {
                if (hashMapList.get(i).equals(currentMap)) {
                    // If a matching hashmap is found, add the word to the corresponding group
                    result.get(i).add(str);
                    found = true;
                    break;
                }
            }

            // If no matching hashmap is found, create a new group
            if (!found) {
                hashMapList.add(currentMap);
                List<String> newGroup = new ArrayList<>();
                newGroup.add(str);
                result.add(newGroup);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        GroupAnagrams solution = new GroupAnagrams();
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> groupedAnagrams = solution.groupAnagrams(input);
        System.out.println(groupedAnagrams);
    }
}
