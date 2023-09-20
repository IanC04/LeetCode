package Medium.minimumoperationstoreducextozero;

import java.util.*;

class Solution {
    public int minOperations(int[] nums, int x) {
        int answer = 0;
        int[] prefixSum = new int[nums.length + 1];
        for (int i = 1; i < prefixSum.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }
        int leftPointer = 0, rightPointer = 1;
        int subarraySum = prefixSum[prefixSum.length - 1] - x;
        if(subarraySum < 0) {
            return -1;
        }
        if(subarraySum == 0) {
            return nums.length;
        }

        // My solution, not the fastest, fastest is the sliding windows with two pointers. I reset the right pointer
        // even though it's not needed in the case of the sliding windows solution.
        int currentSubarray;
        for(; leftPointer < prefixSum.length; leftPointer++) {
            rightPointer = leftPointer + answer + 1;
            if(rightPointer >= prefixSum.length) {
                break;
            }
            currentSubarray = prefixSum[rightPointer] - prefixSum[leftPointer];
            for (; currentSubarray <= subarraySum && rightPointer < prefixSum.length; rightPointer++) {
                currentSubarray = prefixSum[rightPointer] - prefixSum[leftPointer];
                /*System.out.printf("leftPointer: %d, rightPointer: %d, currentSubarray: %d, answer: %d\n", leftPointer,
                        rightPointer, currentSubarray, answer);*/
                if (currentSubarray == subarraySum) {
                    answer = rightPointer - leftPointer;
                    break;
                }
            }
        }

        if(answer == 0) {
            return -1;
        }
        return nums.length - answer;
    }
}