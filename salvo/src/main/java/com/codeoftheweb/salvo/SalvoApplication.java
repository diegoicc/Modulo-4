package com.codeoftheweb.salvo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.Date;

@SpringBootApplication
public class SalvoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalvoApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(PlayerRepository playerRepository,
									  GameRepository gameRepository,
									  GameplayerRepository gameplayerRepository){
			return (args) -> {
				Player P1 = new Player("j.bauer@ctu.gov");
				Player P2 = new Player("c.obrian@ctu.gov");
				Player P3 = new Player("kim_bauer@gtmail.com");
				Player P4 = new Player("t.almeida@ctu.gov");

				playerRepository.save(P1);
				playerRepository.save(P2);
				playerRepository.save(P3);
				playerRepository.save(P4);


				Date date = new Date();
				Date date2 = Date.from(date.toInstant().plusSeconds(3600));
				Date date3 = Date.from(date2.toInstant().plusSeconds(3600));

				Game G1 = new Game(date);
				Game G2 = new Game(date2);
				Game G3 = new Game(date3);

				gameRepository.save(G1);
				gameRepository.save(G2);
				gameRepository.save(G3);

				GamePlayer GP1 = new GamePlayer(date,G1,P1);
				GamePlayer GP2 = new GamePlayer(date,G1,P2);

				GamePlayer GP3 = new GamePlayer(date,G2,P1);
				GamePlayer GP4 = new GamePlayer(date,G2,P2);

				GamePlayer GP5 = new GamePlayer(date,G3,P2);
				GamePlayer GP6 = new GamePlayer(date,G3,P3);

				gameplayerRepository.save(GP1);
				gameplayerRepository.save(GP2);
				gameplayerRepository.save(GP3);
				gameplayerRepository.save(GP4);
				gameplayerRepository.save(GP5);
				gameplayerRepository.save(GP6);
		};
	}
}
