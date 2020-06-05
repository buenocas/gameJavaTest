package Game;

import java.util.Random;

public abstract class Methods {
	
	private int hp, hpMAX;
	private int mp, mpMAX;
	private int str;
	private int vit;
	private int wis;
	private int dex;
	private int dadoSTR, dadoDEX, dadoDEF, dano , esquiva, block, dadoWIS;
	protected int exp;
	private boolean sucess;
	
	protected Methods() {
		
	}
	
	Random rand = new Random();
	

	//Dados


protected int dmgDiceRoll() {
	
	if(getStr() < 6) {
		
		 return dadoSTR = rand.nextInt(6);
	}else if ((getStr() > 6) && (getStr() < 10)) {
		
		return dadoSTR = rand.nextInt(10) + getStr();
		
	}else if ((getStr() > 10) && (getStr() < 16)) {
		
		return dadoSTR = rand.nextInt(16) + getStr();
		
	}else if (getStr() > 16){
		
		return dadoSTR = rand.nextInt(20) + getStr();
	}else {
		
		return dadoSTR = rand.nextInt(6) + getStr();
	}	
	
	
	
}

protected int dexDiceRoll() {
	
	 if ((getDex() > 6) && (getDex() < 11)) {
		
		return dadoDEX = rand.nextInt(10) + getDex();
		
	}else if ((getDex() > 16) && (getDex() < 21)) {
		
		 return dadoDEX = rand.nextInt(16) + getDex();
		
	}else if (getDex() > 20){
		
		return dadoDEX = rand.nextInt(20) + getDex();
	}else {
		
		return dadoDEX = rand.nextInt(7) + getDex();
	}	
	
}

protected int wisDiceRoll () {
	
	if(getWis() < 6) {
		
		 return dadoWIS = rand.nextInt(6);
	}else if ((getWis() > 6) && (getWis() < 10)) {
		
		return dadoWIS = rand.nextInt(10) + getWis();
		
	}else if ((getWis() > 10) && (getWis() < 16)) {
		
		return dadoWIS = rand.nextInt(16) + getWis();
		
	}else if (getStr() > 16){
		
		return dadoWIS = rand.nextInt(20) + getWis();
	}else {
		
		return dadoWIS = rand.nextInt(6) + getWis();
	}	
	
}





//Gets and Sets

public int getHp() {
	return hp;
}


public void setHp(int hp) {
	this.hp = hp;
}


public int getMp() {
	return mp;
}


public void setMp(int mp) {
	this.mp = mp;
}


public int getStr() {
	return str;
}


public void setStr(int str) {
	this.str = str;
}


public int getVit() {
	return vit;
}


public void setVit(int vit) {
	this.vit = vit;
}


public int getWis() {
	return wis;
}


public void setWis(int wis) {
	this.wis = wis;
}


public int getDex() {
	return dex;
}


public void setDex(int dex) {
	this.dex = dex;
}


public int getDadoSTR() {
	return dadoSTR;
}


public void setDadoSTR(int dadoSTR) {
	this.dadoSTR = dadoSTR;
}


public int getDadoDEX() {
	return dadoDEX;
}


public void setDadoDEX(int dadoDEX) {
	this.dadoDEX = dadoDEX;
}


public int getDadoDEF() {
	return dadoDEF;
}


public void setDadoDEF(int dadoDEF) {
	this.dadoDEF = dadoDEF;
}


public int getDano() {
	return dano;
}


public void setDano(int dano) {
	this.dano = dano;
}


public int getEsquiva() {
	return esquiva;
}


public void setEsquiva(int esquiva) {
	this.esquiva = esquiva;
}


public int getBlock() {
	return block;
}


public void setBlock(int block) {
	this.block = block;
}


public boolean isSucess() {
	return sucess;
}


public void setSucess(boolean sucess) {
	this.sucess = sucess;
}


public int getExp() {
	return exp;
}


public void setExp(int exp) {
	this.exp = exp;
}



public int getHpMAX() {
	return hpMAX;
}

public void setHpMAX(int hpMAX) {
	this.hpMAX = hpMAX;
}

public int getMpMAX() {
	return mpMAX;
}

public void setMpMAX(int mpMAX) {
	this.mpMAX = mpMAX;
}


}
