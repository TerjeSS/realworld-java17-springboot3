package io.shirohoo.realworld.application.order;

import io.shirohoo.realworld.IntegrationTest;
import io.shirohoo.realworld.application.order.controller.CreateOrderRequest;
import io.shirohoo.realworld.application.order.service.OrderService;
import io.shirohoo.realworld.domain.article.Article;
import io.shirohoo.realworld.domain.article.ArticleRepository;
import io.shirohoo.realworld.domain.article.Tag;
import io.shirohoo.realworld.domain.article.TagRepository;
import io.shirohoo.realworld.domain.order.Order;
import io.shirohoo.realworld.domain.order.OrderArticle;
import io.shirohoo.realworld.domain.order.OrderArticleRepository;
import io.shirohoo.realworld.domain.order.OrderRepository;
import io.shirohoo.realworld.domain.user.User;
import io.shirohoo.realworld.domain.user.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.jupiter.api.Assertions.*;


@IntegrationTest
@DisplayName("The order service")
public class OrderServiceTest {

@Autowired
    ArticleRepository articleRepository;
@Autowired
    UserRepository userRepository;
@Autowired
    OrderRepository orderRepository;
@Autowired
    TagRepository tagRepository;
@Autowired
    OrderArticleRepository orderArticleRepository;
@Autowired
    OrderService orderService;
@Autowired
ProcessingOrderService processingOrderService;

    private Article effectiveJava;
    private Article unEffectiveJava;
    private Article tdd;
    private User james;
    private User simpson;

    @BeforeEach
    void setUp() throws Exception {

        james = User.builder()
            .email("james@example.com")
            .username("james")
            .password("password")
            .build();
        userRepository.save(james);

        simpson = User.builder()
            .email("simpson@example.com")
            .username("simpson")
            .password("password")
            .build();
        userRepository.save(simpson);

        Tag java = new Tag("java");
        Tag testing = new Tag("testing");
        tagRepository.save(java);
        tagRepository.save(testing);

        effectiveJava = Article.builder()
            .description("description")
            .title("Effective Java")
            .author(james)
            .content("content")
            .build();
        java.addTo(effectiveJava);
        articleRepository.save(effectiveJava);

        unEffectiveJava = Article.builder()
            .description("description")
            .title("Uneffective Java is fun")
            .author(simpson)
            .content("article goes here?")
            .build();

        articleRepository.save(unEffectiveJava);

        tdd = Article.builder()
            .description("description")
            .title("TDD- Java is fun")
            .author(simpson)
            .content("article goes here?")
            .build();

        articleRepository.save(tdd);

    }


    @Test
    @DisplayName("should set processed to true on processed orders ")
    public void setProcessedOnOrder() throws InterruptedException {

        CreateOrderRequest createOrderRequest = new CreateOrderRequest(james, "ABC Veien 199", james.getEmail());
        Order order = orderService.createOrder(createOrderRequest);
        order.setUser(createOrderRequest.getUser());
        orderRepository.save(order);

        orderService.addArticleToOrder(effectiveJava, order);
        orderService.addArticleToOrder(unEffectiveJava, order);
        orderService.addArticleToOrder(tdd, order);

        orderService.updateOrder(order);

        processingOrderService.processOrder(order);
        System.out.println(order);
        assertTrue(order.isProcessed());

    }
    @Test
    @DisplayName("Should calculate price of order")
    public void calculateOrderPrice(){

        CreateOrderRequest createOrderRequest = new CreateOrderRequest(james, "Some address", james.getEmail());
        Order order = orderService.createOrder(createOrderRequest);
        order.setUser(james);
        orderRepository.save(order);

        orderService.addArticleToOrder(effectiveJava, order);
        orderService.addArticleToOrder(unEffectiveJava, order);
        orderService.addArticleToOrder(tdd, order);

        orderService.updateOrder(order);

        System.out.println(order);
        assertEquals(250, (int) order.getPrice());
    }

    @Test
    @DisplayName("Should add article to existing order")
    public void addArticleToOrder(){

        CreateOrderRequest createOrderRequest = new CreateOrderRequest(james, "Some address", james.getEmail());
        Order order = orderService.createOrder(createOrderRequest);
        OrderArticle orderArticle1 = new OrderArticle(order, effectiveJava);
        order.addOrderArticle(orderArticle1);
        orderArticleRepository.save(orderArticle1);

        System.out.println(order);
        orderService.updateOrder(order);
        assertFalse(order.getOrderArticles().isEmpty());



    }

    @Test
    @DisplayName("Should transform CreateOrderRequest to Order")
    public void saveCreateOrderRequestAsOrder(){


        CreateOrderRequest createOrderRequest = new CreateOrderRequest(james, "Some address", james.getEmail());
        Order order = orderService.createOrder(createOrderRequest);
        System.out.println(order);

        assertThat(order.getId(), greaterThan(0));




    }

     @Test
     @DisplayName("Should create an order with multiple articles")
     public void createOrderWithMultipleArticles(){

        Order order = new Order();
        order.setEmail(simpson.getEmail());
        order.setUser(james);
        orderRepository.save(order);

         OrderArticle orderArticle = new OrderArticle(order, effectiveJava);
         orderArticleRepository.save(orderArticle);
         OrderArticle anotherOrderArticle = new OrderArticle(order, unEffectiveJava);
         orderArticleRepository.save(anotherOrderArticle);
         OrderArticle thirdOrderArticle = new OrderArticle(order, tdd);
         orderArticleRepository.save(thirdOrderArticle);

         order.addOrderArticle(orderArticle);
         order.addOrderArticle(anotherOrderArticle);
         order.addOrderArticle(thirdOrderArticle);

         orderRepository.save(order);

         Order fetchedOrder = orderRepository.findById(order.getId()).get();
         assertTrue(fetchedOrder.getOrderArticles().size() > 2);


     }

    @Test
    @DisplayName("Should create an order with one article")
    public void createOrderWithOneArticle(){

        Order order = new Order();
        order.setEmail("email@email.com");
        order.setProcessed(false);
        order.setUser(james);
        orderRepository.save(order);

        OrderArticle orderArticle = new OrderArticle(order, effectiveJava);
        orderArticleRepository.save(orderArticle);


        order.addOrderArticle(orderArticle);
        orderRepository.save(order);

        Order savedOrder = orderRepository.findById(order.getId()).get();

        assertEquals(savedOrder, order);


    }

}
