import java.util.*;

// Solution for leetcode 735. Asteroid Collision
class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        // Loop over the entire array
        for (int asteroid : asteroids) {
            // only loop when current asteroid is negative
            while (!stack.isEmpty() && asteroid < 0 && stack.peek() > 0) {
                if (stack.peek() < Math.abs(asteroid)) {
                    // Current asteroid is bigger, continue to check if it can destroy other asteroids
                    stack.pop();
                    continue;
                } else if (stack.peek() == Math.abs(asteroid)) {
                    stack.pop(); // Both asteroids are destroyed
                    asteroid = 0; // Current asteroid is destroyed
                } else {
                    asteroid = 0; // Current asteroid is smaller, it gets destroyed
                }
            }
            // Only push to stack if current asteroid hasn't been destroyed
            if (asteroid != 0) stack.push(asteroid); 
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