package com.PizzaOrdering;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PizzaOrder {

	public static void main(String[] args) {
		Pizza p1 = new Pizza("Chicken Pizza", 699);
		Pizza p2 = new Pizza("Pasta Pizza", 599);
		Pizza p3 = new Pizza("Mushroom Pizza", 499);
		
		Map<Integer,Pizza> mymap = new HashMap<>();
		mymap.put(01, p1);
		mymap.put(02, p2);
		mymap.put(03, p3);
		
		System.out.println("-----welcome to pizza App-----");
		System.out.println("Select your pizza from below menu");
		System.out.println(mymap);
		
		Scanner Scan = new Scanner(System.in);
		int srnu = Scan.nextInt();
		Pizza selected = mymap.get(srnu);
		System.out.println("you selected"+ srnu + selected.getName() +" price is " + selected.getPrice());
		
		System.out.println("How many u want");
		
		int quaninty = Scan.nextInt();
		int total = selected.get(srnu);
		
		System.out.println("you selected" + quaninty  + selected.getName() + " price is "+ selected.getPrice() + total);;
		
		
		

	}

}
