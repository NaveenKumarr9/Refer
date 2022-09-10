package com.DateTimeApi;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public class MonthSort {
	public static void main(String[] args) throws Exception {
		List<String> list = new ArrayList<String>();
		list.add("MAY");
		list.add("APRIL");
		list.add("JANUARY");
		list.add("MARCH");
		list.add("MAY");

		Map<Integer, String> mis = new LinkedHashMap<Integer, String>();
		for (int i = 0; i < list.size(); i++) {
			Date date = new SimpleDateFormat("MMMM", Locale.ENGLISH).parse(list.get(i));
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			int n = cal.get(Calendar.MONTH);

			mis.put(n + 1, list.get(i));

		}
		Set<Integer> l2 = new LinkedHashSet<Integer>(mis.keySet());
		List<Integer> l3 = new ArrayList<Integer>(l2);
		Collections.sort(l3);

		Map<Integer, String> map = new LinkedHashMap<Integer, String>();
		for (Integer i : l3) {
			map.put(i, mis.get(i));
		}
		System.out.println(map.values());
	}

}
