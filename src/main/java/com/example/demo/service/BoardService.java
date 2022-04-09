package com.example.demo.service;

import com.example.demo.model.Board;
import com.example.demo.model.Card;
import com.example.demo.storage.Deck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class BoardService {

    @Autowired
    Deck originalDeck;

    Board board = new Board();

    @PostConstruct
    void init(){
        createNewGame();
    }

    public int getGamerScore(){
        return board.getGamerCards().stream()
                .mapToInt(Card::getValue).sum();
    }

    public int getComputerScore(){
        return board.getDealerCards().stream()
                .mapToInt(Card::getValue).sum();
    }

    public void shufflerDeck(){
        Collections.shuffle(board.getDeck());
    }

    public String createMessage(){
        String whoseTurn;
        if(board.isTurn()){
            whoseTurn = " It's Your Turn ";
        }else{
            whoseTurn = " It's Opponent Turn ";
        }
        board.setMessage("Player balance " + this.getGamerScore()
                + " Dealer balance " + this.getComputerScore()
                +  whoseTurn + "  <h2> " + (getBoard().getDeck().size()) + " In stack</h2> "
                + "  <h1>Score " + this.getBoard().getScore()[0]
                + " : " + this.getBoard().getScore()[1] + "</h1> ");
        return board.getMessage();
    }

    public Board getBoard() {
        return board;
    }

    public void createNewGame(){
        List<Card> copied = new ArrayList<>();
        if(board.getDeck() != null){
            copied.addAll(board.getDeck());
        }else{
            copied.addAll(originalDeck.getDeck());
        }
        int[] array = board.getScore();
        this.board = new Board();
        board.setDealerCards(new ArrayList<>());
        board.setGamerCards(new ArrayList<>());
        board.setDeck(copied);
        board.setScore(array);
        board.setTurn(true);
        createMessage();
        this.shufflerDeck();
        board.setFinalMessage(" ");
    }

    public void generateNewGame(){
        List<Card> copied = new ArrayList<>();
        copied.addAll(originalDeck.getDeck());
        this.board = new Board();
        board.setDealerCards(new ArrayList<>());
        board.setGamerCards(new ArrayList<>());
        board.setDeck(copied);
        board.setScore(new int[2]);
        board.setTurn(true);
        createMessage();
        this.shufflerDeck();
        board.setFinalMessage(" ");
    }

    public void giveCardToGamer(){
        int lastIndex = getBoard().getDeck().size()-1;
        if(this.getBoard().isTurn()){
            if(lastIndex<0 || board.getFinalMessage().equals("You Lose!!!!")){
                board.setFinalMessage("You Lose!!!!");
            }else{
                Card card = this.getBoard().getDeck().get(lastIndex);
                board.getGamerCards().add(card);
                board.getDeck().remove(lastIndex);
                createMessage();
                if(getGamerScore()>21){
                    board.setTurn(false);
                    this.giveCardToComputer();
                }
            }
        }else {
            if (lastIndex >= 0) {
                createNewGame();
                giveCardToGamer();
            }
        }
        if(lastIndex == -1  && getBoard().getDeck().isEmpty()){
            generateNewGame();
            giveCardToGamer();
        }
    }

    public void giveCardToComputer() {
        if(!board.isTurn()){
            while(this.getComputerScore()<18 && getBoard().getDeck().size()>0){
                int lastIndex = getBoard().getDeck().size()-1;
                Card card = this.getBoard().getDeck().get(lastIndex);
                board.getDealerCards().add(card);
                board.getDeck().remove(lastIndex);
            }
            if((21 - this.getGamerScore() < 21 - this.getComputerScore() && this.getGamerScore()<22)||(this.getComputerScore() > 21 && this.getGamerScore() < 22)){
                board.setFinalMessage("You win!!!");
                board.getScore()[0]+=1;
                createMessage();
                return;
            }
            if(this.getGamerScore() > 21 || (21 - this.getGamerScore() > 21
                    - this.getComputerScore())){
                board.setFinalMessage("You Lose!!!!");
                board.getScore()[1]+=1;
                createMessage();
                return;
            }else{
                if(this.getComputerScore() == this.getGamerScore()){
                    board.setFinalMessage("Draw");
                    createMessage();
                    return;
                }
            }
            }
        }
}
