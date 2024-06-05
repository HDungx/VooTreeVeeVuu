package com.VooTreeVeeVuu.domain.utils;

import java.util.Comparator;

public class AlphaNumComparator implements Comparator<String> {

	@Override
	public int compare (String o1, String o2) {
		String num1 = o1.replaceAll("\\D+", "");
		String num2 = o2.replaceAll("\\D+", "");
//		System.out.println(num1);
//		System.out.println(num2);
		int n1 = num1.isEmpty() ? 0 : Integer.parseInt(num1);
		int n2 = num2.isEmpty() ? 0 : Integer.parseInt(num2);
		return Integer.compare(n1, n2);
	}
}
