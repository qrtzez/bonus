package com.cards.bonus.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "purchases")
public class Purchases {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "time_purchases")
    @NotNull
    private LocalDateTime timePurchases;

    @Column(name = "sum_purchases")
    @NotNull
    private int sumPurchases;

    @ManyToOne
    @JoinColumn(name = "card_id")
    private Card card;

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

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
}
