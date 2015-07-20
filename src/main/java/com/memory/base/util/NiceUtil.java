package com.memory.base.util;

public class NiceUtil {

	private static long autoIncrease = 1;

	public static long getIncreaseLong() {
		return autoIncrease++;
	}
}
