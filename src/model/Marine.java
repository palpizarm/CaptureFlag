package model;

import commons.IContants;

public class Marine extends Warrior implements IContants{
	
	
	public Marine() {
		super();
		this.attack = MARINE_ATTACK;
		this.delay = MARINE_ATTACK_DELAY;
		this.type = 3;
	}
}
