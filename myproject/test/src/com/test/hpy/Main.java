package com.test.hpy;

public class Main {
    static StringTest test = new StringTest();
    public static void main(String[] args) {
        int[] arrays = {1,2,3,0,0,0,0};
        int[] nums2 = {2,5,6};



        merge(arrays,3,nums2,3);
        for (int k: arrays) {
            System.out.print(k);
        }
//        System.out.println(Arrays.toString(twoSum(arrays,9)));
    }
    public static int[] twoSum(int[] arrays,int target){
        int left = 0,right = arrays.length - 1;
        int sum;
        while(left < right){
            sum = arrays[left] + arrays[right];
            if(sum == target)break;
            if(sum < target) ++left;
            else --right;
        }
        return new int[]{left + 1,right + 1};
    }
    public static void merge(int[] nums1,int m, int[] nums2, int n){
        int pos = m-- + n-- - 1;
        while(m >= 0 && n >= 0){
            nums1[pos--] = nums1[m] > nums2[n] ? nums1[m--] : nums2[n--];
        }
        while( n >= 0){
            nums1[pos--] = nums2[n--];
        }
    }
}