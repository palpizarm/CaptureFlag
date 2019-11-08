package model;

import commons.IContants;

public class Walloper extends Warrior implements IContants{
	
	
	public Walloper() {
		this.attack = WALLOPER_ATTACK;
		this.delay = WALLOPER_ATTACK_DELAY;
	}
}
