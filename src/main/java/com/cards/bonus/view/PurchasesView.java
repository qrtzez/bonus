package com.cards.bonus.view;

import com.cards.bonus.model.Card;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class PurchasesView {
    private int id;

    @NotNull
    private LocalDateTime timePurchases;

    @NotNull
    private int sumPurchases;

    @JsonIgnore
    private CardPurchasesView card;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getTimePurchases() {
        return timePurchases;
    }

    public void setTimePurchases(LocalDateTime timePurchases) {
        this.timePurchases = timePurchases;
    }

    public int getSumPurchases() {
        return sumPurchases;
    }

    public void setSumPurchases(int sumPurchases) {
        this.sumPurchases = sumPurchases;
    }

    public CardPurchasesView getCard() {
        return card;
    }

    public void setCard(CardPurchasesView card) {
        this.card = card;
    }
}
