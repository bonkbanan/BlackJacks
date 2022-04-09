package com.example.demo.model;

import com.example.demo.storage.Deck;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Array;
import java.util.ArrayList;

import java.util.List;

public class Board {
    private List<Card> deck;
    private List<Card> gamerCards;
    private List<Card> dealerCards;
    private String message;
    private String finalMessage;
    private int[] score = new int[] {0,0};
    private boolean turn;

    @Autowired
    Deck originalDeck;

    public Board() {
    }

    public Board(List<Card> deck, List<Card> gamerCards, List<Card> dealerCards, String message) {
        this.deck = new ArrayList<>();
        this.gamerCards = gamerCards;
        this.dealerCards = dealerCards;
        this.message = message;
        this.finalMessage = " ";
        this.turn = true;
    }


    public String getFinalMessage() {
        return finalMessage;
    }

    public void setFinalMessage(String finalMessage) {
        this.finalMessage = finalMessage;
    }

    public List<Card> getDeck() {
        return deck;
    }

    public void setDeck(List<Card> deck) {
        this.deck = deck;
    }

    public List<Card> getGamerCards() {
        return gamerCards;
    }

    public void setGamerCards(List<Card> gamerCards) {
        this.gamerCards = gamerCards;
    }

    public List<Card> getDealerCards() {
        return dealerCards;
    }

    public void setDealerCards(List<Card> dealerCards) {
        this.dealerCards = dealerCards;
    }

    public String getMessage() {
        return message;
    }

    public int[] getScore() {
        return score;
    }

    public void setScore(int[] score) {
        this.score = score;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isTurn() {
        return turn;
    }

    public void setTurn(boolean turn) {
        this.turn = turn;
    }

    @Override
    public String toString() {
        return "Board{" +
                "deck=" + deck +
                ", gamerCards=" + gamerCards +
                ", dealerCards=" + dealerCards +
                ", message='" + message + '\'' +
                '}';
    }

}
