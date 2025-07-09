package com.jusep1983.blackjack.service;

import com.jusep1983.blackjack.model.Card;
import com.jusep1983.blackjack.model.Hand;

public interface HandService {
    void addCardToHand(Hand hand, Card card);

    int calculatePoints(Hand hand);

    boolean isBust(Hand hand);

    void clearHand(Hand hand);
}
