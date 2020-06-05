package Game;

import java.util.Random;

public class Enemy extends Methods {
	
	private int i = 2;
	
	Random rand = new Random();
	
	public Enemy() {
		
	}
	
	public void iniciarInimigo(){
		
		super.setHp(rand.nextInt(this.i)+1);
		super.setMp(rand.nextInt(this.i)+1);
		super.setStr(rand.nextInt(this.i)+1);
		super.setVit(rand.nextInt(this.i)+1);
		super.setWis(rand.nextInt(this.i)+1);
		super.setExp(rand.nextInt(this.i)+1);
		
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