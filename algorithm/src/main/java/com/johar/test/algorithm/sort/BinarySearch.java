package com.johar.test.algorithm.sort;

/**
 * @ClassName: BinarySearch
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/5/13 17:41
 * @Since: 1.0.0
 */
public class BinarySearch {

    /**
     * 二分查找
     * @param a  有序数组
     * @param n  有序数组长度
     * @param value 查找的值
     * @return 若存在，则返回数组对应的下标；否则，返回-1
     */
    public int bsearch(int[] a, int n, int value){
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
     * 查找第一个值等于给定值的元素
     * @param a
     * @param n
     * @param value
     * @return
     */
    public int bsearchFirstEq(int[] a, int n, int value){
        int low = 0;
        int high = n -1;
        while (low <= high){
            int mid = low + ((high - low) >> 1);
            if (a[mid] < value){
                low = mid + 1;
            } else if (a[mid] > value){
                high = mid - 1;
            } else {
                if (mid == 0 || a[mid -1] != value){
                    return mid;
                } else {
                    high = mid - 1;
                }
            }
        }

        return -1;
    }

    /**
     * 查找最后一个值等于给定值的元素
     * @param a
     * @param n
     * @param value
     * @return
     */
    public int bsearchLastEq(int[] a, int n, int value){
        int low = 0;
        int high = n - 1;
        while (low <= high){
            int mid = low + ((high - low) >> 1);
            if (a[mid] < value){
                low = mid + 1;
            } else if (a[mid] > value){
                high = mid - 1;
            } else {
                if (mid == n - 1 || a[mid + 1] != value){
                    return mid;
                } else {
                    low = mid + 1;
                }
            }
        }

        return -1;
    }

    /**
     * 查找第一个大于等于给定值的元素
     * @param a
     * @param n
     * @param value
     * @return
     */
    public int bsearchFirstGreater(int[] a, int n, int value){
        int low = 0;
        int high = n - 1;
        while (low <= high){
            int mid = low + ((high - low) >> 1);
            if (a[mid] < value){
                low = mid + 1;
            } else {
                if (mid == 0 || a[mid - 1] < value){
                    return mid;
                } else {
                    high = mid - 1;
                }
            }
        }

        return -1;
    }

    /**
     * 查找最后一个小于等于给定值的元素
     * @param a
     * @param n
     * @param value
     * @return
     */
    public int bsearchLastLess(int[] a, int n, int value){
        int low = 0;
        int high = n - 1;
        while (low <= high){
            int mid = low + ((high - low) >> 1);
            if (a[mid] > value){
                high = mid - 1;
            } else {
                if (mid == n - 1 || a[mid + 1] > value){
                    return mid;
                } else {
                    low = mid + 1;
                }
            }
        }

        return -1;
    }


    public int bsearch1(int[] a, int n, int value){
        return bsearchInternally(a, 0, n - 1, value);
    }

    public int bsearchInternally(int[] a, int low, int high, int value){
        if (low > high) {
            return -1;
        }

        int mid = low + ((high - low) >> 1);
        if (a[mid] == value){
            return mid;
        } else if (a[mid] < value){
            return bsearchInternally(a, mid + 1, high, value);
        } else {
            return bsearchInternally(a, low, mid - 1, value);
        }
    }
}