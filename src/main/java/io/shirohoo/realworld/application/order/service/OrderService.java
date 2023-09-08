package io.shirohoo.realworld.application.order.service;


import io.shirohoo.realworld.application.order.controller.CreateOrderRequest;
import io.shirohoo.realworld.domain.article.Article;
import io.shirohoo.realworld.domain.order.OrderArticle;
import io.shirohoo.realworld.domain.order.OrderArticleRepository;
import io.shirohoo.realworld.domain.order.OrderRepository;
import io.shirohoo.realworld.domain.order.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderService {


    private final OrderRepository orderRepository;
    private final OrderArticleRepository orderArticleRepository;

    public OrderService(OrderRepository orderRepository, OrderArticleRepository orderArticleRepository) {
            this.orderRepository = orderRepository;

        this.orderArticleRepository = orderArticleRepository;
    }

    public Order addArticleToOrder(Article article, Order order){
        OrderArticle orderArticle = new OrderArticle(order, article);
        orderArticleRepository.save(orderArticle);
        order.addOrderArticle(orderArticle);
        calculatePrice(order);
        updateOrder(order);
        return order;


    }


    public void updateOrder(Order order){
        orderRepository.save(order);
    }

    private void calculatePrice(Order order) {
        int pricePerArticle = 50;
        int physicalShippingPrice = 100;
        int totalPrice = 0;

        for (OrderArticle orderArticle :
            order.getOrderArticles()) {
            totalPrice += pricePerArticle;
        }
        if(order.getSnailMailAddress() != null){
            totalPrice += physicalShippingPrice;
        }
        order.setPrice(totalPrice);
    }


    public Order createOrder(CreateOrderRequest createOrderRequest){

        Order order = new Order();

        order.setUser(createOrderRequest.getUser());
        order.setEmail(createOrderRequest.getEmailAddress());
        order.setSnailMailAddress(createOrderRequest.getSnailMailAddress());


        orderRepository.save(order);


        return order;

    }

    public OrderRepository orderRepository() {
        return orderRepository;
    }

    public OrderArticleRepository getOrderArticleRepository() {
        return orderArticleRepository;
    }
}
