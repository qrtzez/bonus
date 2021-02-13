package com.cards.bonus.model;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "card")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "serial")
    @NotNull
    private int serialCard;

    @Column(name = "number")
    @NotNull
    private int numberCard;

    @Column(name = "birth_card")
    @NotNull
    private LocalDateTime startTimeCard;

    @Column(name = "death_card")
    @NotNull
    private LocalDateTime endCardTime;

    @Column(name = "sum")
    @NotNull
    private int sum;

    @Enumerated(EnumType.STRING)
    @Column(name = "condition")
    @NotNull
    private Condition condition;

    @OneToMany(mappedBy = "card", orphanRemoval = true, fetch = FetchType.LAZY,
                cascade = CascadeType.ALL)
    private List<Purchases> purchasesList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSerialCard() {
        return serialCard;
    }

    public void setSerialCard(int serialCard) {
        this.serialCard = serialCard;
    }

    public int getNumberCard() {
        return numberCard;
    }

    public void setNumberCard(int numberCard) {
        this.numberCard = numberCard;
    }

    public LocalDateTime getStartTimeCard() {
        return startTimeCard;
    }

    public void setStartTimeCard(LocalDateTime startTimeCard) {
        this.startTimeCard = startTimeCard;
    }

    public LocalDateTime getEndCardTime() {
        return endCardTime;
    }

    public void setEndCardTime(LocalDateTime endCardTime) {
        this.endCardTime = endCardTime;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public List<Purchases> getPurchasesList() {
        return purchasesList;
    }

    public void setPurchasesList(List<Purchases> purchasesList) {
        this.purchasesList = purchasesList;
    }
}
