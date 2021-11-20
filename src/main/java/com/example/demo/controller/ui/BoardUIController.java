package com.example.demo.controller.ui;

import com.example.demo.model.Card;
import com.example.demo.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/ui/board")
public class BoardUIController {

    @Autowired
    BoardService service;

    @GetMapping("/all")
    String getBoard(Model model){
        List<Card> myCards = service.getBoard().getGamerCards();
        List<Card> computerCards = service.getBoard().getDealerCards();
        List<Card> allCards = new ArrayList<>();
        for (int i = 0; i < service.getBoard().getDeck().size()-1; i++) {
            allCards.add(new Card(i,"/image/back.png",3*i));
        }
        model.addAttribute("allCards",allCards);
        model.addAttribute("computerCards",computerCards);
        model.addAttribute("gamerCards",myCards);
        model.addAttribute("message",service.getBoard().getMessage());
        model.addAttribute("Finalmessage", service.getBoard().getFinalMessage());
        return "board";
    }

    @GetMapping("/all/give/me")
    String getLastCard(Model model){
        service.giveCardToGamer();
        List<Card> myCards = service.getBoard().getGamerCards();
        List<Card> computerCards = service.getBoard().getDealerCards();
        List<Card> allCards = new ArrayList<>();
        for (int i = 0; i < service.getBoard().getDeck().size()-1; i++) {
            allCards.add(new Card(i,"/image/back.png",3*i));
        }
        model.addAttribute("allCards",allCards);
        model.addAttribute("computerCards",computerCards);
        model.addAttribute("gamerCards",myCards);
        model.addAttribute("message",service.getBoard().getMessage());
        model.addAttribute("Finalmessage", service.getBoard().getFinalMessage());
        return "board";
    }

    @GetMapping("/all/new/game")
    String getNewBoard(Model model){
        service.createNewGame();
        List<Card> myCards = service.getBoard().getGamerCards();
        List<Card> computerCards = service.getBoard().getDealerCards();
        List<Card> allCards = new ArrayList<>();
        for (int i = 0; i < service.getBoard().getDeck().size()-1; i++) {
            allCards.add(new Card(i,"/image/back.png",3*i));
        }
        model.addAttribute("allCards",allCards);
        model.addAttribute("computerCards",computerCards);
        model.addAttribute("gamerCards",myCards);
        model.addAttribute("message",service.getBoard().getMessage());
        model.addAttribute("Finalmessage", service.getBoard().getFinalMessage());
        return "board";
    }

    @GetMapping("/all/stop")
    String Stop(Model model){
        List<Card> myCards = service.getBoard().getGamerCards();
        service.getBoard().setTurn(false);
        service.giveCardToComputer();
        List<Card> computerCards = service.getBoard().getDealerCards();
        service.createMessage();
        List<Card> allCards = new ArrayList<>();
        for (int i = 0; i < service.getBoard().getDeck().size()-1; i++) {
            allCards.add(new Card(i,"/image/back.png",3*i));
        }
        model.addAttribute("allCards",allCards);
        model.addAttribute("computerCards", computerCards);
        model.addAttribute("gamerCards", myCards);
        model.addAttribute("message", service.getBoard().getMessage());
        model.addAttribute("Finalmessage", service.getBoard().getFinalMessage());
        return "board";
    }

    @GetMapping("/all/newCards")
    String newCards(Model model){
        List<Card> myCards = service.getBoard().getGamerCards();
        List<Card> computerCards = service.getBoard().getDealerCards();
        service.createMessage();
        List<Card> allCards = new ArrayList<>();
        for (int i = 0; i < service.getBoard().getDeck().size()-1; i++) {
            allCards.add(new Card(i,"/image/back.png",3*i));
        }
        model.addAttribute("allCards",allCards);
        model.addAttribute("computerCards", computerCards);
        model.addAttribute("gamerCards", myCards);
        model.addAttribute("message", service.getBoard().getMessage());
        model.addAttribute("Finalmessage", service.getBoard().getFinalMessage());
        return "board";
    }
}
