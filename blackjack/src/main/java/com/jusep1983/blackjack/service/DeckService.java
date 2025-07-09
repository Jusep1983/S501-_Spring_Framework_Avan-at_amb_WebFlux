package com.jusep1983.blackjack.service;

import com.jusep1983.blackjack.model.Card;
import com.jusep1983.blackjack.model.Deck;

public interface DeckService {
    Deck createDeck();
    void shuffleDeck(Deck deck);
    Card drawCard(Deck deck);
}
