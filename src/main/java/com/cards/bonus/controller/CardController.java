package com.cards.bonus.controller;

import com.cards.bonus.model.Condition;
import com.cards.bonus.service.CardService;
import com.cards.bonus.view.CardPurchasesView;
import com.cards.bonus.view.CardView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/card")
public class CardController {
    private final CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping("/list")
    public List<CardView> listCard(){
        return cardService.listCard();
    }


    @GetMapping("/search/{id}")
    public CardView findCardById(@PathVariable("id") int id){
        return cardService.findCard(id);
    }

    @GetMapping("/search")
    public List<CardView> findCardsByCondition(@RequestParam Condition condition){
        return cardService.findCardByCondition(condition);
    }

    @GetMapping("/profile/{id}")
    public CardPurchasesView findProfileCard(@PathVariable("id") int id){
        return cardService.findProfileCard(id);
    }

    @PostMapping("/reverse/{id}")
    public void reverseCardCondition(@PathVariable("id") int id){
        cardService.reverseConditionCard(id);
    }

    @PostMapping("/remove/{id}")
    public void removeCard(@PathVariable("id") int id){
        cardService.removeCard(id);
    }

    @PostMapping("/generation/{quantity}")
    public List<CardView> generationCard(@PathVariable("quantity") int quantity){
        return cardService.generatedCard(quantity);
    }
}
