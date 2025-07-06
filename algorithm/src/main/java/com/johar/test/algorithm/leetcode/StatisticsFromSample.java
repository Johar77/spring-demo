package com.johar.test.algorithm.leetcode;

/**
 * @ClassName: StatisticsFromSample
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/5/27 18:13
 * @Since: 1.0.0
 */
public class StatisticsFromSample {

    /**
     * 我们对0到255之间的整数进行采样，并将结果存储在数组count中：count[k]就是整数k 在样本中出现的次数。
     *
     * 计算以下统计数据:
     *
     * minimum：样本中的最小元素。
     * maximum：样品中的最大元素。
     * mean：样本的平均值，计算为所有元素的总和除以元素总数。
     * median：
     * 如果样本的元素个数是奇数，那么一旦样本排序后，中位数 median 就是中间的元素。
     * 如果样本中有偶数个元素，那么中位数median 就是样本排序后中间两个元素的平均值。
     * mode：样本中出现次数最多的数字。保众数是 唯一 的。
     * 以浮点数数组的形式返回样本的统计信息[minimum, maximum, mean, median, mode]。与真实答案误差在10-5内的答案都可以通过。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/statistics-from-a-large-sample
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param count
     * @return
     */
    public double[] sampleStats(int[] count) {
        double minimum = Double.MAX_VALUE;
        double maximum = Double.MIN_VALUE;
        double mean = 0d;
        double median = 0d;
        double mode = 0d;
        int length = count.length;
        int total = 0;
        int maxTime = 0;
        for (int i = 0; i < length; i++){
            int data = count[i];
            if (data > 0){
                if (i < minimum){
                    minimum = i;
                }
                if (i > maximum){
                    maximum = i;
                }
                if (data > maxTime){
                    maxTime = data;
                    mode = i;
                }
                total += data;
            }
        }

        boolean evenNum = total % 2 == 0;
        int half = total >> 1;
        if (!evenNum){
            half += 1;
        }
        boolean checkMedian = true;
        double totalDouble = total;
        for (int i = 0; i < length; i++){
            int data = count[i];
            if (data > 0){
                mean += (i * data) / totalDouble;
                half -= data;
                if (checkMedian && half <= 0){
                    if (evenNum){
                        if (median == 0 && half < 0){
                            median = i;
                            checkMedian = false;
                        } else {
                            if (median > 0){
                                median += i;
                                median = median / 2.0d;
                                checkMedian = false;
                            } else {
                                median += i;
                            }
                        }
                    } else {
                        median = i;
                        checkMedian = false;
                    }
                }
            }
        }

        return new double[] { minimum, maximum, mean, median, mode };
    }
}