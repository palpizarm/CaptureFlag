package model;

import commons.IContants;

public class Acher extends Warrior  implements IContants{
	
	public Acher() {
		super();
		this.attack = ARCHER_ATTACK;
		this.delay = ARCHER_ATTACK_DELAY;
	}
}
