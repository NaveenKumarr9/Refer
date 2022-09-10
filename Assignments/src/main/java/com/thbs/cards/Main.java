package com.thbs.cards;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Set<Card> set = new HashSet<>();

		for (int i = 0; i < 8; i++) {
			System.out.println("Enter a card");
			Card card = new Card();

			card.setSymbol(scan.nextLine().charAt(0));
			card.setNumber(scan.nextInt());
			scan.nextLine();
			set.add(card);

		}

		System.out.println("Four symbols gathered in 8 cards.");
		System.out.println("Cards in Set are :");
		for (Card card : set) {
			System.out.println(card.getSymbol() + " " + card.getNumber());
		}
		scan.close();
	}

}
