package Game;

import java.util.Random;

public class Enemy extends Methods {
	
	private int i = 5;
	
	Random rand = new Random();
	
	public Enemy() {
		
	}
	
	public void iniciarInimigo(){
		
		super.setHp(rand.nextInt(this.i));
		super.setMp(rand.nextInt(this.i));
		super.setStr(rand.nextInt(this.i));
		super.setVit(rand.nextInt(this.i));
		super.setWis(rand.nextInt(this.i));
		super.setExp(rand.nextInt(this.i));
		
		statusInimigo();
		
	}
	
	public void statusInimigo() {
		
		System.out.println("HP: " + super.getHp());
		System.out.println("MP: " + super.getMp());
		System.out.println("EXP: " + super.exp);
	}
	
	public int increase() {
		this.i = i + 1;
		return i;
		
	}
	
	
	
}