package com.zhangqi.common;

import java.util.Random;

/**
 * 随机工具类
 * @author Administrator
 *
 */
public class RandomUtil {

	/**
	 * 获取最小数和最大数之间的随机数
	 * @param: min
	 * @param: max
	 * @return: int
	 */
	public static int random(int min,int max) {
		Random random = new Random();
		return min+random.nextInt(max-min);
	}
	/**
	 * 获取最小数和最大数之间的多个随机数
	 * @param: min
	 * @param: max
	 * @return: int[]
	 */
	public static int[] random(int min,int max,int num) {
		int[] intArray = new int[num];
		for (int i = 0; i < num; i++) {
			intArray[i] = random(min, max);
		}
		return intArray;
	}
}
