import java.util.*;

// Sum to Number: Given an array of integers and a target number, find two numbers in the array that sum to the target number.
public class SumToNumber {
    public ArrayList<int[]> getPairs(int[] input, int target) {
        // Value, Indices[]
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        ArrayList<int[]> result = new ArrayList<>();
        
        // putting all of the index into the map
        for (int i = 0; i < input.length; i++) {
            if (map.containsKey(input[i])) {
                map.get(input[i]).add(i);
                continue;
            }
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(i);
            map.put(input[i], temp); 
        }
        
        // loop through all the items and put them into the result
        for (int i = 0; i < input.length; i++) {
            if (map.containsKey(target - input[i])) {
                ArrayList<Integer> temp = map.get(target -  input[i]);
                for (int index: temp) {
                    if (i != index) { // ensure indices are different to avoid duplicates
                        // curIndex, index in the map
                        int[] indexPairs = new int[] {i, index};
                        result.add(indexPairs); 
                    }
                }
                map.remove(input[i]); // remove the current element to avoid duplicates
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // test case
        SumToNumber sumToNumber = new SumToNumber();
        int[] input = {1, 2, 3, 4, 5};
        int target = 5;
        ArrayList<int[]> pairs = sumToNumber.getPairs(input, target);
        for (int[] pair : pairs) {
            System.out.println(Arrays.toString(pair)); // output: 0, 3 and 1, 2
        }
    }
}
        
