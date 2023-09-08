package io.shirohoo.realworld.domain.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Orders, Integer> {

    @Query("""
FROM Orders WHERE processed = false 
""")

    public List <Orders> getUnprocessedOrders();
}
