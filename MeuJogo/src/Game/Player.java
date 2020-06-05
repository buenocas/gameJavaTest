package Game;

import java.util.Random;
import java.util.Scanner;

public class Player extends Methods {
	
	Random rand = new Random();
	Scanner in = new Scanner(System.in);
	
	private String nome;
	private int Lv = 1;
	private int n = 0;
	private int chooseSkill, custo, restaure;
	private int expMAX;
	private boolean warrior, wizz, thief;
	
	
	//Iniciar Classes
		
	public void iniciarGuerreiro(){
		
		getLv();
		getNome();
		getLv();
		System.out.println("Seus status:");
		System.out.println("---------------------------------------------");
		super.setHpMAX(20);
		super.setHp(getHpMAX());
		super.setMpMAX(6);
		super.setMp(getMpMAX());
		super.setStr(10);
		super.setVit(5);
		super.setWis(2);
		super.setDex(3);
		super.setExp(0);
		setWarrior(false);
		setWizz(true);
		setThief(true);
		setExpMAX(5);
	}
	
	public void iniciarMago(){
		
		getLv();
		getNome();
		getLv();
		System.out.println("Seus status:");
		System.out.println("---------------------------------------------");
		super.setHpMAX(10);
		super.setHp(getHpMAX());
		super.setMpMAX(20);
		super.setMp(getMpMAX());
		super.setStr(2);
		super.setVit(3);
		super.setWis(15);
		super.setDex(6);
		setWizz(false);
		setWarrior(true);
		setThief(true);
		setExpMAX(5);
		
	}

	public void iniciarLadrao(){
	
		getLv();
		getNome();
		getLv();
		System.out.println("Seus status:");
		System.out.println("---------------------------------------------");
		super.setHpMAX(15);
		super.setHp(getHpMAX());
		super.setMpMAX(10);
		super.setMp(getMpMAX());
		super.setStr(6);
		super.setVit(3);
		super.setWis(7);
		super.setDex(10);
		setThief(false);
		setWizz(true);
		setWarrior(true);
		setExpMAX(5);
	
}
	
	//Alteração de Status
	
	public void setStatus() {
		
		this.setHpMAX(getHpMAX()+ n);
		this.setMpMAX(getMpMAX()+ n);
		this.setStr(getStr()+ n);
		this.setVit(getVit()+ n);
		this.setWis(getWis()+ n);
		this.setDex(getDex()+ n);
		
	}

	public void status() {
		
		System.out.println("LV: " + Lv);
		System.out.print("HPMAX: " + getHpMAX());
		System.out.println(" /  " + getHp());
		System.out.print("MP: " + getMpMAX());
		System.out.println(" /  " + getMp());
		System.out.println("STR: " + getStr());
		System.out.println("VIT: " + getVit());
		System.out.println("WIS: " + getWis());
		System.out.println("DEX: " + getDex());
		
	}
	
	public int increaseLv() {
		
		if(getExp() >= getExpMAX()) {
			System.out.println("Você subiu de nível!");
			this.n = rand.nextInt(2)+1;
			setLv(Lv+1);
			setStatus();
			status();
			restaure();
			setExpMAX(getExpMAX() + 5);
		
			
		}else {
			
		}
		
		return n;
	}

