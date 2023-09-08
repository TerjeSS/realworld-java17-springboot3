package io.shirohoo.realworld.domain.order;

import io.shirohoo.realworld.IntegrationTest;
import io.shirohoo.realworld.domain.article.Article;
import io.shirohoo.realworld.domain.user.User;
import io.shirohoo.realworld.domain.user.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertTrue;

@IntegrationTest
@DisplayName("The Order")
public class OrderTest {


    private Article effectiveJava;
    private User testPersson;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    OrderRepository orderRepository;

    private User james;
    @BeforeEach
    public void setUp(){
        james = User.builder()
            .email("james@example.com")
            .username("james")
            .password("password")
            .build();
        userRepository.save(james);

    }
    @Test
    @DisplayName("Should be created with a user attached")
    public void shouldCreateOrderWithOneArticle(){


        Order order = new Order();
        order.setUser(james);

        orderRepository.save(order);

        assertTrue(order.getId() > 0);



    }


}
