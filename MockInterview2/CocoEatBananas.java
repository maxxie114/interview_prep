// Solution for leetcode problem: 875. Koko Eating Bananas
// Submission: https://leetcode.com/problems/koko-eating-bananas/submissions/1471564610
class CocoEatBananas {
    public int minEatingSpeed(int[] piles, int h) {
        // edge case
        if (piles == null || piles.length == 0) {
            return 0;
        }
        int left = 1;
        int right = 0;
        int mid;
        // get the max
        for (int i: piles) {
            if (i > right) {
                right = i;
            }
        }

        while (left < right) {
            mid = left + (right - left) / 2;
            // First check if the sum of the eating time is less than or equal to h
            // Do not flip the order of the two if statements
            if (sumEatingTime(piles, mid) <= h) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        // check if both left and right and see if they match the condition
        if (sumEatingTime(piles, left) <= h) {
            return left;
        }

        if (sumEatingTime(piles, right) <= h) {
            return right;
        }
        return 0;
    }

    public int sumEatingTime(int[]piles, int k) {
        int sum = 0;
        for (int i: piles) {
            // If i mod k is not zero, that means the two numbers can't be fully divided
            // So an addition of a 1 is needed
            if (i % k != 0) {
                sum += i/k + 1;
            // If it can be fully divided, such as 8/4, then 1 is not needed
            } else {
                sum += i/k;
            }
        }
        return sum;
    }

    public static void main(String[] Args) {
        // test case
        int[] piles = {3, 6, 7, 11};
        int h = 8;
        CocoEatBananas test = new CocoEatBananas();
        System.out.println(test.minEatingSpeed(piles, h)); // 4
    }
}


/*

[3,     6,      7,      11] h = 8
1 -> 11
3/4 + 6/4 + 7/4 + 11/4 <= 8
O(n^2)

finding smallest number that when adding everything up is less than 8, between 1 and 11

[1,2,3,4,5,6,7,8,9,10,11]
       l
       r
       m

l = 1
r = 11
m = r - (l + 11) / 2

if sum(mid) is less than h, move l to mid+1
if sum(mid) is more than or equal to h, move r to mid

[30,    11,     23,       4,    20] h=5
1 -> 30f
*/