	public void restaure() {
		
		this.restaure = 0;
		
		System.out.println("Você restaura um pouco da sua força !!");
		
		System.out.println("--------------------------------------------------------------------");
		
		if(isWarrior() != true)	{
	
			if(getHp() < (getHpMAX() -2)) {
			
				setHp(getHp() + 2);
				
				System.out.println("HP: " + getHpMAX() + " / " + getHp());
				
				restaure = 1;
				
			}else if((getHp() < (getHpMAX() -1) ) && (restaure == 0)) {
			
				setHp(getHp() + 1);
				
				System.out.println("HP: " + getHpMAX() + " / " + getHp());
				
			}else {
				System.out.println("HP: " + getHpMAX() + " / " + getHp());
				
			}if(getMp() < (getMpMAX() -1)) {
				setMp(getMp() +1);
				
				System.out.println("MP: " + getMpMAX() + " / " + getMp());
				
			}else {
				
				System.out.println("MP: " + getMpMAX() + " / " + getMp());
			}
			
		}else if (isWizz() != true) {
			
			if(getHp() < (getHpMAX() -1)) {
			
				setHp(getHp() + 1);
				
				System.out.println("HP: " + getHpMAX() + " / " + getHp());
				
			}else {
				System.out.println("HP: " + getHpMAX() + " / " + getHp());
				
			} if(getMp() < (getMpMAX() -2)) {
				
				setMp(getMp() + 2);
				
				restaure = 1;
				
				System.out.println("MP: " + getMpMAX() + " / " + getMp());
			
			} else if(getMp() < (getMpMAX() -1) && (restaure == 0)) {
				
				setMp(getMp() +1);
				
				System.out.println("MP: " + getMpMAX() + " / " + getMp());
				
			}else {
				System.out.println("MP: " + getMpMAX() + " / " + getMp());
			}
			
			
		}else if (isThief() != true) {
			
			if(getHp() < (getHpMAX() -2)) {
				
				setHp(getHp() + 2);
				
				System.out.println("HP: " + getHpMAX() + " / " + getHp());
				
				restaure = 1;
				
			}else if((getHp() < (getHpMAX() -1) ) && (restaure == 0)) {
			
				setHp(getHp() + 1);
				
				System.out.println("HP: " + getHpMAX() + " / " + getHp());
				
			}else {
				System.out.println("Seu HP está cheio");
				
			}if(getMp() < (getMpMAX() -1)) {
				setMp(getMp() +1);
				
				System.out.println("MP: " + getMpMAX() + " / " + getMp());
				
			}else {
				System.out.println("MP: " + getMpMAX() + " / " + getMp());
			}
			
			
		}else {
			System.out.println("nullTEST");
		}
		
	}
	
	
	
	// Skill LIST USE
	
	public void skillList() {
		
		if(isWarrior() != true)	{
			warriorSkills();
			
		}else if (isWizz() != true) {
			wizzSkills();
			
		}else if (isThief() != true) {
			thiefSkills();
			
		}else {
			System.out.println("nullTEST");
		}
	
	}
	
	public void warriorSkills() {
		
		System.out.println("LISTA DE SKILLS: 1 - GOLPEAR (MP 3) / 2 - SACRIFÍCIO (MP 4 / HP 25%) ");
	
		chooseSkill = in.nextInt();
		
		switch (chooseSkill) {
		
		case 1:
			System.out.println("Você usa sua habilidade GOLPEAR!");
			golpear();
			
			break;
		
		case 2:
			System.out.println("Você usa sua habilidade SACRIFÍCIO");
			sacrificio();
			break;
			default:
				System.out.println("Você optou por não fazer nada");
		
		}
	}
	
	public void wizzSkills() {
		
		System.out.println("LISTA DE SKILLS: 1 - MISSÍL MÁGICO (MP 2) / 2 - BOLA DE FOGO (MP 5) ");
	
		chooseSkill = in.nextInt();
		
		switch (chooseSkill) {
		
		case 1:
			System.out.println("Você usa sua habilidade MISSÍL MÁGICO!");
			missilMagico();
			break;
		
		case 2:
			System.out.println("Você usa sua habilidade BOLA DE FOGO");
			bolaFogo();
			break;
			default:
				System.out.println("Você optou por não fazer nada");
		
		}
	}

