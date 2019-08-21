package algorithm.hard;

import java.util.Arrays;

/**
 * Created by shimmer on 07/04/2019
 */
/*
给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。

请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。

你可以假设 nums1 和 nums2 不会同时为空。

示例 1:

nums1 = [1, 3]
nums2 = [2]

则中位数是 2.0
示例 2:

nums1 = [1, 2]
nums2 = [3, 4]

则中位数是 (2 + 3)/2 = 2.5
 */
public class findMedianSortedArrays_0004 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] arr = new int[m + n];
        for (int i = 0; i < (m + n); i++) {
            if (i < m) {
                arr[i] = nums1[i];
                continue;
            }
            arr[i] = nums2[i - m];
        }
        Arrays.sort(arr);
        if ((m + n) % 2 == 0) {
            int index1 = (m + n) / 2 - 1;
            int index2 = (m + n) / 2;
            return (arr[index1] + arr[index2]) / 2.0;
        } else {
            return arr[(m + n) / 2];
        }
    }
}
