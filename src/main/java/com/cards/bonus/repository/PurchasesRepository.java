package com.cards.bonus.repository;

import com.cards.bonus.model.Purchases;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchasesRepository extends JpaRepository<Purchases, Integer> {
}
