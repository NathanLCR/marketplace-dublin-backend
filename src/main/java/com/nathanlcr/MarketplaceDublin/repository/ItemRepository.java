package com.nathanlcr.MarketplaceDublin.repository;

import com.nathanlcr.MarketplaceDublin.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
}
