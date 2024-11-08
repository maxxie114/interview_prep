import java.util.*;

// Solution for Leetcode problem 702. Search in a Sorted Array of Unknown Size
// Leetcode submission: https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/submissions/1446539945
class SortedArrayUnknownSize {
    public int search(ArrayReader reader, int target) {
        if (reader == null) {
            return -1;
        }
        
        int left = 0;
        int right = 1; // Initialize right boundary to 1

        // Loop to find the right boundary, which is the first element that is larger than the target
        // This is necessary because we are using the ArrayReader interface, which does not have a size() method
        while (reader.get(right) < target) {
            left = right;
            right = right * 2; // Double the right boundary
        }
        
        while (left <= right) {
            // This way it won't go overbound
            int mid = left + (right - left) / 2;
        
            if (reader.get(mid) == target) {
                return mid;
            }  else if (reader.get(mid) > target) {
                right = mid - 1; // mid is useless, remove
            } else {
                left =  mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        // test case
        int[] array = {-1, 0, 3, 5, 9, 12}; // Your test array
        int target = 9; // Target to search for
        ArrayReader reader = new ArrayReaderImpl(array);
        SortedArrayUnknownSize solution = new SortedArrayUnknownSize();

        int index = solution.search(reader, target);
        System.out.println("Target index: " + index); // Should print 4, which is the index of 9
    }
}

// Define the ArrayReader interface
interface ArrayReader {
    int get(int index);
}

// Implement the ArrayReader interface for testing
class ArrayReaderImpl implements ArrayReader {
    private int[] array;

    public ArrayReaderImpl(int[] array) {
        this.array = array;
    }

    @Override
    public int get(int index) {
        // Return Integer.MAX_VALUE if index is out of bounds
        if (index < 0 || index >= array.length) {
            return Integer.MAX_VALUE;
        }
        return array[index];
    }
}