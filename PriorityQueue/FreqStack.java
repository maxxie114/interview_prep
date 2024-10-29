import java.util.*;

// Solution for 895. Maximum Frequency Stack
public class FreqStack {
    private HashMap<Integer, Integer> frequencyMap;
    private Stack<Integer> stack;
    private PriorityQueue<int[]> pq;
    private int sequence;

    public FreqStack() {
        frequencyMap = new HashMap<>();
        stack = new Stack<>();
        pq = new PriorityQueue<>(new MyComparator());
        sequence = 0;
    }

    public void push(int val) {
        // Update the frequency map
        frequencyMap.put(val, frequencyMap.getOrDefault(val, 0) + 1);
        int frequency = frequencyMap.get(val);
    
        // Use the current sequence number to maintain order
        sequence++;
    
        // Add the element along with its frequency and the sequence to the priority queue
        pq.add(new int[]{frequency, sequence, val});
    
        // Push the element onto the stack to maintain insertion order
        stack.push(val);
    }

    public int pop() {
        // Poll the priority queue to get the element with the highest frequency and latest sequence
        int[] entry = pq.poll();
        int frequency = entry[0];
        int seq = entry[1];
        int val = entry[2];
        
        // Decrease the frequency of the element in the frequency map
        frequencyMap.put(val, frequency - 1);
        if (frequencyMap.get(val) == 0) {
            frequencyMap.remove(val); // If the frequency of the element becomes zero, remove it
        }
    
        return val;
    }

    public static void main(String[] args) {
        FreqStack freqStack = new FreqStack();
        freqStack.push(5);
        freqStack.push(7);
        freqStack.push(5);
        freqStack.push(7);
        freqStack.push(4);
        freqStack.push(5);
        System.out.println(freqStack.pop()); // Should print 5
        System.out.println(freqStack.pop()); // Should print 7
        System.out.println(freqStack.pop()); // Should print 5
        System.out.println(freqStack.pop()); // Should print 4
    }
}

class MyComparator implements Comparator<int[]> {
    @Override
    public int compare(int[] a, int[] b) {
        // If two numbers have the same frequency, compare the last item in the array
        if (a[0] == b[0]) {
            return Integer.compare(b[1], a[1]); // Higher sequence number first
        }
        return Integer.compare(b[0], a[0]); // Higher frequency first
    }
}