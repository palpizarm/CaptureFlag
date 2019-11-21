package model;

import commons.IContants;

public abstract class Warrior  implements IPersonage, IContants{
	protected int attack;
	protected int energy;
	protected float delay;
	protected int type = 0;
	
	public Warrior() {
		energy = ENERGEY;
	}
	
	public int attack() {
		return attack;
	}
	
	public void lostEnergy(float pAttack) {
		energy -= pAttack;
		if (energy < 0) 
			energy = 0;
	}
	
	public boolean isDie() {
		return (energy == 0);
	}
	
	public int getType() {
		return type;
	}
}
