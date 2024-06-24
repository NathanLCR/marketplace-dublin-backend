package com.nathanlcr.MarketplaceDublin.repository;

import com.nathanlcr.MarketplaceDublin.entity.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
    @Query("select i from Item i where i.category.id = ?1 and upper(i.title) like upper(?2) order by i.createdAt")
    Page<Item> searchItems(Long id, String title, Pageable pageable);
}
