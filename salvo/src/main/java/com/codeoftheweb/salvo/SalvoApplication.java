package com.codeoftheweb.salvo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.*;

@SpringBootApplication
public class SalvoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalvoApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(PlayerRepository playerRepository,
									  GameRepository gameRepository,
									  GameplayerRepository gameplayerRepository,
									  ShipRepository shipRepository,
									  SalvoRepository salvoRepository,
										ScoreRepository scoreRepository){
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


				//Location Creation.
				Set<String> shipLocationgp1 = new HashSet<>();
				Set<String> shipLocationgp2 =  new HashSet<>();
				Set<String> shipLocationgp3 = new HashSet<>();
				Set<String> shipLocationgp4 =  new HashSet<>();
				Set<String> shipLocationgp5 =  new HashSet<>();
				shipLocationgp1.add ("H2");
				shipLocationgp1.add ("H3");
				shipLocationgp1.add ("H4");
				shipLocationgp2.add ("E1");
				shipLocationgp2.add ("F1");
				shipLocationgp2.add ("G1");
				shipLocationgp3.add ("B4");
				shipLocationgp3.add ("B5");
				shipLocationgp4.add ("B5");
				shipLocationgp4.add ("C5");
				shipLocationgp4.add ("D5");
				shipLocationgp5.add ("F1");
				shipLocationgp5.add ("F2");
				shipLocationgp5.add ("F3");
// ShipTypes.
				String shipTypeYate = "Yate";
				String shipTypeVelero = "Velero";
				String shipTypeSubmarino = "Submarino";
				String shipTypeCanoa = "Canoa";

				Ship gp1Uno  = new Ship(GP1,shipTypeCanoa,shipLocationgp1);
				Ship gp1Dos  = new Ship(GP1,shipTypeVelero, shipLocationgp2);
				Ship gp1Tres  = new Ship(GP1,shipTypeSubmarino, shipLocationgp3);
				Ship gp2Uno  = new Ship(GP2,shipTypeYate, shipLocationgp4);
				Ship gp2Dos  = new Ship(GP2,shipTypeSubmarino, shipLocationgp5);
				Ship gp2Tres  = new Ship(GP2,shipTypeVelero, shipLocationgp1);

				shipRepository.save(gp1Uno);
				shipRepository.save(gp1Dos);
				shipRepository.save(gp1Tres);
				shipRepository.save(gp2Uno);
				shipRepository.save(gp2Dos);
				shipRepository.save(gp2Tres);


				//Salvo

				Set<String> salvoLoc1 =  new HashSet(Arrays.asList("B4", "B5", "B6"));
				Set<String> salvoLoc2 =  new HashSet(Arrays.asList("E1", "H3", "A2"));
				Set<String> salvoLoc3 =  new HashSet(Arrays.asList("B5", "D5", "C7"));
				Set<String> salvoLoc4 =  new HashSet(Arrays.asList("C5", "C6"));
				Set<String> salvoLoc5 =  new HashSet(Arrays.asList("H1", "H2", "H3"));

				Salvo salvo1 = new Salvo(1,GP1,salvoLoc1);
				Salvo salvo2 = new Salvo(2,GP1,salvoLoc2);
				Salvo salvo3 = new Salvo(1,GP2,salvoLoc3);
				Salvo salvo4 = new Salvo(2,GP2,salvoLoc4);
				Salvo salvo5 = new Salvo(5,GP5,salvoLoc5);

				salvoRepository.saveAll(Arrays.asList(salvo1,salvo2,salvo3,salvo4,salvo5));

				Score score1 = new Score((float) 0.5,date,P1,G1);
				Score score2 = new Score((float) 1,date,P2,G1);
				Score score3 = new Score((float) 0.5,date,P3,G2);
				Score score4 = new Score((float) 0,date,P4,G2);

				scoreRepository.saveAll(Arrays.asList(score1,score2,score3,score4));
			};
	}
}
