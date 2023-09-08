package io.shirohoo.realworld.domain.order;

import io.shirohoo.realworld.domain.article.Article;
import io.shirohoo.realworld.domain.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("The Order")
public class OrderTest {


    private Article effectiveJava;
    private User testPersson;

    @BeforeEach
    public void setUp(){

    }
    @Test
    public void shouldCreateOrderWithOneArticle(){

        Order order = new Order();

    }


}
