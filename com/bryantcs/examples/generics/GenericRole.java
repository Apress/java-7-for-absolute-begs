package com.bryantcs.examples.generics;

public class GenericRole<Actor, Role> {

	private Actor actor;
	private Role role;

	public GenericRole(Actor p, Role a) {
		actor = p;
		role = a;
	}

	public Actor getActor() {
		return actor;
	}

	public Role getRole() {
		return role;
	}
}