package com.cards.bonus.service;

import com.cards.bonus.model.Card;
import com.cards.bonus.model.Condition;
import com.cards.bonus.model.Purchases;
import com.cards.bonus.repository.CardRepository;
import com.cards.bonus.view.CardPurchasesView;
import com.cards.bonus.view.CardView;
import com.cards.bonus.view.PurchasesView;
import ma.glasnost.orika.MapperFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CardService {
    private final CardRepository cardRepository;

    private final MapperFactory mapperFactory;

    public CardService(CardRepository cardRepository, MapperFactory mapperFactory) {
        this.cardRepository = cardRepository;
        this.mapperFactory = mapperFactory;
    }

    @Transactional
    public List<CardView> listCard(){
        List<Card> listCard = cardRepository.findAll();
        return listCard.stream()
                .map(mapperFactory.getMapperFacade(Card.class, CardView.class)::map)
                .collect(Collectors.toList());
    }

    @Transactional
    public CardView findCard(int id){
        Card findCard = cardRepository.findById(id).get();
        return mapperFactory.getMapperFacade(Card.class, CardView.class).map(findCard);
    }

    @Transactional
    public List<CardView> findCardByCondition(Condition condition){
        List<Card> cardList = cardRepository.findAllByCondition(condition);
        return cardList.stream()
                .map(mapperFactory.getMapperFacade(Card.class, CardView.class)::map)
                .collect(Collectors.toList());
    }

    @Transactional
    public CardPurchasesView findProfileCard(int id){
        Card card = cardRepository.findById(id).get();
        List<Purchases> purchasesList = card.getPurchasesList();
        CardPurchasesView cardPurchasesView = mapperFactory.getMapperFacade(Card.class, CardPurchasesView.class).map(card);
        List<PurchasesView> cardPurchasesViewList = purchasesList.stream()
                .map(mapperFactory.getMapperFacade(Purchases.class, PurchasesView.class)::map)
                .collect(Collectors.toList());
        cardPurchasesView.setPurchasesView(cardPurchasesViewList);
        return cardPurchasesView;
    }

    @Transactional
    public void reverseConditionCard(int id){
        Card card = cardRepository.findById(id).get();
        if(card.getCondition() == Condition.ACTIVATED && card.getCondition() != Condition.EXPIRED){
            card.setCondition(Condition.NotACTIVATED);
        }
        else if(card.getCondition() == Condition.NotACTIVATED && card.getCondition() != Condition.EXPIRED){
            card.setCondition(Condition.ACTIVATED);
        }
        cardRepository.save(card);
    }

    @Transactional
    public void removeCard(int id){
        Card card = cardRepository.findById(id).get();
        cardRepository.delete(card);
    }


}
