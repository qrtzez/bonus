package com.cards.bonus.view;

import com.cards.bonus.model.Condition;
import com.cards.bonus.model.Purchases;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

public class CardView {
    private int id;

    @Length(min = 2, max = 3)
    @NotNull
    private int serialCard;

    @Length(min = 4, max = 5)
    @NotNull
    private int numberCard;

    @NotNull
    private LocalDateTime startTimeCard;

    @NotNull
    private LocalDateTime endCardTime;

    @NotNull
    private int sum;

    @NotNull
    private Condition condition;


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
}
