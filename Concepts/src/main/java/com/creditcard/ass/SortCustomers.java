package com.creditcard.ass;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SortCustomers {

	static List<CreditCard> sortKeys(Set<CreditCard> keyset) {
		List<CreditCard> list = new LinkedList<>();
		list.addAll(keyset);
		Collections.sort(list);
		return list;
	}

	public static void main(String[] args) {
		Map<CreditCard, Customer> map = new LinkedHashMap<CreditCard, Customer>();

		map.put(new CreditCard(101, "Naveen", 123, 2001), new Customer("Naveen", 111));
		map.put(new CreditCard(102, "Kumar", 145, 2024), new Customer("Kumar", 222));
		map.put(new CreditCard(103, "Raju", 133, 2027), new Customer("Raju", 333));
		map.put(new CreditCard(104, "Ravi", 126, 2030), new Customer("Ravi", 444));
		map.put(new CreditCard(105, "vishnu", 134, 1995), new Customer("vishnu", 555));

		Map<CreditCard, Customer> resmap = new LinkedHashMap<CreditCard, Customer>();

		List<CreditCard> ls = sortKeys(map.keySet());
		for (CreditCard cc : ls) {
			resmap.put(cc, map.get(cc));
		}
		Iterator<Map.Entry<CreditCard, Customer>> itr = resmap.entrySet().iterator();

		while (itr.hasNext()) {
			Map.Entry<CreditCard, Customer> entry = itr.next();
			System.out.println(entry.getKey());

		}

//		for (CreditCard x : resmap.keySet()) {
//			System.out.println(x);
//		}
	}
}