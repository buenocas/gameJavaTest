package Game;

import java.util.Random;

public class Player extends Methods {
	
	Random rand = new Random();
	
	private String nome;
	private int Lv = 1;
	private int n = 0;
	private int expMAX = 5;
	
	
	public void iniciarGuerreiro(){
		
		getLv();
		getNome();
		getLv();
		System.out.println("Seus status:");
		System.out.println("---------------------------------------------");
		super.setHp(20 + this.n);
		super.setMp(6 + this.n);
		super.setStr(10 + this.n);
		super.setVit(5 + this.n);
		super.setWis(2 + this.n);
		super.setDex(3 + this.n);
		super.setExp(0);
		
		
	}
	
public void iniciarMago(){
		
		super.setHp(10 + this.n);
		super.setMp(20 + this.n);
		super.setStr(2 + this.n);
		super.setVit(3 + this.n);
		super.setWis(15 + this.n);
		super.setDex(6 + this.n);
		getNome();
		
	}

public void iniciarLadrao(){
	
	super.setHp(15 + this.n);
	super.setMp(10 + this.n);
	super.setStr(6 + this.n);
	super.setVit(3 + this.n);
	super.setWis(7 + this.n);
	super.setDex(10 + this.n);
	getNome();
	
}
	
	public void status() {
		
		System.out.println("LV: " + Lv);
		System.out.println("HP: " + getHp());
		System.out.println("MP: " + getMp());
		System.out.println("STR: " + getStr());
		System.out.println("VIT: " + getVit());
		System.out.println("WIS: " + getWis());
		System.out.println("DEX: " + getDex());
		
	}
	
	
	
	//Gets and Sets

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int increaseLv() {
		
		if(getExp() >= expMAX) {
			System.out.println("Você subiu de nível!");
			this.n = rand.nextInt(2);
			setLv(Lv+1);
			setStatus();
			status();
			
			this.expMAX = (expMAX + 2)*2;
			
		}else {
			
		}
		
		return n;
	}

	public int getLv() {
		return Lv;
	}
	
	public void setLv(int lv) {
		Lv = lv;
	}

	public int gainEXP(int exp) {
		
		return exp;
		
	}
	
	public void setStatus() {
		this.setHp(getHp()+ n);
		this.setMp(getMp()+ n);
		this.setStr(getStr()+ n);
		this.setVit(getVit()+ n);
		this.setWis(getWis()+ n);
		this.setDex(getDex()+ n);
		
	}

}
