package model;

import commons.IContants;

public class Marine extends Warrior implements IContants{
	
	
	public Marine() {
		this.attack = MARINE_ATTACK;
		this.delay = MARINE_ATTACK_DELAY;
	}
}
