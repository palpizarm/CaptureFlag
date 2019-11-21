package model;

import commons.IContants;

public class Walloper extends Warrior implements IContants{
	
	
	public Walloper() {
		super();
		this.attack = WALLOPER_ATTACK;
		this.delay = WALLOPER_ATTACK_DELAY;
		this.type = 2;
	}
}
