package com.bryantcs.examples.generics;

import java.util.LinkedList;

public class GenericRoleProgram {

	public static void main(String[] args) {
		LinkedList<GenericRole<String, String>> roleMap =
				new LinkedList<GenericRole<String, String>>();

		roleMap.add(new GenericRole<String, String>("Humphrey Bogart", "Sam Spade"));
		System.out.println(roleMap.getFirst().getActor() + 
				" appeared on screen as " + roleMap.getFirst().getRole()); 
	}
}