package com.app;

public class Solution {

    // http://www.techiedelight.com/maximum-sum-of-subsequence-with-no-adjacent-elements/
    public int solution2(int[] A) {
        int n = A.length;

        // base case
        if (n == 1) {
            return A[0];
        }

        // create an auxiliary array to store solution of sub-problems
        int[] lookup = new int[n];

        // lookup[i] stores the maximum sum possible till index i

        // trivial case
        lookup[0] = A[0];
        lookup[1] = Integer.max(A[0], A[1]);

        // traverse array from index 2
        for (int i = 2; i < n; i++) {
            // lookup[i] stores the maximum sum we get by

            // 1. excluding current element & take maximum sum till index i-1
            // 2. including current element A[i] and take maximum sum till index i-2
            lookup[i] = Integer.max(lookup[i - 1], lookup[i - 2] + A[i]);

            // if current element is more than max sum till current element
            // lookup[i] = Integer.max(lookup[i], A[i]);
        }

        // return maximum sum
        return lookup[n - 1];
    }
}
