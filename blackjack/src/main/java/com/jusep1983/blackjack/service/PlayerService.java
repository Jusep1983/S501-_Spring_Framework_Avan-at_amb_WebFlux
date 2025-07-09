package com.jusep1983.blackjack.service;

import com.jusep1983.blackjack.dto.PlayerRankingDTO;
import com.jusep1983.blackjack.enums.GameResult;
import com.jusep1983.blackjack.model.Player;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PlayerService {

    Mono<Player> getById(long id);
    Mono<Player> createPlayer(Player player);
    Mono<Player> updateName(Long id, String newName);
    Mono<Player> getByName(String name);
    Mono<Player> updateStats(String playerName, GameResult gameResult);
    Flux<PlayerRankingDTO> getRanking();
}
