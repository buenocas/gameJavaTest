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

		System.out.println("Bem vinde ao meu primeiro teste de jogo com estudo de classes e métodos !!");
		
		System.out.print(" Insira o seu nome: ");
		
		nome = in.nextLine();
		
		player.setNome(nome);
		
		
		do {
			
			System.out.println("Insira a Classe com que quer jogar ! g para Guerreiro, m para Mago, l para Ladrão");
			
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
				
				System.out.println(player.getNome() + " escolheu Ladrão!!");
				
				player.iniciarLadrao();
				player.status();				
				check = 0;
			}
			else {
				
				System.out.println("Escolha errada, tente novamente.");
				
				check = 1;
				
			}
		}while(check != 0);
		
		
		System.out.println("Sua jornada começará agora " + nome + "!! Seu objetivo é ir o mais longe possível nesse calabouço! Que a sorte esteja com você!");
		
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------");

		
		do {
			
			
			
			System.out.println("Você encontra um inimigo! Se prepare para a batalha!");
			
			if(enemy.getHp() > 0) {
				
				enemy.statusInimigo();
			}else {
				enemy.iniciarInimigo();
			}
			
			
			
			do {
				
				System.out.println("Você Deseja atacar o Inimigo? s para sim, n para não");
				
				escolha = in.nextLine();
				
				if(escolha.equals("s")) {
					
				System.out.println("Você declara ataque ao inimigo!");
				
				if(player.dexDiceRoll() > enemy.dexDiceRoll()) {
				
				System.out.println("Seu dano acertou em cheio!");
				
				 dano = player.dmgDiceRoll() - enemy.getVit();
				 enemy.setHp(enemy.getHp() - dano);
				 
				 System.out.println("Dano causado foi: " + dano);
				 
				}else {
					System.out.println("Seu ataque falhou!");
					System.out.println("HP do inimigo atualmente é:" + enemy.getHp());
				}
				
				}else {
					System.out.println("Você optou por não fazer nada!");
					System.out.println("HP do inimigo atualmente é:" + enemy.getHp());
				}
				 
				if(enemy.getHp() <= 0) {
					
					System.out.println("O inimigo morreu!");
					score ++;
					
					player.setExp(player.getExp() + enemy.getExp());
					player.increaseLv();
					System.out.println("Seu Score é: " + score);
					System.out.println("----------------------------------------------------------------");
					
				}else {
					System.out.println("O inimigo continua vivo e prepara o ataque dele!");
					
					System.out.println("----------------------------------------------------------------");
					
					System.out.println("Você deseja se esquivar ou defender? (e para esquivar , d para defender)");
					
					escolha = in.nextLine();
					
					if(escolha.equals("e")) {
						
						if(enemy.dexDiceRoll() < player.dexDiceRoll()) {
							System.out.println("Você se esquivou com sucesso!");
						}else {
						
							System.out.println("Ele te acertou em cheio!");
							
							dano = enemy.dmgDiceRoll();
							player.setHp(player.getHp() - dano);
							
							System.out.print("Você recebeu: ");
							System.out.println(dano);
							System.out.println("Seu HP atualmente é:" + player.getHp());
							
						}
						
						
					}else if(escolha.equals("d")) {
						
						dano = enemy.dmgDiceRoll() - player.getVit();
						player.setHp(player.getHp() - dano);
						
						System.out.print("Você recebeu: ");
						System.out.println(dano);
						System.out.println("Seu HP atualmente é:" + player.getHp());
				
						
					}else {
					
						System.out.println("Você optou por não fazer nada");
						System.out.println("Ele te acertou em cheio!");
						
						dano = enemy.dmgDiceRoll();
						player.setHp(player.getHp() - dano);
						
						System.out.print("Você recebeu: ");
						System.out.println(dano);
						System.out.println("Seu HP atualmente é:" + player.getHp());
						
					}
					
				}
				
			}while((enemy.getHp() > 0) && (player.getHp() > 0));
			
			if(player.getHp() > 0 && score != 20) {
			System.out.println("Deseja continuar o seu combate (s/n)? Score: " + score);
			escolha = in.nextLine();
			
			if(escolha.equals("s")) {
				player.status();
				System.out.println("Indo para o próximo combate");
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
		
		if(score == 20) {
		
		System.out.println("Você concluiu o jogo, seu Score foi: " + score);
	}
		else {
			System.out.println("Jogo encerrado, seu Score foi: " + score);
		}
	}
	

}
