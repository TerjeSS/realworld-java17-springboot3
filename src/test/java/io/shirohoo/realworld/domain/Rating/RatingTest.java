package io.shirohoo.realworld.domain.Rating;

import io.shirohoo.realworld.IntegrationTest;
import io.shirohoo.realworld.application.article.service.ArticleService;
import io.shirohoo.realworld.domain.article.ArticleRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@DisplayName("Rating should")
@IntegrationTest
public class RatingTest {


    @Autowired
    ArticleRepository articleRepository;


    @Test
    @DisplayName("be added to article")
    void addRatingToArticle(){


    }
}
