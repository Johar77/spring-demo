package com.johar.test.algorithm.search;

/**
 * @ClassName: BinarySearch
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/1/21 11:13
 * @Since: 1.0.0
 */
public class BinarySearch {

    /**
     * 有序数组中不存在重复元素，我们在其中用二分查找值等于给定值的数据
     * @param a
     * @param n
     * @param value
     * @return
     */
    public static int bsearch(int[] a, int n, int value){
        int low = 0;
        int high = n - 1;
        while (low <= high){
            int mid = low + ((high - low) >> 1);
            if (a[mid] == value){
                return mid;
            } else if (a[mid] < value){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    /**
     * 有序数据集合中存在重复的数据,查找第一个值等于给定值的元素
     * @param a
     * @param n
     * @param value
     * @return
     */
    public static int bsearch1(int[] a, int n, int value){
        int low = 0;
        int high = n - 1;
        while (low <= high){
            int mid = low + ((high - low) >> 1);
            if (a[mid] > value){
                high = mid - 1;
            } else if (a[mid] < value){
                low = mid + 1;
            } else {
                if ((mid == 0) || (a[mid - 1] != value)){
                    return mid;
                } else {
                    high = mid - 1;
                }
            }
        }

        return -1;
    }

    /**
     * 有序数据集合中存在重复的数据,查找最后一个值等于给定值的元素
     * @param a
     * @param n
     * @param value
     * @return
     */
    public static int bsearch2(int[] a, int n, int value){
        int low = 0;
        int high = n - 1;
        while (low <= high){
            int mid = low + ((high - low) >> 1);
            if (a[mid] > value){
                high = mid - 1;
            } else if (a[mid] < value){
                low = mid + 1;
            } else {
                if ((mid == n - 1) || (a[mid + 1] != value)){
                    return mid;
                } else {
                    low = mid + 1;
                }
            }
        }

        return -1;
    }

    /**
     * 有序数据集合中存在重复的数据,查找第一个大于等于给定值的元素
     * @param a
     * @param n
     * @param value
     * @return
     */
    public static int bsearch3(int[] a, int n, int value){
        int low = 0;
        int high = n - 1;
        while (low <= high){
            int mid = low + ((high - low) >> 1);
            if (a[mid] >= value){
                if (mid == 0 || a[mid - 1] < value){
                    return mid;
                } else {
                    high = mid - 1;
                }
            } else if (a[mid] < value){
                low = mid + 1;
            }
        }

        return -1;
    }

    /**
     * 有序数据集合中存在重复的数据,查找最后一个小于等于给定值的元素
     * @param a
     * @param n
     * @param value
     * @return
     */
    public static int bsearch4(int[] a, int n, int value){
        int low = 0;
        int high = n - 1;
        while (low <= high){
            int mid = low + ((high - low) >> 1);
            if (a[mid] > value){
                high = mid - 1;
            } else if (a[mid] <= value){
                if (mid == n - 1 || a[mid + 1] > value){
                    return mid;
                } else {
                    low = mid + 1;
                }
            }
        }

        return -1;
    }


    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7,8,9};
        System.out.println(bsearch(a, a.length, 5));


        int[] a1 = {1,2,3,4,5,6,7,8,8,8,8,8,9};
        System.out.println(bsearch1(a1, a1.length, 8));
        System.out.println(bsearch2(a1, a1.length, 8));
        System.out.println(bsearch3(a1, a1.length, 8));
        System.out.println(bsearch4(a1, a1.length, 8));
    }

}