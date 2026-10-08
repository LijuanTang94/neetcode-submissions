class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int left = (m + n + 1) / 2;
        int right = (m + n + 2) / 2;
        if ((m + n) % 2 != 0) return findKth(nums1, 0, m - 1, nums2, 0, n - 1, left);
        else return (findKth(nums1, 0, m - 1, nums2, 0, n - 1, left) + findKth(nums1, 0, m - 1, nums2, 0, n - 1, right)) / 2.0;
    }

    private int findKth(int[] nums1, int a, int b, int[] nums2, int c, int d, int k) {
        if (a > b) return nums2[c + k - 1];
        if (c > d) return nums1[a + k - 1];
        if (k == 1) return Math.min(nums1[a], nums2[c]);
        int half = k / 2;
        int i = Math.min(a + half - 1, b);
        int j = Math.min(c + half - 1, d);
        if (nums1[i] <= nums2[j]) {
            int removed = i - a + 1;
            return findKth(nums1, i + 1, b, nums2, c, d, k - removed);
        } else {
            int removed = j - c + 1;
            return findKth(nums1, a, b, nums2, j + 1, d, k - removed);
        }
    }
}
