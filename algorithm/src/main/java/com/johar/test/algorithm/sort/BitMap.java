package com.johar.test.algorithm.sort;

import java.io.Serializable;
import java.util.Random;

/**
 * @ClassName: BitMap
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/5/13 09:05
 * @Since: 1.0.0
 */
public class BitMap implements Serializable {
    private static final long serialVersionUID = 1L;

    private final int capacity;
    private byte[] data;
    private static final byte BIT_1 = 0x01;

    public BitMap(int capacity){
        this.capacity = capacity;
        int num = (capacity >>> 3) + 1;
        this.data = new byte[num];
    }

    public boolean addElement(int num){
        if (num < 0){
            return false;
        }
        if (num > capacity){
            return false;
        }

        int index = num >>> 3;
        int i =  (num & 7);
        data[index] = (byte) (data[index] | (BIT_1 << i));
        return true;
    }

    public boolean exist(int num){
        if (num < 0){
            return false;
        }
        if (num > capacity){
            return false;
        }

        int index = num >>> 3;
        byte temp = data[index];
        int i =  (num & 7);
        if ((temp & (BIT_1 << i)) == 0){
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        int count = 100;
        BitMap bitMap = new BitMap(count);
        Random random = new Random();
        for (int i = 0; i < count; i++){
            bitMap.addElement(random.nextInt(count));
        }

        int num = random.nextInt(100);
        System.out.println(num + ":" + bitMap.exist(num));
        num = random.nextInt(100);
        System.out.println(num + ":" + bitMap.exist(num));
        num = random.nextInt(100);
        System.out.println(num + ":" + bitMap.exist(num));
        num = random.nextInt(100);
        System.out.println(num + ":" + bitMap.exist(num));
        num = random.nextInt(100);
        System.out.println(num + ":" + bitMap.exist(num));
        num = random.nextInt(100);
        System.out.println(num + ":" + bitMap.exist(num));
        num = random.nextInt(100);
        System.out.println(num + ":" + bitMap.exist(num));
        num = random.nextInt(100);
        System.out.println(num + ":" + bitMap.exist(num));
    }
}