package Game;


import java.util.Scanner;

public class Game {

	public static void main(String[] args ) {
		
		int dano, score = 0, check = 0;
		String nome, classe, escolha;
		boolean sucess = false;
		
		
		Player player = new Player();
		Enemy enemy = new Enemy();
		
		Scanner in = new Scanner(System.in);

		System.out.println("Bem vinde ao meu primeiro teste de jogo com estudo de classes e m�todos !!");
		
		System.out.print(" Insira o seu nome: ");
		
		nome = in.nextLine();
		
		player.setNome(nome);
		
		
		do {
			
			System.out.println("Insira a Classe com que quer jogar ! g para Guerreiro, m para Mago, l para Ladr�o");
			
			classe = in.nextLine();
			
			
			if(classe.contentEquals("g")) {
				
				System.out.println(player.getNome() + " escolheu Guerreiro!!");
				
				player.iniciarGuerreiro();
				player.status();
				
				check = 0;
				
			}
			else if(classe.contentEquals("m")) {
				
				System.out.println(player.getNome() + " escolheu Mago!!");
				
				player.iniciarMago();
				player.status();
				
				check = 0;
				
			}
			else if(classe.contentEquals("l")) {
				
				System.out.println(player.getNome() + " escolheu Ladr�o!!");
				
				player.iniciarLadrao();
				player.status();				
				check = 0;
			}
			else {
				
				System.out.println("Escolha errada, tente novamente.");
				
				check = 1;
				
			}
		}while(check != 0);
		
		
		System.out.println("Sua jornada come�ar� agora " + nome + "!! Seu objetivo � ir o mais longe poss�vel nesse calabou�o! Que a sorte esteja com voc�!");
		
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------");

		
		do {
			
			
			
			System.out.println("Voc� encontra um inimigo! Se prepare para a batalha!");
			
			if(enemy.getHp() > 0) {
				
				enemy.statusInimigo();
			}else {
				enemy.iniciarInimigo();
			}
			
			
			
			do {
				
				System.out.println("O que voc� deseja fazer? a - Atacar / h - Usar Habilidade");
				
				escolha = in.nextLine();
				
				if(escolha.equals("a")) {
					
				System.out.println("Voc� declara ataque ao inimigo!");
				
				if(player.dexDiceRoll() > enemy.dexDiceRoll()) {
				
				System.out.println("Seu dano acertou em cheio!");
				
				
				 dano = player.dmgDiceRoll() - enemy.getVit();
				 enemy.setHp(enemy.getHp() - dano);
				 
				 if(dano > 0) {
				 
				 System.out.println("Dano causado foi: " + dano);
				 }else {
					 System.out.println("Voc� n�o causou dano nesse combate");
				 }
				 
				 player.setDano(0);
				 dano = 0;
				 
				}else {
					System.out.println("Seu ataque falhou!");
					System.out.println("HP do inimigo atualmente �:" + enemy.getHp());
				}
				
				}else if(escolha.equals("h")){
					
					if(player.dexDiceRoll() > enemy.dexDiceRoll()) {

					player.skillList();
					
					dano = player.getDano() - enemy.getVit();
					enemy.setHp(enemy.getHp() - dano);
					
					if(dano > 0) {
					 System.out.println("Dano causado foi: " + dano);
					}else {
						System.out.println("Voc� n�o causou dano nesse combate");
					}
					 player.setDano(0);
					 dano = 0;
					
				}else {
					System.out.println("Seu ataque falhou!");
					System.out.println("HP do inimigo atualmente �:" + enemy.getHp());
				}}
				
				else {
					System.out.println("Voc� optou por n�o fazer nada!");
					System.out.println("HP do inimigo atualmente �:" + enemy.getHp());
				}
				 
				if(enemy.getHp() <= 0) {
					
					System.out.println("O inimigo morreu!");
					score ++;
					
					player.setExp(player.getExp() + enemy.getExp());
					player.increaseLv();
					System.out.println("Seu Score �: " + score);
					System.out.println("----------------------------------------------------------------");
					
				}else {
					System.out.println("O inimigo continua vivo e prepara o ataque dele!");
					
					System.out.println("----------------------------------------------------------------");
					
					System.out.println("Voc� deseja se esquivar ou defender? (e para esquivar , d para defender)");
					
					escolha = in.nextLine();
					
					if(escolha.equals("e")) {
						
						if(enemy.dexDiceRoll() < player.dexDiceRoll()) {
							System.out.println("Voc� se esquivou com sucesso!");
						}else {
						
							System.out.println("Ele te acertou em cheio!");
							
							dano = enemy.dmgDiceRoll();
							player.setHp(player.getHp() - dano);
							
							System.out.print("Voc� recebeu: ");
							System.out.println(dano);
							System.out.println("Seu HP atualmente �:" + player.getHp());
							
							dano = 0;
							
						}
						
						
					}else if(escolha.equals("d")) {
						
						dano = enemy.dmgDiceRoll() - player.getVit();
						player.setHp(player.getHp() - dano);
						
					if(dano > 0) {
						System.out.print("Voc� recebeu: ");
						System.out.println(dano);
						System.out.println("Seu HP atualmente �:" + player.getHp());
						
					}else {
						System.out.println("Voc� n�o recebeu dano nesse combate");
					}
						
						dano = 0;
						
					}else {
					
						System.out.println("Voc� optou por n�o fazer nada");
						System.out.println("Ele te acertou em cheio!");
						
						dano = enemy.dmgDiceRoll();
						player.setHp(player.getHp() - dano);
						
						if(dano > 0) {
						System.out.print("Voc� recebeu: ");
						System.out.println(dano);
						System.out.println("Seu HP atualmente �:" + player.getHp());
						}else {
							System.out.println("Voc� n�o recebeu dano nesse combate");
						}
						dano = 0;
						
					}
					
				}
				
			}while((enemy.getHp() > 0) && (player.getHp() > 0));
			
			if(player.getHp() > 0 && score != 25) {
			System.out.println("Deseja continuar o seu combate (s/n)? Score: " + score);
			escolha = in.nextLine();
			
			if(escolha.equals("s")) {
				player.status();
				System.out.println("Indo para o pr�ximo combate");
				check = 1;
				enemy.increase();
				System.out.println("----------------------------------------------------------------");
			}else {
				System.out.println("Sua jornada encerra por aqui!");
				check = 0;
			}}else {
				System.out.println("Sua jornada encerra por aqui!");
				check = 0;
			}
			
			
		}while((check != 0));
		
		if(score == 25) {
		
		System.out.println("Voc� concluiu o jogo, seu Score foi: " + score);
	}
		else {
			System.out.println("Jogo encerrado, seu Score foi: " + score);
		}
	}
	

}
