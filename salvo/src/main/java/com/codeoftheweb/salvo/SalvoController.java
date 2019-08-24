package com.codeoftheweb.salvo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.stream.Collectors;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class SalvoController {

    @Autowired
    private GameRepository gameRepository;

    @RequestMapping("/games")
    public List<Map<String, Object>> getGames() {
        return gameRepository.findAll()
                             .stream()
                             .map(Game -> makeGameDTO(Game))
                             .collect(Collectors.toList());
    }

    public Map<String, Object> makeGameDTO(Game game) {
        Map<String, Object> dto = new LinkedHashMap<String, Object>();
        dto.put("id", game.getId());
        dto.put("created", game.getGameDate().getTime());
        dto.put("gamePlayers", getAllGamePlayers(game.getGamePlayers()));
        return dto;
    }

    public List<Map<String, Object>> getAllGamePlayers(Set<GamePlayer> gamePlayers) {
        return gamePlayers
                .stream()
                .map(GamePlayer -> makeGamePlayerDTO(GamePlayer))
                .collect(Collectors.toList());
    }

    public Map<String, Object> makeGamePlayerDTO (GamePlayer gamePlayer) {
        Map <String, Object> dto = new LinkedHashMap<String, Object>();
        dto.put("id",gamePlayer.getId());
        dto.put("player", gamePlayer.getPlayer().makePlayerDTO());
        return dto;
    }
}