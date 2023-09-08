package io.shirohoo.realworld.domain.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {

    @Query("""
FROM Order WHERE processed = false 
""")

    public List <Order> getUnprocessedOrders();

}
