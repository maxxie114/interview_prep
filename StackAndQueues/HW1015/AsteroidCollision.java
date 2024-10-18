import java.util.*;

// Solution for leetcode 735. Asteroid Collision
class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        // Loop over the entire array
        for (int i = 0; i < asteroids.length; i++) {
            // If the stack is empty, push the current asteroid to the stack
            if (stack.isEmpty() || asteroids[i] > 0) {
                stack.push(asteroids[i]);
            } 
            // If the current asteroid is negative, start a backtrack loop
            else {
                // Keep backtracking until the stack is empty or the current asteroid is positive
                boolean destroyed = false;
                while (!stack.isEmpty() && stack.peek() > 0) {
                    // If the current asteroid is greater than the top of the stack, pop the top of the stack
                    if (stack.peek() < Math.abs(asteroids[i])) {
                        stack.pop();
                    } 
                    // If the current asteroid is equal to the top of the stack, both destroyed
                    else if (stack.peek() == Math.abs(asteroids[i])) {
                        stack.pop();
                        destroyed = true;
                        break;
                    } else {
                        // the asteroid is destroyed
                        destroyed = true;
                        break;
                    }
                }
                // If the asteroid was not destroyed, push it to the stack
                if (!destroyed) {
                    stack.push(asteroids[i]);
                }
            }
        }
        // Convert the stack to an array
        int[] result = new int[stack.size()];
        // Loop over the stack and store the elements in the array
        for (int i = stack.size() - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return result;
    }

    public static void main(String[] Args) {
        // make an edge case where the asteroids are all positive sudden there is a super huge negative
        int[] asteroids = {1000, 5, 10, 15, 20, -100};
        AsteroidCollision ac = new AsteroidCollision();
        int[] result = ac.asteroidCollision(asteroids);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]); // 10000
        }
    }
}