	public void thiefSkills() {
	
	System.out.println("LISTA DE SKILLS: 1 - ATAQUE CERTEIRO (MP 3) / 2 - DEGOLAR (MP 9) ");

	chooseSkill = in.nextInt();
	
	switch (chooseSkill) {
	
	case 1:
		System.out.println("Você usa sua habilidade ATAQUE CERTEIRO");
		ataqueCerteiro();
		break;
	
	case 2:
		System.out.println("Você usa sua habilidade DEGOLAR");
		degolar();
		break;
		default:
			System.out.println("Você optou por não fazer nada");
	
	}
}


//Skill list Warrior

private int golpear() {
	
	custo = 3;
	
	if(getMp() >= custo) {
	
	super.setMp(getMp() - custo);
	
	super.setDano(super.getStr() + (super.dmgDiceRoll() / 2));
	
	}else {
		System.out.println("Você não tem MP para usar a Habilidade");
		super.setDano(0);
	}
	return getDano();
}

private int sacrificio() {
	
	custo = 4;
	
	if((getMp() >= custo ) && (getHp() > 2)) {
	
	super.setMp(getMp() - custo);
	super.setHp(getHp() - Math.round((getHp()*25/100)));
	
	super.setDano(getHp() + (super.getStr() + (super.dmgDiceRoll() / 2)));
	
	}else {
		System.out.println("Você não tem MP para usar a Habilidade");
		super.setDano(0);
	}
	return getDano();
}

// Skill list Wizz

private int missilMagico() {
	
	this.custo = 2;
	
	if(getMp() >= custo) {
		
		super.setMp(getMp() - custo);
		
		super.setDano(super.getWis() + (super.getWis()/2));
		
		
	}else {
		System.out.println("Você não tem MP para usar a Habilidade");
		super.setDano(0);
	}
	return getDano();
}

private int bolaFogo() {
	
	custo = 5;

	if(getMp() >= custo) {
		
	super.setMp(getMp() - custo);
	super.setDano(super.wisDiceRoll() + super.getWis()/2);
	
	}else {
		
	System.out.println("Você não tem MP para usar a Habilidade");
	super.setDano(0);
	}
	return getDano();
}


// Skill List Thief


private int ataqueCerteiro() {
	
	custo = 3;
	
	if(getMp() >= custo) {
	
	super.setMp(getMp() - custo);
	
	if(this.dexDiceRoll() > 10) {
		
		System.out.println("Dano Crítico!");
	
	super.setDano(super.dmgDiceRoll() + Math.round((super.dmgDiceRoll() / 4) + (super.dexDiceRoll()/3)));
	
	}else {
		
	super.setDano(super.dmgDiceRoll() + Math.round((super.dmgDiceRoll() / 6) + (super.dexDiceRoll()/5)));
		
	}
	
	}else {
		System.out.println("Você não tem MP para usar a Habilidade");
		super.setDano(0);
	}
	return getDano();
}

private int degolar() {
	
	custo = 9;
	
	if(getMp() >= custo) {
	
	super.setMp(getMp() - custo);
	
	if(this.dexDiceRoll() > 20) {
		
		System.out.println("Dano Crítico!");
	
	super.setDano(super.dmgDiceRoll() + Math.round((super.getDex()/2) + (super.dexDiceRoll())));
	
	}else {
		
	super.setDano(super.dmgDiceRoll() + Math.round((super.getDex()) / 4) + (super.dexDiceRoll()/2));
		
	}
	
	}else {
		System.out.println("Você não tem MP para usar a Habilidade");
		super.setDano(0);
	}
	return getDano();
}


	
	//Gets and Sets

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getLv() {
		return Lv;
	}
	
	public void setLv(int lv) {
		Lv = lv;
	}

	public boolean isWarrior() {
		return warrior;
	}

	public boolean setWarrior(boolean warrior) {
		this.warrior = warrior;
		return warrior;
	}

	public boolean isWizz() {
		return wizz;
	}

	public boolean setWizz(boolean wizz) {
		this.wizz = wizz;
		return wizz;
	}

	public int gainEXP(int exp) {
		
		return exp;
		
	}

	public boolean isThief() {
		return thief;
	}

	public boolean setThief(boolean thief) {
		this.thief = thief;
		return thief;
	}
	
	public int getExpMAX() {
		return expMAX;
	}

	public void setExpMAX(int expMAX) {
		this.expMAX = expMAX;
	}

	
	
	
}
