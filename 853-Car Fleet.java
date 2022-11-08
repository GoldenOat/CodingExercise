import java.util.*;

/**
 * 853-Car Fleet
 * https://leetcode.com/problems/car-fleet/description/
 */
class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        // base case
        if (position.length == 1) return 1;
        // 2d array to represent position and speed combination
        int[][] combine = new int[position.length][2];
        for (int i = 0; i < position.length; i ++) {
            combine[i][0] = position[i];
            combine[i][1] = speed[i];
        }
        // sort car by the starting position
        Arrays.sort(combine, Comparator.comparingInt(o -> o[0]));
        Deque<Double> stack = new ArrayDeque<>();
  		// loop on each car from the end to beginning
  		// calculate its time to arrive the target, record the currtime
  		// if another car need less or equal time, it can catch up;
  		// If another car needs more time, it will be the new slowest car, and becomes the new lead of a car fleet.
        for (int i = combine.length - 1; i >= 0; i --) {
            Double currTime = (double) (target - combine[i][0]) / combine[i][1];
            if (!stack.isEmpty() && currTime <= stack.peekFirst()) {
                continue;
            } else {
                stack.offerFirst(currTime);
            }
        }
        return stack.size();
    }
}
/*
TC: O(NlogN + N)
O(NlogN) Quick sort the cars by position. (Other sort can be applied)
O(N) One pass for all cars from the end to start (another direction also works).

SC: O(N)
*/



