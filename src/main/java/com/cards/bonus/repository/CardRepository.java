package com.cards.bonus.repository;

import com.cards.bonus.model.Card;
import com.cards.bonus.model.Condition;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.validation.constraints.NotNull;
import java.util.List;

public interface CardRepository extends JpaRepository<Card, Integer> {
    List<Card> findAllByCondition(@NotNull Condition condition);
}
